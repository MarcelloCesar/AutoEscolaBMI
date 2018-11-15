/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoescolabmi;

/**
 *
 * @author Bruno
 */

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

public class Veiculo implements Cloneable {
    
    public Veiculo getClone(){
        try{
                return (Veiculo)this.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }

    private String Modelo;

    public static final String PROP_MODELO = "Modelo";

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        String oldModelo = this.Modelo;
        this.Modelo = Modelo;
        propertyChangeSupport.firePropertyChange(PROP_MODELO, oldModelo, Modelo);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private String Ano;

    public static final String PROP_ANO = "Ano";

    public String getAno() {
        return Ano;
    }

    public void setAno(String Ano) {
        String oldAno = this.Ano;
        this.Ano = Ano;
        propertyChangeSupport.firePropertyChange(PROP_ANO, oldAno, Ano);
    }

    private String Placa;

    public static final String PROP_PLACA = "Placa";

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        String oldPlaca = this.Placa;
        this.Placa = Placa;
        propertyChangeSupport.firePropertyChange(PROP_PLACA, oldPlaca, Placa);
    }

    private String Cor;

    public static final String PROP_COR = "Cor";

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        String oldCor = this.Cor;
        this.Cor = Cor;
        propertyChangeSupport.firePropertyChange(PROP_COR, oldCor, Cor);
    }

    private String Marca;

    public static final String PROP_MARCA = "Marca";

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        String oldMarca = this.Marca;
        this.Marca = Marca;
        propertyChangeSupport.firePropertyChange(PROP_MARCA, oldMarca, Marca);
    }

    private String Especie;

    public static final String PROP_ESPECIE = "Especie";

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String Especie) {
        String oldEspecie = this.Especie;
        this.Especie = Especie;
        propertyChangeSupport.firePropertyChange(PROP_ESPECIE, oldEspecie, Especie);
    }

    private String Numeracao;

    public static final String PROP_NUMERACAO = "Numeracao";

    public String getNumeracao() {
        return Numeracao;
    }

    public void setNumeracao(String Numeracao) {
        String oldNumeracao = this.Numeracao;
        this.Numeracao = Numeracao;
        propertyChangeSupport.firePropertyChange(PROP_NUMERACAO, oldNumeracao, Numeracao);
    }

    private String NrDocumento;

    public static final String PROP_NRDOCUMENTO = "NrDocumento";

    public String getNrDocumento() {
        return NrDocumento;
    }

    public void setNrDocumento(String NrDocumento) {
        String oldNrDocumento = this.NrDocumento;
        this.NrDocumento = NrDocumento;
        propertyChangeSupport.firePropertyChange(PROP_NRDOCUMENTO, oldNrDocumento, NrDocumento);
    }

    private String Historico;

    public static final String PROP_HISTORICO = "Historico";

    public String getHistorico() {
        return Historico;
    }

    public void setHistorico(String Historico) {
        String oldHistorico = this.Historico;
        this.Historico = Historico;
        propertyChangeSupport.firePropertyChange(PROP_HISTORICO, oldHistorico, Historico);
    }

    private Date DataCadastro;

    public static final String PROP_DATACADASTRO = "DataCadastro";

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        Date oldDataCadastro = this.DataCadastro;
        this.DataCadastro = DataCadastro;
        propertyChangeSupport.firePropertyChange(PROP_DATACADASTRO, oldDataCadastro, DataCadastro);
    }

    private Date DataAquisicao;

    public static final String PROP_DATAAQUISICAO = "DataAquisicao";

    public Date getDataAquisicao() {
        return DataAquisicao;
    }

    public void setDataAquisicao(Date DataAquisicao) {
        Date oldDataAquisicao = this.DataAquisicao;
        this.DataAquisicao = DataAquisicao;   
        propertyChangeSupport.firePropertyChange(PROP_DATAAQUISICAO, oldDataAquisicao, DataAquisicao);
    }
}
