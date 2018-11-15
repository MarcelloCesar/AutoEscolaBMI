/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoescolabmi;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 *
 * @author Laboratorio
 */
public class Aluno {
   
    private String nome;

    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }
    private String descCategoria;

    public static final String PROP_DESCCATEGORIA = "descCategoria";

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        String oldDescCategoria = this.descCategoria;
        this.descCategoria = descCategoria;
        propertyChangeSupport.firePropertyChange(PROP_DESCCATEGORIA, oldDescCategoria, descCategoria);
    }


    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

        private Date DtNasc;

    public static final String PROP_DTNASC = "DtNasc";

    public Date getDtNasc() {
        return DtNasc;
    }

    public void setDtNasc(Date DtNasc) {
        Date oldDtNasc = this.DtNasc;
        this.DtNasc = DtNasc;
        propertyChangeSupport.firePropertyChange(PROP_DTNASC, oldDtNasc, DtNasc);
    }

        private String cpf;

    public static final String PROP_CPF = "cpf";

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        propertyChangeSupport.firePropertyChange(PROP_CPF, oldCpf, cpf);
    }

    private String rg;

    public static final String PROP_RG = "rg";

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        String oldRg = this.rg;
        this.rg = rg;
        propertyChangeSupport.firePropertyChange(PROP_RG, oldRg, rg);
    }

        private String telefone;

    public static final String PROP_TELEFONE = "telefone";

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        propertyChangeSupport.firePropertyChange(PROP_TELEFONE, oldTelefone, telefone);
    }
 
    
        private String nomeMae;

    public static final String PROP_NOMEMAE = "nomeMae";

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        String oldNomeMae = this.nomeMae;
        this.nomeMae = nomeMae;
        propertyChangeSupport.firePropertyChange(PROP_NOMEMAE, oldNomeMae, nomeMae);
    }

    private String nomePai;

    public static final String PROP_NOMEPAI = "nomePai";

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        String oldNomePai = this.nomePai;
        this.nomePai = nomePai;
        propertyChangeSupport.firePropertyChange(PROP_NOMEPAI, oldNomePai, nomePai);
    }

       private String rua;

    public static final String PROP_RUA = "rua";

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        String oldRua = this.rua;
        this.rua = rua;
        propertyChangeSupport.firePropertyChange(PROP_RUA, oldRua, rua);
    }
    
        private String bairro;

    public static final String PROP_BAIRRO = "bairro";

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        propertyChangeSupport.firePropertyChange(PROP_BAIRRO, oldBairro, bairro);
    }

    
        private String numero;

    public static final String PROP_NUMERO = "numero";

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        String oldNumero = this.numero;
        this.numero = numero;
        propertyChangeSupport.firePropertyChange(PROP_NUMERO, oldNumero, numero);
    }
   
    private int categoria;

    public static final String PROP_CATEGORIA = "categoria";

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        int oldCategoria = this.categoria;
        this.categoria = categoria;
        propertyChangeSupport.firePropertyChange(PROP_CATEGORIA, oldCategoria, categoria);
    }



}
