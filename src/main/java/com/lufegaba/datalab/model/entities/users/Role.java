package com.lufegaba.datalab.model.entities.users;

public enum Role {
    ADMIN("Admin"),
    WORKER("Worker"),
    USER("User");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
