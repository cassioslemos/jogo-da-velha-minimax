/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_da_velha;

import java.util.ArrayList;

/**
 *
 * @author cassi
 */
public class Nodo {
    private Tabuleiro tabuleiro;
    private Nodo [] prox;
     private Nodo ant;
     private int jogada;
     private int profundidade;
     private int valor_minmax;
    
    public Nodo (Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        prox = new Nodo[10];
        ant = null;
        jogada = -1;
        for(int i=0; i<9; i++)
            prox[i]=null;
        profundidade = 0;
        valor_minmax = 0;
    }
    
    public void setValorMinmax(int valor_minmax){
        this.valor_minmax = valor_minmax;
    }
    
    public int getValorMinmax(){
        return valor_minmax;
    }
        
    public void setProfundidade(int profundidade){
        this.profundidade = profundidade;
    }
    
    public Nodo getAnt(){
        return ant;
    }
    
    public int getProfundidade(){
        return profundidade;
    }
    
    public void setAnt(Nodo ant){
        this.ant = ant;
    }
    
    public void setJogada(int jogada){
        this.jogada = jogada;
    }
    
    public int getJogada(){
        return jogada;
    }
    

 public void setProx(Nodo prox,int pos){
        this.prox[pos] = (prox);
    }    
 
 public void setTabuleiro(Tabuleiro tabuleiro){
     this.tabuleiro = tabuleiro;
 }
 
 public Nodo getProx(int pos){
     return prox[pos];
 }
 
 public Tabuleiro getTabuleiro(){
     return tabuleiro;
 }
}
