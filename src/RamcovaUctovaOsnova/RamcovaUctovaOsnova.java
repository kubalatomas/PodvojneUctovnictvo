/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RamcovaUctovaOsnova;

import ComparatorsAndDate.NazovUctuZAComparator;
import ComparatorsAndDate.CisloUctuMinComparator;
import ComparatorsAndDate.NazovUctuAZComparator;
import ComparatorsAndDate.CisloUctuMaxComparator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Podnik.Podnik;
import Podnik.Vypis;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.Calendar;

/**
 *
 * @author kubala25
 */
public class RamcovaUctovaOsnova  implements Serializable, Vypis {
    private List<Ucet> ramcovaUctovaOsnova;
    
    public RamcovaUctovaOsnova() throws FileNotFoundException, IOException, ClassNotFoundException {
//        this.ramcovaUctovaOsnova = new ArrayList<>();
//        BufferedReader br = new BufferedReader(new FileReader("src\\Data\\ruo.txt"));
//        String riadok = "---";
//        try {
//            while ("---".equals(riadok)) {
//            String nazov = br.readLine();
//            String cislo = br.readLine();
//            String typ = br.readLine();
//            switch (typ) {
//                case "aktiv":
//                    this.ramcovaUctovaOsnova.add(new Aktiv(nazov, cislo));
//                    break;
//                    
//                case "pasiv":
//                    this.ramcovaUctovaOsnova.add(new Pasiv(nazov, cislo));
//                    break;
//                    
//                case "nakladovy":
//                    this.ramcovaUctovaOsnova.add(new Nakladovy(nazov, cislo));
//                    break;
//                    
//                case "vynosovy":
//                    this.ramcovaUctovaOsnova.add(new Vynosovy(nazov, cislo));
//                    break;
//            }
//            riadok = br.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            br.close();
//        }
//        boolean f = false;
//        this.ramcovaUctovaOsnova.get(163).setDanovyUcet(f);
//        String nazovSuboru = "src\\Data\\ruo.bin";
//        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(nazovSuboru));
//        try {
//            os.writeObject(this.ramcovaUctovaOsnova);
//        } catch(FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            os.close();
//        }
        ArrayList<Ucet> ucet = null;
        ObjectInputStream is = null;
        try {
            is = new ObjectInputStream(new FileInputStream("src\\Data\\ruo.bin"));
            ucet = (ArrayList<Ucet>)is.readObject();  
            is.close(); 
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } 
        this.ramcovaUctovaOsnova = ucet;
    }
    
    public boolean pridajUcet(Ucet ucet) throws IllegalArgumentException  {
       boolean zhoda = false;
       int ucet1 = Integer.parseInt(ucet.getCisloUctu());
       for (Ucet u : this.ramcovaUctovaOsnova) {
           int ucet2 = Integer.parseInt(u.getCisloUctu());
           if (ucet1 == ucet2) {
               zhoda = true;
               throw new IllegalArgumentException("Ucet s takymto cislom uz existuje");
           }
       }
       
       if (!zhoda) {
           try {
               this.ramcovaUctovaOsnova.add(ucet);
           } catch (IllegalArgumentException e) {
               throw e;
           }
           zhoda = true;
       }
       return zhoda;
    }
    
    public boolean odstranUcet(Ucet ucet) {
        return this.ramcovaUctovaOsnova.remove(ucet);
    }
    

    
    public Ucet getUcetPodlaCisla(String cislo) {
        Ucet ucet = null;
        for (Ucet u : this.ramcovaUctovaOsnova) {
            if (cislo.equalsIgnoreCase(u.getCisloUctu())) {
                ucet = u;
            }
        }
        return ucet;
        
    }
    
    public String vypisRUO() {
        String vypis = "";
        if (this.ramcovaUctovaOsnova.isEmpty()) {
            vypis = "RUO je prazdna";
        } else {
            for (Ucet u : this.ramcovaUctovaOsnova) {
            vypis += u.toString() + "\n";
            }
            vypis += this.ramcovaUctovaOsnova.size();
        } 
        return vypis;
    }
    
    public void zoradRUOPodlaNazvuUctuAZ() {
        Collections.sort(ramcovaUctovaOsnova, new NazovUctuAZComparator());
    }
    
    public void zoradRUOPodlaNazvuUctuZA() {
        Collections.sort(ramcovaUctovaOsnova, new NazovUctuZAComparator());
    }

    public List<Ucet> getRamcovaUctovnaOsnova() {
        return ramcovaUctovaOsnova;
    }
        
    public void zoradRUOPodlaCislaUctuMin() {
        Collections.sort(ramcovaUctovaOsnova, new CisloUctuMinComparator());
    }
            
    public void zoradRUOPodlaCislaUctuMax() {
        Collections.sort(ramcovaUctovaOsnova, new CisloUctuMaxComparator());
    }
    
//    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
//        RamcovaUctovaOsnova ruo = new RamcovaUctovaOsnova();
//        System.out.println("hadam");
//        
//    }
    
    public String vytvorDoklad() {
        String vypis = "";
        for (Ucet u : this.ramcovaUctovaOsnova) {
            vypis += u.getCisloUctu() + "  -  " + u.getNazovUctu() + "  -  Konečný zostatok: " + u.dajKonecnyZostatok();
            vypis += "\n";
        }
        return vypis;
    }        


    @Override
    public void vypisDoSuboru(Podnik p) throws FileNotFoundException {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("AppData\\Výpisy\\Súvaha.txt")));  
        } catch (FileNotFoundException e) {
            throw e;
        }
        ps.println(p.toString());
        ps.println(p.getAdresa());
        ps.println("Účtovný rok: " + p.getUctovnyRok());
        ps.println();
        ps.println("Súvaha ku dňu " + ComparatorsAndDate.Datum.formatDatum(Calendar.getInstance()));
        ps.println();
        ps.println("Sumy sú uvedené v EUR");
        ps.println();
        ps.println("============================================================================================");
        ps.println();
        String aktiva = "";
        double aktivaSuma = 0;
        for (Ucet u : this.ramcovaUctovaOsnova) {
            if (u instanceof Aktiv) {
                aktiva += u.getCisloUctu() + "   ";
                aktiva += u.getNazovUctu();
                int pom = 80 - u.getNazovUctu().length();
                for (int i = 0; i < pom; i++) {
                    aktiva += ".";
                }
                aktiva += u.dajKonecnyZostatok() + "\n";
                aktivaSuma += u.dajKonecnyZostatok();
            }
        }
        ps.println(aktiva);
        ps.println();
        ps.println("Aktíva spolu: " + aktivaSuma);
        ps.println();
        ps.println();
        String pasiva = "";
        double pasivaSuma = 0;
        for (Ucet u : this.ramcovaUctovaOsnova) {
            if (u instanceof Pasiv) {
                pasiva += u.getCisloUctu() + "   ";
                pasiva += u.getNazovUctu();
                int pom = 80 - u.getNazovUctu().length();
                for (int i = 0; i < pom; i++) {
                    pasiva += ".";
                }
                pasiva += u.dajKonecnyZostatok() + "\n";
                pasivaSuma += u.dajKonecnyZostatok();
            }
        }
        ps.println(pasiva);
        ps.println();
        ps.println("Pasíva spolu: " + pasivaSuma);
        ps.close();
    }
}
