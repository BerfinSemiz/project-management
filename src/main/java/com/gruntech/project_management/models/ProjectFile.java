package com.gruntech.project_management.models;

import com.gruntech.project_management.models.enums.DocumentType;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ProjectFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;         // Dosya adı
    private String filePath;         // Sunucudaki yol (uploads/)

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;  // Enum: Belge Türü

    private LocalDate documentDate;  // Belge Tarihi
    private String documentNumber;   // Belge Numarası (Sayı)
    private LocalDate uploadDate;    // Yükleme tarihi

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
