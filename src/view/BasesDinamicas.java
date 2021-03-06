/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Valmir Andrade
 */

import java.awt.BorderLayout;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EmptyBorder;
import util.Bases;

public class BasesDinamicas extends JFrame {
   //variavel que armazena consulta as bases de dados existentes no banco
    private final String consulta="Select name,database_id From sys.databases;";
    private JPanel contentPane;
    private List<JCheckBox> checkboxes = new ArrayList<>();
    /**
     * Launch the application.
     * @param args
     */
    
     public BasesDinamicas() {
      
     }
    /**
     * Create the frame.
     * @param con
     */
    //monta uma tela para inclusão dos checkboxes
    public BasesDinamicas(Connection con) {
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
      
        setContentPane(contentPane);
        ListarCheckbox(getDb(con));
        for (int i = 0; i< this.checkboxes.size();i++) {
              JCheckBox checkBox =this.checkboxes.get(i);
              checkBox.setBounds(10,20,10,10);
              contentPane.add(checkBox);
        }
                setVisible(true);
    }
    
    //transforma a lista de bases em uma lista de checkbox
    private void ListarCheckbox(List<Bases> bases) {
        
       
       
        for (Bases base : bases) {
             JCheckBox checkBox = new JCheckBox();
            checkBox.setName(Integer.toString(base.getId()));
            checkBox.setText(base.getNome());
            //adiciona o checkbox a lista de checkbox
            this.checkboxes.add(checkBox);
        }
        
    }

    //realiza uma consulta sobre as bases existentes no servidor
    private List<Bases> getDb(Connection con){
      List<Bases> listaBases = new ArrayList();
         Statement stmt;  
        
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            rs.next();
            listaBases = dbToList(rs);
            
        } catch (SQLException ex) {
            //Logger.getLogger(BasesDinamicas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro no getdb");
            ex.printStackTrace();
            
        }
           return listaBases;
    }
    //transforma o resultado de uma consulta em uma lista de objetos do tipo Bases
    private List dbToList(ResultSet rs){
        List bases = new ArrayList();
        try {
            while (rs.next()) {
                Bases base = new Bases();
                base.setNome(rs.getString("name"));
                 base.setId(rs.getInt("database_id"));
                 bases.add(base);
            }
        } catch (SQLException ex) {
            //tratamento casso ocorra algum erro ao percorrer o Resultset (resultado da consulta)
            System.out.println("erro no dbtolist");
            Logger.getLogger(BasesDinamicas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bases;
    }
}