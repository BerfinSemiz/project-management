package com.gruntech.project_management.repositories;

import com.gruntech.project_management.models.Project;
import com.gruntech.project_management.models.enums.ProjectStage;
import com.gruntech.project_management.models.enums.JobType; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    //  Proje adına göre arama (ignore case)
    List<Project> findByNameContainingIgnoreCase(String name);

    //  İşin sahibine göre filtreleme
    List<Project> findByOwner(String owner);

    // Belirli bir mühendis sorumluluğundaki projeler
    List<Project> findByResponsible(String responsible);

    //  Durumuna göre filtreleme
    List<Project> findByProjectStage(ProjectStage projectStage);

    //  İş koluna göre filtreleme
    List<Project> findByJobType(JobType jobType);
}
