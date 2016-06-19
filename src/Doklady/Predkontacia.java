/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doklady;

import RamcovaUctovaOsnova.Ucet;
import java.io.Serializable;

/**
 *
 * @author kubala25
 */
public class Predkontacia implements Serializable {
    private Ucet stranaMD;
    private Ucet stranaD;
    private double suma;
    private String znenie;
    
    public Predkontacia(Ucet md, Ucet d, double suma, String znenie) {
        if (md == null || d == null) {
            throw new IllegalArgumentException("Pre MD a D je potrebne zadať účet");
        } else {
            stranaD = d;
            stranaMD = md;
        }
        if (suma <= 0) {
            throw new IllegalArgumentException("Nie je možné vykonať predkontáciu s nulovou hodnotou");
        } else {
            this.suma = suma;
        }
        if (znenie == null || znenie.length() == 0) {
            throw new IllegalArgumentException("Je potrebné zadať znenie predkontácie");
        } else {
            this.znenie = znenie;
        }
    }

    public double getSuma() {
        return suma;
    }
    
    public void vykonajPredkontaciu() {
        this.stranaMD.pridajSumuNaMD(suma);
        this.stranaD.pridajSumuNaD(suma);
    }

    public Ucet getStranaMD() {
        return stranaMD;
    }

    public Ucet getStranaD() {
        return stranaD;
    }

    public String getSumaString() {
        return suma + " €";
    }

    public String getZnenie() {
        return znenie;
    }
    
    public String vypis() {
        return stranaMD + "  " + stranaD + "  " + suma + "  " + znenie;
    }
    
    public void zauctuj() {
        this.stranaMD.pridajSumuNaMD(this.suma);
        this.stranaD.pridajSumuNaD(this.suma);
    }
    
    public void oductuj() {
        this.stranaMD.odoberSumuNaMD(suma);
        this.stranaD.odoberSumuNaD(suma);
    }
}
