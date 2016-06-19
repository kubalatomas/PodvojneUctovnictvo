/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Podnik;

import java.io.Serializable;

/**
 *
 * @author Tomáš
 */
public class Podnik implements Serializable {
    private String nazovPodniku;
    private int uctovnyRok;
    private FormaPodniku forma;
    private String adresa;
    

    public Podnik(String nazovPodniku, int uctovnyRok, FormaPodniku forma, String adresa) {
        if (nazovPodniku == null || nazovPodniku.length() == 0 || nazovPodniku.charAt(0) == ' ') {
            throw new IllegalArgumentException("Je potrebné zadať názov podniku");
        } else {
            this.nazovPodniku = nazovPodniku;
        }
        if (uctovnyRok <= 0) {
            throw new IllegalArgumentException("Je potrebné zadať správny rok");
        } else {
            this.uctovnyRok = uctovnyRok;
        }       
        if (adresa == null || adresa.length() == 0 || adresa.charAt(0) == ' ') {
            throw new IllegalArgumentException("Je potrebné zadať adresu");
        } else {
            this.adresa = adresa;
        }

        this.forma = forma;
    }

    private void setAdresa(String adresa) {
        if (adresa == null || adresa.length() == 0 || adresa.charAt(0) == ' ') {
            throw new IllegalArgumentException("Je potrebné zadať adresu");
        } else {
            this.adresa = adresa;
        }
    }


    public String getAdresa() {
        return adresa;
    }

    private void setUctovnyRok(int uctovnyRok) {
        if (uctovnyRok <= 0) {
            throw new IllegalArgumentException("Je potrebné zadať správny rok");
        } else {
            this.uctovnyRok = uctovnyRok;
        }
    }

    private void setForma(FormaPodniku forma) {
        this.forma = forma;
    }


    public String getNazovPodniku() {
        return nazovPodniku;
    }

    public int getUctovnyRok() {
        return uctovnyRok;
    }

    public FormaPodniku getForma() {
        return forma;
    }

    private void setNazovPodniku(String nazovPodniku) {
        if (nazovPodniku == null || nazovPodniku.length() == 0 || nazovPodniku.charAt(0) == ' ') {
            throw new IllegalArgumentException("Je potrebné zadať názov podniku");
        } else {
            this.nazovPodniku = nazovPodniku;
        }
    }
    
    public void upravPodnik(String adresa, int uctovnyRok, FormaPodniku forma, String nazovPodniku) throws IllegalArgumentException {
        try {
            this.setAdresa(adresa);
            this.setUctovnyRok(uctovnyRok);
            this.setForma(forma);
            this.setNazovPodniku(nazovPodniku);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
    
    @Override
    public String toString() {
        if (forma == FormaPodniku.as) {
            return this.getNazovPodniku() + " a. s.";
        } else {
            return this.getNazovPodniku() + " s. r. o.";
        }
    }
    
}
 