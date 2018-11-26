/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoescolabmi;

import db.VeiculoDAO;
import model.Veiculo;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class ListagemVeiculo extends javax.swing.JInternalFrame {

    private AreaDeTrabalho a;
    private Veiculo veic;
    private int selected;
    private VeiculoDAO veicDAO;
    /**
     * Creates new form ListagemVeiculo
     */
    public ListagemVeiculo(AreaDeTrabalho a) {
        this.a = a;
        try{
            veicDAO = new VeiculoDAO();
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        try {
            veiculoDAO1 = new db.VeiculoDAO();
        } catch (java.lang.Exception e1) {
            e1.printStackTrace();
        }
        lstVeiculo = veiculoDAO1.listar();
        scpVeiculo = new javax.swing.JScrollPane();
        tbVeiculo = new javax.swing.JTable();
        btOk = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstVeiculo, tbVeiculo);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ano}"));
        columnBinding.setColumnName("Ano");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${marca}"));
        columnBinding.setColumnName("Marca");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${modelo}"));
        columnBinding.setColumnName("Modelo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cor}"));
        columnBinding.setColumnName("Cor");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${placa}"));
        columnBinding.setColumnName("Placa");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        tbVeiculo.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                tbVeiculoMouseWheelMoved(evt);
            }
        });
        scpVeiculo.setViewportView(tbVeiculo);

        btOk.setText("Novo");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(btExcluir)
                .addGap(18, 18, 18)
                .addComponent(btAlterar)
                .addGap(18, 18, 18)
                .addComponent(btOk)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpVeiculo)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scpVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOk)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        this.a.fecharListagemVeiculo();
    }//GEN-LAST:event_formInternalFrameClosing

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        a.abrirCadastroVeiculo();
    }//GEN-LAST:event_btOkActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        
        int selecteds[] = tbVeiculo.getSelectedRows();
        
        if (selecteds.length == 0)
            JOptionPane.showMessageDialog(this, "Nenhum veículo selecionado!");
        else{
                for (int i=0; i<selecteds.length; i++)
                {
                    selected = tbVeiculo.convertRowIndexToModel(selecteds[i]);
                    veicDAO.excluir(this.lstVeiculo.get(selected));
                }                
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed

        if(this.tbVeiculo.getSelectedRow() != -1){
            this.a.abrirCadastroVeiculo();
            this.a.getCadastroVeiculo().setVeiculo(this.lstVeiculo.get(this.tbVeiculo.getSelectedRow()));
            this.a.getCadastroVeiculo().preencheDados();
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum veículo selecionado!");
        } 
    }//GEN-LAST:event_btAlterarActionPerformed

    private void tbVeiculoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_tbVeiculoMouseWheelMoved
       lstVeiculo = veiculoDAO1.listar();    }//GEN-LAST:event_tbVeiculoMouseWheelMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btOk;
    private java.util.List<Veiculo> lstVeiculo;
    private javax.swing.JScrollPane scpVeiculo;
    private javax.swing.JTable tbVeiculo;
    private db.VeiculoDAO veiculoDAO1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
