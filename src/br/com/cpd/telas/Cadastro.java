/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cpd.telas;

import br.com.cpd.dal.ModuloConexao;
import javax.swing.JOptionPane;
import java.sql.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Alysson
 */
public class Cadastro extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cadastro
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Cadastro() {
	initComponents();
	conexao = ModuloConexao.conector();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void pesquisa_d(){
	String sql = "select * from disciplina where DISCIPLINA = ? AND serie = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtDis.getText());
	    pst.setString(2, txtSturmad.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString(1));
		txtDis.setText(rs.getString(2));
		txtQQ.setText(rs.getString(3));
		txtNiveld.setText(rs.getString(4));
		txtSturmad.setText(rs.getString(5));
            } else {                
                JOptionPane.showMessageDialog(null, "Disciplina não encontrada !");
		txtDis.setText("");
		txtNiveld.setText("");
		txtQQ.setText("");
		txtSturmad.setText("");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }   
       }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rbDisciplina = new javax.swing.JRadioButton();
        rbAluno = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDis = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSturmad = new javax.swing.JTextField();
        txtNiveld = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtQQ = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAluno9 = new javax.swing.JTextField();
        txtSturma9 = new javax.swing.JTextField();
        txtNivel9 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnApagar = new javax.swing.JButton();
        btnPesquisa = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro");
        setMinimumSize(new java.awt.Dimension(867, 532));
        setPreferredSize(new java.awt.Dimension(867, 532));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Plantagenet Cherokee", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        buttonGroup1.add(rbDisciplina);
        rbDisciplina.setText("Disciplina");
        rbDisciplina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbDisciplinaItemStateChanged(evt);
            }
        });
        rbDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDisciplinaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbAluno);
        rbAluno.setText("Aluno");
        rbAluno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbAlunoItemStateChanged(evt);
            }
        });
        rbAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbAluno)
                    .addComponent(rbDisciplina))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(rbAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDisciplina)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Disciplina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Plantagenet Cherokee", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        txtID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtID.setForeground(new java.awt.Color(102, 102, 102));
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtID.setCaretColor(new java.awt.Color(153, 153, 153));
        txtID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtID.setEnabled(false);
        txtID.setMargin(new java.awt.Insets(1, 5, 1, 1));

        jLabel7.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 12)); // NOI18N
        jLabel7.setText("Disciplina");

        txtDis.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDis.setForeground(new java.awt.Color(102, 102, 102));
        txtDis.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDis.setToolTipText("");
        txtDis.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtDis.setCaretColor(new java.awt.Color(153, 153, 153));
        txtDis.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDis.setEnabled(false);
        txtDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 12)); // NOI18N
        jLabel6.setText("Série/Turma");

        txtSturmad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSturmad.setForeground(new java.awt.Color(102, 102, 102));
        txtSturmad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSturmad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtSturmad.setCaretColor(new java.awt.Color(153, 153, 153));
        txtSturmad.setEnabled(false);

        txtNiveld.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNiveld.setForeground(new java.awt.Color(102, 102, 102));
        txtNiveld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNiveld.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtNiveld.setCaretColor(new java.awt.Color(153, 153, 153));
        txtNiveld.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 12)); // NOI18N
        jLabel8.setText("Nível");

        jLabel9.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 12)); // NOI18N
        jLabel9.setText("Qnatidade de Questões");

        txtQQ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtQQ.setForeground(new java.awt.Color(102, 102, 102));
        txtQQ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQQ.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtQQ.setCaretColor(new java.awt.Color(153, 153, 153));
        txtQQ.setEnabled(false);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cpd/icones/dis.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtQQ, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtSturmad, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNiveld, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addComponent(txtDis, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDis, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQQ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSturmad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNiveld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addContainerGap())))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Plantagenet Cherokee", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        txtMatricula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMatricula.setForeground(new java.awt.Color(102, 102, 102));
        txtMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMatricula.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtMatricula.setCaretColor(new java.awt.Color(153, 153, 153));
        txtMatricula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtMatricula.setEnabled(false);
        txtMatricula.setMargin(new java.awt.Insets(1, 5, 1, 1));

        jLabel1.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 12)); // NOI18N
        jLabel1.setText("Matrícula");

        jLabel2.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 12)); // NOI18N
        jLabel2.setText("Nome");

        jLabel4.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 12)); // NOI18N
        jLabel4.setText("Nível");

        jLabel3.setFont(new java.awt.Font("Plantagenet Cherokee", 0, 12)); // NOI18N
        jLabel3.setText("Série/Turma");

        txtAluno9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAluno9.setForeground(new java.awt.Color(102, 102, 102));
        txtAluno9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAluno9.setToolTipText("");
        txtAluno9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtAluno9.setCaretColor(new java.awt.Color(153, 153, 153));
        txtAluno9.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtAluno9.setEnabled(false);
        txtAluno9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAluno9ActionPerformed(evt);
            }
        });

        txtSturma9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSturma9.setForeground(new java.awt.Color(102, 102, 102));
        txtSturma9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSturma9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtSturma9.setCaretColor(new java.awt.Color(153, 153, 153));
        txtSturma9.setEnabled(false);

        txtNivel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNivel9.setForeground(new java.awt.Color(102, 102, 102));
        txtNivel9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNivel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtNivel9.setCaretColor(new java.awt.Color(153, 153, 153));
        txtNivel9.setEnabled(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cpd/icones/aluno.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAluno9)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtSturma9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)))
                                .addGap(201, 201, 201)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNivel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(54, 54, 54))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAluno9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSturma9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNivel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        btnPesquisa.setBackground(new java.awt.Color(51, 153, 255));
        btnPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisa.setText("Pesquisa");
        btnPesquisa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        btnPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        btnInserir.setBackground(new java.awt.Color(51, 153, 255));
        btnInserir.setForeground(new java.awt.Color(255, 255, 255));
        btnInserir.setText("Inserir");
        btnInserir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        btnInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
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

        btnLimpar.setBackground(new java.awt.Color(51, 153, 255));
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(867, 532));
    }// </editor-fold>//GEN-END:initComponents
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
	    } else {
		JOptionPane.showMessageDialog(null, "Aluno não encontrado !");
		txtMatricula.setText("");
		txtAluno9.setText("");
		txtNivel9.setText("");
		txtSturma9.setText("");
	    }

	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, e);

	}

    }
    public void inserir_aluno(){
     String sql = "insert into aluno(idaluno,aluno,serie,nivel) values (?,?,?,?)";
     try {
	  pst = conexao.prepareStatement(sql);
          pst.setString(1, txtMatricula.getText());
	  pst.setString(2, txtAluno9.getText());
	  pst.setString(3, txtSturma9.getText());
	  pst.setString(4, txtNivel9.getText());
            // Here we update the table.
            pst.executeUpdate();	 
	 JOptionPane.showMessageDialog(null, "Aluno cadastrado!");
	    
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, e);
	}   
    }
    public void inserir_dis(){	
	String sql= "insert into disciplina (DISCIPLINA,QUANTIDADE_QUETÕES,nivel,serie)values (?,?,?,?)";
	try {
	    pst = conexao.prepareStatement(sql);
	    pst.setString(1, txtDis.getText());
	    pst.setString(2, txtQQ.getText());
	    pst.setString(3, txtNiveld.getText());
	    pst.setString(4, txtSturmad.getText());
	    pst.executeUpdate();
	    JOptionPane.showMessageDialog(null, "Disciplina cadastrada!");
	    
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, e);
	}       
    }
    public void altera_aluno(){
    String sql  = "update aluno set aluno = ?, serie = ?, nivel=? where idaluno=?";
    try {
	    pst = conexao.prepareStatement(sql);	        
	    pst.setString(1, txtAluno9.getText());
	    pst.setString(2, txtSturma9.getText());
	    pst.setString(3, txtNivel9.getText());	
	    pst.setString(4, txtMatricula.getText());    
	    pst.executeUpdate();
	    JOptionPane.showMessageDialog(null, "Aluno alterado!");		
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, e);
	}  
           
    }
    public void altera_dis(){
    String sql  = "update disciplina set DISCIPLINA=?,QUANTIDADE_QUETÕES=?,nivel=?,serie=? where iddisciplina=?";
    try {
	    pst = conexao.prepareStatement(sql);	        
	    pst.setString(1, txtDis.getText());
	    pst.setString(2, txtQQ.getText());
	    pst.setString(3, txtNiveld.getText());
	    pst.setString(4, txtSturmad.getText());
	    pst.setString(5, txtID.getText());
	    pst.executeUpdate();
	    JOptionPane.showMessageDialog(null, "Disciplina alterada!");		
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, e);
	}     
           
    }

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
	// here hwo to remove table lines when selected
	if (rbAluno.isSelected()) {
	    String sql = "DELETE FROM `dbconferencia`.`aluno` WHERE `idaluno`=?";
	    try {
		pst = conexao.prepareStatement(sql);
		pst.setString(1, txtMatricula.getText());
		pst.executeUpdate();
		txtMatricula.setText("");
		txtAluno9.setText("");
		txtNivel9.setText("");
		txtSturma9.setText("");
		JOptionPane.showMessageDialog(null, "Aluno excluido!");
		
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	    }

	} else if (rbDisciplina.isSelected()) {
	    String sql = "DELETE FROM `dbconferencia`.`disciplina` WHERE `iddisciplina`=?";
	    try {
		pst = conexao.prepareStatement(sql);
		pst.setString(1, txtID.getText());
		pst.executeUpdate();
		txtDis.setText("");
		txtNiveld.setText("");
		txtQQ.setText("");
		txtSturmad.setText("");
		txtID.setText("");
		JOptionPane.showMessageDialog(null, "Disciplina excluida!");
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	    }	   
	} else {
	    JOptionPane.showMessageDialog(null, "Selecione uma função!");
	}
    }//GEN-LAST:event_btnApagarActionPerformed

    private void txtAluno9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAluno9ActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_txtAluno9ActionPerformed

    private void txtDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_txtDisActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        // TODO add your handling code here:
	if (rbAluno.isSelected()) {	   
	    consultar();
	} else if (rbDisciplina.isSelected()) {
	     pesquisa_d();
	} else {
	    JOptionPane.showMessageDialog(null, "Selecione uma função!");
	}
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void rbAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAlunoActionPerformed
        // TODO add your handling code here:
	txtMatricula.setEnabled(true);
	txtAluno9.setEnabled(true);
	txtNivel9.setEnabled(true);
	txtSturma9.setEnabled(true);
    }//GEN-LAST:event_rbAlunoActionPerformed

    private void rbAlunoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbAlunoItemStateChanged
        // TODO add your handling code here:
	txtMatricula.setEnabled(false);
	txtAluno9.setEnabled(false);
	txtNivel9.setEnabled(false);
	txtSturma9.setEnabled(false);
    }//GEN-LAST:event_rbAlunoItemStateChanged

    private void rbDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDisciplinaActionPerformed
        // TODO add your handling code here:
	txtDis.setEnabled(true);
	txtNiveld.setEnabled(true);
	txtQQ.setEnabled(true);
	txtSturmad.setEnabled(true);
    }//GEN-LAST:event_rbDisciplinaActionPerformed

    private void rbDisciplinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbDisciplinaItemStateChanged
        // TODO add your handling code here:
	txtDis.setEnabled(false);
	txtNiveld.setEnabled(false);
	txtQQ.setEnabled(false);
	txtSturmad.setEnabled(false);
    }//GEN-LAST:event_rbDisciplinaItemStateChanged

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        // TODO add your handling code here:
	
	if (rbAluno.isSelected()) {

	    inserir_aluno();
	    txtMatricula.setText("");
	    txtAluno9.setText("");
	    txtNivel9.setText("");
	    txtSturma9.setText("");
	    

	} else if (rbDisciplina.isSelected()) {
	    inserir_dis();
	    txtDis.setText("");
	    txtNiveld.setText("");
	    txtQQ.setText("");
	    txtSturmad.setText("");
	} else {
	    JOptionPane.showMessageDialog(null, "Selecione uma função!");
	}
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
	if (rbAluno.isSelected()) {
	    altera_aluno();
	    consultar();
	    
	} else if (rbDisciplina.isSelected()) {
	    altera_dis();
	    pesquisa_d();
	} else {
	    JOptionPane.showMessageDialog(null, "Selecione uma função!");
	}
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
	    txtDis.setText("");
	    txtNiveld.setText("");
	    txtQQ.setText("");
	    txtSturmad.setText("");
	    txtMatricula.setText("");
	    txtAluno9.setText("");
	    txtNivel9.setText("");
	    txtSturma9.setText("");	    
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rbAluno;
    private javax.swing.JRadioButton rbDisciplina;
    private javax.swing.JTextField txtAluno9;
    private javax.swing.JTextField txtDis;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNivel9;
    private javax.swing.JTextField txtNiveld;
    private javax.swing.JTextField txtQQ;
    private javax.swing.JTextField txtSturma9;
    private javax.swing.JTextField txtSturmad;
    // End of variables declaration//GEN-END:variables
}
