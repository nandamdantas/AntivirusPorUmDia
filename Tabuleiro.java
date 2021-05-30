package projeto.oo;

import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro {

    private Setores tabu[][] = new Setores[5][5];
    private Random random = new Random();

    public Setores[][] getTabu() {
        return tabu;
    }

    public void setTabu(Setores[][] tabu) {
        this.tabu = tabu;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void gerarSetores() {
        int valor = 0;
        for (int i = 0; i < tabu.length; i++) {
            for (int j = 0; j < tabu[i].length; j++) {

                tabu[i][j] = new Setores(random.nextInt(3));
                
                int numini = 1;
                int numini2 = 0;

                int chance = random.nextInt(10);
                
                if (chance < 3) {
                    numini2 = random.nextInt(6);
                } else {
                    numini2 = random.nextInt(4);
                }
                
                do {
                    do {
                        valor = random.nextInt(4);
                    } while (valor == 0);
                    
                    
                    Inimigo inimigo = new Inimigo(valor, valor);
                    
                    tabu[i][j].getInimigos().add(inimigo);
                    numini++;
                    
                } while (numini < numini2);
            }
        }
    }

    public void imprimir(JogadorSimples jogador1, JogadorSuporte jogador2) {
        //System.out.println("    -Antivírus por um dia-\n");

        System.out.print("      1   2   3   4   5");

        System.out.println();

        for (int i = 0; i < tabu.length; i++) {
            System.out.print("    |");

            for (int j = 0; j < tabu.length; j++) {
                if (tabu[i][j].isPortanorte()) {
                    System.out.print("-*-|");
                } else {
                    System.out.print("---|");
                }
            }
            System.out.println();

            System.out.print(i+1 + "   |");

            for (int j = 0; j < tabu.length; j++) {
                if (jogador2.getPosicaox() == i && jogador2.getPosicaoy() == j && jogador1.getPosicaox() == i && jogador1.getPosicaoy() == j) {
                    if (tabu[i][j].isPortaleste()) {
                        System.out.print(" P *");
                    } else {
                        System.out.print(" P |");
                    }
                } else if (jogador1.getPosicaox() == i && jogador1.getPosicaoy() == j) {
                    if (tabu[i][j].isPortaleste()) {
                        System.out.print(" A *");
                    } else {
                        System.out.print(" A |");
                    }
                } else if (jogador2.getPosicaox() == i && jogador2.getPosicaoy() == j) {
                    if (tabu[i][j].isPortaleste()) {
                        System.out.print(" B *");
                    } else {
                        System.out.print(" B |");
                    }
                } else {
                    if (tabu[i][j].isPortaleste()) {
                        System.out.print("   *");
                    } else {
                        System.out.print("   |");
                    }
                }

            }

            System.out.println();
        }

        System.out.println("    |---|---|---|---|---|");

    }
}
