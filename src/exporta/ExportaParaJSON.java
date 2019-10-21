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

        String espacos = "";
        for (int i = 1; i <= nivel; i++) espacos += "  ";

        // TODO: falta adicionar a chave "pessoa": {
        String p = "{";
        if (nivel == 0) p += "\n \"uuid\": \"" + pessoa.getUUID() + "\",";
        else p += "\n" + espacos + " \"uuid\": \"" + pessoa.getUUID() + "\",";

        if (pessoa instanceof PessoaLeaf){
            if (nivel == 0) p += "\n \"nome\": \"" + pessoa.getNome() + "\"";
            else p += "\n " + espacos + "\"nome\": \"" + pessoa.getNome() + "\"";
        } else if (!((PessoaComposite) pessoa).getParceiros().isEmpty() || !((PessoaComposite) pessoa).getFilhos().isEmpty()){

            if (nivel == 0) p += "\n \"nome\": \"" + pessoa.getNome() + "\",";
            else p += "\n " + espacos + "\"nome\": \"" + pessoa.getNome() + "\",";

            int nivelf = nivel;
            if (!((PessoaComposite) pessoa).getFilhos().isEmpty()){
                if (nivel == 0) p += "\n\"filhos\": [";
                else p += "\n" + espacos + "\"filhos\": [";

                int numFilhos = 1;
                nivelf++;
                for (IPessoa filho: ((PessoaComposite) pessoa).getFilhos()){
                    ExportaParaJSON exportaParaJSON = new ExportaParaJSON(filho);
                    if (numFilhos != ((PessoaComposite) pessoa).getFilhos().size())
                        p += exportaParaJSON.export(0) + ",";
                    else p += exportaParaJSON.export(0);
                    numFilhos++;
                }
                if (nivel == 0) p += "\n]";
                else p += "\n" + espacos + "]";
            }

            int nivelp = nivel;
            if (!((PessoaComposite) pessoa).getParceiros().isEmpty()){
                if (nivel == 0) p += "\n\"parceiros\": [";
                else p += "\n" + espacos + "\"parceiros\": [";

                int numParceiros = 1;
                nivelp++;
                for (IPessoa parceiro: ((PessoaComposite) pessoa).getParceiros()){
                    ExportaParaJSON exportaParaJSON = new ExportaParaJSON(parceiro);
                    if (numParceiros != ((PessoaComposite) pessoa).getParceiros().size())
                        p += exportaParaJSON.export(nivelp++) + ",";
                    else p += exportaParaJSON.export(nivelp++);
                    numParceiros++;
                }
                if (nivel == 0) p += "\n]";
                else p += "\n" + espacos + "]";
            }
        }

        if (nivel == 0) p += "}";
        else p += espacos + "}";
        return p;
    }
}
