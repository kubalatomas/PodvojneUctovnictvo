/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComparatorsAndDate;

import Sklad.SkladovaKarta;
import java.util.Comparator;

/**
 *
 * @author Tomáš
 */
public class NazovSkladovejKartyZAComparator implements Comparator<SkladovaKarta>{
    
    @Override
    public int compare(SkladovaKarta u1, SkladovaKarta u2) {
        return u2.getNazov().compareTo(u1.getNazov());
    }
    
}
