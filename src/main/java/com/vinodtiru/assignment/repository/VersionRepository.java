package com.vinodtiru.assignment.repository;
import com.vinodtiru.assignment.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<Version, Integer > {
}
