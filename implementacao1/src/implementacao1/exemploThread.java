/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao1;

/**
 *
 * @author aluno
 */
class exemploThread implements Runnable {

    private Thread t;
    private String nomeThread;

    public exemploThread(String nome) {

        this.nomeThread = nome;
        System.out.println("Criando" + nomeThread);
    }

    @Override
    public void run() {
        System.out.println("Executando" + nomeThread);

        try {
            //Utilizado a classe da sequencia de Fibonacci para testar a utilização de threds

            // Teste do programa. Imprime os 40 primeiros termos       
            for (int i = 0; i < 40; i++) {
                System.out.print("(" + i + "):" + Fibonacci.fibo(i));
                System.out.println("Thread: " + nomeThread + " , " + i);
                Thread.sleep(50); //Tempo de sleep influencia na execução das threds 
            }

        } catch (Exception e) {
            System.out.println("Thread" + nomeThread + "interrupted");
        }

        System.out.println(
                "Thread" + nomeThread + " exiting");

    }

    public void start() {
        System.out.println("Iniciando" + nomeThread);

        if (t == null) {
            t = new Thread(this, nomeThread);
            t.start();
        }
    }

}
