package exporta;

import arvore.IPessoa;
import arvore.PessoaComposite;
import arvore.PessoaLeaf;

public class ExportaParaJSON {

    private IPessoa pessoa;

    public ExportaParaJSON(IPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String export(int nivel) {

        // TODO: falta adicionar a chave "pessoa": {
        String p = "{";
        p += "\n \"uuid\": \"" + pessoa.getUUID() + "\",";

        if (pessoa instanceof PessoaLeaf){
            p += "\n \"nome\": \"" + pessoa.getNome() + "\"";
        } else if (!((PessoaComposite) pessoa).getParceiros().isEmpty() || !((PessoaComposite) pessoa).getFilhos().isEmpty()){

            p += "\n \"nome\": \"" + pessoa.getNome() + "\",";

            // Caso tenha filhos
            if (!((PessoaComposite) pessoa).getFilhos().isEmpty()){
                p += "\n\"filhos\": [";

                int numFilhos = 1;
                for (IPessoa filho: ((PessoaComposite) pessoa).getFilhos()){
                    ExportaParaJSON exportaParaJSON = new ExportaParaJSON(filho);
                    if (numFilhos != ((PessoaComposite) pessoa).getFilhos().size())
                        p += exportaParaJSON.export(0) + ",";
                    else p += exportaParaJSON.export(0);
                    numFilhos++;
                }
                p += "\n]";
            }

            // Caso tenha parceiros
            if (!((PessoaComposite) pessoa).getParceiros().isEmpty()){
                p += "\n\"parceiros\": [";

                int numParceiros = 1;
                for (IPessoa parceiro: ((PessoaComposite) pessoa).getParceiros()){
                    ExportaParaJSON exportaParaJSON = new ExportaParaJSON(parceiro);
                    if (numParceiros != ((PessoaComposite) pessoa).getParceiros().size())
                        p += exportaParaJSON.export(0) + ",";
                    else p += exportaParaJSON.export(0);
                    numParceiros++;
                }
                p += "\n]";
            }
        }

        p += "}";
        return p;
    }
}
