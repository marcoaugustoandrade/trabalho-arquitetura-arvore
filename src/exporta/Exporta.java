package exporta;

import arvore.IPessoa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exporta implements IExporta{

    private ExportaParaJSON exportaParaJSON;
    private ExportaParaTOML exportaParaTOML;
    private ExportaParaXML exportaParaXML;
    private ExportaParaYAML exportaParaYAML;

    @Override
    public void para(String tipo, String nomeArquivo, IPessoa pessoa) {

        String dados = "";

        if (tipo.equals("JSON")){
            exportaParaJSON = new ExportaParaJSON(pessoa);
            dados = exportaParaJSON.export(0);
            nomeArquivo += ".json";

        } else if (tipo.equals("TOML")){
            exportaParaTOML = new ExportaParaTOML(pessoa);
            dados = exportaParaTOML.export(0);
            nomeArquivo += ".toml";

        } else if (tipo.equals("XML")){
            exportaParaXML = new ExportaParaXML(pessoa);
            dados = exportaParaXML.export(0);
            nomeArquivo += ".xml";

        } else if (tipo.equals("YAML")){
            exportaParaYAML = new ExportaParaYAML(pessoa);
            dados = exportaParaYAML.export(0);
            nomeArquivo += ".yaml";
        }
        gravarArquivo(nomeArquivo, dados);
    }

    public void gravarArquivo(String nomeArquivo, String dados){

        BufferedWriter writer = null;
        try{
            File arquivo = new File(nomeArquivo);
            writer = new BufferedWriter(new FileWriter(arquivo));
            writer.write(dados);
            System.out.println("Salvando dados em " + nomeArquivo);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
