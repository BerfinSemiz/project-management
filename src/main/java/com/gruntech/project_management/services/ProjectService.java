package com.gruntech.project_management.services;

import com.gruntech.project_management.models.Project;
import com.gruntech.project_management.models.enums.JobType;
import com.gruntech.project_management.models.enums.ProjectStage;

import com.gruntech.project_management.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Tüm projeleri getir
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // ID ile proje getir
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    // Yeni proje oluştur
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // Proje güncelle
    public Project updateProject(Long id, Project updatedProject) {
        Project existingProject = projectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Proje bulunamadı: ID = " + id));
    
        // Alanlar null değilse güncelle
        if (updatedProject.getName() != null) existingProject.setName(updatedProject.getName());
        if (updatedProject.getOwner() != null) existingProject.setOwner(updatedProject.getOwner());
        if (updatedProject.getResponsible() != null) existingProject.setResponsible(updatedProject.getResponsible());
        if (updatedProject.getStartDate() != null) existingProject.setStartDate(updatedProject.getStartDate());
        if (updatedProject.getEndDate() != null) existingProject.setEndDate(updatedProject.getEndDate());
        if (updatedProject.getJobType() != null) existingProject.setJobType(updatedProject.getJobType());
        if (updatedProject.getScope() != null) existingProject.setScope(updatedProject.getScope());
        if (updatedProject.getDescription() != null) existingProject.setDescription(updatedProject.getDescription());
        if (updatedProject.getGeneralNotes() != null) existingProject.setGeneralNotes(updatedProject.getGeneralNotes());
        if (updatedProject.getLocationOwner() != null) existingProject.setLocationOwner(updatedProject.getLocationOwner());
        if (updatedProject.getAddress() != null) existingProject.setAddress(updatedProject.getAddress());
        if (updatedProject.getParcel() != null) existingProject.setParcel(updatedProject.getParcel());
        if (updatedProject.getPanelType() != null) existingProject.setPanelType(updatedProject.getPanelType());
        if (updatedProject.getPanelCount() != null) existingProject.setPanelCount(updatedProject.getPanelCount());
        if (updatedProject.getInverter() != null) existingProject.setInverter(updatedProject.getInverter());
        if (updatedProject.getRegulationTypes() != null) existingProject.setRegulationTypes(updatedProject.getRegulationTypes());
        if (updatedProject.getInverterSerial() != null) existingProject.setInverterSerial(updatedProject.getInverterSerial());
        if (updatedProject.getCallLetterDate() != null) existingProject.setCallLetterDate(updatedProject.getCallLetterDate());
        if (updatedProject.getApprovalDueText() != null) existingProject.setApprovalDueText(updatedProject.getApprovalDueText());
        if (updatedProject.getApprovalStatus() != null) existingProject.setApprovalStatus(updatedProject.getApprovalStatus());
        if (updatedProject.getConnectionAgreement() != null) existingProject.setConnectionAgreement(updatedProject.getConnectionAgreement());
        if (updatedProject.getStaticStatus() != null) existingProject.setStaticStatus(updatedProject.getStaticStatus());
        if (updatedProject.getLastOperation() != null) existingProject.setLastOperation(updatedProject.getLastOperation());
        if (updatedProject.getProjectStage() != null) existingProject.setProjectStage(updatedProject.getProjectStage());
        if (updatedProject.getInvoiceStatus() != null) existingProject.setInvoiceStatus(updatedProject.getInvoiceStatus());
    
        return projectRepository.save(existingProject);
    }
    

    // Proje sil
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    // Filtreleme metotları
    public List<Project> getProjectsByName(String name) {
        return projectRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Project> getProjectsByOwner(String owner) {
        return projectRepository.findByOwner(owner);
    }

    public List<Project> getProjectsByResponsible(String responsible) {
        return projectRepository.findByResponsible(responsible);
    }

    public List<Project> getProjectsByProjectStage(ProjectStage projectStage) {
        return projectRepository.findByProjectStage(projectStage);
    }

    public List<Project> getProjectsByJobType(JobType jobType) {
        return projectRepository.findByJobType(jobType);
    }

}
