import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Princess {
    String name;
    int age;
    String movie;

    public Princess(String line) {
        final var tokens = line.split(";");
        this.name = tokens[0];
        this.age = Integer.parseInt(tokens[1]);
        this.movie = tokens[2];
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return String.format("%s;%d;%s", name, age, movie);
    }

    public static void main(String[] args) throws IOException {
        try(final var br = new BufferedReader(new InputStreamReader(System.in))) {
            br.lines()
                    .map(line -> new Princess(line))
                    .sorted(Comparator.comparing(Princess::getMovie, Comparator.reverseOrder())
                            .thenComparing(Princess::getAge, Comparator.reverseOrder())
                            .thenComparing(Princess::getName, Comparator.naturalOrder()))
                    .forEach(System.out::println);
        }
    }
}
