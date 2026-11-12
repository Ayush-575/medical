package com.example.Medical_store.Repository;
import com.example.Medical_store.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository
        extends JpaRepository<Medicine, Long> {

    List<Medicine> findByMedicineNameContaining(String medicineName);
}
