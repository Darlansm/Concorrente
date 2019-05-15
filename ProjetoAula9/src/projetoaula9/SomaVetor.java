/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaula9;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author fabricio
 */
public class SomaVetor extends RecursiveTask<Long>{
    int low;
    int high;
    int[] array;
    int limiar=10;
    
    SomaVetor(int[] array, int low, int high){
        this.array=array;
        this.low=low;
        this.high=high;
    }
    
    @Override
    protected Long compute(){
        if(high-low<=limiar){
            long sum=0;
            for(int i=low;i<high;i++)
                sum +=array[i];
            return sum;
        }else{
            int mid=low+(high-low)/2;
            
            SomaVetor left=new SomaVetor(array,low,mid);
            SomaVetor right=new SomaVetor(array,mid,high);
            
            left.fork();
            
            long rightResult=right.compute();
            long leftResult=left.join();
            return leftResult+rightResult;
        }
        
        
    }
    
}
