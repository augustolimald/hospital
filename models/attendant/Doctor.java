package models.attendant;

import java.time.LocalDate;

public class Doctor extends Attendant {
    private final String CRM;
    
    public Doctor(String name, String cpf, String genre, LocalDate birthdate, String CRM) {
        super(name, cpf, genre, birthdate);
        this.CRM = CRM;
    }

    public String getCRM() {
        return CRM;
    }
    
    @Override
    public String toString() {
        return super.toString() +
                " | " +
                CRM;
    }
}
