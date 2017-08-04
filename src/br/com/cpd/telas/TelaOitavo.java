/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cpd.telas;

/**
 *
 * @author Alysson
 */
import java.sql.*;
import br.com.cpd.dal.ModuloConexao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.cpd.telas.TelaNono;

public class TelaOitavo extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String stringSimNome;
    static String turma;

    /**
     * Creates new form TelaOitavo
     */
    public TelaOitavo() {
        initComponents();	
	
        conexao = ModuloConexao.conector();	
        populaJCombobox();
    }

    /* private void consultar() {
        String sql = "select *from aluno where idaluno=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtMatricula.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtAluno8.setText(rs.getString(2));
                txtSturma8.setText(rs.getString(3));
                txtNivel8.setText(rs.getString(4));
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado !");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }*/
    
    
    
    
    
    public void populaJCombobox() {
        String sql = "select * from SIMULADO";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                cmbDisciplina.addItem(rs.getString("SIMNOME"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(TelaOitavo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insert() {
        stringSimNome = JOptionPane.showInputDialog(null, "Nome do Simulado", "SIM0_0BIM_EMI");

        String sql = "insert into SIMULADO(SIMNOME) values (?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, stringSimNome);
            // Here we update the table.
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void get_turma(){
    
	if (rbOitavo.isSelected()) {	    
	    turma = "8";	    
	} else if(rbNono.isSelected()){
	    turma = "9";
	}else if(rbSerie1.isSelected()){
	    turma = "1";
	}else if(rbSerie2.isSelected()){
	    turma = "2";
	}else if(rbSerie3.isSelected()){
	    turma ="3";
	}
	//System.out.println(turma);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgTurma = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        cmbDisciplina = new javax.swing.JComboBox<>();
        btnSelect = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        rbOitavo = new javax.swing.JRadioButton();
        rbNono = new javax.swing.JRadioButton();
        rbSerie1 = new javax.swing.JRadioButton();
        rbSerie2 = new javax.swing.JRadioButton();
        rbSerie3 = new javax.swing.JRadioButton();
        dtnRelatoio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Para iniciar você deve selecionar o simulado.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Rod", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Simulado");

        btnInsert.setText("Inserir");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        cmbDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDisciplinaActionPerformed(evt);
            }
        });

        btnSelect.setText("Selecionar");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btgTurma.add(rbOitavo);
        rbOitavo.setText("8º");

        btgTurma.add(rbNono);
        rbNono.setText("9º");

        btgTurma.add(rbSerie1);
        rbSerie1.setText("1ª");

        btgTurma.add(rbSerie2);
        rbSerie2.setText("2ª");

        btgTurma.add(rbSerie3);
        rbSerie3.setText("3ª");

        dtnRelatoio.setText("Relatório");
        dtnRelatoio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtnRelatoioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(cmbDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rbOitavo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(rbNono)
                        .addGap(29, 29, 29)
                        .addComponent(rbSerie1)
                        .addGap(29, 29, 29)
                        .addComponent(rbSerie2)
                        .addGap(33, 33, 33)
                        .addComponent(rbSerie3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dtnRelatoio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtnRelatoio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbOitavo)
                    .addComponent(rbNono)
                    .addComponent(rbSerie1)
                    .addComponent(rbSerie2)
                    .addComponent(rbSerie3))
                .addGap(17, 17, 17))
        );

        jLabel1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // Insert a new SMULADO in the DataBase.
        insert();
        cmbDisciplina.removeAllItems();
        populaJCombobox();

    }//GEN-LAST:event_btnInsertActionPerformed

    private void cmbDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDisciplinaActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        // TODO add your handling code here:
	get_turma();
	if (turma == null) {
	    JOptionPane.showMessageDialog(null, "Escolha uma tuarma");

	} else {
	    TelaSelect master = new TelaSelect();	   
	    master.setVisible(true);
	    TelaNono.sSimNome = cmbDisciplina.getSelectedItem().toString();
	    this.dispose();
	}

    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int btnCancel = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Atenção1", JOptionPane.YES_NO_OPTION);

        if (btnCancel == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (btnCancel == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Ok, Selecione o simulado");
        }


    }//GEN-LAST:event_btnCancelActionPerformed

    private void dtnRelatoioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtnRelatoioActionPerformed
        // TODO add your handling code here:
	TelaSelect master = new TelaSelect();
	master.setVisible(true);	
	this.dispose();
	
    }//GEN-LAST:event_dtnRelatoioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaOitavo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaOitavo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaOitavo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaOitavo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaOitavo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgTurma;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSelect;
    private javax.swing.JComboBox<String> cmbDisciplina;
    private javax.swing.JButton dtnRelatoio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rbNono;
    private javax.swing.JRadioButton rbOitavo;
    private javax.swing.JRadioButton rbSerie1;
    private javax.swing.JRadioButton rbSerie2;
    private javax.swing.JRadioButton rbSerie3;
    // End of variables declaration//GEN-END:variables
}
