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
    public void to(String tipo, String fileName, IPessoa pessoa) {

        String data = "";

        if (tipo.equals("JSON")){
            exportaParaJSON = new ExportaParaJSON(pessoa);
            data = exportaParaJSON.export(0);
            fileName += ".json";

        } else if (tipo.equals("TOML")){
            exportaParaTOML = new ExportaParaTOML(pessoa);
            data = exportaParaTOML.export();
            fileName += ".toml";

        } else if (tipo.equals("XML")){
            exportaParaXML = new ExportaParaXML(pessoa);
            data = exportaParaXML.export(0);
            fileName += ".xml";

        } else if (tipo.equals("YAML")){
            exportaParaYAML = new ExportaParaYAML(pessoa);
            data = exportaParaYAML.export(0);
            fileName += ".yaml";
        }
        writeFile(fileName, data);
    }

    public void writeFile(String filename, String data){

        BufferedWriter writer = null;
        try{
            File file = new File(filename);
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(data);
            System.out.println("Salvando dados em " + filename);
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
