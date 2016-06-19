/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComparatorsAndDate;

import Sklad.PolozkaSkladu;
import java.util.Comparator;

/**
 *
 * @author Tomáš
 */
public class NazovPolozkySkladuZAComparator implements Comparator<PolozkaSkladu>{
    
    @Override
    public int compare(PolozkaSkladu u1, PolozkaSkladu u2) {
        return u2.getSkladovaKarta().getNazov().compareTo(u1.getSkladovaKarta().getNazov());
    }
    
}
