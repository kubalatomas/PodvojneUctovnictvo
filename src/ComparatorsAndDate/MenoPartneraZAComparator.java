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
public class MenoPartneraZAComparator implements Comparator<Partner>{
    
    @Override
    public int compare(Partner u1, Partner u2) {
        return u2.getMeno().compareTo(u1.getMeno());
    }
    
}
