package com.gruntech.project_management.repositories;

import com.gruntech.project_management.models.ProjectFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectFileRepository extends JpaRepository<ProjectFile, Long> {

    // Belirli bir projeye ait tüm dosyaları getir
    List<ProjectFile> findByProjectId(Long projectId);
}
