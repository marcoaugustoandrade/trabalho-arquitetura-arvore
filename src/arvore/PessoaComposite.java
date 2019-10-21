package arvore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaComposite implements IPessoa {

    private int UUID;
    private String nome;
    private Character sexo;
    private String localNascimento;
    private LocalDate dataNascimento;
    private String localFalecimento;
    private LocalDate dataFalecimento;
    private List<IPessoa> parceiros;
    private List<IPessoa> filhos;

    public PessoaComposite(String nome, Character sexo, String localNascimento,
                           LocalDate dataNascimento, String localFalecimento, LocalDate dataFalecimento) {
        UUID = this.hashCode();
        this.nome = nome;
        this.sexo = sexo;
        this.localNascimento = localNascimento;
        this.dataNascimento = dataNascimento;
        this.localFalecimento = localFalecimento;
        this.dataFalecimento = dataFalecimento;
        parceiros = new ArrayList<IPessoa>();
        filhos = new ArrayList<IPessoa>();
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

    public void addParceiro(IPessoa parceiro){
        this.parceiros.add(parceiro);
    }

    public List<IPessoa> getParceiros(){
        return parceiros;
    }

    public void addFilho(IPessoa filho){
        this.filhos.add(filho);
    }

    public List<IPessoa> getFilhos(){
        return filhos;
    }

}
