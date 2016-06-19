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
public class CisloUctuMaxComparator implements Comparator<Ucet>{
    
    @Override
    public int compare(Ucet u1, Ucet u2) {
        int a = Integer.parseInt(u1.getCisloUctu());
        int b = Integer.parseInt(u2.getCisloUctu());
        return b-a;
    }
    
}
