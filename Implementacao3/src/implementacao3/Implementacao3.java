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
public class Implementacao3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CiclodeVidaThread thread1 = new CiclodeVidaThread("Threa-1");
        thread1.start();

        CiclodeVidaThread thread2 = new CiclodeVidaThread("Thread-2");

        thread2.start();

        try {

            Thread.sleep(1000);
            thread1.suspend();
            System.out.println("Suspendendo ******************** Thread1");

            Thread.sleep(1000);

            thread1.resume();
            System.out.println("Retomando ************************Thread1");

            thread2.suspend();
            System.out.println("Suspendendo ********************** Thread 2");
           Thread.sleep(1000);
            thread2.resume();
            System.out.println("Retomando ******************* Thread2");
        } catch (InterruptedException e) {
            System.out.println("Thread ************************* interrompida");
        }

        try {
            System.out.println("Esperando que Threads terminem");
            thread1.t.join();
            thread2.t.join();
       } catch (InterruptedException e) {
            System.out.println("Esperando que Threads ******************terminem");
        }
        System.out.println("Thread ***************** Executando");
    }

}
