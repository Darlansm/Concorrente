/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author aluno
 */
class CounterInt {
    
    private int c = 0;
    private AtomicInteger atomicC = new AtomicInteger(0);
    
    public void increment(){
        c ++;
        atomicC.getAndIncrement();
    }
    
    public  int value(){
        return c;
    }
    
    public AtomicInteger valueAtomic(){
        return atomicC;
    }
    
}
