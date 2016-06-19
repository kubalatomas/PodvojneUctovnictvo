/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doklady;

import Partneri.Partner;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Tomáš
 */
public abstract class UctovnyDoklad implements Serializable {
    private String znenieDokladu;
    private Calendar datumDokladu;
    private double sumaDokladu;
    private Partner partner;
    private List<Predkontacia> predkontacieDokladu;


    public UctovnyDoklad(String znenieDokladu, Calendar datumDokladu, double sumaDokladu, Partner partner, List<Predkontacia> predkontacieDokladu) {
        if (znenieDokladu == null || znenieDokladu.length() == 0 || znenieDokladu.charAt(0) == ' ') {
            throw new IllegalArgumentException("Je potrebné zadať znenie dokladu");
        } else {
            this.znenieDokladu = znenieDokladu;
        }
        if (datumDokladu == null) {
            throw new IllegalArgumentException("Je potrebné zadať dátum vytvorenia dokladu");
        } else {
            this.datumDokladu = datumDokladu;            
        }       
        if (sumaDokladu <= 0) {
            throw new IllegalArgumentException("Nie je možné vytvoriť doklad s nulovou alebo zápornou hodnotou");
        } else {
            this.sumaDokladu = sumaDokladu;
        }
        if (partner == null) {
            throw new IllegalArgumentException("Je potrebné zvoliť si partnera");
        } else {
            this.partner = partner;
        }
        if (predkontacieDokladu.isEmpty()) {
            throw new IllegalArgumentException("Nie je možné vytvoriť doklad bez predkontácií");
        } else {
            this.predkontacieDokladu = predkontacieDokladu;
        }

    }

    public String getZnenieDokladu() {
        return znenieDokladu;
    }

    public Calendar getDatumDokladu() {
        return datumDokladu;
    }

    public double getSumaDokladu() {
        return sumaDokladu;
    }
    
    public String getSumaDokladuString() {
        return sumaDokladu + " €";
    }
    
    public Partner getPartner() {
        return partner;
    }

    public List<Predkontacia> getPredkontacieDokladu() {
        return predkontacieDokladu;
    }
    
    @Override
    public String toString() {
        return znenieDokladu;
    }
    
    public abstract String zauctujDoklad();
    public abstract String oductujDoklad();
    public abstract String vypis();
}
