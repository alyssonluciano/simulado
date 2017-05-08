/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cpd.telas;

import javax.swing.JOptionPane;
import java.sql.*;
import br.com.cpd.dal.ModuloConexao;

/**
 *
 * @author Alysson
 */
public class TelaSelect extends javax.swing.JFrame {
    Connection conexao=null;
    PreparedStatement pst = null;
    ResultSet rs= null;
    
    /**
     * Creates new form TelaSelect
     */
    public TelaSelect() {
        initComponents();
        conexao = ModuloConexao.conector();
        if (conexao != null){
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cpd/icones/dbok.png")));
        }else{
             lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cpd/icones/dberror.png")));
        }
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGrupo = new javax.swing.ButtonGroup();
        RB8ano = new javax.swing.JRadioButton();
        RR9ano = new javax.swing.JRadioButton();
        RB12serie = new javax.swing.JRadioButton();
        RB3serie = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btGrupo.add(RB8ano);
        RB8ano.setFont(new java.awt.Font("Rod", 1, 18)); // NOI18N
        RB8ano.setForeground(new java.awt.Color(102, 102, 102));
        RB8ano.setText("8° Ano");

        btGrupo.add(RR9ano);
        RR9ano.setFont(new java.awt.Font("Rod", 1, 18)); // NOI18N
        RR9ano.setForeground(new java.awt.Color(102, 102, 102));
        RR9ano.setText("9° Ano");

        btGrupo.add(RB12serie);
        RB12serie.setFont(new java.awt.Font("Rod", 1, 18)); // NOI18N
        RB12serie.setForeground(new java.awt.Color(102, 102, 102));
        RB12serie.setText("1ª e 2ª Serie");

        btGrupo.add(RB3serie);
        RB3serie.setFont(new java.awt.Font("Rod", 1, 18)); // NOI18N
        RB3serie.setForeground(new java.awt.Color(102, 102, 102));
        RB3serie.setText("3ª Serie");

        jLabel1.setFont(new java.awt.Font("Rod", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Que ano deseja conferir?");

        jToggleButton1.setText("Selecionar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cpd/icones/dberror.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblStatus)
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RB12serie)
                            .addComponent(RR9ano)
                            .addComponent(RB8ano)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jToggleButton1)
                                .addComponent(RB3serie))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(RB8ano)
                .addGap(18, 18, 18)
                .addComponent(RR9ano)
                .addGap(18, 18, 18)
                .addComponent(RB12serie)
                .addGap(18, 18, 18)
                .addComponent(RB3serie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus)
                    .addComponent(jToggleButton1))
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // Aqui eu chamo as telas de cada turma.
        if (RB8ano.isSelected()) {
            TelaOitavo oitavo = new TelaOitavo();
            oitavo.setVisible(true); 
            //this.dispose();
            //JOptionPane.showMessageDialog(null, "Sorry, tela em construção");
        }
        else if (RR9ano.isSelected()) {
            this.dispose();
            JOptionPane.showMessageDialog(null, "Sorry, tela em construção");
        }
        else if (RB12serie.isSelected()) {
            this.dispose();
            JOptionPane.showMessageDialog(null, "Sorry, tela em construção");
        }
        else if (RB3serie.isSelected()) {
            this.dispose();
            JOptionPane.showMessageDialog(null, "Sorry, tela em construção");
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione uma opção");
        }
            

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSelect().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RB12serie;
    private javax.swing.JRadioButton RB3serie;
    private javax.swing.JRadioButton RB8ano;
    private javax.swing.JRadioButton RR9ano;
    private javax.swing.ButtonGroup btGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
