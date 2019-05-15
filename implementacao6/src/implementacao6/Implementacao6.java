/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao6;

/**
 *
 * @author aluno
 */
public class Implementacao6 {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
       
        Atomic atomic = new Atomic();
        atomic.countInt();
        atomic.simulaMovimentacao();
        
    }
    
}
