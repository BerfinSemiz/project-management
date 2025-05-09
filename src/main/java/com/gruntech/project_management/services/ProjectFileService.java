package com.gruntech.project_management.services;

import com.gruntech.project_management.models.Project;
import com.gruntech.project_management.models.ProjectFile;
import com.gruntech.project_management.models.enums.DocumentType;
import com.gruntech.project_management.repositories.ProjectFileRepository;
import com.gruntech.project_management.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectFileService {

    @Autowired
    private ProjectFileRepository projectFileRepository;

    @Autowired
    private ProjectRepository projectRepository;

    // Belirli bir projeye ait tüm dosyaları getir
    public List<ProjectFile> getFilesByProjectId(Long projectId) {
        return projectFileRepository.findByProjectId(projectId);
    }

    // Belirli bir proje ve belge türüne göre dosya getir
    public Optional<ProjectFile> getFileByProjectAndType(Long projectId, DocumentType type) {
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        return projectOpt.flatMap(project -> projectFileRepository.findByProjectAndDocumentType(project, type));
    }

    // Belirli bir dosya ID'sine göre dosya getir
    public Optional<ProjectFile> getFileById(Long id) {
        return projectFileRepository.findById(id);
    }

    
    // Yeni dosya kaydet
    public ProjectFile saveFile(ProjectFile file) {
        return projectFileRepository.save(file);
    }

    // Dosya sil
    public void deleteFile(Long id) {
        projectFileRepository.deleteById(id);
    }
}
