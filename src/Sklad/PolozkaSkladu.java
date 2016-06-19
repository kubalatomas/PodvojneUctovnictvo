/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sklad;

import java.io.Serializable;

/**
 *
 * @author Tomáš
 */
public class PolozkaSkladu implements Serializable {
    private SkladovaKarta tovar;
    private int pocetKs;

    public PolozkaSkladu(SkladovaKarta tovar, int pocetKs) {
        this.tovar = tovar;
        if (pocetKs <= 0) {
            throw new IllegalArgumentException("Nie je možné vytvoriť položku skladu s nulovým alebo záporným počtom kusov");
        } else {
            this.pocetKs = pocetKs;
        }
    }
    
    public int pridajKusy(int pocet) {
        return this.pocetKs += pocet;
    }
    
    public int odoberKusy(int pocet) {
        if (pocet > this.pocetKs) {
            throw new IllegalArgumentException("Zadali ste vela ks");
        } else {
            return this.pocetKs -= pocet;
        }
    }

    public SkladovaKarta getSkladovaKarta() {
        return tovar;
    }

    public int getPocetKs() {
        return pocetKs;
    }
    
    @Override
    public String toString() {
        return this.tovar.getNazov();
    }
    
    public String vypis() {
        return "Názov tovaru :" + this.tovar.getNazov() + "\nID tovaru: " + this.tovar.getIdTovaru() + "\nCena za jednotku: " + this.tovar.getCenaString() + "\nMnožstvo na sklade: " + this.pocetKs + "\nDátum zaradenia: " + ComparatorsAndDate.Datum.formatDatum(this.getSkladovaKarta().getDatumZaradenia());
    }
}
