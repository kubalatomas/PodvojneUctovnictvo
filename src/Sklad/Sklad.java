/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sklad;

import ComparatorsAndDate.NazovPolozkySkladuAZComparator;
import ComparatorsAndDate.NazovPolozkySkladuZAComparator;
import Podnik.Podnik;
import Podnik.Vypis;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Tomáš
 */
public class Sklad implements Vypis, Serializable {
    private List<PolozkaSkladu> polozkySkladu;

    public Sklad() {
        this.polozkySkladu = new ArrayList<>();
    }
    
    public boolean pridajPolozku(PolozkaSkladu ps) {
        for (PolozkaSkladu p : this.polozkySkladu) {
            if (p.getSkladovaKarta().getIdTovaru() == ps.getSkladovaKarta().getIdTovaru()) {
                p.pridajKusy(ps.getPocetKs());
                return true;
            }
        }
        return this.polozkySkladu.add(ps);
    }
    
    public boolean odoberPolozku(PolozkaSkladu ps) throws IllegalArgumentException {
        for (PolozkaSkladu p : this.polozkySkladu) {
            if (p.getSkladovaKarta().getIdTovaru() == ps.getSkladovaKarta().getIdTovaru()) {
                if (ps.getPocetKs() < p.getPocetKs()) {
                    p.odoberKusy(ps.getPocetKs());
                } else if (ps.getPocetKs() == p.getPocetKs()) {
                    this.polozkySkladu.remove(p);
                } else if (ps.getPocetKs() > p.getPocetKs()) {
                    throw new IllegalArgumentException("K výdajú bolo zadané väčšie množstvo ako sa nachádza na sklade. Vytvorte novú výdajku so správnymi hodnotami");
                }
            }
        }
        return true;
    }
    
    public List<PolozkaSkladu> getPolozkySkladu() {
        return polozkySkladu;
    }
    
    public int dajPocetKusovPodlaId(int id) {
        for (PolozkaSkladu p : this.polozkySkladu) {
            if (id == p.getSkladovaKarta().getIdTovaru()) {
                return p.getPocetKs();
            }
        }
        return 0;
    }

    @Override
    public void vypisDoSuboru(Podnik p) throws FileNotFoundException {
        if (this.polozkySkladu.isEmpty()) {
            throw new IllegalStateException("Sklad je prázdny. Nie je možné vytvoriť výpis");
        }  
        PrintStream ps = null;
        try {
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("AppData\\Výpisy\\Inventárny súpis skladu.txt")));  
        } catch (FileNotFoundException e) {
            throw e;
        }
        ps.println(p.toString());
        ps.println(p.getAdresa());
        ps.println("Účtovný rok: " + p.getUctovnyRok());
        ps.println();
        ps.println("Inventárny súpis skladu ku dňu " + ComparatorsAndDate.Datum.formatDatum(Calendar.getInstance()));
        ps.println();
        ps.println("Počet vedených položiek skladu v podniku: " + this.polozkySkladu.size());
        ps.println();
        ps.println("============================================================================================");
        ps.println();
        for (PolozkaSkladu pss : this.polozkySkladu) {
            ps.println(pss.vypis());
            ps.println();
            ps.println();
        }
        ps.close();
    }
    
    public void zoradSkladPodlaNazvuAZ() {
        Collections.sort(this.polozkySkladu, new NazovPolozkySkladuAZComparator());
    }
    
    public void zoradSkladPodlaNazvuZA() {
        Collections.sort(this.polozkySkladu, new NazovPolozkySkladuZAComparator());
    }
}
