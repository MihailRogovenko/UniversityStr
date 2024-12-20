package com.tpp.UniversityStr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpp.UniversityStr.models.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
}
