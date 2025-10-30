package hu.unideb.util;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NeptunUtils {
    private static final Random RANDOM = new Random();
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String ALL = LETTERS + DIGITS;

    public static String getNeptun() {
        return IntStream.range(0, 6)
                .mapToObj(pos -> pos == 0
                        ? LETTERS.charAt(RANDOM.nextInt(LETTERS.length()))
                        : ALL.charAt(RANDOM.nextInt(ALL.length()))
                )
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
