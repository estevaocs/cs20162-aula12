/**
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 * 
 * Pacote Contendo todos os dao
 */
package com.github.estevaocs.dao;

import com.google.gson.Gson;
import com.github.estevaocs.model.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe responsável por escrever o Json
 * expressão teste.
 * @author Estevao Cristino
 * @since 04/12/2016.
 * @version 1.0
 */
public class DAOJson {
    
    /**
     * Instanciador do Json.
     * 
     * @see com.google.gson.Gson
     */
    private final Gson gson = new Gson();
    
    /**
     * Codigo Json
     */
    private String json;
    
    /**
     * gerador do arquivo .json
     */
    private final FileWriter fileWriter;
    
    /**
     * escritor do arquivo .json
     */
    private final PrintWriter printWriter;

    /**
     * Construtor do DAOJson
     * instacia o PrintWriter e o FileWrite e cria o arquivo.json
     * @param localFile
     * @throws IOException
     * 
     * @see java.io.IOException
     */
    public DAOJson(String localFile) throws IOException {
        fileWriter = new FileWriter(localFile.replaceAll(".txt",".json"));
        printWriter = new PrintWriter(fileWriter);
    }

    /**
     * Instancia o arquivo.json
     * @param test - resultados dos testes executados
     * @throws IOException
     * 
     * @see java.io.IOException
     * @see com.github.estevaocs.model.Test
     */
    public void add(Test test) throws IOException {
        json = gson.toJson(test);
        printWriter.write(json);
        fileWriter.close();
        printWriter.close();
    }
}
