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
        for (int i = 1; i <= nivel; i++) espacos += "  ";

        String p = "";

        if (nivel == 0) {
            p += "nome: " + pessoa.getNome();
            p += "\nuuid: " + pessoa.getUUID();
            p += "\nsexo: " + pessoa.getSexo();
            if (pessoa.getLocalNascimento() != null)
                p += "\nLocal nascimento: " + pessoa.getLocalNascimento();
            if (pessoa.getDataNascimento() != null)
                p += "\nData nascimento: " + pessoa.getDataNascimento();
            if (pessoa.getLocalFalecimento() != null)
                p += "\nLocal falecimento: " + pessoa.getLocalNascimento();
            if (pessoa.getDataFalecimento() != null)
                p += "\nData falecimento: " + pessoa.getDataFalecimento();
        } else {
            p += "\n" + espacos + "- nome: " + pessoa.getNome();
            p += "\n" + espacos + "  uuid: " + pessoa.getUUID();
            p += "\n" + espacos + "  sexo: " + pessoa.getSexo();
            if (pessoa.getLocalNascimento() != null)
                p += "\n" + espacos + "  Local nascimento: " + pessoa.getLocalNascimento();
            if (pessoa.getDataNascimento() != null)
                p += "\n" + espacos + "  Data nascimento: " + pessoa.getDataNascimento();
            if (pessoa.getLocalFalecimento() != null)
                p += "\n" + espacos + "  Local falecimento: " + pessoa.getLocalNascimento();
            if (pessoa.getDataFalecimento() != null)
                p += "\n" + espacos + "  Data falecimento: " + pessoa.getDataFalecimento();
        }

        if (pessoa instanceof PessoaComposite){

            int nivelf = nivel;
            if (!((PessoaComposite) pessoa).getParceiros().isEmpty()){
                if (nivel == 0) p += "\nconjuges:";
                else p += "\n" + espacos + "  conjuges:";
                nivelf++;
                for (IPessoa c: ((PessoaComposite) pessoa).getParceiros()){
                    ExportaParaYAML exportaParaYAML = new ExportaParaYAML(c);
                    p += exportaParaYAML.export(nivelf);
                }
            }

            int nivelp = nivel;
            if (!((PessoaComposite) pessoa).getFilhos().isEmpty()){
                p += "\n" + espacos + "  filhos:";
                nivelp++;
                for (IPessoa f: ((PessoaComposite) pessoa).getFilhos()){
                    ExportaParaYAML exportaParaYAML = new ExportaParaYAML(f);
                    p += exportaParaYAML.export(nivelp);
                }
            }
        }
        return p;
    }
}
