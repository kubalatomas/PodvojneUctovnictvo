/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sklad;

import RamcovaUctovaOsnova.RamcovaUctovaOsnova;
import java.util.Calendar;

/**
 *
 * @author Tomáš
 */
public class Vydajka extends Pohyb {

    public Vydajka(Sklad s, Calendar d, RamcovaUctovaOsnova ruo) {
        super(s, d, ruo);
    }

    @Override
    public String toString() {
        return "Výdajka - " + ComparatorsAndDate.Datum.formatDatum(super.getDatumVytvorenia());
    }

    @Override
    public boolean zauctujPohyb() throws IllegalArgumentException {
        Sklad skladPom = new Sklad();
        if (super.getSklad().getPolozkySkladu().isEmpty()) {
            throw new IllegalStateException("Sklad je prázdny");
        }
        
        for (PolozkaSkladu pp : super.getSklad().getPolozkySkladu()) {
            skladPom.pridajPolozku(new PolozkaSkladu(pp.getSkladovaKarta(), pp.getPocetKs()));
        }
        
        try {
            for (PolozkaSkladu ps : super.getPolozkyDokladu()) {
                skladPom.odoberPolozku(ps);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
        try {
            for (PolozkaSkladu pps : super.getPolozkyDokladu()) {
                super.getSklad().odoberPolozku(pps);
            }

            

        } catch (IllegalArgumentException e) {
            throw e;
        }
        super.setZauctovany(true);
        super.getRuo().getUcetPodlaCisla("504").pridajSumuNaMD(super.celkovaSuma());
        super.getRuo().getUcetPodlaCisla("132").pridajSumuNaD(super.celkovaSuma());
        return true;
    }

    @Override
    public String vypis() {
        String vypis = this.toString() + "\n";
        String stav = "";
        if (super.isZauctovany()) {
            stav = "Pohyb je zaúčtovaný";
        } else {
            stav = "Pohyb nie je zaúčtovaný";            
        }
        vypis += "Stav: " + stav + "\n" + "\n";
        vypis += "Položky dokladu:" + "\n";
        vypis += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n";
        for (PolozkaSkladu ps : super.getPolozkyDokladu()) {
            vypis += ps.getSkladovaKarta().getNazov();
            int pom = 80 - ps.getSkladovaKarta().getNazov().length();
            for (int i = 0; i < pom; i++) {
                vypis += ".";
            }
            vypis += ps.getPocetKs();
            if (ps.getSkladovaKarta().getTypTovaru() == Typ.kg) {
                vypis += " kg";
            } else if (ps.getSkladovaKarta().getTypTovaru() == Typ.ks) {
                vypis += " ks";
            } else if (ps.getSkladovaKarta().getTypTovaru() == Typ.l) {
                vypis += " l";
            }
            vypis += "\n";
        }
        vypis += "\n" + "Celková hodnota dokladu: " + super.celkovaSumaString();
        return vypis;
    }
}


    

