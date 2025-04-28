package com.oxyl.coursepfback.Core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Effet {
    NORMAL("normal"),
    SLOW_LOW("slow low"),
    SLOW_MEDIUM("slow medium"),
    SLOW_STOP("slow stop");

    private final String label;

    Effet(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static Effet fromLabel(String label) {
        for (Effet effet : values()) {
            if (effet.label.equalsIgnoreCase(label)) {
                return effet;
            }
        }
        throw new IllegalArgumentException("Unknown label: " + label);
    }
}

