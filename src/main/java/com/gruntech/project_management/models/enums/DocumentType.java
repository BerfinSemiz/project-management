package com.gruntech.project_management.models.enums;

public enum DocumentType {
    STATIK_PROJE,
    CAGRI_MEKTUBU,
    BAGLANTI_ANLASMASI,
    GES_ELEKTRIK_PROJE,
    BELEDIYE_UYGUNLUK,
    ON_KABUL,
    GECICI_KABUL;

    @Override
    public String toString() {
        switch (this) {
            case STATIK_PROJE: return "Statik Proje";
            case CAGRI_MEKTUBU: return "Çağrı Mektubu";
            case BAGLANTI_ANLASMASI: return "Bağlantı Anlaşması";
            case GES_ELEKTRIK_PROJE: return "GES Elektrik Proje";
            case BELEDIYE_UYGUNLUK: return "Belediye Uygunluk";
            case ON_KABUL: return "Ön Kabul";
            case GECICI_KABUL: return "Geçici Kabul";
            default: return super.toString();
        }
    }
}
