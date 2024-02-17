package com.lufegaba.datalab.model.entities.enumerations;

public enum Concentration {
    NO_DILUTED("N/D"),
    DILUTION_01("D_1"),
    DILUTION_02 ("D_2"),
    DILUTION_03("D_3"),
    DILUTION_04("D_4"),
    DILUTION_05("D_1");

    private String code;

    Concentration(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
