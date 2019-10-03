package exporta;

import arvore.IPessoa;
import arvore.PessoaComposite;

public class ExportaParaXML {

    private IPessoa pessoa;

    public ExportaParaXML(IPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String export(boolean header, int nivel){

        String p = "";
        if (header) p += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
        p += "\n<pessoa uuid=\"" + pessoa.getUUID() + "\">";
        p += "\n<nome>" + pessoa.getNome() + "</nome>";

        if (pessoa instanceof PessoaComposite){

            // Caso tenha filhos
            if (!((PessoaComposite) pessoa).getFilhos().isEmpty()){
                p += "\n<filhos>";
                for (IPessoa filho: ((PessoaComposite) pessoa).getFilhos()){
                    ExportaParaXML exportaParaXML = new ExportaParaXML(filho);
                    p += exportaParaXML.export(false, 0);
                }
                p += "\n</filhos>";
            }

            // Caso tenha parceiros
            if (!((PessoaComposite) pessoa).getParceiros().isEmpty()){
                p += "\n<parceiros>";
                for(IPessoa parceiro: ((PessoaComposite) pessoa).getParceiros()){
                    ExportaParaXML exportaParaXML = new ExportaParaXML(parceiro);
                    p += exportaParaXML.export(false, 0);
                }
                p += "\n</parceiros>";
            }
        }
        p += "\n</pessoa>";
        return p;
    }
}
