/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

public class Instrutor implements Cloneable {
    
    public Instrutor getClone(){
        try{
                return (Instrutor)this.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }
    
    private String Nome;

    public static final String PROP_NOME = "Nome";

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        String oldNome = this.Nome;
        this.Nome = Nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, Nome);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private Date DataNascimento;

    public static final String PROP_DATANASCIMENTO = "DataNascimento";

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        Date oldDataNascimento = this.DataNascimento;
        this.DataNascimento = DataNascimento;
        propertyChangeSupport.firePropertyChange(PROP_DATANASCIMENTO, oldDataNascimento, DataNascimento);
    }

    private String CPF;

    public static final String PROP_CPF = "CPF";

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        String oldCPF = this.CPF;
        this.CPF = CPF;
        propertyChangeSupport.firePropertyChange(PROP_CPF, oldCPF, CPF);
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

    private String Telefone;

    public static final String PROP_TELEFONE = "Telefone";

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        String oldTelefone = this.Telefone;
        this.Telefone = Telefone;
        propertyChangeSupport.firePropertyChange(PROP_TELEFONE, oldTelefone, Telefone);
    }

    private String Endereco;

    public static final String PROP_ENDERECO = "Endereco";

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        String oldEndereco = this.Endereco;
        this.Endereco = Endereco;
        propertyChangeSupport.firePropertyChange(PROP_ENDERECO, oldEndereco, Endereco);
    }

        private String Numero;

    public static final String PROP_NUMERO = "Numero";

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        String oldNumero = this.Numero;
        this.Numero = Numero;
        propertyChangeSupport.firePropertyChange(PROP_NUMERO, oldNumero, Numero);
    }


        private String Cidade;

    public static final String PROP_CIDADE = "Cidade";

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        String oldCidade = this.Cidade;
        this.Cidade = Cidade;
        propertyChangeSupport.firePropertyChange(PROP_CIDADE, oldCidade, Cidade);
    }

        private Date DataCad;

    public static final String PROP_DATACAD = "DataCad";

    public Date getDataCad() {
        return DataCad;
    }

    public void setDataCad(Date DataCad) {
        Date oldDataCad = this.DataCad;
        this.DataCad = DataCad;
        propertyChangeSupport.firePropertyChange(PROP_DATACAD, oldDataCad, DataCad);
    }

    private String Credenciamento;

    public static final String PROP_CREDENCIAMENTO = "Credenciamento";

    public String getCredenciamento() {
        return Credenciamento;
    }

    public void setCredenciamento(String Credenciamento) {
        String oldCredenciamento = this.Credenciamento;
        this.Credenciamento = Credenciamento;
        propertyChangeSupport.firePropertyChange(PROP_CREDENCIAMENTO, oldCredenciamento, Credenciamento);
    }

           private String RegDetran;

    public static final String PROP_REGDETRAN = "RegDetran";

    public String getRegDetran() {
        return RegDetran;
    }

    public void setRegDetran(String RegDetran) {
        String oldRegDetran = this.RegDetran;
        this.RegDetran = RegDetran;
        propertyChangeSupport.firePropertyChange(PROP_REGDETRAN, oldRegDetran, RegDetran);
    }




}
