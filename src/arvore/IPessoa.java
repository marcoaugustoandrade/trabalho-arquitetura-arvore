package arvore;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface IPessoa {

    int getUUID();
    String getNome();
    Character getSexo();

    void setLocalNascimento(String localNascimento);
    String getLocalNascimento();

    void setDataNascimento(LocalDate dataNascimento);
    LocalDate getDataNascimento();

    void setLocalFalecimento(String localFalecimento);
    String getLocalFalecimento();

    void setDataFalecimento(LocalDate dataFalecimento);
    LocalDate getDataFalecimento();
}
