/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoescolabmi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class CadastroVeiculo extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastroVeiculo
     */
    private Veiculo veiculo;
    private SimpleDateFormat date;
    private Date dataCad;
    private AreaDeTrabalho a;
    private boolean ok = true;
    private int pos;
    
    public CadastroVeiculo(AreaDeTrabalho at) {
        this.a = at;
        date = new SimpleDateFormat("dd/MM/yyyy");
        initComponents();
        CadastroVeiculo.setEnabledAt(1, false);
        CadastroVeiculo.setEnabledAt(0, true);       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CadastroVeiculo = new javax.swing.JTabbedPane();
        DadosVeiculo = new javax.swing.JPanel();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        lblAno = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        lblPlaca = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        lblCor = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        lblEspecie = new javax.swing.JLabel();
        txtEspecie = new javax.swing.JTextField();
        lblNumeracao = new javax.swing.JLabel();
        txtNumeracao = new javax.swing.JTextField();
        btAvancar = new javax.swing.JButton();
        btGerarNum = new javax.swing.JButton();
        lblNumeroDoc = new javax.swing.JLabel();
        txtNumeroDoc = new javax.swing.JTextField();
        Historico = new javax.swing.JPanel();
        lblDataCad = new javax.swing.JLabel();
        txtDataCad = new javax.swing.JTextField();
        lblDataAquisicao = new javax.swing.JLabel();
        txtDataAquisicao = new javax.swing.JTextField();
        lblHistorico = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHistorico = new javax.swing.JTextArea();
        btConfirmar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Veículo");
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

        lblMarca.setText("* Marca");

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        lblModelo.setText("* Modelo");

        lblAno.setText("* Ano");

        lblPlaca.setText("* Placa");

        lblCor.setText("* Cor");

        lblEspecie.setText(" Espécie");

        lblNumeracao.setText("* Numeração");

        txtNumeracao.setEditable(false);
        txtNumeracao.setOpaque(false);

        btAvancar.setText("Avançar");
        btAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAvancarActionPerformed(evt);
            }
        });

        btGerarNum.setText("Gerar Numeração");
        btGerarNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarNumActionPerformed(evt);
            }
        });

        lblNumeroDoc.setText("* Número do Documento");

        javax.swing.GroupLayout DadosVeiculoLayout = new javax.swing.GroupLayout(DadosVeiculo);
        DadosVeiculo.setLayout(DadosVeiculoLayout);
        DadosVeiculoLayout.setHorizontalGroup(
            DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DadosVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DadosVeiculoLayout.createSequentialGroup()
                        .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DadosVeiculoLayout.createSequentialGroup()
                        .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DadosVeiculoLayout.createSequentialGroup()
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblNumeracao, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeracao, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroDoc)
                            .addComponent(lblNumeroDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DadosVeiculoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btGerarNum)
                .addGap(18, 18, 18)
                .addComponent(btAvancar)
                .addContainerGap())
        );
        DadosVeiculoLayout.setVerticalGroup(
            DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DadosVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeracao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(DadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAvancar)
                    .addComponent(btGerarNum))
                .addGap(26, 26, 26))
        );

        CadastroVeiculo.addTab("Dados Do Veículo", DadosVeiculo);

        lblDataCad.setText("Data do cadastro");

        txtDataCad.setEditable(false);

        lblDataAquisicao.setText("Data de aquisição");

        lblHistorico.setText("Histórico");

        txtHistorico.setColumns(20);
        txtHistorico.setRows(5);
        jScrollPane1.setViewportView(txtHistorico);

        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HistoricoLayout = new javax.swing.GroupLayout(Historico);
        Historico.setLayout(HistoricoLayout);
        HistoricoLayout.setHorizontalGroup(
            HistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HistoricoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(HistoricoLayout.createSequentialGroup()
                        .addGroup(HistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDataCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(HistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDataAquisicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(179, 179, 179))
                    .addGroup(HistoricoLayout.createSequentialGroup()
                        .addComponent(lblHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HistoricoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btConfirmar)))
                .addContainerGap())
        );
        HistoricoLayout.setVerticalGroup(
            HistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HistoricoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataAquisicao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblHistorico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btConfirmar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        CadastroVeiculo.addTab("Histórico", Historico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CadastroVeiculo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CadastroVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed

    }//GEN-LAST:event_txtMarcaActionPerformed

    

    private void btGerarNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarNumActionPerformed
        //Futuramente sera tratado como PK do Banco
        Random Gerador = new Random();
        String num = "";
        for (int i=0; i<=13; i++){
            num += Integer.toString(Gerador.nextInt(10));
        }
        txtNumeracao.setText(num);
        btGerarNum.setEnabled(false);
    }//GEN-LAST:event_btGerarNumActionPerformed

    private void btAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAvancarActionPerformed
        try{
            this.AvancarDadosVeiculos();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btAvancarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        a.fecharCadastroVeiculo();
    }//GEN-LAST:event_formInternalFrameClosing

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
             try{
                 this.FinalizaCadastro();
                }catch(ParseException e){
                    JOptionPane.showMessageDialog(this,"Data Inválida!!");
                }    
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void AvancarDadosVeiculos() throws Exception{
        this.ValidaDadosVeiculo();
        if(ok){
                dataCad = new Date();
                txtDataCad.setText(date.format(dataCad));
                }
        this.CadastroVeiculo.setEnabledAt(1,true);
        this.CadastroVeiculo.setSelectedIndex(1);
        this.CadastroVeiculo.setEnabledAt(0,false);
    }
    
    private void FinalizaCadastro() throws ParseException{
        veiculo = new Veiculo();
        veiculo.setAno(txtAno.getText());
        veiculo.setNrDocumento(txtNumeroDoc.getText());
        veiculo.setMarca(txtMarca.getText());
        veiculo.setModelo(txtModelo.getText());
        veiculo.setPlaca(txtPlaca.getText());
        veiculo.setCor(txtCor.getText());
        veiculo.setEspecie(txtEspecie.getText());
        veiculo.setNumeracao(txtNumeracao.getText());
        veiculo.setDataAquisicao(date.parse(txtDataAquisicao.getText()));
        veiculo.setDataCadastro(date.parse(txtDataCad.getText()));
        veiculo.setHistorico(txtHistorico.getText());
        
        if(ok)
            AutoEscolaBmi.getBaseDados().addVeiculo(veiculo);
        else
            AutoEscolaBmi.getBaseDados().getListaVeiculos().set(pos,veiculo);
      
        JOptionPane.showMessageDialog(this,"Dados inseridos com sucesso!");
        
        a.fecharCadastroVeiculo();
        this.dispose();
    }
    
    
    private void ValidaDadosVeiculo() throws Exception{
       if(txtMarca.getText().equals(""))
           throw new Exception("Campo Marca deve ser preenchido!");
       
       if(txtModelo.getText().equals(""))
           throw new Exception("Campo Modelo deve ser preenchido!");
       
       if(txtAno.getText().equals("") || txtAno.getText().length()!=4)
           throw new Exception("Ano deve possuir 4 digitos!");
       
       if(txtPlaca.getText().equals("") || txtPlaca.getText().length()!=7)
           throw new Exception("Placa deve possuir 7 Caracteres!");
       
       if(txtCor.getText().equals(""))
           throw new Exception("Campo Cor deve ser preenchido!");
       
       if(txtNumeracao.getText().equals(""))
           throw new Exception("Numeracao nao gerada!");
       
       if(txtNumeroDoc.getText().equals(""))
           throw new Exception("Documento deve ser preenchido!");

    }
    

    public void setVeiculo(Veiculo v){
        this.veiculo = v;
    }

    public void preencheDados(int p){
        ok = false;
        this.pos = p;
        btGerarNum.setEnabled(false);
        txtAno.setText(veiculo.getAno());
        txtCor.setText(veiculo.getCor());
        txtDataAquisicao.setText(date.format(veiculo.getDataAquisicao()));
        txtDataCad.setText(date.format(veiculo.getDataCadastro()));
        txtEspecie.setText(veiculo.getEspecie());
        txtHistorico.setText(veiculo.getHistorico());
        txtMarca.setText(veiculo.getMarca());
        txtModelo.setText(veiculo.getModelo());
        txtNumeracao.setText(veiculo.getNumeracao());
        txtNumeroDoc.setText(veiculo.getNrDocumento());
        txtPlaca.setText(veiculo.getPlaca());

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane CadastroVeiculo;
    private javax.swing.JPanel DadosVeiculo;
    private javax.swing.JPanel Historico;
    private javax.swing.JButton btAvancar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btGerarNum;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblDataAquisicao;
    private javax.swing.JLabel lblDataCad;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblHistorico;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNumeracao;
    private javax.swing.JLabel lblNumeroDoc;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtDataAquisicao;
    private javax.swing.JTextField txtDataCad;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextArea txtHistorico;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumeracao;
    private javax.swing.JTextField txtNumeroDoc;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
