package com.lufegaba.datalab.model.entities.enumerations;

public enum SamplingType {
    POR_EL_LABORATORIO ("LAB"),
    POR_EL_CLIENTE ("CLI"),
    POR_MENSAJERÍA ("MEN");

    public final String label;

    private SamplingType (String label) {
        this.label = label;
    }
}
