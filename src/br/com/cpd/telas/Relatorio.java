/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cpd.telas;

import java.sql.*;
import br.com.cpd.dal.ModuloConexao;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author Alysson
 */
public class Relatorio extends javax.swing.JInternalFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form Relatorio
     */
    public Relatorio() {
	initComponents();
	 conexao = ModuloConexao.conector();
	 populaJCombobox();
    }
    
     public void populaJCombobox() {
        String sql = "select * from SIMULADO";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                cmbSimulado.addItem(rs.getString("SIMNOME"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(TelaOitavo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      private void select_nota() {
        String sql = "SELECT nota.IDNOTA, nota.MATRICULA, aluno.aluno, aluno.nivel,aluno.SERIE,nota.DISCIPLINA, nota.ACERTOS,		   \n"
		  + "nota.NOTA, nota.CONFERENCIA_DATA \n"
		  + "\n"
		  + "FROM aluno INNER JOIN nota on aluno.IDALUNO = nota.MATRICULA WHERE nota.SIMULADO =  ?  order by aluno.SERIE, nota.MATRICULA";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cmbSimulado.getSelectedItem().toString());
            rs = pst.executeQuery();
            //carregando consulta na tebela com a bibliotecars2xml
            tblNota.setModel(DbUtils.resultSetToTableModel(rs));
            //btnPesquisa.setEnabled(false);
	    //btnImprimir.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNota = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cmbSimulado = new javax.swing.JComboBox<>();
        btnApagar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnPesquisa = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setTitle("Relatório");
        setMinimumSize(new java.awt.Dimension(867, 532));
        setPreferredSize(new java.awt.Dimension(867, 532));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 500));

        tblNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNota);
        if (tblNota.getColumnModel().getColumnCount() > 0) {
            tblNota.getColumnModel().getColumn(0).setResizable(false);
            tblNota.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblNota.getColumnModel().getColumn(1).setResizable(false);
            tblNota.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Plantagenet Cherokee", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        cmbSimulado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Simulado", " " }));
        cmbSimulado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSimuladoItemStateChanged(evt);
            }
        });

        btnApagar.setBackground(new java.awt.Color(51, 153, 255));
        btnApagar.setForeground(new java.awt.Color(255, 255, 255));
        btnApagar.setText("Excluir");
        btnApagar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        btnApagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(51, 153, 255));
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(51, 153, 255));
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cpd/icones/if_Print.png"))); // NOI18N
        btnImprimir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnPesquisa.setBackground(new java.awt.Color(51, 153, 255));
        btnPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisa.setText("Pesquisar");
        btnPesquisa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        btnPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbSimulado, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSimulado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(867, 532));
    }// </editor-fold>//GEN-END:initComponents

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        // here hwo to remove table lines when selected
        int excluir = tblNota.getSelectedRow();

        String idsim = tblNota.getModel().getValueAt(excluir, 0).toString();

        String sql = "DELETE FROM `dbconferencia`.`nota` WHERE `IDNOTA`=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, idsim);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "O Registro selecionado foi excluido !");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
	select_nota();	
        
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO update on nota table in data source
	int alter = tblNota.getSelectedRow();

        String id = tblNota.getModel().getValueAt(alter, 0).toString();
        String disc = tblNota.getModel().getValueAt(alter, 5).toString();
        String acertos = tblNota.getModel().getValueAt(alter, 6).toString();
        String nota = tblNota.getModel().getValueAt(alter, 7).toString();

        String sql = "update nota set DISCIPLINA=?,ACERTOS=?, NOTA=? where IDNOTA=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, disc);
            pst.setString(2, acertos);
            pst.setString(3, nota);
            pst.setString(4, id);
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
	JOptionPane.showMessageDialog(null, "Informação alterada com sucesso!");
       select_nota();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // Geração do relatorio de conferencia
	int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impressão desse relatório?",
		"Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	    try {
		HashMap filtro = new HashMap();
		filtro.put("cbmSim",cmbSimulado.getSelectedItem().toString());
		JasperPrint print = JasperFillManager.fillReport("C:\\Users\\Alysson\\Documents\\NetBeansProjects\\conferenciasimulado\\src\\reports\\MyReports\\conferencia.jasper", filtro, conexao);
		// exibe o relatorio
		JasperViewer.viewReport(print,false);
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	    }

	}
	
	
	
	
	
	
        
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        // TODO add your handling code here:
	select_nota();
	//cmbSimulado.setSelectedIndex(0);
	//if (cmbSimulado.getSelectedItem() == "Selecione o Simulado") {
	   // btnPesquisa.setEnabled(false);
	   // btnImprimir.setEnabled(false);
	//}
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void cmbSimuladoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSimuladoItemStateChanged
        // TODO add your handling code here:
	//btnPesquisa.setEnabled(true);
	//btnImprimir.setEnabled(true);
    }//GEN-LAST:event_cmbSimuladoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JComboBox<String> cmbSimulado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNota;
    // End of variables declaration//GEN-END:variables
}
