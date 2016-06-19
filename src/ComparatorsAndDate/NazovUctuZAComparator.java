/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComparatorsAndDate;

import RamcovaUctovaOsnova.Ucet;
import java.util.Comparator;

/**
 *
 * @author Tomáš
 */
public class NazovUctuZAComparator implements Comparator<Ucet>{
    
    @Override
    public int compare(Ucet u1, Ucet u2) {
        return u2.getNazovUctu().compareTo(u1.getNazovUctu());
    }
    
}
