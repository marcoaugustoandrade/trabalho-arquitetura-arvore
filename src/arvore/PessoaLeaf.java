package arvore;

import java.time.LocalDate;

public class PessoaLeaf implements IPessoa {

    private int UUID;
    private String nome;
    private Character sexo;
    private String localNascimento;
    private LocalDate dataNascimento;
    private String localFalecimento;
    private LocalDate dataFalecimento;

    public PessoaLeaf(String nome, Character sexo, String localNascimento, LocalDate dataNascimento, String localFalecimento, LocalDate dataFalecimento) {
        UUID = this.hashCode();
        this.nome = nome;
        this.sexo = sexo;
        this.localNascimento = localNascimento;
        this.dataNascimento = dataNascimento;
        this.localFalecimento = localFalecimento;
        this.dataFalecimento = dataFalecimento;
    }

    @Override
    public int getUUID() {
        return UUID;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    @Override
    public Character getSexo() {
        return sexo;
    }

    @Override
    public void setLocalNascimento(String localNascimento) {
        this.localNascimento = localNascimento;
    }

    @Override
    public String getLocalNascimento() {
        return localNascimento;
    }

    @Override
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public void setLocalFalecimento(String localFalecimento) {
        this.localFalecimento = localFalecimento;
    }

    @Override
    public String getLocalFalecimento() {
        return localFalecimento;
    }

    @Override
    public void setDataFalecimento(LocalDate dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    @Override
    public LocalDate getDataFalecimento() {
        return dataFalecimento;
    }
}
