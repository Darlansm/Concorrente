/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaormi1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author aluno
 */
public class Servidor {
    
    public static void main(String[] args)throws RemoteException {
        try {
            Registry registry = LocateRegistry.createRegistry(2001);
            
            ObjetoRemoto objRemoto = new ObjetoRemoto();
            
            Hello skeleton_objR = (Hello) UnicastRemoteObject.exportObject(objRemoto, 0);
            
            registry.bind("Hello", skeleton_objR);
            
            System.out.println("Sevidor pronto");
            
            
            
        } catch (Exception e) {
            System.out.println("Erro no servidor:" + e.toString());
        }
        
        
    }
    
}
