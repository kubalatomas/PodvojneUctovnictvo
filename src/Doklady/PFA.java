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
public class PFA extends UctovnyDoklad {
    private int externeCislo;
    private static int posledneId = 1;
    private String interneCislo = "PFA-";

    public PFA(String znenieDokladu, Calendar datumDokladu, double sumaDokladu, Partner partner, List<Predkontacia> predkontacieDokladu, int externeCislo) {
        super(znenieDokladu, datumDokladu, sumaDokladu, partner, predkontacieDokladu);
        if (externeCislo <= 0) {
            throw new IllegalArgumentException("Zadajte správnu hodnotu pre externé číslo");
        } else {
            this.externeCislo = externeCislo;
        }
        this.interneCislo += posledneId;
        posledneId++;
    }

    public int getExterneCislo() {
        return externeCislo;
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
        return "Doklad: Prijatá faktúra\nInterné číslo: " + this.getInterneCislo() + "\nExterné číslo: " + this.getExterneCislo() + "\nZnenie dokladu: " + super.getZnenieDokladu() + "\nCelková hodnota dokladu: " + super.getSumaDokladuString() + "\nPartner: " + super.getPartner().getMeno() + "\nDátum vytvorenia dokladu: " + ComparatorsAndDate.Datum.formatDatum(super.getDatumDokladu());
    }
}
