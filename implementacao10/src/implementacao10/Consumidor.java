/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao10;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author aluno
 */
public class Consumidor implements Runnable{
    
     private BlockingQueue<Integer> fila;
    
    private int tamanhoFila;

    public Consumidor(BlockingQueue<Integer> fila, int tamanhoFila) {
        this.fila = fila;
        this.tamanhoFila = tamanhoFila;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < tamanhoFila; i++) {
                
                Thread.sleep(1000);
                                
                System.out.println("Removido: "+ fila.take());
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
