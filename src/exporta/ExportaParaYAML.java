package exporta;

import arvore.IPessoa;
import arvore.PessoaComposite;

public class ExportaParaYAML {

    private IPessoa pessoa;

    public ExportaParaYAML(IPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String export(int nivel) {

        String espacos = "";
        String p = "";

        for (int i = 1; i <= nivel; i++) espacos += "  ";

        if (nivel == 0) {
            p += "nome: " + pessoa.getNome();
            p += "\nuuid: " + pessoa.getUUID();
        } else {
            p += "\n" + espacos + "- nome: " + pessoa.getNome();
            p += "\n" + espacos + "  uuid: " + pessoa.getUUID();
        }

        if (pessoa instanceof PessoaComposite){

            int nivelc = nivel;
            if (!((PessoaComposite) pessoa).getParceiros().isEmpty()){
                if (nivel == 0) p += "\nconjuges:";
                else p += "\n" + espacos + "  conjuges:";
                nivelc++;
                for (IPessoa c: ((PessoaComposite) pessoa).getParceiros()){
                    ExportaParaYAML exportaParaYAML = new ExportaParaYAML(c);
                    p += exportaParaYAML.export(nivelc);
                }
            }

            int nivelf = nivel;
            if (!((PessoaComposite) pessoa).getFilhos().isEmpty()){
                p += "\n" + espacos + "  filhos:";
                nivelf++;
                for (IPessoa f: ((PessoaComposite) pessoa).getFilhos()){
                    ExportaParaYAML exportaParaYAML = new ExportaParaYAML(f);
                    p += exportaParaYAML.export(nivelf);
                }
            }
        }
        return p;
    }
}
