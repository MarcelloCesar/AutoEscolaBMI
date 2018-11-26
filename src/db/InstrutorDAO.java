/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

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
import model.Instrutor;

/**
 *
 * @author Bruno
 */
public class InstrutorDAO extends DAO<Instrutor> {
    private SimpleDateFormat df;
    
    public InstrutorDAO() throws Exception{
        super();
        this.tabelaBanco = "INSTRUTOR";
        df = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public boolean inserir(Instrutor e) throws Exception {
        InsertQuery insert = new InsertQuery(this.conn, this.tabelaBanco);
        insert.addValue("IDATOR",String.valueOf(e.getAtor().getIdAtor()));
        insert.addValue("DTCREDENCIAMENTO", df.format(e.getDataCad()));
        insert.addValue("NRREGISTRODETRAN", e.getRegDetran());
        insert.addValue("NRCREDENCIAMENTO",e.getCredenciamento());
        insert.addValue("CIDADE",e.getCidade());
        insert.addValue("ENDERECO", e.getEndereco());
        insert.addValue("NUMERO", e.getNumero());
        insert.addValue("TELEFONE", e.getTelefone());
        
        return insert.execute();
    }

    @Override
    public boolean alterar(Instrutor e) throws Exception {
        String sql = "UPDATE INSTRUTOR SET NRREGISTRODETRAN = ?, DTCREDENCIAMENTO = ?"+
                ", NRCREDENCIAMENTO = ?, ENDERECO = ?, NUMERO = ?, CIDADE = ?"+
                ", TELEFONE = ?" + "WHERE IDATOR = ?";
        
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, e.getRegDetran());
            stmt.setDate(2, new java.sql.Date(e.getDataCad().getTime()));
            stmt.setString(3, e.getCredenciamento());
            stmt.setString(4, e.getEndereco());
            stmt.setString(5, e.getNumero());
            stmt.setString(6, e.getCidade());
            stmt.setString(7, e.getTelefone());
            stmt.setInt(8, e.getAtor().getIdAtor());
            return stmt.executeUpdate()==1;
    
}

    @Override
    public boolean excluir(Instrutor e) throws Exception {
        String sql = "DELETE FROM INSTRUTOR WHERE IDATOR = "+e.getAtor().getIdAtor();
        
        try(
            Statement stmt = conn.createStatement();
        ){
            return stmt.executeUpdate(sql) == 1;
        }catch(SQLException ex)
        {
            System.out.println("Erro ao deletar" +ex.getMessage());
        }
        return false;
    }        

    @Override
    public List<Instrutor> listar(){
        List<Instrutor> lstInstrutor = new LinkedList<Instrutor>();
        lstInstrutor = org.jdesktop.observablecollections.ObservableCollections.observableList(lstInstrutor);
        String sql = "SELECT * FROM INSTRUTOR";
        
        try(
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
            ){
            PessoaDAO pd = new PessoaDAO();
                while(rs.next())
                {
                    Instrutor i = new Instrutor();
                    
                    i.setAtor(pd.getById(rs.getInt("IDATOR")));
                    i.setDataCad(rs.getDate("DTCREDENCIAMENTO"));
                    i.setRegDetran(rs.getString("NRREGISTRODETRAN"));
                    i.setCredenciamento(rs.getString("NRCREDENCIAMENTO"));
                    i.setEndereco(rs.getString("ENDERECO"));
                    i.setNumero(rs.getString("NUMERO"));
                    i.setCidade(rs.getString("CIDADE"));
                    i.setTelefone(rs.getString("TELEFONE"));
                    lstInstrutor.add(i);     
                }
        }catch(Exception ex)
        {
            System.out.println("Erro ao listar"+ex.getMessage());
        }
        return lstInstrutor;
    }

    
}
