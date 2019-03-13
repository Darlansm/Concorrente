/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao3;

/**
 *
 * @author aluno
 */
public class CiclodeVidaThread implements Runnable {

    public Thread t;
    public String nomeThread;
    //variavel logica utilizada para determinar quando uma thread
    //deve entrar em modo de espera

    boolean espera = false;

    public CiclodeVidaThread(String nome) {

        this.nomeThread = nome;
        System.out.println("Criando" + nomeThread);
    }

    @Override
    public void run() {
        System.out.println("Executando" + nomeThread);

        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("Threa:" + nomeThread + " ," + i);

                synchronized (this) {
                    while (espera) {
                        wait();

                    }
                }
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread" + nomeThread + "interrompida");
        }

        System.out.println("Thread" + nomeThread + "saindo");

    }

    public void start() {
        System.out.println("Iniciando" + nomeThread);

        if (t == null) {
            t = new Thread(this, nomeThread);
            t.start();
        }
    }

    public void suspend() {
        this.espera = true;
    }

    synchronized void resume() {
        espera = false;
        notify();
    }

}
