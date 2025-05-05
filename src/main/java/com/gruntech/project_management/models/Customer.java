package com.gruntech.project_management.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;        // İşin sahibi (müşteri adı)
    private String contactInfo; // İletişim bilgisi (opsiyonel)

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Project> projects;

    // Getter ve Setter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
