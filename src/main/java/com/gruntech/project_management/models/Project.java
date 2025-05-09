package com.gruntech.project_management.models;

import com.gruntech.project_management.models.enums.ApprovalStatus;
import com.gruntech.project_management.models.enums.JobType;
import com.gruntech.project_management.models.enums.ProjectStage;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;               // İşin Adı
    private String owner;              // İşin Sahibi
    
    private String responsible;        // Sorumlu (mühedis)
    private LocalDate startDate;       // İşe Başlanma Tarihi
    private LocalDate endDate;         // Bitiş Tarihi

    @Enumerated(EnumType.STRING)
    private JobType jobType;            // İş Kolu

    private String scope;              // İşin Kapsamı
    private String description;        // İşin Mahiyeti
    private String generalNotes;       // Genel Notlar
    
    private String locationOwner;      // Yer Sahibi
    private String address;            // Yer Adresi
    private String parcel;             // Ada Parsel
   
    private String panelType;          // Kullanılan PV Panel
    private Integer panelCount;        // Kullanılan PV Panel Adedi
    private String inverter;           // Kullanılan İnverter
    private String inverterSerial;     // İnverter Seri Numarası
    
    
    private String callLetterStatus;    // Çağrı Mektubu
    private String approvalDueText;     // Proje onayı için kalan süre (örnek: "15 gün kaldı")
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private ApprovalStatus approvalStatus;      // Proje Onay Durumu
    


    private String connectionAgreement; // Bağlantı Sözleşmesi
    
    private String staticStatus;       // Statik Durumu
    private String lastOperation;      // Son İşlem

    @Enumerated(EnumType.STRING)
    private ProjectStage projectStage; // Proje Durumu
    
    private String invoiceStatus;      // Fatura Durumu
    

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


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


    public String getOwner() {
        return owner;
    }


    public void setOwner(String owner) {
        this.owner = owner;
    }


    public String getResponsible() {
        return responsible;
    }


    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }


    public LocalDate getStartDate() {
        return startDate;
    }


    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }


    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public JobType getJobType() {
        return jobType;
    }


    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }


    public String getScope() {
        return scope;
    }


    public void setScope(String scope) {
        this.scope = scope;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getGeneralNotes() {
        return generalNotes;
    }


    public void setGeneralNotes(String generalNotes) {
        this.generalNotes = generalNotes;
    }


    public String getLocationOwner() {
        return locationOwner;
    }


    public void setLocationOwner(String locationOwner) {
        this.locationOwner = locationOwner;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getParcel() {
        return parcel;
    }


    public void setParcel(String parcel) {
        this.parcel = parcel;
    }


    public String getPanelType() {
        return panelType;
    }


    public void setPanelType(String panelType) {
        this.panelType = panelType;
    }


    public Integer getPanelCount() {
        return panelCount;
    }


    public void setPanelCount(Integer panelCount) {
        this.panelCount = panelCount;
    }


    public String getInverter() {
        return inverter;
    }


    public void setInverter(String inverter) {
        this.inverter = inverter;
    }


    public String getInverterSerial() {
        return inverterSerial;
    }


    public void setInverterSerial(String inverterSerial) {
        this.inverterSerial = inverterSerial;
    }


    public String getCallLetterStatus() {
        return callLetterStatus;
    }


    public void setCallLetterStatus(String callLetterStatus) {
        this.callLetterStatus = callLetterStatus;
    }


    public String getApprovalDueText() {
        return approvalDueText;
    }


    public void setApprovalDueText(String approvalDueText) {
        this.approvalDueText = approvalDueText;
    }


    public String getConnectionAgreement() {
        return connectionAgreement;
    }


    public void setConnectionAgreement(String connectionAgreement) {
        this.connectionAgreement = connectionAgreement;
    }


    public String getStaticStatus() {
        return staticStatus;
    }


    public void setStaticStatus(String staticStatus) {
        this.staticStatus = staticStatus;
    }


    public String getLastOperation() {
        return lastOperation;
    }


    public void setLastOperation(String lastOperation) {
        this.lastOperation = lastOperation;
    }


    public ProjectStage getProjectStage() {
        return projectStage;
    }


    public void setProjectStage(ProjectStage projectStage) {
        this.projectStage = projectStage;
    }


    public String getInvoiceStatus() {
        return invoiceStatus;
    }


    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }


    public Customer getCustomer() {
        return customer;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
    
}
