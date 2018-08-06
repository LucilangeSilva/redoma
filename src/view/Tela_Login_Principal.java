/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import util.ConnectionFactory;

/**
 *
 * @author aldam
 */
public class Tela_Login_Principal extends javax.swing.JFrame {
    /**
     * Creates new form telaLogin
     */
    
     private Connection con;
    public Tela_Login_Principal() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jBtCredito = new javax.swing.JButton();
        jLsimblo = new javax.swing.JLabel();
        jLNomeServidor = new javax.swing.JLabel();
        jLautenticacao = new javax.swing.JLabel();
        jLnomUsuario = new javax.swing.JLabel();
        jLsenha = new javax.swing.JLabel();
        jTextFieldNomServidor = new javax.swing.JTextField();
        jComboBoxAutenticar = new javax.swing.JComboBox<>();
        jTextFieldNomUsuario = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanelFuncao = new javax.swing.JPanel();
        jBtConectar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAjuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TelaLogin");
        setName("Gerenciador de dados"); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 550));

        jPanelPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder("Redoma - Tela de Login"));

        jBtCredito.setText("Créditos");
        jBtCredito.setPreferredSize(new java.awt.Dimension(100, 30));
        jBtCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtCreditoMousePressed(evt);
            }
        });

        jLsimblo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/download.jpg"))); // NOI18N

        jLNomeServidor.setText("Nome do Servidor: ");

        jLautenticacao.setText("Autenticação: ");

        jLnomUsuario.setText("Nome do Usuário:");

        jLsenha.setText("Senha:");

        jTextFieldNomServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomServidorActionPerformed(evt);
            }
        });
        jTextFieldNomServidor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldNomServidorPropertyChange(evt);
            }
        });

        jComboBoxAutenticar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Autenticação do SQL Server" }));

        jTextFieldNomUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomUsuarioActionPerformed(evt);
            }
        });

        jPasswordField1.setText("jPasswordField1");

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLsimblo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLNomeServidor, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLautenticacao, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(20, 20, 20)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxAutenticar, 0, 276, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNomServidor)))
                            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLnomUsuario)
                                    .addComponent(jLsenha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNomUsuario)
                                    .addComponent(jPasswordField1))))
                        .addContainerGap())))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLsimblo)
                    .addComponent(jBtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNomeServidor))
                .addGap(20, 20, 20)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLautenticacao)
                    .addComponent(jComboBoxAutenticar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLnomUsuario))
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLsenha))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );

        jPanelFuncao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBtConectar.setText("Conectar");
        jBtConectar.setPreferredSize(new java.awt.Dimension(100, 30));
        jBtConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConectarActionPerformed(evt);
            }
        });
        jPanelFuncao.add(jBtConectar);

        jBtSair.setText("Sair");
        jBtSair.setPreferredSize(new java.awt.Dimension(100, 30));
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });
        jPanelFuncao.add(jBtSair);

        jBtAjuda.setText("Ajuda");
        jBtAjuda.setPreferredSize(new java.awt.Dimension(100, 30));
        jBtAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAjudaActionPerformed(evt);
            }
        });
        jPanelFuncao.add(jBtAjuda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelFuncao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(jPanelFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConectarActionPerformed
   
      ConnectionFactory fabrica = new ConnectionFactory();
      con = fabrica.getConnection(jTextFieldNomServidor.getText(),jTextFieldNomUsuario.getText(), new String(jPasswordField1.getPassword())); 
        
      if (con!= null) {
             BasesDinamicas tdb = new BasesDinamicas(con);
            
             this.dispose();
         } 
    }//GEN-LAST:event_jBtConectarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja Sair Realmente ?");
        if ( con !=null){
            try {
                con.close();
            } catch (SQLException ex) {
                //erro ao fechar a conexão 
                Logger.getLogger(Tela_Login_Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (resposta == JOptionPane.YES_OPTION) {
            
            System.exit(0);
        }  
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAjudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAjudaActionPerformed

    private void jBtCreditoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtCreditoMousePressed
    }//GEN-LAST:event_jBtCreditoMousePressed

    private void jTextFieldNomServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomServidorActionPerformed

    }//GEN-LAST:event_jTextFieldNomServidorActionPerformed

    private void jTextFieldNomServidorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldNomServidorPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomServidorPropertyChange

    private void jTextFieldNomUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Login_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Login_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Login_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Login_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Login_Principal().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAjuda;
    private javax.swing.JButton jBtConectar;
    private javax.swing.JButton jBtCredito;
    private javax.swing.JButton jBtSair;
    private javax.swing.JComboBox<String> jComboBoxAutenticar;
    private javax.swing.JLabel jLNomeServidor;
    private javax.swing.JLabel jLautenticacao;
    private javax.swing.JLabel jLnomUsuario;
    private javax.swing.JLabel jLsenha;
    private javax.swing.JLabel jLsimblo;
    private javax.swing.JPanel jPanelFuncao;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldNomServidor;
    private javax.swing.JTextField jTextFieldNomUsuario;
    // End of variables declaration//GEN-END:variables
}
