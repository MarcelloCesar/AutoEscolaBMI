/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Exceptions.AppException;
import db.query.InsertQuery;
import db.query.SelectQuery;
import db.query.UpdateQuery;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Pessoa;

/**
 *
 * @author Marcello
 */
public class PessoaDAO extends DAO<Pessoa>{
    private final SimpleDateFormat df;
    public PessoaDAO() throws Exception{
        this.tabelaBanco = "ATOR";
        this.df = new SimpleDateFormat("yyyy-MM-dd");
    }
    
    @Override
    public boolean inserir(Pessoa e) throws Exception {
        InsertQuery insert = new InsertQuery(this.conn, this.tabelaBanco);
        insert.addValue("NOME", e.getNome());
        insert.addValue("CPF", e.getCpf());
        insert.addValue("RG", e.getRg());
        insert.addValue("DATAINCLUSAO", df.format(e.getDataInclusao()));
        insert.addValue("DATANASCIMENTO", df.format(e.getDataNascimento()));
        insert.executeUpdate();
        e.setIdAtor(insert.getGeneratedId());
             
        return true;
    }

    @Override
    public boolean alterar(Pessoa e) throws Exception {
        UpdateQuery update = new UpdateQuery(this.conn, this.tabelaBanco);
        update.addValue("NOME", e.getNome());
        update.addValue("CPF", e.getCpf());
        update.addValue("RG", e.getRg());
        update.addValue("DATANASCIMENTO", df.format(e.getDataNascimento()));
        update.addWhere("IDATOR", String.valueOf(e.getIdAtor()));
        update.executeUpdate();        
        return true;
    }

    @Override
    public boolean excluir(Pessoa e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Pessoa findByCpf(String cpf) throws Exception{
        SelectQuery select = new SelectQuery(this.conn, this.tabelaBanco);
        select.addCampo("IDATOR");
        select.addCampo("NOME");        
        select.addCampo("CPF");
        select.addCampo("RG");
        select.addCampo("DATANASCIMENTO");
        select.addCampo("DATAINCLUSAO");
        select.addCampoWhere("CPF", cpf);
        
        ResultSet rs = select.executeQuery();
        Pessoa p = null;
        if(rs.next()){
            p = new Pessoa(rs);         
        }
        
        //Se houver violacao do unique index de cpf e retornou mais de 1
        if(rs.next()){
            AppException exc = new AppException("Encontrada inconsistência no campo de CPF. ");            
            exc.saveLog("CPF " + cpf + " repetido para os atores: " + p.getIdAtor() + " e " + rs.getInt(1));
            throw exc;
        }
        return p;
            
    }
    
    
}
