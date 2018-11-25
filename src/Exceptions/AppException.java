/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import db.LogDAO;
import java.io.BufferedWriter;
import java.io.FileWriter;
import model.Log;

/**
 *
 * @author Marcello
 */
public class AppException extends Exception{
    protected int logNumber;
    protected String message;

    @Override
    public String getMessage(){
        return this.message;
    }
    
    public AppException(){
    
    }
    
    public AppException(String mensagem){
        this.message = mensagem;
    }
    
    public int saveLog(String mensagem){
        Log log = new Log(mensagem);
        
        try{
            new LogDAO().inserir(log);
        } catch (Exception e){
            try(
                BufferedWriter buffWrite = new BufferedWriter(new FileWriter("logs.txt"));            
            ){
                buffWrite.append(e.getMessage() + "\n\n\n\n");
                buffWrite.close();
            } catch (Exception exc){
                System.out.printf("Não foi possível salvar os logs");
            }
        }
        //Retornara propositalmente 0 se houver exceçoes
        this.logNumber = log.getNumero();
        this.message   = this.message + "Número do erro: " + this.logNumber;
        return log.getNumero();
    }
}
