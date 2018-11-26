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
    private Pessoa ator;
    private String endereco;

    public Instrutor(){
        ator = new Pessoa();
        this.ator.setDataInclusao(new Date());

    }

    public void setAtor(Pessoa ator) {
        this.ator = ator;
    }
    
    public static final String PROP_ENDERECO = "endereco";

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        propertyChangeSupport.firePropertyChange(PROP_ENDERECO, oldEndereco, endereco);
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

    private String cidade;

    public static final String PROP_CIDADE = "cidade";

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        propertyChangeSupport.firePropertyChange(PROP_CIDADE, oldCidade, cidade);
    }


    public Pessoa getAtor() {
        return ator;
    }
    
    public Instrutor getClone(){
        try{
                return (Instrutor)this.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
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
