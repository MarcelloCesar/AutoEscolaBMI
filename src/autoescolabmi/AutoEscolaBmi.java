/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoescolabmi;

import javax.swing.JOptionPane;

public class AutoEscolaBmi {
    private static BaseDados dados;
    
    public AutoEscolaBmi(){
        
        //Efetuar o login
        Login telaLogin = new Login(null);
        telaLogin.setVisible(true);
        
        if(telaLogin.estaLogado()){
            this.iniciarSistema();
        } else {
            JOptionPane.showMessageDialog(null, "Autenticação não realizada corretamente. O sistema será encerrado.");
        }
    }
    
    private void iniciarSistema(){        
        MenuPrincipal sistema =  new MenuPrincipal();
        sistema.setVisible(true);
    }
    
    public static BaseDados getBaseDados(){
        if(AutoEscolaBmi.dados == null){
            AutoEscolaBmi.dados =  new BaseDados();
        }
        return AutoEscolaBmi.dados;
    }
    
    public static void main(String args[]){
        new AutoEscolaBmi();
    }    
}
