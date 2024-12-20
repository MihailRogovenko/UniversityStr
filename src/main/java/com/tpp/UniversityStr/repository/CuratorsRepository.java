package com.tpp.UniversityStr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpp.UniversityStr.models.Curators;

@Repository
public interface CuratorsRepository extends JpaRepository<Curators, Integer> {
}
