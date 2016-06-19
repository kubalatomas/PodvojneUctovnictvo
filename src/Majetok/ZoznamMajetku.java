/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Majetok;

import ComparatorsAndDate.NazovMajetkuAZComparator;
import ComparatorsAndDate.NazovMajetkuZAComparator;
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
public class ZoznamMajetku implements Vypis, Serializable {
    private List<Majetok> zoznamMajetku;

    public ZoznamMajetku() {
        this.zoznamMajetku = new ArrayList<>();
    }

    public List<Majetok> getZoznamMajetku() {
        return zoznamMajetku;
    }
    
    public boolean pridajMajetok(Majetok m) {
        return this.zoznamMajetku.add(m);
    }
    
    public boolean odoberMajetok(Majetok m) {
        return this.zoznamMajetku.remove(m);
    }




    @Override
    public void vypisDoSuboru(Podnik p) throws FileNotFoundException {
        if (this.zoznamMajetku.isEmpty()) {
            throw new IllegalStateException("V podniku sa nenachádza žiadny majetok. Nie je možné vytvoriť výpis");
        }  
        PrintStream ps = null;
        try {
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("AppData\\Výpisy\\Zoznam majetku.txt")));  
        } catch (FileNotFoundException e) {
            throw e;
        }
        ps.println(p.toString());
        ps.println(p.getAdresa());
        ps.println("Účtovný rok: " + p.getUctovnyRok());
        ps.println();
        ps.println("Inventárny súpis skladu ku dňu " + ComparatorsAndDate.Datum.formatDatum(Calendar.getInstance()));
        ps.println();
        ps.println("Počet majetku v podniku: " + this.zoznamMajetku.size());
        ps.println();
        ps.println("============================================================================================");
        ps.println();
        for (Majetok m : this.zoznamMajetku) {
            ps.println(m.vypis());
            ps.println();
            ps.println();
        }
        ps.close();
    }
    
    public void zoradMajetokPodlaNazvuAZ() {
        Collections.sort(this.zoznamMajetku, new NazovMajetkuAZComparator());
    }
   
    public void zoradMajetokPodlaNazvuZA() {
        Collections.sort(this.zoznamMajetku, new NazovMajetkuZAComparator());
    }    
}
