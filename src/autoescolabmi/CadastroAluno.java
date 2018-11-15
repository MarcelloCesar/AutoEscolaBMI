/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoescolabmi;

import model.Aluno;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Gideon
 */
public class CadastroAluno extends javax.swing.JInternalFrame {
    
    private Aluno aluno;
    SimpleDateFormat date;
    AreaDeTrabalho areaPai;

    /**
     * Creates new form CadastroAluno
     */
    public CadastroAluno(AreaDeTrabalho a) {
        this.aluno   = new Aluno();
        this.date    = new SimpleDateFormat("dd/mm/yyyy");
        this.areaPai = a;
        
        initComponents();        
        
        abas.setEnabledAt(1, false);
        abas.setEnabledAt(0, true);
        this.btnAlterar.setVisible(false);
        this.cmbCategoria.setSelectedIndex(1);
        this.cmbCategoria.setSelectedIndex(0);
    }
    
    public void setAluno(Aluno a){    
        this.aluno = a;
    }       
    
    public void preencheDados(){
        txtBairro.setText(this.aluno.getBairro());
        this.cmbCategoria.setSelectedIndex(1);
        this.cmbCategoria.setSelectedIndex(this.aluno.getCategoria());
        txtCpf.setText(this.aluno.getCpf());
        txtDtNasc.setText(date.format(this.aluno.getDtNasc()));
        txtNome.setText(this.aluno.getNome());
        txtNomeMae.setText(this.aluno.getNomeMae());
        txtNomePai.setText(this.aluno.getNomePai());
        txtNumero.setText(this.aluno.getNumero());
        txtRg.setText(this.aluno.getRg());
        txtRua.setText(this.aluno.getRua());
        txtTelefone.setText(this.aluno.getTelefone());
        
        this.btnCategoriaCadastrar.setVisible(false);
        this.btnAlterar.setVisible(true);
    }
    
    private void alterarDescricaoCategoria() throws Exception{
        
        switch(cmbCategoria.getSelectedIndex()){
            case 0:
                this.alteraDescricaoCategoriaA();
                break;
                
            case 1:
                this.alteraDescricaoCategoriaB();
                break;
                
            case 2:
                this.alteraDescricaoCategoriaAB();
                break;
                
            case 3:
                this.alteraDescricaoCategoriaC();
                break;
                
            case 4:
                this.alterarDescricaoCategoriaD();
                break;
                
            case 5:
                this.alterarDescricaoCategoriaE();
                break;                
                
            default:
                throw new Exception("Categoria Inválida");
                
        }  
    }
        
    private void alteraDescricaoCategoriaA(){
        String descricaoCategoria = 
            "Condutor de veículo motorizado de duas ou três rodas, com ou sem carro lateral (motos).";
        
        String requisitosCategoria = 
            "";
        
        this.txtDescricaoCategoria.setText(descricaoCategoria);
        this.txtRequisitosCategoria.setText(requisitosCategoria);
        this.txtCategoria.setText("Categoria A (Motos)");
    }
    
    private void alteraDescricaoCategoriaB(){
        String descricaoCategoria = 
            "Condutor de veículo motorizado não abrangido pela categoria A, com peso bruto total inferior a 3.500 quilos e lotação máxima de oito lugares, além do motorista (automóveis).";
        
        String requisitosCategoria = 
            "";
        
        this.txtDescricaoCategoria.setText(descricaoCategoria);
        this.txtRequisitosCategoria.setText(requisitosCategoria);
        this.txtCategoria.setText("Categoria B (Carros)");
            
    }
    
    private void alteraDescricaoCategoriaAB(){
        String descricaoCategoria = 
            "Categoria A:\nCondutor de veículo motorizado de duas ou três rodas, com ou sem carro lateral (motos).\n"+
            "\nCategoria B\nCondutor de veículo motorizado não abrangido pela categoria A, com peso bruto total inferior a 3.500 quilos e lotação máxima de oito lugares, além do motorista (automóveis).\n";
        
        String requisitosCategoria = 
            "";
        
        this.txtDescricaoCategoria.setText(descricaoCategoria);
        this.txtRequisitosCategoria.setText(requisitosCategoria); 
        this.txtCategoria.setText("Categoria A/B (Carros e Motos)");
    }
    
    private void alteraDescricaoCategoriaC(){
        String descricaoCategoria = 
            "Condutor de veículo motorizado usado para transporte de carga, com peso bruto superior a 3.500 quilos (como caminhões).";
        
        String requisitosCategoria = 
            "Estar habilitado há pelo menos 1 ano na categoria B.\nNão ter cometido nenhuma infração grave ou gravíssima ou ser reincidente em infrações médias durante os últimos doze meses.";
        
        this.txtDescricaoCategoria.setText(descricaoCategoria);
        this.txtRequisitosCategoria.setText(requisitosCategoria);            
        this.txtCategoria.setText("Categoria C (Transporte de cargas)");
    }
    
    private void alterarDescricaoCategoriaD(){
        String descricaoCategoria = 
            "Condutor de veículo motorizado usado no transporte de passageiros, com lotação superior a oito lugares além do motorista (ônibus e vans, por exemplo).";
        
        String requisitosCategoria = 
            "Ser maior de 21 anos.\nEstar habilitado há pelo menos 1 ano na categoria C.\nNão ter cometido nenhuma infração grave ou gravíssima ou ser reincidente em infrações médias durante os últimos doze meses.";
        
        this.txtDescricaoCategoria.setText(descricaoCategoria);
        this.txtRequisitosCategoria.setText(requisitosCategoria); 
        this.txtCategoria.setText("Categoria D (Ônibus)");
    }
    
    private void alterarDescricaoCategoriaE(){
        String descricaoCategoria = 
            "Condutor de combinação de veículos em que a unidade conduzida se enquadre nas categorias B, C ou D e cuja unidade acoplada ou rebocada tenha peso bruto de 6 mil quilos ou mais; ou cuja lotação seja superior a oito lugares; ou, ainda, que seja enquadrado na categoria trailer.";
        
        String requisitosCategoria = 
            "Ser maior de 21 anos.\nEstar habilitado há pelo menos 1 ano na categoria C.\nNão ter cometido nenhuma infração grave ou gravíssima ou ser reincidente em infrações médias durante os últimos doze meses.";
        
        this.txtDescricaoCategoria.setText(descricaoCategoria);
        this.txtRequisitosCategoria.setText(requisitosCategoria);  
        this.txtCategoria.setText("Categoria E (Caminhões)");
    }
    
    private void avancarDadosPessoais() throws Exception{
        this.validaDadosPessoais();        
        
        this.abas.setEnabledAt(1, true);
        this.abas.setSelectedIndex(1);
        this.abas.setEnabledAt(0, false);        
    }
    
    private void validaDadosPessoais() throws Exception{     
        
        if(txtNome.getText().equals(""))
            throw new Exception("Campo nome não pode estar vazio"); 
        
        if(txtNome.getText().matches(".*[^a-zA-Z ].*"))
            throw new Exception("Caracteres inválidos no nome");        

        if(txtCpf.getText().equals(""))
            throw new Exception("Campo cpf não pode estar vazio");
        
        if(txtRg.getText().equals(""))
            throw new Exception("Campo rg não pode estar vazio");
        
        if(txtDtNasc.getText().equals(""))
            throw new Exception("Campo data de nascimento não pode estar vazio"); 
        
        try{
            if(((new Date().getTime() - date.parse(txtDtNasc.getText()).getTime())/1000/60/60/24/365) < 18){
                throw new Exception("Aluno não possui 18 anos completos.");
            }
        }catch (ParseException ex){
            throw new Exception ("Data de nascimento inválida");
        }
    }
    
    private void finalizarCadastro() throws Exception{
        this.aluno.setNome(txtNome.getText());
        this.aluno.setCpf(txtCpf.getText());
        this.aluno.setRg(txtRg.getText());
        this.aluno.setDtNasc(date.parse(txtDtNasc.getText()));
        this.aluno.setTelefone(txtTelefone.getText());
        this.aluno.setNomeMae(txtNomeMae.getText());
        this.aluno.setNomePai(txtNomePai.getText());
        this.aluno.setRua(txtRua.getText());
        this.aluno.setBairro(txtBairro.getText());
        this.aluno.setNumero(txtNumero.getText());
        this.aluno.setNumero(txtNumero.getText());
        this.aluno.setCategoria(this.cmbCategoria.getSelectedIndex());
        this.aluno.setDescCategoria(this.cmbCategoria.getSelectedItem().toString());
        
        AutoEscolaBmi.getBaseDados().addAluno(this.aluno);        
        JOptionPane.showMessageDialog(this,"Dados inseridos com sucesso!");
        
        dispose();
        this.areaPai.fecharCadastroAluno();
    }
    
    private void alterarCadastro() throws Exception{
        this.aluno.setNome(txtNome.getText());
        this.aluno.setCpf(txtCpf.getText());
        this.aluno.setRg(txtRg.getText());
        this.aluno.setDtNasc(date.parse(txtDtNasc.getText()));
        this.aluno.setTelefone(txtTelefone.getText());
        this.aluno.setNomeMae(txtNomeMae.getText());
        this.aluno.setNomePai(txtNomePai.getText());
        this.aluno.setRua(txtRua.getText());
        this.aluno.setBairro(txtBairro.getText());
        this.aluno.setNumero(txtNumero.getText());
        this.aluno.setCategoria(this.cmbCategoria.getSelectedIndex());
        this.aluno.setDescCategoria(this.cmbCategoria.getSelectedItem().toString());
        
        JOptionPane.showMessageDialog(this,"Dados alterados com sucesso!");
        
        dispose();
        this.areaPai.fecharCadastroAluno();
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abas = new javax.swing.JTabbedPane();
        abaDadosPessoais = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDtNasc = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNomeMae = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNomePai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        txtRua = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnDadosPessoaisAvancar = new javax.swing.JToggleButton();
        abaCategoria = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        txtCategoria = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricaoCategoria = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRequisitosCategoria = new javax.swing.JTextArea();
        btnAlterar = new javax.swing.JButton();
        btnCategoriaCadastrar = new javax.swing.JButton();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
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

        abas.setFocusable(false);
        abas.setRequestFocusEnabled(false);

        abaDadosPessoais.setEnabled(false);
        abaDadosPessoais.setFocusable(false);
        abaDadosPessoais.setRequestFocusEnabled(false);

        jLabel1.setText("* Nome:");

        jLabel2.setText("* Data de Nascimento:");

        jLabel3.setText("* CPF:");

        jLabel4.setText("* RG:");

        jLabel5.setText("Nome do pai ou responsável:");

        jLabel6.setText("Nome da mãe ou responsável:");

        jLabel7.setText("Rua:");

        jLabel8.setText("Telefone:");

        jLabel9.setText("Bairro:");

        jLabel10.setText("Numero:");

        btnDadosPessoaisAvancar.setText("Avançar");
        btnDadosPessoaisAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadosPessoaisAvancarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout abaDadosPessoaisLayout = new javax.swing.GroupLayout(abaDadosPessoais);
        abaDadosPessoais.setLayout(abaDadosPessoaisLayout);
        abaDadosPessoaisLayout.setHorizontalGroup(
            abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 62, Short.MAX_VALUE))
                            .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(txtNumero)
                                .addContainerGap())))
                    .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(txtDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtTelefone)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(txtNome)
                            .addComponent(txtNomeMae, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNomePai))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDadosPessoaisAvancar)
                .addContainerGap())
        );
        abaDadosPessoaisLayout.setVerticalGroup(
            abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDadosPessoaisAvancar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        abas.addTab("Dados Pessoais", abaDadosPessoais);

        abaCategoria.setEnabled(false);
        abaCategoria.setRequestFocusEnabled(false);

        jLabel11.setText("Categoria:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "A/B", "C", "D", "E" }));
        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        txtCategoria.setEditable(false);

        jLabel12.setText("Descrição:");

        txtDescricaoCategoria.setEditable(false);
        txtDescricaoCategoria.setColumns(20);
        txtDescricaoCategoria.setRows(5);
        txtDescricaoCategoria.setWrapStyleWord(true);
        txtDescricaoCategoria.setAutoscrolls(false);
        jScrollPane1.setViewportView(txtDescricaoCategoria);

        jLabel13.setText("Requisitos:");

        txtRequisitosCategoria.setEditable(false);
        txtRequisitosCategoria.setColumns(20);
        txtRequisitosCategoria.setRows(5);
        txtRequisitosCategoria.setAutoscrolls(false);
        jScrollPane2.setViewportView(txtRequisitosCategoria);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnCategoriaCadastrar.setText("Cadastrar");
        btnCategoriaCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout abaCategoriaLayout = new javax.swing.GroupLayout(abaCategoria);
        abaCategoria.setLayout(abaCategoriaLayout);
        abaCategoriaLayout.setHorizontalGroup(
            abaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(abaCategoriaLayout.createSequentialGroup()
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCategoria))
                    .addGroup(abaCategoriaLayout.createSequentialGroup()
                        .addGroup(abaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaCategoriaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(abaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCategoriaCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        abaCategoriaLayout.setVerticalGroup(
            abaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCategoriaCadastrar)
                .addContainerGap())
        );

        abas.addTab("Categoria", abaCategoria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abas, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDadosPessoaisAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadosPessoaisAvancarActionPerformed
        try{
            this.avancarDadosPessoais();            
        } catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());  
        }
    }//GEN-LAST:event_btnDadosPessoaisAvancarActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        try{
            this.alterarDescricaoCategoria();
        }catch(Exception e){      
            JOptionPane.showMessageDialog(this,e.getMessage());            
        }
                
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void btnCategoriaCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaCadastrarActionPerformed
        try{
            this.finalizarCadastro();         
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage()); 
        }
    }//GEN-LAST:event_btnCategoriaCadastrarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        this.areaPai.fecharCadastroAluno();
    }//GEN-LAST:event_formInternalFrameClosed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try{
            this.alterarCadastro();                
        } catch (Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage()); 
        }
    }//GEN-LAST:event_btnAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abaCategoria;
    private javax.swing.JPanel abaDadosPessoais;
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCategoriaCadastrar;
    private javax.swing.JToggleButton btnDadosPessoaisAvancar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextArea txtDescricaoCategoria;
    private javax.swing.JTextField txtDtNasc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeMae;
    private javax.swing.JTextField txtNomePai;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextArea txtRequisitosCategoria;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
