/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Podnik.FormaPodniku;
import Podnik.Podnik;
import javax.swing.JOptionPane;

/**
 *
 * @author Tomáš
 */
public class UpravPodnikGUI extends javax.swing.JDialog {
    private Podnik podnik;
    /**
     * Creates new form UpravPodnikGUI
     */
    public UpravPodnikGUI(java.awt.Frame parent, boolean modal, Podnik p) {
        super(parent, modal);
        initComponents();
        this.podnik = p;
        this.adresaPodniku.setText(p.getAdresa());
        this.nazovPodniku.setText(p.getNazovPodniku());
        this.uctovnyRok.setText(String.valueOf(p.getUctovnyRok()));
        if (p.getForma() == FormaPodniku.as) {
            this.forma.setSelectedIndex(1);
            } else {
            this.forma.setSelectedIndex(0);
        }
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        forma = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nazovPodniku = new javax.swing.JTextField();
        uctovnyRok = new javax.swing.JTextField();
        adresaPodniku = new javax.swing.JTextField();
        uprav = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Zadajte informácie o podniku");

        jLabel2.setText("Názov podniku");

        jLabel3.setText("Forma podniku");

        forma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Spoločnosť s ručením obmedzením (s. r. o.)", "Akciová spoločnosť (a. s.)" }));

        jLabel4.setText("Účtovný rok");

        jLabel5.setText("Adresa podniku");

        nazovPodniku.setText("jTextField1");

        uctovnyRok.setText("jTextField2");

        adresaPodniku.setText("jTextField3");

        uprav.setText("Uprav informácie");
        uprav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upravActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(forma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nazovPodniku)
                                .addComponent(uctovnyRok, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(adresaPodniku))
                            .addComponent(uprav))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nazovPodniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(forma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(uctovnyRok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(adresaPodniku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(uprav)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void upravActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upravActionPerformed
        try {
            String nazovPodniku = this.nazovPodniku.getText();
            String adresaPodniku = this.adresaPodniku.getText();
            int uctovnyRok = Integer.parseInt(this.uctovnyRok.getText());
            FormaPodniku forma = null;
            if (this.forma.getSelectedIndex() == 0) {
                forma = FormaPodniku.sro;
            } else {
                forma = FormaPodniku.as;
            }
            this.podnik.upravPodnik(adresaPodniku, uctovnyRok, forma, nazovPodniku);
            JOptionPane.showMessageDialog(rootPane, "Údaje boli zmenené");
            dispose();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    
    }//GEN-LAST:event_upravActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresaPodniku;
    private javax.swing.JComboBox forma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nazovPodniku;
    private javax.swing.JTextField uctovnyRok;
    private javax.swing.JButton uprav;
    // End of variables declaration//GEN-END:variables
}
