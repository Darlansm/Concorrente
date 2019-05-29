/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaormi1;

import java.rmi.Naming;

/**
 *
 * @author aluno
 */
public class Cliente2 {
    
    public static void main(String[] args) {
         try {
            Hello obj = null;            
            obj = (Hello)Naming.lookup("//10.141.9.230:2001/Hello");
            obj.printMsg("Darlan");
            
        } catch (Exception e) {
            System.out.println("Erro no cliente: "+ e.toString());
        }
    }
        
       
              
      
       
    
}
