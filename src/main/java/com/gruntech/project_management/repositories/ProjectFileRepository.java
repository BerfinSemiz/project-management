package com.gruntech.project_management.repositories;

import com.gruntech.project_management.models.ProjectFile;
import com.gruntech.project_management.models.Project;
import com.gruntech.project_management.models.enums.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectFileRepository extends JpaRepository<ProjectFile, Long> {

    // Belirli bir projeye ait tüm belgeleri getir
    List<ProjectFile> findByProject(Project project);

    // Belirli bir proje + belge türü ile belgeyi getir (her belge türünden 1 tane olacağı varsayılırsa)
    Optional<ProjectFile> findByProjectAndDocumentType(Project project, DocumentType documentType);

    // Bir projenin tüm belge türlerine göre gruplanmış dosyaları dönebilir
    List<ProjectFile> findByProjectId(Long projectId);
}
