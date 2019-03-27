/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao4;

/**
 *
 * @author aluno
 */
public class Implementacao4 {

    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();

        T1.start();
        T2.start();

    }

    private static class ThreadDemo1 extends Thread {
        //Objeto lock1 é bloqueado
        public void run() {
            synchronized (Lock1) {
                System.out.println("Thread1 bloqeando lock 1 ...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                // Objeto tenta bloquear lock 2, que já vai estar bloqueado por outro
                // objeto
                System.out.println("Thread1 esperando por lock2....");
                synchronized (Lock2) {
                    //devido ao deadlock, esta linha é inalcançavel
                    System.out.println("Thread1 bloqueando lock 1 & 2");
                }
            }
        }

    }

    private static class ThreadDemo2 extends Thread {

        public void run() {
            //objeto bloqueia lock2
            synchronized (Lock2) {
                System.out.println("Thread2 bloqeando lock 2 ...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread2 esperando por lock1....");
                //objeto tenta bloquear lock1, que já vai estar bloqueado
                synchronized (Lock1) {
                    //devido ao deadlock, esta linha é inalcançavel
                    System.out.println("Thread2 bloqueando lock 2 & 1");
                }
            }
        }

    }
}
