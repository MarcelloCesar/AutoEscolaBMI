/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoescolabmi;

import db.AlunoDAO;
import db.EmailDAO;
import db.PessoaDAO;
import db.ResponsavelDAO;
import db.TelefoneDAO;
import model.Aluno;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Email;
import model.Pessoa;
import model.Responsavel;
import model.Telefone;

/**
 *
 * @author Gideon
 */
public class CadastroAluno extends javax.swing.JInternalFrame {
    
    private Aluno matricula;
    private List<Responsavel> responsaveis;
    private List<Telefone> telefones;
    private List<Email> emails;
    
    SimpleDateFormat dateFormat;
    AreaDeTrabalho areaPai;

    /**
     * Creates new form CadastroAluno
     */
    public CadastroAluno(AreaDeTrabalho a) {
        this.matricula    = new Aluno();
        this.responsaveis = new LinkedList<>();
        this.telefones = new LinkedList<>();
        this.emails = new LinkedList<>();
        
        
        
        this.dateFormat   = new SimpleDateFormat("dd/MM/yyyy");
        this.areaPai = a;
        
        initComponents();        
        
        abas.setEnabledAt(1, false);
        abas.setEnabledAt(0, true);
        cmbCategoria.setSelectedItem("B");
        cmbCategoria.setSelectedItem("A");
    }
    
    public void setAluno(Aluno a){    
        
    }       
    
    public void preencheDados(String cod){
        try{
            this.matricula = new AlunoDAO().encontrarMatricula(cod);
            txtCodMatricula.setText(String.valueOf(matricula.getCodMatricula()));
            txtDataMatricula.setText(matricula.getDataMatricula() == null ? " " : dateFormat.format(matricula.getDataMatricula()));            
            preencheDadosPessoa();
            cmbCategoria.setSelectedItem(matricula.getCodCategoria());
            /*txtCpf.setText(matricula.getCpf());
            txtRg.setText(matricula.getRg());
            txtNome.setText(matricula.)*/
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Erro ao carregar aluno: " +  e.getMessage());
        }
        
        
    }
    
    private void alterarDescricaoCategoria() throws Exception{
        
        switch(cmbCategoria.getSelectedIndex()){
            case 0:
                this.matricula.setCodCategoria("A");
                this.alteraDescricaoCategoriaA();
                break;
                
            case 1:
                this.matricula.setCodCategoria("B");
                this.alteraDescricaoCategoriaB();
                break;
                
            case 2:
                this.matricula.setCodCategoria("A/B");
                this.alteraDescricaoCategoriaAB();
                break;
                
            case 3:
                this.matricula.setCodCategoria("C");
                this.alteraDescricaoCategoriaC();
                break;
                
            case 4:
                this.matricula.setCodCategoria("D");
                this.alterarDescricaoCategoriaD();
                break;
                
            case 5:
                this.matricula.setCodCategoria("E");
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
            if(((new Date().getTime() - dateFormat.parse(txtDtNasc.getText()).getTime())/1000/60/60/24/365) < 18){
                throw new Exception("Aluno não possui 18 anos completos.");
            }
        }catch (ParseException ex){
            throw new Exception ("Data de nascimento inválida");
        }
    }
    
    private void finalizarCadastro() throws Exception{
        
        PessoaDAO pessoaDAO     = new PessoaDAO();
        AlunoDAO alunoDAO       = new AlunoDAO();
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        EmailDAO    emailDAO    = new EmailDAO();
        ResponsavelDAO respDAO  = new ResponsavelDAO();
        
        try{
            
            //Caso nao tenha id é uma inclusao      
            this.matricula.setEndereco(txtBairro.getText() + " " + 
                                       txtRua.getText() + " " + 
                                       txtNumero.getText());
            
            if(this.matricula.getIdAtor() == null){
                this.matricula.setDataInclusao(new Date());
                pessoaDAO.inserir(this.matricula);
            } else {
                pessoaDAO.alterar(this.matricula);
            }
            
            //Inclusao de matricula
            if(this.matricula.getCodMatricula() == null){
                matricula.setCodMatricula(txtCodMatricula.getText());
                alunoDAO.inserir(matricula);
            } else {
                alunoDAO.alterar(matricula);
            }
            
            telefoneDAO.desativarTelefones(this.matricula.getIdAtor());
            for (Telefone telefone : telefones){
                if(telefone.getIdAtor() == null){
                    telefone.setIdAtor(this.matricula.getIdAtor());
                    telefone.setPrioridade(telefoneDAO.buscaUltimaPrioridade());
                    telefoneDAO.inserir(telefone);
                } else {
                    telefoneDAO.alterar(telefone);
                }
            }  
            
            emailDAO.desativarEmail(this.matricula.getIdAtor());
            for (Email e : emails){
                if(e.getIdAtor() == null){
                    e.setIdAtor(this.matricula.getIdAtor());
                    e.setPrioridade(emailDAO.buscaUltimaPrioridade());
                    emailDAO.inserir(e);
                } else {
                    emailDAO.alterar(e);
                }
            }
            
            respDAO.desativarResp(this.matricula.getIdAtor());
            for (Responsavel r : responsaveis){
                if(r.getIdAtor() == null){
                    r.setIdAtor(this.matricula.getIdAtor());
                    r.setPrioridade(respDAO.buscaUltimaPrioridade());
                    respDAO.inserir(r);
                } else {
                    respDAO.alterar(r);
                }
            }   
            
            JOptionPane.showMessageDialog(this,"Dados inseridos com sucesso!");        
            dispose();
            this.areaPai.fecharCadastroAluno();
        } catch (Exception e){
            matricula.setCodMatricula(null);
            this.matricula.setIdAtor(null);
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
        
    private void limparCampos(){
        this.matricula = new Aluno();
        this.responsaveis = new LinkedList<>();
        this.telefones = new LinkedList<>();
        this.emails = new LinkedList<>();
        
        txtCodMatricula.setText("");
        txtDataMatricula.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        txtNome.setText("");
        txtDtNasc.setText("");
        cmbTelefone.removeAllItems();
        cmbTelefone.addItem("");
        cmbResponsavel.removeAllItems();
        cmbResponsavel.addItem("");
        cmbEmail.removeAllItems();
        cmbEmail.addItem("");
        txtRua.setText("");
        txtBairro.setText("");
        txtNumero.setText("");
        cmbCategoria.setSelectedItem("B");
        cmbCategoria.setSelectedItem("A");
        btnCategoriaCadastrar.setVisible(true);
    }
    
    private void novaMatricula(){
        txtDataMatricula.setText(dateFormat.format(new Date()));
        try{            
            int codMatricula = new AlunoDAO().buscaUltimaMatricula();
            txtCodMatricula.setText(String.valueOf(codMatricula));
                        
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            this.limparCampos();
        }
    }
    
    private void buscaPessoaExistente(){
        try{
            Pessoa pessoa = new PessoaDAO().findByCpf(txtCpf.getText());
            if(pessoa != null){
                this.matricula = new Aluno(pessoa);
                this.preencheDadosPessoa();
            }            
        } catch (Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }      
    
    private void preencheDadosPessoa(){
        Pessoa p = this.matricula;
        txtCpf.setText(p.getCpf());
        txtNome.setText(p.getNome());
        txtRg.setText(p.getRg());   
        txtDtNasc.setText(dateFormat.format(p.getDataNascimento()));
        
        cmbCategoria.setSelectedItem("B");
        cmbCategoria.setSelectedItem("A");
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnDadosPessoaisAvancar = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCodMatricula = new javax.swing.JTextField();
        txtDataMatricula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnAddTelefone = new javax.swing.JButton();
        btnAddEmail = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnAddResponsavel = new javax.swing.JButton();
        cmbTelefone = new javax.swing.JComboBox<>();
        cmbEmail = new javax.swing.JComboBox<>();
        cmbResponsavel = new javax.swing.JComboBox<>();
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

        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeFocusLost(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });

        jLabel2.setText("* Data de Nascimento:");

        txtDtNasc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDtNascFocusLost(evt);
            }
        });

        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfFocusLost(evt);
            }
        });

        jLabel3.setText("* CPF:");

        jLabel4.setText("* RG:");

        txtRg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRgFocusLost(evt);
            }
        });

        jLabel5.setText("Nome do responsável:");

        jLabel7.setText("Rua:");

        jLabel8.setText("Telefone:");

        jLabel9.setText("Bairro:");

        jLabel10.setText("Número:");

        btnDadosPessoaisAvancar.setText("Avançar");
        btnDadosPessoaisAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadosPessoaisAvancarActionPerformed(evt);
            }
        });

        jLabel6.setText("* Código da Matrícula");

        jLabel14.setText("* Data da matrícula");

        txtCodMatricula.setEditable(false);

        txtDataMatricula.setEditable(false);

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAddTelefone.setText("+");
        btnAddTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTelefoneActionPerformed(evt);
            }
        });

        btnAddEmail.setText("+");
        btnAddEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmailActionPerformed(evt);
            }
        });

        jLabel15.setText("Email:");

        btnAddResponsavel.setText("+");
        btnAddResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddResponsavelActionPerformed(evt);
            }
        });

        cmbTelefone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cmbTelefone.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTelefoneItemStateChanged(evt);
            }
        });
        cmbTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTelefoneActionPerformed(evt);
            }
        });

        cmbEmail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbEmail.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmailItemStateChanged(evt);
            }
        });
        cmbEmail.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cmbEmailInputMethodTextChanged(evt);
            }
        });
        cmbEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmailActionPerformed(evt);
            }
        });

        cmbResponsavel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbResponsavel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbResponsavelItemStateChanged(evt);
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
                                .addGap(0, 63, Short.MAX_VALUE))
                            .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(txtNumero)
                                .addContainerGap())))
                    .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCodMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(txtDataMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                        .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4)
                                            .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtRg, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                                .addComponent(jLabel8))))
                                    .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                        .addComponent(txtDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbTelefone, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddTelefone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                                .addComponent(cmbEmail, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAddEmail))))))
                            .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaDadosPessoaisLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnDadosPessoaisAvancar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(cmbResponsavel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddResponsavel)))
                        .addContainerGap())))
        );
        abaDadosPessoaisLayout.setVerticalGroup(
            abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDadosPessoaisLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(12, 12, 12)
                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddTelefone)
                    .addComponent(btnAddEmail)
                    .addComponent(cmbTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddResponsavel)
                    .addComponent(cmbResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(18, Short.MAX_VALUE))
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

        btnCategoriaCadastrar.setText("Salvar");
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
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
                        .addComponent(btnCategoriaCadastrar)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
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

    private void btnDadosPessoaisAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadosPessoaisAvancarActionPerformed
        try{
            this.avancarDadosPessoais();
        } catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btnDadosPessoaisAvancarActionPerformed

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped

    }//GEN-LAST:event_txtNomeKeyTyped

    private void cmbTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTelefoneActionPerformed

    private void cmbEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEmailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.limparCampos();        
        this.novaMatricula();       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusLost
        this.buscaPessoaExistente();
        this.matricula.setCpf(txtCpf.getText());
    }//GEN-LAST:event_txtCpfFocusLost

    private void btnAddTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTelefoneActionPerformed
        if(btnAddTelefone.getText().equals("+")){
            String tel = JOptionPane.showInputDialog("Novo Telefone: ");        
            if(tel != null){
                                
                try{
                    Telefone telefone = new Telefone();
                    telefone.setNumero(tel);                    
                    telefone.setAtivo("T");

                    telefones.add(telefone);
                    cmbTelefone.addItem(tel);
                    cmbTelefone.setSelectedItem(tel);
                } catch (Exception e){
                    JOptionPane.showMessageDialog(this, "Não foi possível adicionar o telefone corretamente: " + e.getMessage());
                }
            }
        } else {
            cmbTelefone.removeItem(cmbTelefone.getSelectedItem());
        }
    }//GEN-LAST:event_btnAddTelefoneActionPerformed

    private void btnAddEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmailActionPerformed
        if(btnAddEmail.getText().equals("+")){
            String email = JOptionPane.showInputDialog("Novo Email: ");
            if(email != null){
                Email e = new Email();
                e.setEmail(email);
                e.setAtivo("T");
                
                emails.add(e);
                cmbEmail.addItem(email);
                cmbEmail.setSelectedItem(email);
            }
        } else {
             cmbEmail.removeItem(cmbEmail.getSelectedItem());
        }
    }//GEN-LAST:event_btnAddEmailActionPerformed

    private void btnAddResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddResponsavelActionPerformed
        if(btnAddResponsavel.getText().equals("+")){
            boolean encontrado = false;            
            String resp = "123";
            
            while(!encontrado){
                resp = JOptionPane.showInputDialog("CPF Responsável: ");
                if(resp != null){
                    try{
                        Responsavel responsavel = new Responsavel(new PessoaDAO().findByCpf(resp));
                        responsavel.setAtivo("T");
                        //nullpointerexception se nao encontrou                    
                        resp = responsavel.getResponsavel().getNome();                   
                        this.responsaveis.add(responsavel); 
                        
                        encontrado = true;
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(this, "CPF não encontrado");
                        encontrado = false;
                    }                
                } else {
                    //botao cancelar
                    encontrado = true;
                }
            }                
                
            if(resp != null){
                cmbResponsavel.addItem(resp);
                cmbResponsavel.setSelectedItem(resp);
            }
        } else {
             cmbResponsavel.removeItem(cmbResponsavel.getSelectedItem());
        }
    }//GEN-LAST:event_btnAddResponsavelActionPerformed

    private void cmbTelefoneItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTelefoneItemStateChanged
        if(evt.getStateChange() == 1){
            if(cmbTelefone.getSelectedIndex() != 0){
                btnAddTelefone.setText("-");
            } else {
                btnAddTelefone.setText("+");
            }
        }
    }//GEN-LAST:event_cmbTelefoneItemStateChanged

    private void cmbEmailInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmbEmailInputMethodTextChanged
        
    }//GEN-LAST:event_cmbEmailInputMethodTextChanged

    private void cmbEmailItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmailItemStateChanged
        if(evt.getStateChange() == 1){
            if(cmbEmail.getSelectedIndex() != 0){
                btnAddEmail.setText("-");
            } else {
                btnAddEmail.setText("+");
            }
        }
    }//GEN-LAST:event_cmbEmailItemStateChanged

    private void cmbResponsavelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbResponsavelItemStateChanged
        if(evt.getStateChange() == 1){
            if(cmbResponsavel.getSelectedIndex() != 0){
                btnAddResponsavel.setText("-");
            } else {
                btnAddResponsavel.setText("+");
            }
        }
    }//GEN-LAST:event_cmbResponsavelItemStateChanged

    private void txtRgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRgFocusLost
        this.matricula.setRg(txtRg.getText());
    }//GEN-LAST:event_txtRgFocusLost

    private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost
        this.matricula.setNome(txtNome.getText());
    }//GEN-LAST:event_txtNomeFocusLost

    private void txtDtNascFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDtNascFocusLost
        try{
            this.matricula.setDataNascimento(dateFormat.parse(txtDtNasc.getText()));
        } catch (ParseException e){
            JOptionPane.showMessageDialog(this, "Data inválida");
        }                    
    }//GEN-LAST:event_txtDtNascFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abaCategoria;
    private javax.swing.JPanel abaDadosPessoais;
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton btnAddEmail;
    private javax.swing.JButton btnAddResponsavel;
    private javax.swing.JButton btnAddTelefone;
    private javax.swing.JButton btnCategoriaCadastrar;
    private javax.swing.JToggleButton btnDadosPessoaisAvancar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEmail;
    private javax.swing.JComboBox<String> cmbResponsavel;
    private javax.swing.JComboBox<String> cmbTelefone;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JTextField txtCodMatricula;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDataMatricula;
    private javax.swing.JTextArea txtDescricaoCategoria;
    private javax.swing.JTextField txtDtNasc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextArea txtRequisitosCategoria;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables
}
