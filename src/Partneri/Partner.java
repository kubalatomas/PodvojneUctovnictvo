/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partneri;

import java.io.Serializable;

/**
 *
 * @author Tomáš
 */
public class Partner implements Serializable {
    private String meno;
    private int ICO;
    private String adresa;
    private String stat;
    private int id;
    private static int posledneId = 1;
    
    public Partner(String paMeno, int paICO, String paAdresa, String paStat) throws IllegalArgumentException {
        if (paMeno == null || paMeno.length() == 0 || paMeno.charAt(0) == ' ') {
            throw new IllegalArgumentException("Je potrebné zadať meno partnera");
        } else {
            this.meno = paMeno;
        }
        if (paICO > 99999999 || paICO < 10000000) {
            throw new IllegalArgumentException("Zle zadana hodnota ico");
        } else {
            this.ICO = paICO;
        }
        if (paAdresa == null || paAdresa.length() == 0 || paAdresa.charAt(0) == ' ') {
            throw new IllegalArgumentException("Je potrebné zadať adresu partnera");
        } else {
            this.adresa = paAdresa;
        }
        if (paStat == null || paStat.length() == 0 || paStat.charAt(0) == ' ') {
            throw new IllegalArgumentException("Je potrebné zadať štát partnera");
        } else {
            this.stat = paStat;
        }
        this.id = posledneId;
        posledneId++;
    }

    public String getMeno() {
        return meno;
    }

    public int getICO() {
        return ICO;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getStat() {
        return stat;
    }


    public int getId() {
        return id;
    }

    
    public String dajPopis() {
        return this.meno + " - " + this.adresa + " - " + this.stat + " - " + this.ICO + " - " + this.id;
    }
    
    @Override
    public String toString() {
        return this.meno;
    }
    
    public String vypis() {
        return "Partner: " + this.meno + "\nID partnera: " + this.id + "\nIČO: " + this.ICO + "\nAdresa: " + this.adresa + "\nŠtát: " + this.stat;
    }
    
}
