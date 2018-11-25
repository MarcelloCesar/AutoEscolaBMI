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
public class SelectQueryException extends QueryException {
    public static final int TABELA_NAO_INFORMADA            = 1;
    public static final int QUANTIDADE_CAMPOS_WHERE_VALORES = 2;
    public static final int ERRO_PREPARAR_QUERY             = 3;
    
    private final int exception;    
    
    public SelectQueryException(int exception){
        this.exception = exception;
        
        switch(this.exception){
            case TABELA_NAO_INFORMADA:
                this.message = "Não é possível gerar a query. Tabela não informada. ";
                break;
                
            case QUANTIDADE_CAMPOS_WHERE_VALORES:
                this.message = "Não é possível gerar a query. Quantidade de campos e valores na clausula where informados não bate. ";
                break;
            
            case ERRO_PREPARAR_QUERY:
                this.message = "Ocorreu um erro ao preparar uma consulta. ";
                break;
        }
    }
    
    public SelectQueryException(int exception, String mensagem){
        this(exception);
        super.saveLog(mensagem);
    } 
}
