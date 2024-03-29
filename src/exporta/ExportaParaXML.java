package exporta;

import arvore.IPessoa;
import arvore.PessoaComposite;

public class ExportaParaXML {

    private IPessoa pessoa;

    public ExportaParaXML(IPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String export(int nivel){

        String espacos = "";
        for (int i = 1; i <= nivel; i++) espacos += "    ";

        String p = "";
        if (nivel == 0) {
            p += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
        }
        p += "\n" + espacos + "<pessoa uuid=\"" + pessoa.getUUID() + "\">";
        p += "\n" + espacos + "<nome>" + pessoa.getNome() + "</nome>";
        p += "\n" + espacos + "<sexo>" + pessoa.getSexo() + "</sexo>";
        if (pessoa.getLocalNascimento() != null)
            p += "\n" + espacos + "<local-nascimento>" + pessoa.getLocalNascimento() + "</local-nascimento>";
        if (pessoa.getDataNascimento() != null)
            p += "\n" + espacos + "<data-nascimento>" + pessoa.getDataNascimento().toString() + "</data-nascimento>";
        if (pessoa.getLocalFalecimento() != null)
            p += "\n" + espacos + "<local-falecimento>" + pessoa.getLocalFalecimento() + "</local-falecimento>";
        if (pessoa.getDataFalecimento() != null)
            p += "\n" + espacos + "<data-falecimento>" + pessoa.getDataFalecimento().toString() + "</data-nascimento>";

        if (pessoa instanceof PessoaComposite){

            int nivelf = nivel;
            if (!((PessoaComposite) pessoa).getFilhos().isEmpty()){
                if (nivel == 0) p += "\n<filhos>";
                else p += "\n" + espacos + "<filhos>";
                nivelf++;
                for (IPessoa filho: ((PessoaComposite) pessoa).getFilhos()){
                    ExportaParaXML exportaParaXML = new ExportaParaXML(filho);
                    p += exportaParaXML.export(nivelf);
                }
                if (nivel == 0) p += "\n</filhos>";
                else p += "\n" + espacos + "</filhos>";
            }

            int nivelp = nivel;
            if (!((PessoaComposite) pessoa).getParceiros().isEmpty()){
                if (nivel == 0) p += "\n<parceiros>";
                else p += "\n" + espacos + "<parceiros>";
                nivelp++;
                for(IPessoa parceiro: ((PessoaComposite) pessoa).getParceiros()){
                    ExportaParaXML exportaParaXML = new ExportaParaXML(parceiro);
                    p += exportaParaXML.export(nivelp);
                }
                if (nivel == 0) p += "\n</parceiros>";
                else p += "\n" + espacos + "</parceiros>";
            }
        }

        if (nivel == 0) p += "\n</pessoa>";
        else p += "\n" + espacos + "</pessoa>";
        return p;
    }
}
