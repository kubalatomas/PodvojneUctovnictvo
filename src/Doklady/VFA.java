/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doklady;

import Partneri.Partner;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Tomáš
 */
public class VFA extends UctovnyDoklad {
    private static int posledneId = 1;
    private String interneCislo = "VFA-";
    private int externeCislo;

    public VFA(String znenieDokladu, Calendar datumDokladu, double sumaDokladu, Partner partner, List<Predkontacia> predkontacieDokladu, int externeCislo) {
        super(znenieDokladu, datumDokladu, sumaDokladu, partner, predkontacieDokladu);
        this.interneCislo += posledneId;
        posledneId++;
        if (externeCislo <= 0) {
            throw new IllegalArgumentException("Zadajte správnu hodnotu pre externé číslo");
        } else {
            this.externeCislo = externeCislo;
        }
    }

    public String getInterneCislo() {
        return interneCislo;
    }

    public int getExterneCislo() {
        return externeCislo;
    }

    @Override
    public String zauctujDoklad() {
        for (Predkontacia p : super.getPredkontacieDokladu()) {
            p.zauctuj();
        }
        return "Doklad bol vytvorený pod interným číslom: " + this.interneCislo;
    }
    
    @Override
    public String oductujDoklad() {
        for (Predkontacia p : super.getPredkontacieDokladu()) {
            p.oductuj();
        }
        return "Doklad vedený pod interným číslom: " + this.interneCislo + " bol odstránený";
    }

    @Override
    public String vypis() {
        return "Doklad: Vystavená faktúra\nInterné číslo: " + this.getInterneCislo() + "\nExterné číslo: " + this.getExterneCislo() + "\nZnenie dokladu: " + super.getZnenieDokladu() + "\nCelková hodnota dokladu: " + super.getSumaDokladuString() + "\nPartner: " + super.getPartner().getMeno() + "\nDátum vytvorenia dokladu: " + ComparatorsAndDate.Datum.formatDatum(super.getDatumDokladu());
    }  
}
