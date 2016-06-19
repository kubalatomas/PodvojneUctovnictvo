/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComparatorsAndDate;

import Partneri.Partner;
import java.util.Comparator;

/**
 *
 * @author Tomáš
 */
public class MenoPartneraAZComparator implements Comparator<Partner>{
    
    @Override
    public int compare(Partner u1, Partner u2) {
        return u1.getMeno().compareTo(u2.getMeno());
    }
    
}
