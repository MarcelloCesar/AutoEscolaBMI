/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Marcello
 */
public class QueryException extends AppException {
    
    public static final int ERRO_EXECUTAR_QUERY = 1;
    private int exc;
    
    public QueryException(){}
    
    public QueryException(int exception){
        this.exc = exception;
        
        switch(this.exc){
            case ERRO_EXECUTAR_QUERY:
                this.message = "Ocorreu um erro ao executar uma consulta aos dados. ";
                break;
        }
    }
    
    public QueryException(int exception, String mensagem){
        this(exception);
        super.saveLog(mensagem);
    }                 
    
}
