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
public class UpdateQueryException extends QueryException{
    public static final int TABELA_NAO_INFORMADA            = 1;
    public static final int CAMPOS_NAO_INFORMADOS           = 2;
    public static final int QUANTIDADE_CAMPOS_VALORES       = 3;
    public static final int ERRO_PREPARAR_QUERY             = 4;
    public static final int QUANTIDADE_CAMPOS_WHERE_VALORES = 5;
    
    private final int exception;
    
    public UpdateQueryException(int exception){
        this.exception = exception;
        
        switch(this.exception){
            case TABELA_NAO_INFORMADA:
                this.message = "Não é possível gerar a query. Tabela não informada. ";
                break;
                
            case CAMPOS_NAO_INFORMADOS:
                this.message = "Não é possível gerar a query. Campos não informados. ";
                break;
                
            case QUANTIDADE_CAMPOS_VALORES:
                this.message = "Não é possível gerar a query. Quantidade de campos e valores informados não bate. ";
                break;
            
            case ERRO_PREPARAR_QUERY:
                this.message = "Ocorreu um erro ao preparar a query. ";
                break;
                
            case QUANTIDADE_CAMPOS_WHERE_VALORES:
                this.message = "Não é possível gerar a query. Quantidade de campos e valores na clausula where informados não bate. ";
                break;
        }
        
    }
    
    public UpdateQueryException(int exception, String mensagem){
        this(exception);
        super.saveLog(mensagem);
    }     
}
