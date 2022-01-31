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
public class Arvore {

    private Nodo raiz;
    private char player;
    private int altura;
    private int cont;
    private int n_jogadas;

    public Arvore() {
        Tabuleiro tabuleiro = new Tabuleiro();
        raiz = new Nodo(tabuleiro);
        altura = 0;
        cont = 0;
        n_jogadas = 10;
    }

    public void setPlayer(char player) {
        this.player = player;
    }

    public char getPlayer() {
        return player;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public boolean tabCheio(Tabuleiro tabuleiro) {
        for (int i = 0; i < 9; i++) {
            if (tabuleiro.getPosicao(i) == ' ') {
                return false;
            }
        }
        return true;
    }

    public boolean tabVazio(Tabuleiro tabuleiro) {
        for (int i = 0; i < 9; i++) {
            if (tabuleiro.getPosicao(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public boolean fimdejogo(char jogador, Tabuleiro tabuleiro) {
        if ((tabuleiro.getPosicao(0) == jogador && tabuleiro.getPosicao(1) == jogador && tabuleiro.getPosicao(2) == jogador)
                || (tabuleiro.getPosicao(3) == jogador && tabuleiro.getPosicao(4) == jogador && tabuleiro.getPosicao(5) == jogador)
                || (tabuleiro.getPosicao(6) == jogador && tabuleiro.getPosicao(7) == jogador && tabuleiro.getPosicao(8) == jogador)
                || (tabuleiro.getPosicao(0) == jogador && tabuleiro.getPosicao(3) == jogador && tabuleiro.getPosicao(6) == jogador)
                || (tabuleiro.getPosicao(1) == jogador && tabuleiro.getPosicao(4) == jogador && tabuleiro.getPosicao(7) == jogador)
                || (tabuleiro.getPosicao(2) == jogador && tabuleiro.getPosicao(5) == jogador && tabuleiro.getPosicao(8) == jogador)
                || (tabuleiro.getPosicao(6) == jogador && tabuleiro.getPosicao(4) == jogador && tabuleiro.getPosicao(2) == jogador)
                || (tabuleiro.getPosicao(0) == jogador && tabuleiro.getPosicao(4) == jogador && tabuleiro.getPosicao(8) == jogador)) {
            return true;
        }
        return false;
    }

    public void criarNodo(Nodo aux, int i) {
        Nodo novonodo;
        char jogador;
        Tabuleiro auxtab;
        int i2;
        if (player == 'X') {
            jogador = 'O';
        } else {
            jogador = 'X';
        }
        for (i2 = 0; aux.getProx(i2) != null && i2 < 9; i2++) {
        }
        if (aux.getTabuleiro().getPosicao(i) == ' ' && !this.fimdejogo(jogador, aux.getTabuleiro()) && !this.fimdejogo(player, aux.getTabuleiro())) {
           // if(raiz.getProx(2)!=null &&raiz.getProx(2).getProx(0)!=null && raiz.getProx(2).getProx(0).getProx(6)!=null && raiz.getProx(2).getProx(0).getProx(6).getProx(3) != null && raiz.getProx(2).getProx(0).getProx(6).getProx(3).getProx(3)!=null && aux == raiz.getProx(2).getProx(0).getProx(6).getProx(3).getProx(3))
           // System.out.println(i);
            if (aux.getJogada() == 0) {
                //chama max(aux.prox(i2), jogada, jogador)
                auxtab = new Tabuleiro();
                aux.getTabuleiro().copia(auxtab);
                auxtab.setPosicao(jogador, i);
                //System.out.println(auxtab.getPosicao(0)+" "+auxtab.getPosicao(1)+" "+auxtab.getPosicao(2)+"\n"+auxtab.getPosicao(3)+" "+auxtab.getPosicao(4)+" "+auxtab.getPosicao(5)+"\n"+auxtab.getPosicao(6)+" "+auxtab.getPosicao(7)+" "+auxtab.getPosicao(8)+"\n");
                //System.out.println(cont);
                novonodo = new Nodo(auxtab);
                novonodo.setJogada(1);
                novonodo.setValorMinmax(1);
                novonodo.setProfundidade(aux.getProfundidade() + 1);
                aux.setProx(novonodo, i2);
                novonodo.setAnt(aux);
                cont++;
            } else {
                //chama min(aux.prox(i2), jogada, player)
                auxtab = new Tabuleiro();
                aux.getTabuleiro().copia(auxtab);
                auxtab.setPosicao(player, i);
                //System.out.println(auxtab.getPosicao(0)+" "+auxtab.getPosicao(1)+" "+auxtab.getPosicao(2)+"\n"+auxtab.getPosicao(3)+" "+auxtab.getPosicao(4)+" "+auxtab.getPosicao(5)+"\n"+auxtab.getPosicao(6)+" "+auxtab.getPosicao(7)+" "+auxtab.getPosicao(8)+"\n");
                //System.out.println(cont);
                novonodo = new Nodo(auxtab);
                novonodo.setJogada(0);
                novonodo.setValorMinmax(-1);
                novonodo.setProfundidade(aux.getProfundidade() + 1);
                aux.setProx(novonodo, i2);
                novonodo.setAnt(aux);
                cont++;
            }
        }
    }

    public void criararvore(Nodo aux) {
        if (aux.getProx(0) != null) {
            this.criararvore(aux.getProx(0));
        } else {
            this.criarNodo(aux, 0);
        }
        if (aux.getProx(1) != null) {
            this.criararvore(aux.getProx(1));
        } else {
            this.criarNodo(aux, 1);
        }
        if (aux.getProx(2) != null) {
            this.criararvore(aux.getProx(2));
        } else {
            this.criarNodo(aux, 2);
        }
        if (aux.getProx(3) != null) {
            this.criararvore(aux.getProx(3));
        } else {
            this.criarNodo(aux, 3);
        }
        if (aux.getProx(4) != null) {
            this.criararvore(aux.getProx(4));
        } else {
            this.criarNodo(aux, 4);
        }
        if (aux.getProx(5) != null) {
            this.criararvore(aux.getProx(5));
        } else {
            this.criarNodo(aux, 5);
        }
        if (aux.getProx(6) != null) {
            this.criararvore(aux.getProx(6));
        } else {
            this.criarNodo(aux, 6);
        }
        if (aux.getProx(7) != null) {
            this.criararvore(aux.getProx(7));
        } else {
            this.criarNodo(aux, 7);
        }
        if (aux.getProx(8) != null) {
            this.criararvore(aux.getProx(8));
        } else {
            this.criarNodo(aux, 8);
        }
    }

    public void procuraJogada(int pos) {
        for (int i = 0; raiz.getProx(i) != null && i < 9; i++) {
            if (raiz.getProx(i).getTabuleiro().getPosicao(pos) == player) {
                raiz = raiz.getProx(i);
                return;
            }
        }
    }

    public void zerarProx() {
        for (int i = 0; i < 9; i++) {
            raiz.setProx(null, i);
        }
    }

    public void expandindoArvore() {
        while (altura < n_jogadas) {
            this.criararvore(raiz);
            altura++;
        }
        //  n_jogadas=9;
         // altura=0;
        //  System.out.println(cont);
        //   cont=0;
    }

    public void setRaiz(Nodo novaraiz) {
        raiz = novaraiz;
    }

    public void explorarArvore(Nodo aux) {
        if (aux.getProx(0) != null) {
            for(int i=0; aux.getProx(i)!=null && i<9; i++)
                this.explorarArvore(aux.getProx(i));
            for (int i = 0; aux.getProx(i) != null && i < 9; i++) {
                if (aux.getJogada() == 1) {
                    if (aux.getValorMinmax() == 1 && aux.getProx(i).getValorMinmax() == -1) {
                        aux.setValorMinmax(aux.getProx(i).getValorMinmax());
                    } else {
                        if (aux.getValorMinmax() == 1 && aux.getProx(i).getValorMinmax() == 0) {
                            aux.setValorMinmax(aux.getProx(i).getValorMinmax());
                        } else {
                            if (aux.getValorMinmax() == 0 && aux.getProx(i).getValorMinmax() == -1) {
                                aux.setValorMinmax(aux.getProx(i).getValorMinmax());
                            }
                        }
                    }
                } else {
                    if (aux.getJogada() == 0) {
                        if (aux.getValorMinmax() == -1 && aux.getProx(i).getValorMinmax() == 1) {
                            aux.setValorMinmax(aux.getProx(i).getValorMinmax());
                                 
                        } else {
                            if (aux.getValorMinmax() == -1 && aux.getProx(i).getValorMinmax() == 0) {
                                aux.setValorMinmax(aux.getProx(i).getValorMinmax());
                            } else {
                                if (aux.getValorMinmax() == 0 && aux.getProx(i).getValorMinmax() == 1) {
                                    aux.setValorMinmax(aux.getProx(i).getValorMinmax());
                                }
                            }
                        }
                    }
                }
            }

            // System.out.println(aux.getValorMinmax());
        } else {
                char jogador;
                if (player == 'X') {
                    jogador = 'O';
                } else {
                    jogador = 'X';
                }
                if (this.fimdejogo(player, aux.getTabuleiro()) || this.fimdejogo(jogador, aux.getTabuleiro())) {
                    if (this.fimdejogo(player, aux.getTabuleiro())) {
                        aux.setValorMinmax(-1);
                    } else {
                        aux.setValorMinmax(1);
                    }
                } else {
                    aux.setValorMinmax(0);
                }
        }
        
    }

    public void novaRaiz(Nodo aux) {
        /*for (int i = 0; aux.getProx(0).getProx(i) != null && i < 9; i++) {
            System.out.println(aux.getProx(0).getProx(i).getValorMinmax());
        }*/
        for (int i = 0; aux.getProx(i) != null && i < 9; i++) {
            if (aux.getProx(i).getValorMinmax() == 1) {
                raiz = aux.getProx(i);
                return;
            }
        }
        /* for(int i=0; aux.getProx(i)!= null && i<9; i++){
        for(int i3=0;aux.getProx(i).getProx(i3)!= null && i3<9; i3++ ){
           // System.out.println(aux.getProx(i).getTabuleiro().getPosicao(0)+" "+aux.getProx(i).getTabuleiro().getPosicao(1)+" "+aux.getProx(i).getTabuleiro().getPosicao(2)+"\n"+aux.getProx(i).getTabuleiro().getPosicao(3)+" "+aux.getProx(i).getTabuleiro().getPosicao(4)+" "+aux.getProx(i).getTabuleiro().getPosicao(5)+"\n"+aux.getProx(i).getTabuleiro().getPosicao(6)+" "+aux.getProx(i).getTabuleiro().getPosicao(7)+" "+aux.getProx(i).getTabuleiro().getPosicao(8)+"\n");
           //System.out.println(player);
          if(this.fimdejogo(player, aux.getProx(i).getProx(i3).getTabuleiro())){
             //System.out.println("teste");
            for(int i2=0;i2<9;i2++){
                if(aux.getTabuleiro().getPosicao(i2)!=aux.getProx(i).getProx(i3).getTabuleiro().getPosicao(i2) && aux.getProx(i).getProx(i3).getTabuleiro().getPosicao(i2)==player){
                    if(player=='X'){
                        aux.getTabuleiro().setPosicao('O', i2);
                    }
                    else{
                        aux.getTabuleiro().setPosicao('X', i2);
                    }
                }
            }
            return;
        }
        }
    }*/
        for (int i = 0; aux.getProx(i) != null && i < 9; i++) {
            if (aux.getProx(i).getValorMinmax() == 0) {
                raiz = aux.getProx(i);
                return;
            }
        }
        raiz = aux.getProx(0);
    }

}
