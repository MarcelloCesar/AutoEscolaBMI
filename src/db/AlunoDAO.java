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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import model.Aluno;
import model.Pessoa;

public class AlunoDAO extends DAO<Aluno> {    
    private SimpleDateFormat df;
    public AlunoDAO() throws Exception{
        super();
        this.tabelaBanco = "MATRICULA";
        this.df = new SimpleDateFormat("yyyy-MM-dd");
    }
    
    @Override    
    public List<Aluno> listar(){
        String tabela = this.tabelaBanco;
        tabela += " JOIN ATOR ON MATRICULA.IDATOR = ATOR.IDATOR ";
        
        SelectQuery select = new SelectQuery(this.conn, tabela);
        select.addCampo("ATOR.IDATOR IDATOR");
        select.addCampo("ATOR.NOME NOME");
        select.addCampo("MATRICULA.DATAMATRICULA");
        select.addCampo("ATOR.CPF CPF");        
        select.addCampo("MATRICULA.CODIGOMATRICULA");
        select.addCampo("MATRICULA.CODCATEGORIA");
        List<Aluno> lst = new LinkedList<>();
        try{
            ResultSet rs = select.executeQuery();            
            while(rs.next()){            
                Pessoa p = new Pessoa(rs);
                Aluno  a = new Aluno(p);
                a.setAlunoFromResultSet(rs);
                lst.add(a);
            }
        } catch (Exception e){}
        return lst;
    }
    
    @Override
    public boolean inserir(Aluno aluno) throws Exception{
        InsertQuery insert = new InsertQuery(this.conn, this.tabelaBanco);
        insert.addValue("IDATOR", String.valueOf(aluno.getIdAtor()));
        insert.addValue("CODIGOMATRICULA", aluno.getCodMatricula());
        insert.addValue("CODCATEGORIA", aluno.getCodCategoria());
        insert.addValue("DATAMATRICULA", df.format(new Date()));
        insert.executeUpdate();
        return true;
    }
    
    @Override
    public boolean alterar(Aluno aluno) throws Exception{
        UpdateQuery update = new UpdateQuery(this.conn, this.tabelaBanco);
        update.addValue("IDATOR", String.valueOf(aluno.getIdAtor()));
        update.addValue("CODCATEGORIA", aluno.getCodCategoria());
        update.addWhere("CODIGOMATRICULA", aluno.getCodMatricula());
        
        update.executeUpdate();
        return true;
    }
    
    @Override
    public boolean excluir(Aluno aluno) throws Exception{
        String sql = "DELETE FROM MATRICULA WHERE MATRICULA.IDATOR = ?";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setInt(1, aluno.getIdAtor());
        stmt.executeUpdate();
        
        return true;
    }
    
    public int buscaUltimaMatricula() throws Exception{
        SelectQuery select = new SelectQuery(this.conn, this.tabelaBanco);
        select.addCampo("COALESCE(MAX(CODIGOMATRICULA), 0) + 1");
        
        ResultSet result = select.executeQuery();
        result.next();
        return result.getInt(1);        
    }
    
    public List<Aluno> buscarAlunosPorCpf(String cpf) throws Exception{
        String tabela = this.tabelaBanco;
        tabela += " JOIN ATOR ON MATRICULA.IDATOR = ATOR.IDATOR ";
        
        SelectQuery select = new SelectQuery(this.conn, tabela);
        select.addCampo("ATOR.NOME");
        select.addCampo("ATOR.CPF");        
        select.addCampo("MATRICULA.CODIGOMATRICULA");
        select.addCampo("MATRICULA.CODCATEGORIA");
        select.addQuery("WHERE ATOR.CPF LIKE '%" + cpf + "%'");
        ResultSet rs = select.executeQuery();
        
        List<Aluno> lst = new LinkedList<>();
        while(rs.next()){            
            Pessoa p = new Pessoa(rs);
            Aluno  a = new Aluno(p);
            a.setAlunoFromResultSet(rs);
            lst.add(a);
        }
        return lst;
    }
    
    public List<Aluno> buscarAlunosPorNome(String nome) throws Exception{
        String tabela = this.tabelaBanco;
        tabela += " JOIN ATOR ON MATRICULA.IDATOR = ATOR.IDATOR ";
        
        SelectQuery select = new SelectQuery(this.conn, tabela);
        select.addCampo("ATOR.IDATOR");
        select.addCampo("ATOR.NOME");
        select.addCampo("MATRICULA.DATAMATRICULA");
        select.addCampo("ATOR.CPF");        
        select.addCampo("MATRICULA.CODIGOMATRICULA");
        select.addCampo("MATRICULA.CODCATEGORIA");
        select.addQuery("WHERE ATOR.NOME LIKE '%" + nome + "%'");
        ResultSet rs = select.executeQuery();
        
        List<Aluno> lst = new LinkedList<>();
        while(rs.next()){            
            Pessoa p = new Pessoa(rs);
            Aluno  a = new Aluno(p);
            a.setAlunoFromResultSet(rs);
            lst.add(a);
        }
        return lst;
    }
    
    public Aluno encontrarMatricula(String matricula) throws Exception{
        String TABELA = this.tabelaBanco;
        TABELA += " JOIN ATOR ON MATRICULA.IDATOR = ATOR.IDATOR ";
        
        SelectQuery select = new SelectQuery(this.conn, TABELA);
        select.addCampoWhere("MATRICULA.CODIGOMATRICULA", String.valueOf(matricula));
        ResultSet rs = select.executeQuery();
        rs.next();
        
        Pessoa p = new Pessoa(rs);
        Aluno a = new Aluno(p);
        a.setAlunoFromResultSet(rs);
        
        return a;      
        
    }
}
