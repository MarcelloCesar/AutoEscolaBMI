package db.query;

import Exceptions.QueryException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marcello
 */
public abstract class Query {
    
    protected String nomeTabela;
    protected String query;    
    protected String extraQuery;
    protected Connection connection;
    protected PreparedStatement lastStatement;
    
    public Query (){
        this.extraQuery = "";
    }
    
    public abstract PreparedStatement getStatement() throws QueryException;
    protected PreparedStatement prepareStatement(Connection conn, String sql) throws SQLException{
        lastStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);        
        return this.lastStatement;
    }
    
    public ResultSet executeQuery() throws QueryException{
        ResultSet result;
        try{            
            return this.getStatement().executeQuery();
        } catch (SQLException exc){       
            throw new QueryException(QueryException.ERRO_EXECUTAR_QUERY, 
                                           exc.getMessage() + "\n" + this.query);
        } catch (QueryException exc){
            throw exc;
        }        
    }  
    
    public boolean execute() throws QueryException{        
        try{            
            return this.getStatement().execute();
        } catch (SQLException exc){       
            throw new QueryException(QueryException.ERRO_EXECUTAR_QUERY, 
                                           exc.getMessage() + "\n" + this.query);
        } catch (QueryException exc){
            throw exc;
        }
    }
    
    public int executeUpdate() throws QueryException{
        try{            
            return this.getStatement().executeUpdate();
        } catch (SQLException exc){       
            throw new QueryException(QueryException.ERRO_EXECUTAR_QUERY, 
                                           exc.getMessage() + "\n" + this.query);
        } catch (QueryException exc){
            throw exc;
        }
    }
    
    public int getGeneratedId() throws Exception{
        ResultSet rs = this.lastStatement.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }
    
    public void addQuery(String query){
        this.extraQuery = query;
    }
}
