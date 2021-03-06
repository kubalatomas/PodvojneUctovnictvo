/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ComparatorsAndDate.CenaSkladovejKartyMaxComparator;
import ComparatorsAndDate.CenaSkladovejKartyMinComparator;
import ComparatorsAndDate.NazovSkladovejKartyAZComparator;
import ComparatorsAndDate.NazovSkladovejKartyZAComparator;
import ComparatorsAndDate.Datum;
import RamcovaUctovaOsnova.Ucet;
import Sklad.PolozkaSkladu;
import Sklad.Sklad;
import Sklad.SkladovaKarta;
import Sklad.ZoznamSkladovychKariet;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Tomáš
 */
public class ZoznamSkladovychKarietGUI extends javax.swing.JFrame {
    private ZoznamSkladovychKariet zoznamSK;
    private DefaultListModel<SkladovaKarta> dlm;
    private Sklad sklad;
    private PolozkaSkladu selected;
    /**
     * Creates new form ZoznamSkladovychKarietGUI
     */
    public ZoznamSkladovychKarietGUI(ZoznamSkladovychKariet zsk, Sklad sklad) {
        initComponents();
        this.zoznamSK = zsk;
        this.dlm = new DefaultListModel<>();
        for (SkladovaKarta s : this.zoznamSK.getZoznamSkladovychKariet()) {
            this.dlm.addElement(s);
        }
        this.vypis.setModel(dlm);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.sklad = sklad;
        this.setResizable(false);
    }
    
    public void obnovList() {
        DefaultListModel<SkladovaKarta> dlmnew = new DefaultListModel<>();
         for (SkladovaKarta s : this.zoznamSK.getZoznamSkladovychKariet()) {
            dlmnew.addElement(s);
        }
        this.vypis.setModel(dlmnew);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        vypis = new javax.swing.JList();
        pridajSK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nazov = new javax.swing.JLabel();
        cena = new javax.swing.JLabel();
        datum = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mnozstvo = new javax.swing.JLabel();
        odstranSK = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sortovanie = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Zoznam skladových kariet");

        vypis.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                vypisValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(vypis);

        pridajSK.setText("Pridaj skladovú kartu");
        pridajSK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajSKActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Informácie o skladovej karte");

        jLabel2.setText("Názov");

        jLabel3.setText("Cena");

        jLabel4.setText("Dátum zaradenia");

        nazov.setText("   ");

        cena.setText("   ");

        datum.setText("   ");

        jLabel6.setText("Množstvo na sklade");

        mnozstvo.setText("   ");

        odstranSK.setText("Odstraň skladovú kartu");
        odstranSK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odstranSKActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Ponuka činností");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Triedenie");

        sortovanie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Podľa názvu skladovej karty vzostupne", "Podľa názvu skladovej karty zostupne", "Podľa ceny skladovej karty vzostupne", "Podľa ceny skladovej karty zostupne" }));
        sortovanie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortovanieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(0, 177, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cena, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(nazov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(datum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mnozstvo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pridajSK, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(odstranSK))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sortovanie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nazov))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cena))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(datum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(mnozstvo))
                        .addGap(134, 134, 134)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(pridajSK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(odstranSK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(14, 14, 14)
                        .addComponent(sortovanie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridajSKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajSKActionPerformed
        PridajSkladovuKartuGUI psk = new PridajSkladovuKartuGUI(null, true);
        if (psk.getSk() != null) {
            if (!this.zoznamSK.pridajSkladovuKartu(psk.getSk())) {
                JOptionPane.showMessageDialog(null, "Skladovú kartu sa nepodarilo pridať. Skúste to znovu");
            } else {
                JOptionPane.showMessageDialog(null, "Skladová karta bola pridaná");
            }
            this.obnovList();
        }
    }//GEN-LAST:event_pridajSKActionPerformed

    private void vypisValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_vypisValueChanged
        SkladovaKarta sk = (SkladovaKarta)this.vypis.getSelectedValue();
        if (sk != null) {
            this.nazov.setText(sk.getNazov());
            this.cena.setText(sk.getCenaString());
            this.datum.setText(Datum.formatDatum(sk.getDatumZaradenia()));
            this.mnozstvo.setText(String.valueOf(this.sklad.dajPocetKusovPodlaId(sk.getIdTovaru())));
        }
    }//GEN-LAST:event_vypisValueChanged

    private void odstranSKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odstranSKActionPerformed
        SkladovaKarta selected = (SkladovaKarta) this.vypis.getSelectedValue();
        if (selected != null) {
            int i = JOptionPane.showConfirmDialog(rootPane, "Naozaj chcete odstrániť skladovú kartu?", "Odstránenie skladovej karty", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_NO_OPTION) {
                this.zoznamSK.odstranSkladovuKartu(selected);
                this.obnovList();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nie je zvolená skladová karta");
        }
        
    }//GEN-LAST:event_odstranSKActionPerformed

    private void sortovanieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortovanieActionPerformed
        if (this.sortovanie.getSelectedIndex() == 0) {
            zoznamSK.zoradSkladoveKartyPodlaNazvuAZ();
            this.obnovList();
        } else if (this.sortovanie.getSelectedIndex() == 1) {
            zoznamSK.zoradSkladoveKartyPodlaNazvuZA();
            this.obnovList();
        } else if (this.sortovanie.getSelectedIndex() == 2) {
            zoznamSK.zoradSkladoveKartyPodlaCenyMin();
            this.obnovList();
        } else if (this.sortovanie.getSelectedIndex() == 3) {
            zoznamSK.zoradSkladoveKartyPodlaCenyMax();
            this.obnovList();
        }
    }//GEN-LAST:event_sortovanieActionPerformed

    public PolozkaSkladu getSelected() {
        return selected;
    }


    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cena;
    private javax.swing.JLabel datum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mnozstvo;
    private javax.swing.JLabel nazov;
    private javax.swing.JButton odstranSK;
    private javax.swing.JButton pridajSK;
    private javax.swing.JComboBox sortovanie;
    private javax.swing.JList vypis;
    // End of variables declaration//GEN-END:variables
}
