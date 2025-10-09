package hu.unideb.model;

import java.util.Random;

public enum Program {
    CS_BSC,
    CSE_BSC,
    BI_BSC;

    private static final Random RANDOM = new Random();

    public static Program random() {
        final var length = RANDOM.nextInt(values().length);
        return values()[length];
    }
}
