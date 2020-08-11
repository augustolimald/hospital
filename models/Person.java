package models;

import java.time.LocalDate;
import java.util.Objects;
import utils.DateManipulator;

public abstract class Person {
    private final String name, cpf, genre;
    private final LocalDate birthdate;
    
    public Person(String name, String cpf, String genre, LocalDate birthdate) {
        this.name = name;
        this.cpf = cpf;
        this.genre = genre;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        Person other = (Person) obj;
        return cpf.equals(other.cpf);
    }

    @Override
    public String toString() {
        return 
            name +
            " | " +
            cpf +
            " | " + 
            DateManipulator.dateToString(birthdate)+
            " | " +
            genre;
    }
}
