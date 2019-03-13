/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao02;

/**
 *
 * @author aluno
 */
public class Implementacao02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ExemploThread1 thread3 = new ExemploThread1("Thread3");
        ExemploThread1 thread4 = new ExemploThread1("Thread4");
        
        thread3.start();
        thread4.start();
        
    }
    
}
