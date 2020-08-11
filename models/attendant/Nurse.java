package models.attendant;

import java.time.LocalDate;

public class Nurse extends Attendant {
    public Nurse(String name, String cpf, String genre, LocalDate birthdate) {
        super(name, cpf, genre, birthdate);
    }
}
