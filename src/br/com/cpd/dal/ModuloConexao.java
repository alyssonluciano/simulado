/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cpd.dal;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Alysson
 */
public class ModuloConexao {
    

    public static Connection conector() {

        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbconferencia";
        String user = "root";
        String senha = "";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, senha);
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
       /** try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String strConect = "jdbc:odbc:c:/Primeirobd.accdb";
            conexao = DriverManager.getConnection(strConect,"","");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"erro na conexão" + e);
        }
        return conexao;
        */
    }
}
