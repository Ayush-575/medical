package com.example.Medical_store.Controller;
import com.example.Medical_store.Dto.MedicineDto;
import com.example.Medical_store.Entity.Medicine;
import com.example.Medical_store.Service.MedicineService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/add")
    public Medicine addMedicine(
            @Valid @RequestBody MedicineDto dto) {

        return medicineService.addMedicine(dto);
    }

    @GetMapping("/all")
    public List<Medicine> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public Medicine getMedicineById(
            @PathVariable Long id) {

        return medicineService.getMedicineById(id);
    }

    @PutMapping("/{id}")
    public Medicine updateMedicine(
            @PathVariable Long id,
            @Valid @RequestBody MedicineDto dto) {

        return medicineService.updateMedicine(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteMedicine(
            @PathVariable Long id) {

        medicineService.deleteMedicine(id);

        return "Medicine Deleted Successfully";
    }
}
