package com.github.estevaocs.view;

import com.github.estevaocs.dao.*;
import dao.DAO_HTML;
import java.io.IOException;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Created by Estevao on 04/12/2016.
 */
public class qp {

    static String localFile;

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

    public static int pseudoMain(String[] args) {
        try {
            localFile = args[0];
            try {
                QpHelper.popularTeste();
            } catch (IOException | NumberFormatException e) {
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

        } catch (NullPointerException e) {
            return 1;
        }
    }

    /**
     * Metodo que chama o construtor de Json e executa os testes;
     */
    private static int jsonOption() {
        try {
            DAOJson dao = new DAOJson(localFile);
            dao.add(QpHelper.getTeste());
        } catch (IOException ioe) {
            return 1;
        }
        return 0;
    }

    /**
     * Método que chama o construtor de HTML e executa os testes;
     */
    private static int htmlOption() {
        try {
            DAO_HTML dao = new DAO_HTML(localFile);
            dao.createHTML(QpHelper.getTeste());
        } catch (IOException ioe) {
            return 1;
        }
        return 0;
    }

}
