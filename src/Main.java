import arvore.IPessoa;
import arvore.PessoaComposite;
import arvore.PessoaLeaf;
import exporta.Exporta;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {

        // Os filhos sao adicionados aos parceiros
        // Todas as pessoas que possuem parceiro(a) sao PessoaComposite
        // Todas as pessoas que sao parceiros(as) e possuem filhos(as) sao PessoaComposite
        // Todas as pessoas que sao parceiros(as) e NAO possuem filhos(as) sao PessoaLeaf
        // Todas as pessoas que sao filhos(as) e possuem parceiros(as) sao PessoaComposite
        // Todas as pessoas que sao filhos(as) e nao possuem parceiros(as) sao PessoaLeaf

        IPessoa maria = new PessoaComposite("Maria", 'F', "Sao Paulo - SP",
                LocalDate.of(1970, Month.APRIL, 10), null, null);
        IPessoa joao = new PessoaComposite("Joao",'M', "Rio de Janeiro - RJ",
                LocalDate.of(1971, Month.AUGUST, 20), null, null);
        ((PessoaComposite) maria).addParceiro(joao);

        IPessoa joana = new PessoaLeaf("Joana",'F', "Belo Horizonte - BH",
                LocalDate.of(1992, Month.AUGUST, 3), null, null);
        IPessoa mariana = new PessoaComposite("Mariana",'F', "Belo Horizonte - BH",
                LocalDate.of(1994, Month.JANUARY, 8), null, null);
        ((PessoaComposite) joao).addFilho(joana);
        ((PessoaComposite) joao).addFilho(mariana);

        IPessoa otavio = new PessoaLeaf("Otavio",'M', "Belo Horizonte - BH",
                LocalDate.of(1990, Month.AUGUST, 23), null, null);
        ((PessoaComposite) mariana).addParceiro(otavio);

        IPessoa jose = new PessoaComposite("Jose",'M', "Cuiaba - MT",
                LocalDate.of(1971, Month.MARCH, 2), null, null);
        ((PessoaComposite) maria).addParceiro(jose);

        IPessoa mario = new PessoaComposite("Mario",'M', "Belo Horizonte - BH",
                LocalDate.of(1995, Month.FEBRUARY, 1), null, null);
        ((PessoaComposite) jose).addFilho(mario);

        IPessoa ana = new PessoaComposite("Ana",'F', "Belo Horizonte - BH",
                LocalDate.of(1990, Month.JANUARY, 30), null, null);
        ((PessoaComposite) mario).addParceiro(ana);

        IPessoa tatiana = new PessoaLeaf("Tatiana",'F', "Belo Horizonte - BH",
                LocalDate.of(2018, Month.AUGUST, 23), null, null);
        ((PessoaComposite) ana).addFilho(tatiana);

        // Exportando dados
        Exporta exporta = new Exporta();
        exporta.to("XML", "dados", maria);
        exporta.to("JSON", "dados", maria);
    }
}
