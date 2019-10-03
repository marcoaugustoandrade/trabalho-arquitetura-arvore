package exporta;

import arvore.IPessoa;

public interface IExporta {

    void to(String tipo, String fileName, IPessoa pessoa);
}
