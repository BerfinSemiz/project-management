package com.gruntech.project_management.models.enums;

public enum RegulationType {
    ON_BIR_BIR("11/1", 90),
    ON_BIR_IKI("11/2", 60),
    ON_BIR_UC("11/3", 45),
    BES_BIR_H("5.1h", 30);

    private final String label;
    private final int dayLimit;

    RegulationType(String label, int dayLimit) {
        this.label = label;
        this.dayLimit = dayLimit;
    }

    public String getLabel() {
        return label;
    }

    public int getDayLimit() {   
        return dayLimit;
    }

    @Override
    public String toString() {
        return label;
    }
}
