/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sklad;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Tomáš
 */
public class SkladovaKarta implements Serializable {
    private String nazov;
    private double cenaZaJednotku;
    private Calendar datumZaradenia;
    private final int idTovaru;
    private static int posledneId = 1;
    private Typ typTovaru;
    
    public SkladovaKarta(String paNazov, double cenaZaJednotku, Calendar paDatum, Typ paTyp) {
        if (paNazov == null || paNazov.length() == 0 || paNazov.charAt(0) == ' ') {
            throw new IllegalArgumentException("Je potrebné zadať názov skladovej karty");
        } else if (paNazov.length() > 70) {
            throw new IllegalArgumentException("Zadali ste príliš dlhý názov skladovej karty");
        } else {
            this.nazov = paNazov;
        }
        if (cenaZaJednotku <= 0) {
            throw new IllegalArgumentException("Nie je možné vytvoriť skladovú kartu s nulovou alebo zápornou hodnotou");
        } else {
            this.cenaZaJednotku = cenaZaJednotku;
        }
        if (paDatum == null) {
            throw new IllegalArgumentException("Je potrebné zadať dátum");
        } else {
            this.datumZaradenia = paDatum;
        }
        this.idTovaru = posledneId;
        this.typTovaru = paTyp;
        posledneId++;
    }

    public String getNazov() {
        return nazov;
    }

    public double getCenaZaJednotku() {
        return cenaZaJednotku;
    }


    public Calendar getDatumZaradenia() {
        return datumZaradenia;
    }


    public int getIdTovaru() {
        return idTovaru;
    }
    
    @Override
    public String toString() {
        return this.getNazov();
    }
    
    public String getCenaString() {
        String typ = "";
        switch (this.typTovaru) {
            case kg:
                typ = "kg";
                break;
            case ks:
                typ = "ks";
                break;
            case l:
                typ = "l";
                break;
        }
        return this.cenaZaJednotku + " €/" + typ;
    }

    public Typ getTypTovaru() {
        return typTovaru;
    }
    
    public String vypis() {
        return "Názov skladovej karty: " + this.nazov + "\nID skladovej karty: " + this.idTovaru + "\nCena skladovej karty: " + this.getCenaString() + "\nDátum zaradenia: " + ComparatorsAndDate.Datum.formatDatum(datumZaradenia);
    }
}
