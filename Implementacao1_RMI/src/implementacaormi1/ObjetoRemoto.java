/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaormi1;

import java.rmi.RemoteException;

/**
 *
 * @author aluno
 */
public class ObjetoRemoto implements Hello{

    @Override
    public void printMsg(String msg) {
        System.out.println("Mensagem recebida do cliente: "+msg);
    }
    
}
