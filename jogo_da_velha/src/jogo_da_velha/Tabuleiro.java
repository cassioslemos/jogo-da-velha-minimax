/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_da_velha;

/**
 *
 * @author cassi
 */
public class Tabuleiro {
    private char [] tabuleiro = tabuleiro = new char[9];
    
    public Tabuleiro(){
            tabuleiro[0] = ' ';
            tabuleiro[1] = ' ';
            tabuleiro[2] = ' ';
            tabuleiro[3] = ' ';
            tabuleiro[4] = ' ';
            tabuleiro[5] = ' ';
            tabuleiro[6] = ' ';
            tabuleiro[7] = ' ';
            tabuleiro[8] = ' ';
    
    }
    
    public void setPosicao (char jogador, int pos){
        tabuleiro[pos] = jogador;
    }
    
    public char getPosicao (int pos){
        return tabuleiro [pos];
    }
    
    public void copia(Tabuleiro aux){
        for(int i=0; i<9; i++){
            aux.setPosicao(tabuleiro[i], i);  
        }
    }
}
