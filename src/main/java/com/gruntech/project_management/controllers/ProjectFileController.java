package com.gruntech.project_management.controllers;

import com.gruntech.project_management.models.Project;
import com.gruntech.project_management.models.ProjectFile;
import com.gruntech.project_management.models.enums.DocumentType;
import com.gruntech.project_management.services.ProjectFileService;
import com.gruntech.project_management.repositories.ProjectRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/files")
public class ProjectFileController {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private ProjectFileService projectFileService;

    @Autowired
    private ProjectRepository projectRepository;

    // 1. Belirli bir projeye ait tüm belgeleri getir
    @GetMapping("/project/{projectId}")
    public List<ProjectFile> getFilesByProject(@PathVariable Long projectId) {
        return projectFileService.getFilesByProjectId(projectId);
    }

    // 2. Yeni belge yükle
    @PostMapping("/upload")
    public ProjectFile uploadFile(
            @RequestParam("projectId") Long projectId,
            @RequestParam("documentType") DocumentType documentType,
            @RequestParam("documentDate") String documentDate,
            @RequestParam("documentNumber") String documentNumber,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        if (projectOpt.isEmpty()) throw new RuntimeException("Project not found");

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + "project_" + projectId);
        Files.createDirectories(filePath); // klasör yoksa oluştur

        Path fullPath = filePath.resolve(fileName);
        Files.copy(file.getInputStream(), fullPath, StandardCopyOption.REPLACE_EXISTING);

        ProjectFile pf = new ProjectFile();
        pf.setProject(projectOpt.get());
        pf.setDocumentType(documentType);
        pf.setDocumentDate(LocalDate.parse(documentDate));
        pf.setDocumentNumber(documentNumber);
        pf.setFilePath(fullPath.toString());

        return projectFileService.saveFile(pf);
    }

    // 3. Dosya sil
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFile(@PathVariable Long id) throws IOException {
        Optional<ProjectFile> fileOpt = projectFileService.getFileById(id);
        if (fileOpt.isPresent()) {
            Path path = Paths.get(fileOpt.get().getFilePath());
            Files.deleteIfExists(path);
        }
        projectFileService.deleteFile(id);
    }

    // 4. Dosya indir
    @GetMapping("/download/{id}")
    public void downloadFile(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Optional<ProjectFile> fileOpt = projectFileService.getFileById(id);
        if (fileOpt.isEmpty()) throw new FileNotFoundException("File not found");

        File file = new File(fileOpt.get().getFilePath());
        FileInputStream fis = new FileInputStream(file);

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        StreamUtils.copy(fis, response.getOutputStream());
        fis.close();
    }
}
