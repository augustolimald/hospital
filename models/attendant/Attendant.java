package models.attendant;

import java.time.LocalDate;
import models.Person;

public abstract class Attendant extends Person {
    private boolean available;

    public Attendant(String name, String cpf, String genre, LocalDate birthdate) {
        super(name, cpf, genre, birthdate);
        available = true;
    }
    
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
