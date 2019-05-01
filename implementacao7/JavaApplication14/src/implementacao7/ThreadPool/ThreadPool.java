/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao7.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


/**
 *
 * @author darlan
 */
public class ThreadPool {
    
    public ThreadPool() throws InterruptedException{
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ThreadPoolExecutor pool= (ThreadPoolExecutor) executor;
        
        System.out.println("Máximo de execuções :"+
                pool.getLargestPoolSize());
        System.out.println("Número máximo de Threads permitidas :"+
                pool.getMaximumPoolSize());
        System.out.println("Número de Threads no poll :"+
                pool.getPoolSize());
        System.out.println("Número de Threads em execução :"+
                pool.getActiveCount());
        System.out.println("Total de Threads: "+
                pool.getTaskCount());
        
        executor.submit(new Task());
        executor.submit(new Task());
        
        System.out.println("Máximo de execuções :"+
                pool.getLargestPoolSize());
        System.out.println("Número máximo de Threads permitidas :"+
                pool.getMaximumPoolSize());
        System.out.println("Número de Threads no poll :"+
                pool.getPoolSize());
        System.out.println("Número de Threads em execução :"+
                pool.getActiveCount());
        System.out.println("Total de Threads: "+
                pool.getTaskCount());
        
        executor.shutdown();
        pool.shutdown();
        
    }
    
}
