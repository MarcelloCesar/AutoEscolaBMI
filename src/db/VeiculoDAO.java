/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Exceptions.QueryException;
import db.query.InsertQuery;
import db.query.SelectQuery;
import db.query.UpdateQuery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Veiculo;

/**
 *
 * @author Bruno
 */
public class VeiculoDAO extends DAO<Veiculo>{
    
    private SimpleDateFormat df;

    public VeiculoDAO() throws Exception{
        super();
        this.tabelaBanco = "VEICULO";
        df = new SimpleDateFormat("yyyy-MM-dd");        
    }
    
    @Override
    public boolean inserir(Veiculo v) throws Exception {
        InsertQuery insert = new InsertQuery(this.conn, this.tabelaBanco);
        
        insert.addValue("NUMERACAO", v.getNumeracao());
        insert.addValue("MARCA", v.getMarca());
        insert.addValue("MODELO", v.getModelo());
        insert.addValue("ANO", v.getAno());
        insert.addValue("PLACA", v.getPlaca());
        insert.addValue("COR", v.getCor());
        insert.addValue("ESPECIE", v.getEspecie());
        insert.addValue("NUMERODOCUMENTO", v.getNrDocumento());
        insert.addValue("DATACADASTRO", df.format(v.getDataCadastro()));
        insert.addValue("DATAAQUISICAO", df.format(v.getDataAquisicao()));
        insert.addValue("HISTORICO", v.getHistorico());
        
        return insert.execute();
    } 

    @Override
    public boolean alterar(Veiculo v) throws Exception{
        String sql = "UPDATE VEICULO SET MARCA = ?, MODELO = ?, ANO = ?, PLACA = ?, COR = ?"
        +", ESPECIE = ?, NUMERODOCUMENTO = ?, DATACADASTRO = ?, DATAAQUISICAO = ?"
        +", HISTORICO = ? WHERE NUMERACAO = ?";
        
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, v.getMarca());
            stmt.setString(2, v.getModelo());
            stmt.setString(3, v.getAno());
            stmt.setString(4, v.getPlaca());
            stmt.setString(5, v.getCor());
            stmt.setString(6, v.getEspecie());
            stmt.setString(7, v.getNrDocumento());
            stmt.setDate(8, new java.sql.Date(v.getDataCadastro().getTime()));
            if(v.getDataAquisicao() == null)
                stmt.setDate(9,null);
            else
                stmt.setDate(9, new java.sql.Date(v.getDataAquisicao().getTime()));
            stmt.setString(10, v.getHistorico());
            stmt.setString(11, v.getNumeracao());
            return stmt.executeUpdate()==1;
        
    }

    @Override
    public boolean excluir(Veiculo v){
        String sql = "DELETE FROM VEICULO WHERE VEICULO.NUMERACAO = " +v.getNumeracao();
        
        try(
            Statement stmt = conn.createStatement();
        ){
            return stmt.executeUpdate(sql) == 1;
        }catch(SQLException e)
        {
            System.out.println("Erro ao deletar" +e.getMessage());
        }
        return false;
    }

    @Override
    public List<Veiculo> listar() {
        List<Veiculo> lstVeiculo = new LinkedList<Veiculo>();
        lstVeiculo = org.jdesktop.observablecollections.ObservableCollections.observableList(lstVeiculo);
        SelectQuery select = new SelectQuery(this.conn, this.tabelaBanco);
        select.addCampo("*");
        try(
                ResultSet rs = select.executeQuery();
            ){
            while(rs.next()){
                Veiculo v = new Veiculo();
                v.setNumeracao(rs.getString("NUMERACAO"));
                v.setAno(rs.getString("ANO"));
                v.setCor(rs.getString("COR"));
                v.setDataAquisicao(rs.getDate("DATAAQUISICAO"));
                v.setDataCadastro(rs.getDate("DATACADASTRO"));
                v.setEspecie(rs.getString("ESPECIE"));
                v.setHistorico(rs.getString("HISTORICO"));
                v.setMarca(rs.getString("MARCA"));
                v.setModelo(rs.getString("MODELO"));
                v.setNrDocumento(rs.getString("NUMERODOCUMENTO"));
                v.setPlaca(rs.getString("PLACA"));
                lstVeiculo.add(v);
            }
            }catch(SQLException e){
                System.out.println("Erro ao listar"+e.getMessage());
            }catch(QueryException ex)
            {
                ex.getMessage();
            }
        return lstVeiculo;
    }
    
}
