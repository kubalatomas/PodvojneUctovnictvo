/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partneri;

import ComparatorsAndDate.MenoPartneraAZComparator;
import ComparatorsAndDate.MenoPartneraZAComparator;
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
public class ZoznamPartnerov implements Vypis, Serializable {
    private List<Partner> partneri;
    
    public ZoznamPartnerov() {
        this.partneri = new ArrayList<>();
        this.partneri.add(new Partner("Podnikové účtovníctvo", 12345678, "PODNIK", "PODNIK"));
    }
    
    public boolean pridajPartnera(Partner partner) throws IllegalArgumentException {
        boolean zhoda = false;
        for (Partner p : this.partneri) {
            if (p.getICO() == partner.getICO()) {
                zhoda = true;
                throw new IllegalArgumentException("Partner s takýmto IČO už existuje");
            }
        }
        if (!zhoda) {
            zhoda = true;
            this.partneri.add(partner);
        }
    return zhoda;    
    }
    
    public boolean odstranParntera(Partner p) {
        return this.partneri.remove(p);
    }

    public List<Partner> getPartneri() {
        return partneri;
    }
    
    
    public String vypis() {
        String vypis = "";
        for (Partner p : this.partneri) {
            vypis += p.dajPopis();
        }
        return vypis;
    }

    @Override
    public void vypisDoSuboru(Podnik p) throws FileNotFoundException {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("AppData\\Výpisy\\Zoznam partnerov.txt")));  
        } catch (FileNotFoundException e) {
            throw e;
        }
        ps.println(p.toString());
        ps.println(p.getAdresa());
        ps.println("Účtovný rok: " + p.getUctovnyRok());
        ps.println();
        ps.println("Zoznam partnerov ku dňu " + ComparatorsAndDate.Datum.formatDatum(Calendar.getInstance()));
        ps.println();
        ps.println("Počet vedených partnerov v podniku: " + this.partneri.size());
        ps.println();
        ps.println("============================================================================================");
        ps.println();
        for (Partner pa : this.partneri) {
            ps.println(pa.vypis());
            ps.println();
            ps.println();
        }
        ps.close();
    }
    
    public void zoradPartnerovPodlaMenaAZ() {
        Collections.sort(partneri, new MenoPartneraAZComparator());
    }
    
    public void zoradPartnerovPodlaMenaZA() {
        Collections.sort(partneri, new MenoPartneraZAComparator());
    }
}
