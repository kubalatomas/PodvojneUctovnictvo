/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Majetok;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Tomáš
 */
public class Majetok implements Serializable {
    private String nazov;
    private double cena;
    private DruhMajetku typ;
    private Calendar datum;
    private String vyrobca;
    private final int idMajetku;
    private static int posledneId = 1;

    public Majetok(String nazov, double cena, DruhMajetku typ, Calendar datum, String vyrobca) {
        if (nazov == null || nazov.length() == 0 || nazov.charAt(0) == ' ') {
            throw new IllegalArgumentException("Je potrebné zadať názov majetku");
        } else {
            this.nazov = nazov;
        }
        if (cena <= 0) {
            throw new IllegalArgumentException("Nie je možné vytvoriť majetok s nulovou alebo zápornou hodnotou");
        } else {
            this.cena = cena;
        }
        this.typ = typ;
        if (datum == null) {
            throw new IllegalArgumentException("Je potrebné zadať dátum zaradenia majetku");
        } else {
            this.datum = datum;
        }
        if (vyrobca == null || vyrobca.length() == 0 || vyrobca.charAt(0) == ' ') {
            throw new IllegalArgumentException("Je potrebné zadať výrobcu");
        } else {
            this.vyrobca = vyrobca;
        }
        this.idMajetku = Majetok.posledneId;
        posledneId++;
    }

    public String getNazov() {
        return nazov;
    }

    public double getCena() {
        return cena;
    }

    public DruhMajetku getTyp() {
        return typ;
    }

    public Calendar getDatum() {
        return datum;
    }

    public String getVyrobca() {
        return vyrobca;
    }
 
    @Override
    public String toString() {
        return this.nazov;
    }

    public int getIdMajetku() {
        return idMajetku;
    }
    
    public String vypis() {
        String druh = "";
        if (this.getTyp() == DruhMajetku.kratkodoby) {
            druh = "Krátkodobý";
        } else {
            druh = "Dlhodobý";
        }
        return "Názov majetku: " + this.nazov + "\nID majetku: " + this.idMajetku + "\nCena majetku: " + this.cena + " €\nTyp majetku: " + druh + "\nVýrobca majetku: " + this.vyrobca + "\nDátum zaradenia: " + ComparatorsAndDate.Datum.formatDatum(this.datum);
    }
}
