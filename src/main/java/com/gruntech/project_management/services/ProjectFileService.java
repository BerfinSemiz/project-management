package com.gruntech.project_management.services;

import com.gruntech.project_management.models.Project;
import com.gruntech.project_management.models.ProjectFile;
import com.gruntech.project_management.repositories.ProjectFileRepository;
import com.gruntech.project_management.repositories.ProjectRepository;
import com.gruntech.project_management.models.enums.DocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectFileService {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private ProjectFileRepository projectFileRepository;

    @Autowired
    private ProjectRepository projectRepository;

    // Dosya yükleme işlemi
    public ProjectFile uploadFile(
            Long projectId,
            MultipartFile file,
            DocumentType documentType,
            LocalDate documentDate,
            String documentNumber
    ) throws IOException {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Proje bulunamadı: " + projectId));

        // uploads/ klasörünü oluştur (eğer yoksa)
        Files.createDirectories(Paths.get(UPLOAD_DIR));

        // Dosya adı ve path oluştur
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        // Dosyayı uploads klasörüne kaydet
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // ProjectFile nesnesini oluştur ve veritabanına kaydet
        ProjectFile projectFile = new ProjectFile();
        projectFile.setFileName(file.getOriginalFilename());
        projectFile.setFilePath(filePath.toString());
        projectFile.setDocumentType(documentType);
        projectFile.setDocumentDate(documentDate);
        projectFile.setDocumentNumber(documentNumber);
        projectFile.setUploadDate(LocalDate.now());
        projectFile.setProject(project);

        return projectFileRepository.save(projectFile);
    }

    // Belirli projeye ait dosyaları getir
    public List<ProjectFile> getFilesByProjectId(Long projectId) {
        return projectFileRepository.findByProjectId(projectId);
    }

    // Dosya silme işlemi
    public void deleteFile(Long fileId) {
        ProjectFile file = projectFileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("Dosya bulunamadı: " + fileId));

        try {
            Files.deleteIfExists(Paths.get(file.getFilePath()));
        } catch (IOException e) {
            throw new RuntimeException("Dosya sisteminden silinemedi", e);
        }

        projectFileRepository.delete(file);
    }
} 