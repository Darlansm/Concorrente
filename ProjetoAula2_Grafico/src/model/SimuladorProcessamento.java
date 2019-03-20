/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fabricio
 */
public class SimuladorProcessamento {
    
    public long sorteioNumeroAleatorio() throws InterruptedException{
        long numero1,numero2;
        //cria dois números aleatórios
        numero1=(long) (Math.random()*100);
        numero2=(long) (Math.random()*100);
        //repete a criação do segundo número até que seja igual ao primeiro
        while(numero1!=numero2){
            Thread.sleep(10);
            numero2=(long) (Math.random()*100);
        }
        return numero1;
        
}
    
}
