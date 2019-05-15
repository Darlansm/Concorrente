
package implementacao6;

/**
 *
 * @author aluno
 */
public class Atomic {
 CounterInt couterInt = new CounterInt(); 

public void countInt() throws InterruptedException{
    for (int i = 0; i < 1000; i++) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                couterInt.increment();
            }
        } ).start();
        
    }
    
    Thread.sleep(1000);
    System.out.println("Numero final sem atomicidade" + couterInt.value());
    System.out.println("Numero final com atomicidade" + couterInt.valueAtomic());

}
public void simulaMovimentacao() throws InterruptedException{
    SaldoConta saldoConta = new SaldoConta();
    
    for (int i = 0; i < 1000; i++) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                saldoConta.movimentacao(1);
            }
        }).start();
    }
    
    for (int i = 0; i < 1000; i++) {
        
         new Thread(new Runnable() {
            @Override
            public void run() {
                saldoConta.movimentacao(10);
            }
        }).start();
}
    
    Thread.sleep(1000);
    
    System.out.println("Saldo sem atomicidade :"+ saldoConta.value());
    System.out.println("Número final com atomicidade :" +saldoConta.valueAtomic());
}

}
