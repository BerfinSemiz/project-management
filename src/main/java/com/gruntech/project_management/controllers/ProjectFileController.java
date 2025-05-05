package com.gruntech.project_management.controllers;

import com.gruntech.project_management.models.ProjectFile;
import com.gruntech.project_management.services.ProjectFileService;
import com.gruntech.project_management.models.enums.DocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectFileController {

    @Autowired
    private ProjectFileService projectFileService;

    // 🔽 1. Dosya yükleme
    @PostMapping("/projects/{projectId}/files")
    public ResponseEntity<ProjectFile> uploadFile(
            @PathVariable Long projectId,
            @RequestParam("file") MultipartFile file,
            @RequestParam("documentType") DocumentType documentType,
            @RequestParam("documentDate") String documentDateStr,
            @RequestParam("documentNumber") String documentNumber
    ) throws IOException {

        LocalDate documentDate = LocalDate.parse(documentDateStr);
        ProjectFile savedFile = projectFileService.uploadFile(projectId, file, documentType, documentDate, documentNumber);
        return new ResponseEntity<>(savedFile, HttpStatus.CREATED);
    }

    // 📋 2. Projeye ait tüm dosyaları getir
    @GetMapping("/projects/{projectId}/files")
    public ResponseEntity<List<ProjectFile>> getFilesByProject(@PathVariable Long projectId) {
        List<ProjectFile> files = projectFileService.getFilesByProjectId(projectId);
        return new ResponseEntity<>(files, HttpStatus.OK);
    }

    // 📥 3. Dosya indir / görüntüle
    @GetMapping("/files/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) throws MalformedURLException {
        List<ProjectFile> allFiles = projectFileService.getFilesByProjectId(fileId);
        ProjectFile file = allFiles.stream()
                .filter(f -> f.getId().equals(fileId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Dosya bulunamadı"));

        File physicalFile = new File(file.getFilePath());
        if (!physicalFile.exists()) {
            throw new RuntimeException("Fiziksel dosya sistemde bulunamadı");
        }

        Path path = physicalFile.toPath();
        Resource resource = new UrlResource(path.toUri());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    // ❌ 4. Dosya sil
    @DeleteMapping("/files/{fileId}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long fileId) {
        projectFileService.deleteFile(fileId);
        return ResponseEntity.noContent().build();
    }
}
