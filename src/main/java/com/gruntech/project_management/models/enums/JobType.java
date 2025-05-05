package com.gruntech.project_management.models.enums;

public enum JobType {
    GES_PROJESI("GES Projesi"),
    GUC_ARTISI("Güç Artışı"),
    YENI_ABONELIK("Yeni Abonelik");

    private final String label;

    JobType(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
