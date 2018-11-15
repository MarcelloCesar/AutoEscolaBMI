/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoescolabmi;

/**
 *
 * @author Gideon
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
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

        areaDeTrabalho = new autoescolabmi.AreaDeTrabalho();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCadastro = new javax.swing.JMenu();
        mniCadAluno = new javax.swing.JMenuItem();
        mniCadVeiculo = new javax.swing.JMenuItem();
        mniCadInstrutor = new javax.swing.JMenuItem();
        mnuListagem = new javax.swing.JMenu();
        mniListAluno = new javax.swing.JMenuItem();
        mniListVeiculo = new javax.swing.JMenuItem();
        mniListInstrutor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Auto Escola Dirigir");
        setResizable(false);
        getContentPane().add(areaDeTrabalho, java.awt.BorderLayout.CENTER);

        mnuCadastro.setText("Cadastro");

        mniCadAluno.setText("Cadastro de Alunos");
        mniCadAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadAlunoActionPerformed(evt);
            }
        });
        mnuCadastro.add(mniCadAluno);

        mniCadVeiculo.setText("Cadastro de Veículos");
        mniCadVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadVeiculoActionPerformed(evt);
            }
        });
        mnuCadastro.add(mniCadVeiculo);

        mniCadInstrutor.setText("Cadastro de Instrutores");
        mniCadInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadInstrutorActionPerformed(evt);
            }
        });
        mnuCadastro.add(mniCadInstrutor);

        jMenuBar1.add(mnuCadastro);

        mnuListagem.setText("Listagem");

        mniListAluno.setText("Listagem de Alunos");
        mniListAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniListAlunoActionPerformed(evt);
            }
        });
        mnuListagem.add(mniListAluno);

        mniListVeiculo.setText("Listagem de Veículos");
        mniListVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniListVeiculoActionPerformed(evt);
            }
        });
        mnuListagem.add(mniListVeiculo);

        mniListInstrutor.setText("Listagem de Instrutores");
        mniListInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniListInstrutorActionPerformed(evt);
            }
        });
        mnuListagem.add(mniListInstrutor);

        jMenuBar1.add(mnuListagem);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1193, 634));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mniCadAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadAlunoActionPerformed
        this.areaDeTrabalho.abrirCadastroAluno();
    }//GEN-LAST:event_mniCadAlunoActionPerformed

    private void mniCadVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadVeiculoActionPerformed
        this.areaDeTrabalho.abrirCadastroVeiculo();
    }//GEN-LAST:event_mniCadVeiculoActionPerformed

    private void mniCadInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadInstrutorActionPerformed
        areaDeTrabalho.abrirCadastroInstrutor();
    }//GEN-LAST:event_mniCadInstrutorActionPerformed

    private void mniListAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniListAlunoActionPerformed
         this.areaDeTrabalho.abrirListagemAluno();
    }//GEN-LAST:event_mniListAlunoActionPerformed

    private void mniListVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniListVeiculoActionPerformed
        this.areaDeTrabalho.abrirListagemVeiculo();
    }//GEN-LAST:event_mniListVeiculoActionPerformed

    private void mniListInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniListInstrutorActionPerformed
        this.areaDeTrabalho.abrirListagemInstrutor();
    }//GEN-LAST:event_mniListInstrutorActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private autoescolabmi.AreaDeTrabalho areaDeTrabalho;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mniCadAluno;
    private javax.swing.JMenuItem mniCadInstrutor;
    private javax.swing.JMenuItem mniCadVeiculo;
    private javax.swing.JMenuItem mniListAluno;
    private javax.swing.JMenuItem mniListInstrutor;
    private javax.swing.JMenuItem mniListVeiculo;
    private javax.swing.JMenu mnuCadastro;
    private javax.swing.JMenu mnuListagem;
    // End of variables declaration//GEN-END:variables
}