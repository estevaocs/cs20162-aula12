/**
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 *
 * Pacote Contendo as Classes de interção com o usuário.
 */
package com.github.estevaocs.view;

import com.github.estevaocs.dao.DAOJson;
import com.github.estevaocs.dao.DAO_HTML;
import java.io.IOException;

/**
 * Classe Principal
 *
 * @author Estevao Cristino
 * @since 04/12/2016.
 * @version 1.0
 */
public class qp {

    /**
     * String que guarda o diretório do arquivo.txt
     */
    static String localFile;

    /**
     * Classe de apoio ao qp
     */
    static QpHelper qpHelper = new QpHelper();

    /**
     * Metodo Principal, o Argumentos são referentes ao tipo de relatorio e ao
     * local onde estão salvo os testes em .txt
     *
     * @param args - Local onde está o .txt contendo os testes. Caso cotenha -h
     * antes do Local onde estão os testes, o programa retornará o relatorio em
     * HTML caso contrário será padrão e o relatório será em Json.
     */
    public static void main(String[] args) {
        System.exit(pseudoMain(args));
    }

    /**
     * Metodo referentr ao Main, o Argumentos são referentes ao tipo de
     * relatorio e ao local onde estão salvo os testes em .txt
     *
     * @param args - Local onde está o .txt contendo os testes. Caso cotenha -h
     * antes do Local onde estão os testes, o programa retornará o relatorio em
     * HTML caso contrário será padrão e o relatório será em Json.
     * @return int - o retorno do valor 0 ou o valor 1. O valor 0 indica
     * sucesso, enquanto o valor 1 indica a ocorrência de situação excepcional.
     */
    public static int pseudoMain(String[] args) {
        try {
            localFile = args[0];
            try {
                qpHelper.popularTeste();
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace(System.out);
                return 1;
            }
            if (args.length > 1) {
                String op = args[1];
                if (op.equals("-h")) {
                    return htmlOption();
                } else {
                    return jsonOption();
                }
            } else {
                return jsonOption();
            }

        } catch (NullPointerException | IOException e) {
            e.printStackTrace(System.out);
            return 1;
        }
    }

    /**
     * Metodo que chama o construtor de Json e executa os testes;
     *
     * @return int - o retorno do valor 0 ou o valor 1. O valor 0 indica
     * sucesso, enquanto o valor 1 indica a ocorrência de situação excepcional.
     */
    private static int jsonOption() throws IOException {
        DAOJson dao = new DAOJson(localFile);
        dao.add(qpHelper.getTeste());

        return 0;
    }

    /**
     * Método que chama o construtor de HTML e executa os testes;
     *
     * @return int - o retorno do valor 0 ou o valor 1. O valor 0 indica
     * sucesso, enquanto o valor 1 indica a ocorrência de situação excepcional.
     */
    private static int htmlOption() throws IOException {
        DAO_HTML dao = new DAO_HTML(localFile);
        dao.createHTML(qpHelper.getTeste());
        return 0;
    }

}
