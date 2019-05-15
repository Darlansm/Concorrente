/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaula9;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author fabricio
 */
public class ProjetoAula9 {
   
    
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int execucoes=4;
        long tempos=0;
        long result;
        
        long tempoInicio=System.currentTimeMillis();
    
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);
        
        int[] numbers=new int[100000000];
        
        for(int i=0;i<numbers.length;i++){
            numbers[i]=i;
        }
        
        ForkJoinPool forkJoinPool=new ForkJoinPool(nThreads);
        for(int n=0;n<execucoes;n++){
            
            result=forkJoinPool.invoke(new SomaVetor(numbers,0,numbers.length));
            System.out.println("***** Execução "+n+" *****");
            System.out.println("Resultado: "+result);
            //System.out.println("Tempo Total "+(System.currentTimeMillis()-tempoInicio)+" *****");
            tempos+=System.currentTimeMillis()-tempoInicio;
            
        }
        System.out.println("Tempo médio: "+tempos/execucoes);
    }
    
}
