/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sklad;

import ComparatorsAndDate.CenaSkladovejKartyMaxComparator;
import ComparatorsAndDate.CenaSkladovejKartyMinComparator;
import ComparatorsAndDate.NazovSkladovejKartyAZComparator;
import ComparatorsAndDate.NazovSkladovejKartyZAComparator;
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
public class ZoznamSkladovychKariet implements Vypis, Serializable {
    private List<SkladovaKarta> zoznamSkladovychKariet;

    public ZoznamSkladovychKariet() {
        this.zoznamSkladovychKariet = new ArrayList<>();
    }
    
    public boolean pridajSkladovuKartu(SkladovaKarta sk) {   
        for(SkladovaKarta s : this.zoznamSkladovychKariet) {
            if (s.getNazov().toLowerCase().equalsIgnoreCase(sk.getNazov().toLowerCase())) {
                if (s.getCenaZaJednotku() == sk.getCenaZaJednotku()) {
                    throw new IllegalArgumentException("Takátko skladová karta už existuje");
                }
            }
        }
        return this.zoznamSkladovychKariet.add(sk);

    }

    public List<SkladovaKarta> getZoznamSkladovychKariet() {
        return zoznamSkladovychKariet;
    }
    
    public boolean odstranSkladovuKartu(SkladovaKarta sk) {
        return this.zoznamSkladovychKariet.remove(sk);
    }
    
    public String vypis() {
        String vypis = "";
        for(SkladovaKarta s : this.zoznamSkladovychKariet) {
            vypis += s.toString() + "\n";
        }
        return vypis;
    }

    @Override
    public void vypisDoSuboru(Podnik p) throws FileNotFoundException {
        if (this.zoznamSkladovychKariet.isEmpty()) {
            throw new IllegalStateException("Zoznam skladových kariet je prázdny. Nie je možné vytvoriť výpis");
        }  
        PrintStream ps = null;
        try {
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("AppData\\Výpisy\\Zoznam skladových kariet.txt")));  
        } catch (FileNotFoundException e) {
            throw e;
        }
        ps.println(p.toString());
        ps.println(p.getAdresa());
        ps.println("Účtovný rok: " + p.getUctovnyRok());
        ps.println();
        ps.println("Zoznam skladových kariet ku dňu " + ComparatorsAndDate.Datum.formatDatum(Calendar.getInstance()));
        ps.println();
        ps.println("Počet vedených skladových kariet v podniku: " + this.zoznamSkladovychKariet.size());
        ps.println();
        ps.println("============================================================================================");
        ps.println();
        for (SkladovaKarta sk : this.zoznamSkladovychKariet) {
            ps.println(sk.vypis());
            ps.println();
            ps.println();
        }
        ps.close();
    }
    
    public void zoradSkladoveKartyPodlaNazvuAZ() {
        Collections.sort(this.zoznamSkladovychKariet, new NazovSkladovejKartyAZComparator());
    }
    
    public void zoradSkladoveKartyPodlaNazvuZA() {
        Collections.sort(this.zoznamSkladovychKariet, new NazovSkladovejKartyZAComparator());
    }
        
    public void zoradSkladoveKartyPodlaCenyMin() {
        Collections.sort(this.zoznamSkladovychKariet, new CenaSkladovejKartyMinComparator());
    }
            
    public void zoradSkladoveKartyPodlaCenyMax() {
        Collections.sort(this.zoznamSkladovychKariet, new CenaSkladovejKartyMaxComparator());
    }
    
}
