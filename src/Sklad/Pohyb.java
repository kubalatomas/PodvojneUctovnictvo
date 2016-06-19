/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sklad;

import RamcovaUctovaOsnova.RamcovaUctovaOsnova;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Tomáš
 */
public abstract class Pohyb implements Serializable {
    private List<PolozkaSkladu> polozkyDokladu;
    private Sklad sklad;
    private boolean zauctovany;
    private Calendar datumVytvorenia;
    private RamcovaUctovaOsnova ruo;
    
    public Pohyb(Sklad s, Calendar d, RamcovaUctovaOsnova ruo) {
        this.polozkyDokladu = new ArrayList<>();
        this.sklad = s;
        this.zauctovany = false;
        this.datumVytvorenia = d;
        this.ruo = ruo;
    }

    protected RamcovaUctovaOsnova getRuo() {
        return ruo;
    }

    public boolean isZauctovany() {
        return zauctovany;
    }

    public void setZauctovany(boolean zauctovany) {
        this.zauctovany = zauctovany;
    }

    public List<PolozkaSkladu> getPolozkyDokladu() {
        return polozkyDokladu;
    }
    
    public boolean pridajPolozkuDoDokladu(PolozkaSkladu ps) {
        for (PolozkaSkladu p : this.polozkyDokladu) {
            if (ps.getSkladovaKarta().getIdTovaru() == p.getSkladovaKarta().getIdTovaru()) {
                p.pridajKusy(ps.getPocetKs());
                return true;
            }
        }
        return this.polozkyDokladu.add(ps);
    }
    
    public boolean odoberPolozkuZDokladu(PolozkaSkladu ps) {
        return this.polozkyDokladu.remove(ps);
    }
       

    
    public String celkovaSumaString() {
        double suma = 0;
        for (PolozkaSkladu p : this.polozkyDokladu) {
            suma += p.getPocetKs()*p.getSkladovaKarta().getCenaZaJednotku();
        }
        return String.valueOf(suma) + " €";
    }
    
    public double celkovaSuma() {
        double suma = 0;
        for (PolozkaSkladu p : this.polozkyDokladu) {
            suma += p.getPocetKs()*p.getSkladovaKarta().getCenaZaJednotku();
        }
        return suma;
    }
    @Override
    public abstract String toString();

    public Sklad getSklad() {
        return sklad;
    }
    public abstract boolean zauctujPohyb();
    public abstract String vypis();
//    
//    public static void main(String[] args) {
//        Pohyb p = new Pohyb();
//        Calendar d = Calendar.getInstance();
//        SkladovaKarta s1 = new SkladovaKarta("Stolicka", 50, d, Typ.ks);
//        SkladovaKarta s2 = new SkladovaKarta("Stol", 50, d, Typ.ks);
//        PolozkaSkladu p1 = new PolozkaSkladu(s1, 50);
//        PolozkaSkladu p2 = new PolozkaSkladu(s2, 50);
//        PolozkaSkladu p3 = new PolozkaSkladu(s1, 88);
//        System.out.println(p.pridajPolozkuDoDokladu(p1));
//        System.out.println(p.vypis());
//        System.out.println(p.pridajPolozkuDoDokladu(p2));
//        System.out.println(p.vypis());
//        System.out.println(p.pridajPolozkuDoDokladu(p3));
//        System.out.println(p.vypis());
//    }



    public Calendar getDatumVytvorenia() {
        return datumVytvorenia;
    }

    public void setDatumVytvorenia(Calendar datumVytvorenia) {
        this.datumVytvorenia = datumVytvorenia;
    }
    
}
