package exporta;

import arvore.IPessoa;

public interface IExporta {

    void para(String tipo, String fileName, IPessoa pessoa);
    void gravarArquivo(String nomeArquivo, String dados);
}
