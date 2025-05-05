package com.gruntech.project_management.models.enums;

public enum ProjectStage {
    IPTAL("İptal"),
    VERILDI_ONAY_BEKLIYOR("Verildi - Onay Bekliyor"),
    TAMAMLANDI("Tamamlandı"),
    HAZIRLANDI_VERILMEDI("Hazırlandı - Verilmedi"),
    HAZIRLANDI_EKSIK_VAR("Hazırlandı - Eksik Var"),
    HAZIRLANACAK("Hazırlanacak");

    private final String label;

    ProjectStage(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
