package com.github.estevaocs.dao;

import com.google.gson.Gson;
import model.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Estevao on 04/12/2016.
 */
public class DAOJson {
    private Gson gson = new Gson();
    private String json;
    private FileWriter fileWriter;
    private PrintWriter printWriter;

    /**
     * Construtor do DAOJson
     * instacia o PrintWriter e o FileWrite e cria o arquivo.json
     * @throws IOException
     */
    public DAOJson(String localFile) throws IOException {
        fileWriter = new FileWriter(localFile.replaceAll(".txt",".json"));
        printWriter = new PrintWriter(fileWriter);
    }

    /**
     * Instancia o arquivo.json
     * @param test - resultados dos testes executados
     * @throws IOException
     */
    public void add(Test test) throws IOException {
        json = gson.toJson(test);
        printWriter.write(json);
        fileWriter.close();
        printWriter.close();
    }
}
