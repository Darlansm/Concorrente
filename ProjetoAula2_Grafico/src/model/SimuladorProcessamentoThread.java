/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.Tela;

/**
 *
 * @author fabricio
 */
public class SimuladorProcessamentoThread extends Thread{
    private Thread t;
    long numero1,numero2;   
    long sorteio=0;
    private Tela tela;
    
    
    public void run(){
        
        //cria dois números aleatórios
        numero1=(long) (Math.random()*100);
        numero2=(long) (Math.random()*100);
        //cria o segundo número até que se iguale ao primeiro
        while(numero1!=numero2){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(SimuladorProcessamentoThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            numero2=(long) (Math.random()*100);
        }
        
        sorteio=numero2;
        
        tela.atualiza(String.valueOf(sorteio));
        
        
        
    }
                
    public long sorteioNumeroAleatorio(Tela tela) {
        this.tela = tela;
        return sorteio;       
        
    }
    public void start(){        
        
        t=new Thread(this);    
        t.start();     
        
    }
        
}
    

