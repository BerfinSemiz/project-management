/* package com.gruntech.project_management.models;

//import com.gruntech.project_management.security.User;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Çalışan adı
    private String department; // Çalışanın uzmanlık alanı
    private String email; // E-posta
    private String phone; // Telefon numarası
    

    @ManyToMany
    @JoinTable(
        name = "project_employee", 
        joinColumns = @JoinColumn(name = "employee_id"), 
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;  // Çalışanların yer aldığı projeler

    // @OneToOne
    // @JoinColumn(name = "user_id")
    // private User user;


    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
*/