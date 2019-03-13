/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao1;

/**
 *
 * @author aluno
 */
public class Implementacao1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        exemploThread thread1 = new exemploThread("Thread1");
        thread1.start();
        exemploThread thread2 = new exemploThread("Thread2");
        thread2.start();
    }
    
}
