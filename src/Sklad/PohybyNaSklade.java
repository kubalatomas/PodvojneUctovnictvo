/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sklad;

import Podnik.Podnik;
import Podnik.Vypis;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Tomáš
 */
public class PohybyNaSklade implements Vypis, Serializable {
    private List<Pohyb> pohyby;

    public PohybyNaSklade() {
        this.pohyby = new ArrayList<>();
    }
    
    public boolean pridajPohyb(Pohyb p) {
        if (p.getPolozkyDokladu().isEmpty()) {
            throw new IndexOutOfBoundsException("Nie je možné pridať prázdny pohyb");
        } else {
            return this.pohyby.add(p);
        }
    }
    
    public boolean odstranPohyb(Pohyb p) {
        return this.pohyby.remove(p);
    }

    public List<Pohyb> getPohyby() {
        return pohyby;
    }

    @Override
    public void vypisDoSuboru(Podnik p) throws FileNotFoundException {
        if (this.pohyby.isEmpty()) {
            throw new IllegalStateException("V podniku sa nenachádzajú žiadné pohyby na sklade. Nie je možné vytvoriť výpis");
        }  
        PrintStream ps = null;
        try {
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("AppData\\Výpisy\\Pohyby na sklade.txt")));  
        } catch (FileNotFoundException e) {
            throw e;
        }
        ps.println(p.toString());
        ps.println(p.getAdresa());
        ps.println("Účtovný rok: " + p.getUctovnyRok());
        ps.println();
        ps.println("Pohyby na sklade ku dňu " + ComparatorsAndDate.Datum.formatDatum(Calendar.getInstance()));
        ps.println();
        ps.println("Počet pohybov na sklade: " + this.pohyby.size());
        ps.println();
        ps.println("============================================================================================");
        ps.println();
        for (Pohyb po : this.pohyby) {
            ps.println(po.vypis());
            ps.println();
            ps.println();
        }
        ps.close();
    }
     
}
