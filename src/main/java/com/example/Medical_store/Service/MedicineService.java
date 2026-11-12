package com.example.Medical_store.Service;
import com.example.Medical_store.Dto.MedicineDto;
import com.example.Medical_store.Entity.Medicine;
import com.example.Medical_store.Exception.MedicineNotFoundException;
import com.example.Medical_store.Repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public Medicine addMedicine(MedicineDto dto) {

        Medicine medicine = Medicine.builder()
                .medicineName(dto.getMedicineName())
                .manufacturer(dto.getManufacturer())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .description(dto.getDescription())
                .build();

        return medicineRepository.save(medicine);
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Medicine getMedicineById(Long id) {

        return medicineRepository.findById(id)
                .orElseThrow(() ->
                        new MedicineNotFoundException(
                                "Medicine not found with id : " + id));
    }

    public Medicine updateMedicine(Long id,
                                   MedicineDto dto) {

        Medicine medicine = getMedicineById(id);

        medicine.setMedicineName(dto.getMedicineName());
        medicine.setManufacturer(dto.getManufacturer());
        medicine.setPrice(dto.getPrice());
        medicine.setStock(dto.getStock());
        medicine.setDescription(dto.getDescription());

        return medicineRepository.save(medicine);
    }

    public void deleteMedicine(Long id) {

        Medicine medicine = getMedicineById(id);

        medicineRepository.delete(medicine);
    }
}