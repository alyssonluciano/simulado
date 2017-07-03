/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cpd.telas;

import br.com.cpd.classes.Numeros;
import br.com.cpd.dal.ModuloConexao;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Alysson
 */
public class TelaNono extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int acertos, questoes;
    double nota;
    String sNota;

    /**
     * Creates new form TelaNono
     */
    public TelaNono() {
	initComponents();
	conexao = ModuloConexao.conector();
	txtAcertos.setDocument(new Numeros());

    }

    private void consultar() {
	String sql = "select *from aluno where idaluno=?";
	try {
	    pst = conexao.prepareStatement(sql);
	    pst.setString(1, txtMatricula.getText());
	    rs = pst.executeQuery();
	    if (rs.next()) {
		txtAluno9.setText(rs.getString(2));
		txtSturma9.setText(rs.getString(3));
		txtNivel9.setText(rs.getString(4));
		btnDisciplina.setEnabled(true);
	    } else {
		btnDisciplina.setEnabled(false);
		JOptionPane.showMessageDialog(null, "Aluno não encontrado !");
	    }

	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, e);
	}

    }

    private void carregar_disciplinas() {
	String sql = "select DISCIPLINA,QUANTIDADE_QUETÕES from disciplina where serie = ?";
	try {
	    pst = conexao.prepareStatement(sql);
	    pst.setString(1, txtSturma9.getText());
	    rs = pst.executeQuery();
	    //carregando consulta na tebela com a bibliotecars2xml
	    tblDisciplinas.setModel(DbUtils.resultSetToTableModel(rs));
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, e);
	}

    }

    // metodo para carregar valores da tabela nas caixas de texto
    public void setar_campos() {
	int setar = tblDisciplinas.getSelectedRow();
	txtDisciplina.setText(tblDisciplinas.getModel().getValueAt(setar, 0).toString());
	txtQuestoes.setText(tblDisciplinas.getModel().getValueAt(setar, 1).toString());

    }

    public void calcula_nota() {
	questoes = Integer.parseInt(txtQuestoes.getText());
	acertos = Integer.parseInt(txtAcertos.getText());

	try {
	    if(questoes >= acertos ){
	    nota = 10.0 / questoes * acertos;
	    BigDecimal bNota = new BigDecimal(nota).setScale(1, RoundingMode.HALF_EVEN);
	    //System.out.println(bNota.doubleValue());
	    sNota = bNota.toString();
	    txtNota.setText(sNota);
	    }
	    else{
	    JOptionPane.showMessageDialog(null, "Número de acertos excedente !");
	    txtAcertos.setText("");
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, e);
	}
    }
    public void popula_conferencia(){
    
	String matricula = txtMatricula.getText().trim();
	String disciplina = txtDisciplina.getText().trim();
	String acertos2 = txtAcertos.getText().trim();
	
	DefaultTableModel val =(DefaultTableModel) tblConferencia1.getModel();
	val.addRow(new String[]{matricula,disciplina,acertos2,sNota});
	
	txtDisciplina.setText("");
	txtQuestoes.setText("");
	txtAcertos.setText("");
	txtNota.setText("");        
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAluno9 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSturma9 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNivel9 = new javax.swing.JTextField();
        btnSelectStudant = new javax.swing.JButton();
        btnDisciplina = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisciplinas = new javax.swing.JTable();
        txtAcertos = new javax.swing.JTextField();
        txtDisciplina = new javax.swing.JTextField();
        txtQuestoes = new javax.swing.JTextField();
        txtNota = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConferencia1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Conf. 9ºAno");
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(867, 532));
        setName("FrameNono"); // NOI18N
        setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(867, 532));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Plantagenet Cherokee", 1, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        txtMatricula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMatricula.setForeground(new java.awt.Color(102, 102, 102));
        txtMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMatricula.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtMatricula.setCaretColor(new java.awt.Color(153, 153, 153));
        txtMatricula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtMatricula.setMargin(new java.awt.Insets(1, 5, 1, 1));

        jLabel1.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 12)); // NOI18N
        jLabel1.setText("Matrícula");

        jLabel2.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 12)); // NOI18N
        jLabel2.setText("Nome");

        txtAluno9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAluno9.setForeground(new java.awt.Color(102, 102, 102));
        txtAluno9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAluno9.setToolTipText("");
        txtAluno9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtAluno9.setCaretColor(new java.awt.Color(153, 153, 153));
        txtAluno9.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtAluno9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAluno9ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 12)); // NOI18N
        jLabel3.setText("Série/Turma");

        txtSturma9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSturma9.setForeground(new java.awt.Color(102, 102, 102));
        txtSturma9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSturma9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtSturma9.setCaretColor(new java.awt.Color(153, 153, 153));

        jLabel4.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 12)); // NOI18N
        jLabel4.setText("Nível");

        txtNivel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNivel9.setForeground(new java.awt.Color(102, 102, 102));
        txtNivel9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNivel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtNivel9.setCaretColor(new java.awt.Color(153, 153, 153));

        btnSelectStudant.setText("Selecionar Aluno");
        btnSelectStudant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectStudantActionPerformed(evt);
            }
        });

        btnDisciplina.setText("Carregar Disciplinas");
        btnDisciplina.setEnabled(false);
        btnDisciplina.setPreferredSize(new java.awt.Dimension(111, 23));
        btnDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisciplinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSturma9)))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtAluno9)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNivel9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)))
                        .addGap(71, 71, 71)
                        .addComponent(btnDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnSelectStudant, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAluno9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatricula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectStudant, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSturma9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNivel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 11, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Displinas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Plantagenet Cherokee", 1, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        tblDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disciplina", "Quantidade de Questões"
            }
        ));
        tblDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDisciplinasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDisciplinas);

        txtAcertos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAcertos.setForeground(new java.awt.Color(102, 102, 102));
        txtAcertos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAcertos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtAcertos.setCaretColor(new java.awt.Color(153, 153, 153));
        txtAcertos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAcertosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAcertosKeyTyped(evt);
            }
        });

        txtDisciplina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDisciplina.setForeground(new java.awt.Color(102, 102, 102));
        txtDisciplina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDisciplina.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtDisciplina.setCaretColor(new java.awt.Color(153, 153, 153));
        txtDisciplina.setEnabled(false);

        txtQuestoes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtQuestoes.setForeground(new java.awt.Color(102, 102, 102));
        txtQuestoes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuestoes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtQuestoes.setCaretColor(new java.awt.Color(153, 153, 153));
        txtQuestoes.setEnabled(false);

        txtNota.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNota.setForeground(new java.awt.Color(102, 102, 102));
        txtNota.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNota.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtNota.setCaretColor(new java.awt.Color(153, 153, 153));
        txtNota.setEnabled(false);
        txtNota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNotaKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText(" Disciplina");

        jLabel6.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("  Questões");

        jLabel7.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 153));
        jLabel7.setText("Acertos");

        jLabel8.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 153));
        jLabel8.setText("Nota");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cpd/icones/ancel.png"))); // NOI18N
        jButton1.setToolTipText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cpd/icones/add.png"))); // NOI18N
        jButton2.setToolTipText("Insert");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuestoes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(17, 17, 17))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtAcertos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuestoes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAcertos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton1.getAccessibleContext().setAccessibleDescription("");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conferência", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Plantagenet Cherokee", 1, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        tblConferencia1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Disciplina", "Acertos", "Nota"
            }
        ));
        jScrollPane2.setViewportView(tblConferencia1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(867, 532));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectStudantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectStudantActionPerformed
	// Using the method consultar.
	consultar();
    }//GEN-LAST:event_btnSelectStudantActionPerformed


    private void txtAluno9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAluno9ActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_txtAluno9ActionPerformed

    private void btnDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisciplinaActionPerformed
	carregar_disciplinas();
    }//GEN-LAST:event_btnDisciplinaActionPerformed

    private void tblDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDisciplinasMouseClicked
	// chamando metodo para carregar as caixas de texto
	setar_campos();
    }//GEN-LAST:event_tblDisciplinasMouseClicked

    private void txtAcertosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAcertosKeyTyped
	// TODO add your handling code here:


    }//GEN-LAST:event_txtAcertosKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	// TODO add your handling code here:
	popula_conferencia();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNotaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotaKeyPressed
	// TODO add your handling code here:
	//calcula_nota();
    }//GEN-LAST:event_txtNotaKeyPressed

    private void txtAcertosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAcertosKeyReleased
	// TODO add your handling code here:
	calcula_nota();
    }//GEN-LAST:event_txtAcertosKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	txtDisciplina.setText("");
	txtQuestoes.setText("");
	txtAcertos.setText("");
	txtNota.setText("");
// Limpando os campos  carregados
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisciplina;
    private javax.swing.JButton btnSelectStudant;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblConferencia1;
    private javax.swing.JTable tblDisciplinas;
    private javax.swing.JTextField txtAcertos;
    private javax.swing.JTextField txtAluno9;
    private javax.swing.JTextField txtDisciplina;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNivel9;
    private javax.swing.JTextField txtNota;
    private javax.swing.JTextField txtQuestoes;
    private javax.swing.JTextField txtSturma9;
    // End of variables declaration//GEN-END:variables
}
