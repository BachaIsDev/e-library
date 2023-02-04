package com.bacha.libraryproject.entity;

public enum Permission {
    BOOKS_READ("books:read"),
    BOOKS_WRITE("books:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
