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
public class ID extends UctovnyDoklad {
    private boolean uctovatDoOtvorenia = false;
    private String interneCislo = "ID-";
    private static int posledneId = 1;

    public ID(String znenieDokladu, Calendar datumDokladu, double sumaDokladu, Partner partner, List<Predkontacia> predkontacieDokladu) {
        super(znenieDokladu, datumDokladu, sumaDokladu, partner, predkontacieDokladu);
        this.interneCislo += posledneId;
        posledneId++;
        this.uctovatDoOtvorenia = false;
    }

    public String getInterneCislo() {
        return interneCislo;
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
        return "Doklad: Interný doklad\nInterné číslo: " + this.getInterneCislo() + "\nZnenie dokladu: " + super.getZnenieDokladu() + "\nCelková hodnota dokladu: " + super.getSumaDokladuString() + "\nPartner: " + super.getPartner().getMeno() + "\nDátum vytvorenia dokladu: " + ComparatorsAndDate.Datum.formatDatum(super.getDatumDokladu());
    }
}
