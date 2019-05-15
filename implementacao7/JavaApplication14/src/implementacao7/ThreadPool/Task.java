/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao7.ThreadPool;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author darlan
 */
public class Task implements Runnable{

    @Override
    public void run() {
        try {
            Long duration=(long) (Math.random()*5);
            System.out.println("Executando nova tarefa! Nome da Thread:"+
                    Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(duration);
            
            System.out.println("Task Executada! Nome da Thread:" +
                    Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
  
    }
    
    
}
