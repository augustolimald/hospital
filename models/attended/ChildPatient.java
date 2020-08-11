package models.attended;

import java.time.LocalDate;

public class ChildPatient extends Attended {
    private final int codCarteiraVacinacao;
    
    public ChildPatient(String name, String cpf, String genre, LocalDate birthdate, String tipoSanguineo, float height, float weight, int codCarteiraVacinacao) {
        super(name, cpf, genre, birthdate, tipoSanguineo, height, weight);
        this.codCarteiraVacinacao = codCarteiraVacinacao;
    }

    public int getCodCarteiraVacinacao() {
        return codCarteiraVacinacao;
    }
    
    @Override
    public String toString() {
        return super.toString() +
                " | " +
                codCarteiraVacinacao;
    }
}
