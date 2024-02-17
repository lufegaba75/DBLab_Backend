package com.lufegaba.datalab.model.entities.enumerations;

public enum WayType {
    CALLE ("C/"),
    AVENIDA ("Avda/"),
    CARRETERA ("Ctra/"),
    CAMINO ("Cmno/"),
    PLAZA ("Pza/"),
    URBANIZACIÓN ("Urb."),
    POLÍGONO_INDUSTRIAL ("P.I.");

    public final String label;

    private WayType (String label) {
        this.label = label;
    }
}
