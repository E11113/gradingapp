package org.example.gradingapp.repository;

import org.example.gradingapp.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {

    Classes findByCode(String code);
}
