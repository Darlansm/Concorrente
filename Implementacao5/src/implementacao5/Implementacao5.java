/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao5;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author aluno
 */
public class Implementacao5 {

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private static String message = " ";
    private static int num = 3;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        Thread t1 = new Thread(new Writer("Programação", 3));
        t1.setName("Writer A");
        Thread t2 = new Thread(new Writer("Paralela", 2));
        t1.setName("Writer B");
        Thread t3 = new Thread(new Reader());
        t1.setName("Reader");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }

    static class Writer implements Runnable {

        private String msg;

        private int numero; // Numero criado para calculo

        public Writer(String msg, int numero) {
            this.msg = msg;
            this.numero = numero;
        }

        public void run() {
            //faz um bloqueio de escrita
            lock.writeLock().lock();

            try {
                //define aleatoriamente tempo da operação
                Long duration = (long) (Math.random() * 100);
                System.out.println(Thread.currentThread().getName()
                        + " Tempo Utilizado " + (duration / 1000) + " segundos"
                );
                Thread.sleep(duration);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //Escreve mensagem

                message = message.concat(" " + this.msg.toString());
                // Faz operação conforme numero inicializado com o numero passado
                //pela thread
                num *= numero;
                //libera bloqueio
                lock.writeLock().unlock();
            }
        }
    }

    static class Reader implements Runnable {

        public void run() {
            //verifica se já foi estabelecido lock de escrita

            if (lock.isWriteLocked()) {
                System.out.println("Lock de escrita detectado.");
            }

            // faz bloqueio de leitura
            lock.readLock().lock();

            try {
                //define aleatoriamente o tempo da operação
                Long duration = (long) (Math.random() * 100);
                System.out.println(Thread.currentThread().getName()
                        + " Tempo Utilizado  " + (duration / 1000) + " segundos");
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " : " + message);
                //Escreve o resultado no final das execuções
                System.out.println("Resultado ...:" + num);
                // desbloqueia lock
                lock.readLock().unlock();
            }
        }

    }

}
