package com.gruntech.project_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gruntech.project_management.models.Project;
import com.gruntech.project_management.models.enums.JobType;
import com.gruntech.project_management.models.enums.ProjectStage;
import com.gruntech.project_management.services.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Tüm projeleri getir
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    // ID'ye göre proje getir
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Yeni proje oluştur
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    // Proje güncelle (PUT: tamamını günceller)
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        try {
            Project updated = projectService.updateProject(id, project);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Proje sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    // Filtre: İsme göre arama
    @GetMapping("/search")
    public List<Project> searchByName(@RequestParam String name) {
        return projectService.getProjectsByName(name);
    }

    // Filtre: İşin sahibine göre
    @GetMapping("/owner")
    public List<Project> getByOwner(@RequestParam String owner) {
        return projectService.getProjectsByOwner(owner);
    }

    // Filtre: Duruma göre
    @GetMapping("/projectStage")
    public List<Project> getByProjectStage(@RequestParam ProjectStage ProjectStage) {
    return projectService.getProjectsByProjectStage(ProjectStage);
    }


    // Filtre: İş koluna göre
    @GetMapping("/jobType")
    public List<Project> getByJobType(@RequestParam JobType jobType) {
        return projectService.getProjectsByJobType(jobType);
    }


    // Filtre: Sorumlu mühendis
    @GetMapping("/responsible")
    public List<Project> getByResponsible(@RequestParam String responsible) {
        return projectService.getProjectsByResponsible(responsible);
    }
}
