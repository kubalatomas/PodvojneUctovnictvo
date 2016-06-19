/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComparatorsAndDate;

import RamcovaUctovaOsnova.Ucet;
import Sklad.PolozkaSkladu;
import java.util.Comparator;

/**
 *
 * @author Tomáš
 */
public class NazovPolozkySkladuAZComparator implements Comparator<PolozkaSkladu>{
    
    @Override
    public int compare(PolozkaSkladu u1, PolozkaSkladu u2) {
        return u1.getSkladovaKarta().getNazov().compareTo(u2.getSkladovaKarta().getNazov());
    }
    
}
