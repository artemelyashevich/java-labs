package com.elyashevich.book.entity;

/**
 * Enum representing different types of book bindings.
 */
public enum BindingType {

    /**
     * Represents a soft binding type.
     */
    SOFT("Soft"),

    /**
     * Represents a hardcover binding type.
     */
    HARDCOVER("Hardcover");

    /**
     * Constructor for BindingType enum.
     *
     * @param bindingType The string representation of the binding type.
     */
    BindingType(String bindingType) {}
}
