package models.attended;

import java.time.LocalDate;

public class AdultPatient extends Attended {
    private final boolean isSmoker;
    
    public AdultPatient(String name, String cpf, String genre, LocalDate birthdate, String tipoSanguineo, float height, float weight, boolean isSmoker) {
        super(name, cpf, genre, birthdate, tipoSanguineo, height, weight);
        this.isSmoker = isSmoker;
    }

    public boolean isIsSmoker() {
        return isSmoker;
    }
    
    @Override
    public String toString() {
        return super.toString() +
                " | " +
                isSmoker;
    }
}
