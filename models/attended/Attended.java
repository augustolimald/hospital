package models.attended;

import java.time.LocalDate;
import models.Person;

public abstract class Attended extends Person {
    private final String tipoSanguineo;
    private final float height, weight;

    public Attended(String name, String cpf, String genre, LocalDate birthdate, String tipoSanguineo, float height, float weight) {
        super(name, cpf, genre, birthdate);
        this.tipoSanguineo = tipoSanguineo;
        this.height = height;
        this.weight = weight;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return super.toString() +
              " | " + 
              tipoSanguineo +
              " | " +
              height +
              " | " +
              weight;
    }
}
