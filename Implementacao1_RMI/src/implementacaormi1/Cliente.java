/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaormi1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author aluno
 */
public class Cliente {
    
    public static void main(String[] args) {
        try {
            
            Registry registry = LocateRegistry.getRegistry(2001);
            
            Hello stub= (Hello) registry.lookup("Hello");
            
            stub.printMsg("Cliente invocando método");
            
        } catch (Exception e) {
            System.out.println("Erro no cliente: "+ e.toString());
        }
    }
    
}
