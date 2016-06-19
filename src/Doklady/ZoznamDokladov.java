/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doklady;

import ComparatorsAndDate.ZnenieDokladuAZComparator;
import ComparatorsAndDate.ZnenieDokladuZAComparator;
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
public class ZoznamDokladov implements Vypis, Serializable {
    private List<UctovnyDoklad> zoznamDokladov;

    public ZoznamDokladov() {
        this.zoznamDokladov = new ArrayList<>();
    }
    
    public boolean pridajDoklad(UctovnyDoklad u) {
        return this.zoznamDokladov.add(u);
    }
    
    public boolean odstranDoklad(UctovnyDoklad u) {
        return this.zoznamDokladov.remove(u);
    }

    public List<UctovnyDoklad> getZoznamDokladov() {
        return zoznamDokladov;
    }

    @Override
    public void vypisDoSuboru(Podnik p) throws FileNotFoundException {
        if (this.zoznamDokladov.isEmpty()) {
            throw new IllegalStateException("Evidencia účtovných dokladov je prázdna. Nie je možné vytvoriť výpis");
        }          
        PrintStream ps = null;
        try {
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("AppData\\Výpisy\\Účtovné doklady.txt")));  
        } catch (FileNotFoundException e) {
            throw e;
        }
        ps.println(p.toString());
        ps.println(p.getAdresa());
        ps.println("Účtovný rok: " + p.getUctovnyRok());
        ps.println();
        ps.println("Evidencia účtovných dokladov ku dňu " + ComparatorsAndDate.Datum.formatDatum(Calendar.getInstance()));
        ps.println();
        ps.println("Počet vedených účtovných dokladov v podniku: " + this.zoznamDokladov.size());
        ps.println();
        ps.println("============================================================================================");
        ps.println();
        ps.println();        
        for (UctovnyDoklad u : this.zoznamDokladov) {
            ps.println(u.vypis());
            ps.println();
            ps.println();
        }
        ps.close();
    }

    public void zoradDokladyPodlaZneniaAZ() {
        Collections.sort(this.zoznamDokladov, new ZnenieDokladuAZComparator());
    }
    
    public void zoradDokladyPodlaZneniaZA() {
        Collections.sort(this.zoznamDokladov, new ZnenieDokladuZAComparator());
    }
}
