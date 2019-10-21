package exporta;

import arvore.IPessoa;
import arvore.PessoaComposite;

public class ExportaParaTOML {

    private IPessoa pessoa;

    public ExportaParaTOML(IPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String export(int nivel) {

        String p = "";

        p += "uuid = \"" + pessoa.getUUID() + "\"\n";
        p += "nome = \"" + pessoa.getNome() + "\"\n";
        p += "sexo = \"" + pessoa.getSexo() + "\"\n";

        if (pessoa.getLocalNascimento() != null)
            p += "local-nascimento = \"" + pessoa.getLocalNascimento() + "\"\n";
        if (pessoa.getDataNascimento() != null)
            p += "data-nascimento = \"" + pessoa.getDataNascimento() + "\"\n";
        if (pessoa.getLocalFalecimento() != null)
            p += "local-falecimento = \"" + pessoa.getLocalNascimento() + "\"\n";
        if (pessoa.getDataFalecimento() != null)
            p += "data-falecimento = \"" + pessoa.getDataFalecimento() + "\"\n";

        if (pessoa instanceof PessoaComposite){

            int nivelf = nivel;
            if (!((PessoaComposite) pessoa).getFilhos().isEmpty()){
                nivelf++;
                for (IPessoa filho: ((PessoaComposite) pessoa).getFilhos()){
                    ExportaParaTOML exportaParaTOML = new ExportaParaTOML(filho);
                    p += "[[";
                    if (nivelf > 1){
                        for (int i = 3; i < nivelf; i++) p += "parceiros.filhos.";
                    }
                    p += "parceiros.filhos";
                    p += "]]\n";
                    p += exportaParaTOML.export(nivelf);
                }
            }

            int nivelp = nivel;
            if (!((PessoaComposite) pessoa).getParceiros().isEmpty()){
                nivelp++;
                for (IPessoa parceiro: ((PessoaComposite) pessoa).getParceiros()){
                    ExportaParaTOML exportaParaTOML = new ExportaParaTOML(parceiro);

                    p += "[[";
                    if (nivelp > 1){
                        for (int i = 2; i < nivelp; i++) p += "parceiros.filhos.";
                    }
                    p += "parceiros";
                    p += "]]\n";
                    //p += "[[parceiros]]\n";


                    p += exportaParaTOML.export(nivelp);
                }
            }
        }
        return p;
    }
}
