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
public class CenaSkladovejKartyMaxComparator implements Comparator<SkladovaKarta>{
    
    @Override
    public int compare(SkladovaKarta u1, SkladovaKarta u2) {
        int i1 = (int)u1.getCenaZaJednotku()*1000;
        int i2 = (int)u2.getCenaZaJednotku()*1000;
        return i2 - i1;
    }
    
}
