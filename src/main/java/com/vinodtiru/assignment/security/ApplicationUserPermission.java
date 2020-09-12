package com.vinodtiru.assignment.security;

public enum ApplicationUserPermission {
    VERSION_READ("version:read"),
    VERSION_WRITE("version:write"),
    VERSION_DELETE("version:delete");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
