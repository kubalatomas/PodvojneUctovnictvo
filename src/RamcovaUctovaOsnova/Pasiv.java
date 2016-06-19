/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RamcovaUctovaOsnova;

/**
 *
 * @author Tomáš
 */
public class Pasiv extends Ucet  {  
    
    public Pasiv(String nazov, String cislo) {
        super(nazov, cislo);
    }    
    
    @Override
    public double dajKonecnyZostatok() {
        return super.getStranaD() - super.getStranaMD();
    }
    
    
    @Override
    public String toString() {
        return this.getCisloUctu() + " - " + this.getNazovUctu();
    }
}
