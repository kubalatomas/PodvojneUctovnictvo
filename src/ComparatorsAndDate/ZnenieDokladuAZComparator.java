/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComparatorsAndDate;

import Doklady.UctovnyDoklad;
import java.util.Comparator;

/**
 *
 * @author Tomáš
 */
public class ZnenieDokladuAZComparator implements Comparator<UctovnyDoklad>{
    
    @Override
    public int compare(UctovnyDoklad u1, UctovnyDoklad u2) {
        return u1.getZnenieDokladu().compareTo(u2.getZnenieDokladu());
    }
    
}
