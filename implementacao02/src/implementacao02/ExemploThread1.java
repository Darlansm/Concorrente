/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao02;

/**
 *
 * @author aluno
 */
public class ExemploThread1 extends Thread {

    private Thread t;
    private String nomeThread;
    //Construtor da classe Exemplo
    public ExemploThread1(String nome) {
        this.nomeThread = nome;
        System.out.println("Criando" + nomeThread);
    }
    // Implementação do metodo run herdado da classe Thread
    @Override
    public void run() {
        System.out.println("Executando" + nomeThread);

        try {
            for (int i = 4; i > 0; i--) { // For para testar o programa
                System.out.println("Thread" + nomeThread + " ," + i);

                //Let the thread sleep for a while.
                // Tempo para poder testar as threads criadas
                Thread.sleep(50); 

            }

        } catch (InterruptedException e) {
            System.out.println("Thread" + nomeThread + "interrompida");
        }
        // Fim da execução da Thread
        System.out.println("Thread" + nomeThread + "saindo");

    }
    // Implementação do método start() herdado do thread
    // Este método é usado para iniciar a chamada da thread
    @Override
    public void start() {
        System.out.println("Iniciando" + nomeThread);

        if (t == null) {
            t = new Thread(this, nomeThread);
            t.start();
        }
    }

}
