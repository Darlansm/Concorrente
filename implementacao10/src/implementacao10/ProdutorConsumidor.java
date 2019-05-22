/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao10;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author aluno
 */
public class ProdutorConsumidor {
    
    //como os processos se comunicam?
    //o conceito de fila está corretamente empregado? Ou trata-se de uma pilha
    
    BlockingQueue<Integer> fila;

    public ProdutorConsumidor(int tamanhoFila) throws InterruptedException {
        this.fila = new ArrayBlockingQueue<>(tamanhoFila);
        Produtor produtor = new Produtor(fila, tamanhoFila);
        Consumidor consumidor = new Consumidor(fila, tamanhoFila);
        
        //diferença para primeiros programas...declarações diferentes...
        //maior controle do ciclo de vida das t
        new Thread(produtor).start();
        new Thread(consumidor).start();
        
        Thread.sleep(4000);
    }
    
    
    
}
