/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RamcovaUctovaOsnova;

import java.io.Serializable;

/**
 *
 * @author Tomáš
 */
public abstract class Ucet implements Serializable {
    private String nazovUctu;
    private String cisloUctu;
    private double stranaMD;
    private double stranaD;
    private boolean danovyUcet = true;

    
    public Ucet(String nazov, String cislo) throws IllegalArgumentException {
        this.nazovUctu = nazov;
        int pom = 0;
            pom = Integer.parseInt(cislo);
            if (pom < 1 || pom > 999) {
                throw new IllegalArgumentException("Zadali ste nespravne cislo uctu");
            } 
        this.stranaD = 0;
        this.stranaMD = 0;
        this.danovyUcet = true;
        this.cisloUctu = cislo;
    }

    public String getNazovUctu() {
        return nazovUctu;
    }

    public String getCisloUctu() {
        return cisloUctu;
    }

    public double getStranaMD() {
        return stranaMD;
    }

    public double getStranaD() {
        return stranaD;
    }

    public boolean isDanovyUcet() {
        return danovyUcet;
    }


    public double pridajSumuNaMD (double suma) {
        return this.stranaMD += suma;
    }

    public double pridajSumuNaD(double suma) {
        return this.stranaD += suma;
    }

    public void setDanovyUcet(boolean DanovyUcet) {
        this.danovyUcet = DanovyUcet;
    }
    
    public double odoberSumuNaMD(double suma) {
        return this.stranaMD -= suma;
    }
    
    public double odoberSumuNaD(double suma) {
        return this.stranaD -= suma;
    }
    @Override
    public abstract String toString();
    public abstract double dajKonecnyZostatok();
    
}
