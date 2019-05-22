/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao10;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author aluno
 */
public class Produtor implements Runnable{
    
    //cria fila local a esta classe
    private BlockingQueue<Integer> fila;
    
    private int tamanhoFila;

    public Produtor(BlockingQueue<Integer> fila, int tamanhoFila) {
        this.fila = fila;
        this.tamanhoFila = tamanhoFila;
        
    }
    //sobrescreve método run()
    @Override
    public void run() {
        //instancia classe geradora de números aleatórios
        Random random = new Random();
        int numero;
        
        try {
            //obtem números aleatório de 0 a 100
            for (int i = 0; i < tamanhoFila; i++) {
                
                numero = random.nextInt(100);
                //paraliza thread dando tempo para thread consumidora
                //retirar número da fila
                //Experimente comentar esta linha e compare os resultados
                
                //Thread.sleep(1000);
                //insere número na fila
                fila.put(numero);
                System.out.println("Adicionando: "+ numero);
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
