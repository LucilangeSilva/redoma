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
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Bases;
public class BasesDinamicas extends JFrame {
   //variavel que armazena consulta as bases de dados existentes no banco
    private final String consulta="Select name,database_id From sys.databases;";
    private JPanel contentPane;
    private JPanel panel;
    private JPanel panel_1;
    private JButton btnAdicionarCheckbox;
    private JButton btnRemoverCheckbox;
    private JButton btnRemoverTodos;
    private List<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BasesDinamicas frame = new BasesDinamicas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    
    //monta uma tela para inclusão dos checkboxes
    public BasesDinamicas() {
        setTitle("Adicionar Checkboxes Dinamicamente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.add(getPanel(), BorderLayout.CENTER);
        contentPane.add(getPanel_1(), BorderLayout.SOUTH);
    }
    private JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        }
        return panel;
    }
    private JPanel getPanel_1() {
        if (panel_1 == null) {
            panel_1 = new JPanel();
           panel_1.add(getBtnAdicionarCheckbox());
            panel_1.add(getBtnRemoverCheckbox());
            panel_1.add(getBtnRemoverTodos());
        }
        return panel_1;
    }
    //realiza uma consulta sobre as bases existentes no servidor
    private List getDb(Connection con){
      List listaBases = new ArrayList();
         Statement stmt;  
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            listaBases = dbToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BasesDinamicas.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BasesDinamicas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bases;
    }
    
    
    
    private int indiceCheckbox = 0;
    private JButton getBtnAdicionarCheckbox() {
        if (btnAdicionarCheckbox == null) {
            btnAdicionarCheckbox = new JButton("Adicionar Checkbox");
            btnAdicionarCheckbox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JCheckBox checkBox = new JCheckBox();
                    indiceCheckbox++;
                    checkBox.setText(String.format("Combo id # %d", indiceCheckbox));
                    panel.add(checkBox); // adiciona o componente criado ao panel...
                    checkboxes.add(checkBox); // e à lista
                    panel.validate();
                    panel.repaint(); // redesenha o painel para mostrar o novo checkbox
                }
            });
        }
        return btnAdicionarCheckbox;
    }
    private JButton getBtnRemoverCheckbox() {
        if (btnRemoverCheckbox == null) {
            btnRemoverCheckbox = new JButton("Remover Checkbox");
            btnRemoverCheckbox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (checkboxes.size() > 0) {
                        // Vamos remover o último, por exemplo
                        // Primeiramente vamos achar o último elemento...
                        JCheckBox checkBox = checkboxes.get(checkboxes.size() - 1);
                        // Agora vamos removê-lo do panel...
                        panel.remove(checkBox);
                        // e da lista também!
                        checkboxes.remove(checkBox);
                        panel.validate();
                        panel.repaint();
                    }
                }
            });
        }
        return btnRemoverCheckbox;
    }
    private JButton getBtnRemoverTodos() {
        if (btnRemoverTodos == null) {
            btnRemoverTodos = new JButton("Remover Todos");
            btnRemoverTodos.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (JCheckBox checkbox : checkboxes) {
                        panel.remove(checkbox); // remove os componentes do panel
                    }
                    checkboxes.clear(); // limpa a lista
                    panel.validate();
                    panel.repaint(); // redesenha o painel para mostrar o novo checkbox
                }
            });
        }
        return btnRemoverTodos;
    }
}