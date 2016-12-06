package model;

import java.util.ArrayList;

/**
 * Created by Estevao on 04/12/2016.
 */
public class Test {
    private long tempoTotal;
    private long memoriaInicio;
    private long memoriaFinal;
    private int totalDeTest;
    private int sucessos;
    private int falhas;
    private ArrayList<Expression> testes;


    public Test(ArrayList<Expression> testes) {
        this.testes = testes;
        this.totalDeTest = testes.size();
    }

    public long getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(long tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    public long getTempoMedio() {
        long tempoMedio = tempoTotal / totalDeTest;
        return tempoMedio;
    }


    public int getTotalDeTest() {
        return totalDeTest;
    }


    public int getSucessos() {
        return sucessos;
    }

    public void setSucessos(int sucessos) {
        this.sucessos = sucessos;
        this.falhas = totalDeTest - sucessos;
    }

    public int getFalhas() {
        return falhas;
    }

    public ArrayList<Expression> getTestes() {
        return testes;
    }

    public long getMemoriaInicio() {
        return memoriaInicio;
    }

    public void setMemoriaInicio(long memoriaInicio) {
        this.memoriaInicio = memoriaInicio;
    }

    public long getMemoriaFinal() {
        return memoriaFinal;
    }

    public void setMemoriaFinal(long memoriaFinal) {
        this.memoriaFinal = memoriaFinal;
    }
}
