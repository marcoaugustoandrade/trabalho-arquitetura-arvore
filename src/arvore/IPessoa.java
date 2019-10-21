package arvore;

import java.time.LocalDate;

public interface IPessoa {

    int getUUID();

    void setNome(String nome);
    String getNome();

    void setSexo(Character sexo);
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
