/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComparatorsAndDate;

import Majetok.Majetok;
import java.util.Comparator;

/**
 *
 * @author Tomáš
 */
public class NazovMajetkuAZComparator implements Comparator<Majetok>{
    
    @Override
    public int compare(Majetok u1, Majetok u2) {
        return u1.getNazov().compareTo(u2.getNazov());
    }
    
}
