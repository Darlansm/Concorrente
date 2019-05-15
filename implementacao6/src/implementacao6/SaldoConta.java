/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao6;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author aluno
 */
class SaldoConta {
    private long saldo = 0;
    
    private AtomicLong atomicSaldo = new AtomicLong(0);
    
    
    public long value() {
        return saldo;
    }

    public AtomicLong valueAtomic() {
        return atomicSaldo;
    }

    public void movimentacao(long valor) {
        saldo = saldo+valor;
        atomicSaldo.getAndAdd(valor);
        
    }
    
}
