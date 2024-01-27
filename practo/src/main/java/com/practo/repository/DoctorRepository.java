package com.practo.repository;


import com.practo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    @Query("SELECT d FROM Doctor d WHERE d.doctorName LIKE %:search% OR d.specializations LIKE %:search%")
    List<Doctor> searchByNameOrSpecialization(@Param("search") String search);
}
