package projeto.oo;

import java.util.Scanner;
import java.util.Random;

public class Principal {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        int ciclos = 0;
        Tabuleiro tabu = new Tabuleiro();
        JogadorSimples jogador1 = new JogadorSimples();
        JogadorSuporte jogador2 = new JogadorSuporte();
        Random random = new Random();
        tabu.gerarSetores();

        char opc = 'o';

        int linFonte = 0;
        int colFonte = 0;

        do {
            linFonte = random.nextInt(4);
            colFonte = random.nextInt(4);
        } while (linFonte == 2 && colFonte == 2);

        tabu.getTabu()[2][2].setPortaleste(true);
        tabu.getTabu()[2][2].setPortaoeste(true);
        tabu.getTabu()[2][2].setPortanorte(true);
        tabu.getTabu()[2][2].setPortasul(true);
        tabu.getTabu()[2][2].setVisitado(true);
        tabu.getTabu()[2][1].setPortaleste(true);
        tabu.getTabu()[3][2].setPortanorte(true);
        tabu.getTabu()[2][3].setPortaoeste(true);
        tabu.getTabu()[1][2].setPortasul(true);
        try{
        do {
            
            if(jogador1.getDef() == 0 && jogador2.getDef() == 0){
            System.out.println("Ambos os jogadores morreram");
            break;
            }
            
            if(jogador1.getDef() < 0){
                jogador1.setDef(0);
            }
            if(jogador2.getDef() < 0){
                jogador2.setDef(0);
            }

            if (ciclos == 0 && jogador2.getPosicaox() == 2 && jogador2.getPosicaoy() == 2) {

                Setores setorAux = tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()];

                System.out.println();
                System.out.println("|------Setor Inicial------|");
                System.out.println("|                         |");
                System.out.println("|                         |");
                System.out.println("|                         |");
                System.out.println("|                         |");
                System.out.println("|                         |");
                System.out.println("|    P1             P2    |");
                System.out.println("|    " + jogador1.getAtk() + "/" + jogador1.getDef() + "            " + jogador2.getAtk() + "/" + jogador2.getDef() + "   |");
                System.out.println("|                         |");
                System.out.println("|-------------------------|");
                System.out.println();
            }
            if (ciclos != 0 && jogador1.getPosicaox() == linFonte && jogador1.getPosicaoy() == colFonte) {

                Setores setorAux = tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()];

                System.out.println();
                System.out.println("|------Setor FonteX-------|");
                System.out.println("|                         |");
                System.out.println("|                         |");
                System.out.println("|                         |");
                System.out.println("|          FONTEX         |");
                System.out.println("|                         |");
                System.out.println("|            P1           |");
                System.out.println("|         " + jogador1.getAtk() + "/" + jogador1.getDef() + "          |");
                System.out.println("|                         |");
                System.out.println("|-------------------------|");
                System.out.println();
            }
            if (ciclos != 0 && jogador2.getPosicaox() == linFonte && jogador2.getPosicaoy() == colFonte) {

                Setores setorAux = tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()];

                System.out.println();
                System.out.println("|------Setor FonteX-------|");
                System.out.println("|                         |");
                System.out.println("|                         |");
                System.out.println("|                         |");
                System.out.println("|          FONTEX         |");
                System.out.println("|                         |");
                System.out.println("|            P1           |");
                System.out.println("|          " + jogador2.getAtk() + "/" + jogador2.getDef() + "          |");
                System.out.println("|                         |");
                System.out.println("|-------------------------|");
                System.out.println();
            }
            if (ciclos != 0 && jogador1.getPosicaox() == jogador2.getPosicaox() && jogador1.getPosicaoy() == jogador2.getPosicaoy()) {

                Setores setorAux = tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()];

                System.out.println();
                System.out.println("|--------Setor(" + (jogador2.getPosicaox() + 1) + "/" + (jogador2.getPosicaoy() + 1) + ")-------|");
                System.out.println("|                         |");
                for (Inimigo inimigo : setorAux.getInimigos()) {
                    System.out.println("            " + inimigo.getAtk() + "/" + inimigo.getDef());
                }
                System.out.println("|                         |");
                System.out.println("|                         |");
                System.out.println("|                         |");
                System.out.println("|    PL1           PL2    |");
                System.out.println("|    " + jogador1.getAtk() + "/" + jogador1.getDef() + "           " + jogador2.getAtk() + "/" + jogador2.getDef() + "    |");
                System.out.println("|                         |");
                System.out.println("|-------------------------|");
                System.out.println();
            } else if (ciclos != 0 && jogador1.getPosicaox() != jogador2.getPosicaox() && jogador1.getPosicaoy() != jogador2.getPosicaoy()) {

                Setores setorAux1 = tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()];
                Setores setorAux2 = tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()];

                System.out.println();
                System.out.println("|--------Setor(" + (jogador1.getPosicaox() + 1) + "/" + (jogador1.getPosicaoy() + 1) + ")-------|   |--------Setor(" + (jogador2.getPosicaox() + 1) + "/" + (jogador2.getPosicaoy() + 1) + ")-------|");
                System.out.println("|                         |   |                         |");
                for (Inimigo inimigo : setorAux1.getInimigos()) {
                    System.out.println("            " + inimigo.getAtk() + "/" + inimigo.getDef());
                }
                for (Inimigo inimigo : setorAux2.getInimigos()) {
                    System.out.println("                                          " + inimigo.getAtk() + "/" + inimigo.getDef());
                }
                System.out.println("|                         |   |                         |");
                System.out.println("|                         |   |                         |");
                System.out.println("|                         |   |                         |");
                System.out.println("|           PL1           |   |           PL2           |");
                System.out.println("|           " + jogador1.getAtk() + "/" + jogador1.getDef() + "           |   |           " + jogador2.getAtk() + "/" + jogador2.getDef() + "           |");
                System.out.println("|                         |   |                         |");
                System.out.println("|-------------------------|   |-------------------------|");
                System.out.println();

            } else if (ciclos != 0 && jogador1.getPosicaox() != jogador2.getPosicaox() && jogador1.getPosicaoy() == jogador2.getPosicaoy()) {

                Setores setorAux1 = tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()];
                Setores setorAux2 = tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()];

                System.out.println();
                System.out.println("|--------Setor(" + (jogador1.getPosicaox() + 1) + "/" + (jogador1.getPosicaoy() + 1) + ")-------|   |--------Setor(" + (jogador2.getPosicaox() + 1) + "/" + (jogador2.getPosicaoy() + 1) + ")-------|");
                System.out.println("|                         |   |                         |");
                for (Inimigo inimigo : setorAux1.getInimigos()) {
                    System.out.println("            " + inimigo.getAtk() + "/" + inimigo.getDef());
                }
                for (Inimigo inimigo : setorAux2.getInimigos()) {
                    System.out.println("                                          " + inimigo.getAtk() + "/" + inimigo.getDef());
                }
                System.out.println("|                         |   |                         |");
                System.out.println("|                         |   |                         |");
                System.out.println("|                         |   |                         |");
                System.out.println("|           PL1           |   |           PL2           |");
                System.out.println("|           " + jogador1.getAtk() + "/" + jogador1.getDef() + "           |   |           " + jogador2.getAtk() + "/" + jogador2.getDef() + "           |");
                System.out.println("|                         |   |                         |");
                System.out.println("|-------------------------|   |-------------------------|");
                System.out.println();
            } else if (ciclos != 0 && jogador1.getPosicaox() == jogador2.getPosicaox() && jogador1.getPosicaoy() != jogador2.getPosicaoy()) {

                Setores setorAux1 = tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()];
                Setores setorAux2 = tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()];

                System.out.println();
                System.out.println("|--------Setor(" + (jogador1.getPosicaox() + 1) + "/" + (jogador1.getPosicaoy() + 1) + ")-------|   |--------Setor(" + (jogador2.getPosicaox() + 1) + "/" + (jogador2.getPosicaoy() + 1) + ")-------|");
                System.out.println("|                         |   |                         |");
                for (Inimigo inimigo : setorAux1.getInimigos()) {
                    System.out.println("            " + inimigo.getAtk() + "/" + inimigo.getDef());
                }
                for (Inimigo inimigo : setorAux2.getInimigos()) {
                    System.out.println("                                          " + inimigo.getAtk() + "/" + inimigo.getDef());
                }
                System.out.println("|                         |   |                         |");
                System.out.println("|                         |   |                         |");
                System.out.println("|                         |   |                         |");
                System.out.println("|           PL1           |   |           PL2           |");
                System.out.println("|           " + jogador1.getAtk() + "/" + jogador1.getDef() + "           |   |           " + jogador2.getAtk() + "/" + jogador2.getDef() + "           |");
                System.out.println("|                         |   |                         |");
                System.out.println("|-------------------------|   |-------------------------|");
                System.out.println();
            }

            tabu.imprimir(jogador1, jogador2);
            System.out.println("Qual turno está: " + ciclos);
            if (jogador1.getPosicaox() == linFonte && jogador1.getPosicaoy() == colFonte) {
                System.out.println("Parabéns Player 1 você encontrou a FONTE X");
                break;
            }

            if (jogador2.getPosicaox() == linFonte && jogador2.getPosicaoy() == colFonte) {
                System.out.println("Parabéns Player 2 você encontrou a FONTE X");
                break;
            }

            if (ciclos == 0) {
                System.out.println("Digite a ação que deseja fazer");
                System.out.print("(M) para movimentar: ");
            } else if (ciclos == 1 || ciclos == 2 || ciclos == 5 || ciclos == 6 || ciclos == 9 || ciclos == 10 || ciclos == 13 || ciclos == 14 || ciclos == 17 || ciclos == 18 || ciclos == 21 || ciclos == 22 || ciclos == 25 || ciclos == 26 || ciclos == 29 || ciclos == 30 || ciclos == 33 || ciclos == 34 || ciclos == 37 || ciclos == 38 || ciclos == 41 || ciclos == 42 || ciclos == 45 || ciclos == 46 || ciclos == 49 || ciclos == 50) {
                System.out.println("Player 1 digite a ação que deseja fazer");
                System.out.print("(P) para procurar, (A) para atacar, (M) para movimentar: ");
            } else if (ciclos == 3 || ciclos == 4 || ciclos == 7 || ciclos == 8 || ciclos == 11 || ciclos == 12 || ciclos == 15 || ciclos == 16 || ciclos == 19 || ciclos == 20 || ciclos == 23 || ciclos == 24 || ciclos == 27 || ciclos == 28 || ciclos == 31 || ciclos == 32 || ciclos == 35 || ciclos == 36 || ciclos == 39 || ciclos == 40 || ciclos == 43 || ciclos == 44 || ciclos == 47 || ciclos == 48) {
                System.out.println("Player 2 digite a ação que deseja fazer");
                System.out.print("(R) para recuperar defesa, (P) para procurar, (A) para atacar, (M) para movimentar: ");
            }

            opc = input.next().charAt(0);

            if (ciclos == 0) {
                if (opc == 'M' || opc == 'm') {
                    int x = 0;
                    int y = 0;

                    do {
                        System.out.print("P1 Digite a linha que deseja ir: ");
                        x = input.nextInt();
                        x--;
                        if (x > 4 || x < 0) {
                            System.out.println("Tamanho não permitido");
                            continue;
                        }

                        System.out.print("P1 Digite a coluna que deseja ir: ");
                        y = input.nextInt();
                        y--;
                        if (y > 4 || y < 0) {
                            System.out.println("Tamanho não permitido");
                            continue;
                        }

                        int difex = jogador1.getPosicaox() - x;
                        int difey = jogador1.getPosicaoy() - y;

                        if (difex < 0) {
                            difex = difex * -1;
                        }

                        if (difey < 0) {
                            difey = difey * -1;
                        }

                        if ((difex == 1 && difey == 0) || (difex == 0 && difey == 1)) {
                            break;
                        } else {
                            System.out.println("Movimente somente para os setores vizinhos");
                            continue;
                        }

                    } while (true);

                    jogador1.movimentar(x, y);

                    if (tabu.getTabu()[x][y].isVisitado() == false) {
                        tabu.getTabu()[x][y].gerarPortas(tabu.getTabu(), x, y);
                        tabu.getTabu()[x][y].setVisitado(true);

                    }

                    do {
                        System.out.print("P2 Digite a linha que deseja ir: ");
                        x = input.nextInt();
                        x--;

                        if (x > 4 || x < 0) {
                            System.out.println("Tamanho não permitido");
                            continue;
                        }

                        System.out.print("P2 Digite a coluna que deseja ir: ");
                        y = input.nextInt();
                        y--;

                        if (y > 4 || y < 0) {
                            System.out.println("Tamanho não permitido");
                            continue;
                        }

                        int difex = jogador2.getPosicaox() - x;
                        int difey = jogador2.getPosicaoy() - y;

                        if (difex < 0) {
                            difex = difex * -1;
                        }

                        if (difey < 0) {
                            difey = difey * -1;
                        }

                        if ((difex == 1 && difey == 0) || (difex == 0 && difey == 1)) {
                            break;
                        } else {
                            System.out.println("Movimente somente para os setores vizinhos");
                            continue;
                        }

                    } while (true);

                    jogador2.movimentar(x, y);

                    if (tabu.getTabu()[x][y].isVisitado() == false) {
                        tabu.getTabu()[x][y].gerarPortas(tabu.getTabu(), x, y);
                        tabu.getTabu()[x][y].setVisitado(true);

                    }

                }
                ciclos++;
                continue;
            }
            if (ciclos == 1 || ciclos == 2 || ciclos == 5 || ciclos == 6 || ciclos == 9 || ciclos == 10 || ciclos == 13 || ciclos == 14 || ciclos == 17 || ciclos == 18 || ciclos == 21 || ciclos == 22 || ciclos == 25 || ciclos == 26 || ciclos == 29 || ciclos == 30 || ciclos == 33 || ciclos == 34 || ciclos == 37 || ciclos == 38 || ciclos == 41 || ciclos == 42 || ciclos == 45 || ciclos == 46 || ciclos == 49 || ciclos == 50) {

                if (opc == 'M' || opc == 'm') {
                    Setores setorAux1 = tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()];
                    if (setorAux1.getInimigos().size() <= 0) {
                        int x = 0;
                        int y = 0;

                        do {
                            System.out.print("P1 Digite a linha que deseja ir: ");
                            x = input.nextInt();
                            x--;

                            if (x > 4 || x < 0) {
                                System.out.println("Tamanho não permitido");
                                continue;
                            }

                            System.out.print("P1 Digite a coluna que deseja ir: ");
                            y = input.nextInt();
                            y--;

                            if (y > 4 || y < 0) {
                                System.out.println("Tamanho não permitido");
                                continue;
                            }

                            int difex = jogador1.getPosicaox() - x;
                            int difey = jogador1.getPosicaoy() - y;

                            if (difex < 0) {
                                difex = difex * -1;
                            }

                            if (difey < 0) {
                                difey = difey * -1;
                            }

                            if ((difex == 1 && difey == 0) || (difex == 0 && difey == 1)) {
                                break;
                            } else {
                                System.out.println("Movimente somente para os setores vizinhos");
                                continue;
                            }

                        } while (true);

                        if (x < jogador1.getPosicaox()) {
                            if (tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()].isPortanorte() == true ) {
                                jogador1.movimentar(x, y);
                                if (tabu.getTabu()[x][y].isVisitado() == false) {
                                    tabu.getTabu()[x][y].gerarPortas(tabu.getTabu(), x, y);
                                    tabu.getTabu()[x][y].setVisitado(true);

                                }
                            } else {
                                System.out.println("Não tem porta nessa direção");
                            }
                        }
                        if (x > jogador1.getPosicaox()) {
                            if (tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()].isPortasul() == true ) {
                                jogador1.movimentar(x, y);
                                if (tabu.getTabu()[x][y].isVisitado() == false) {
                                    tabu.getTabu()[x][y].gerarPortas(tabu.getTabu(), x, y);
                                    tabu.getTabu()[x][y].setVisitado(true);

                                }
                            } else {
                                System.out.println("Não tem porta nessa direção");
                            }
                        }
                        if (y < jogador1.getPosicaoy()) {
                            if (tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()].isPortaoeste() == true ) {
                                jogador1.movimentar(x, y);
                                if (tabu.getTabu()[x][y].isVisitado() == false) {
                                    tabu.getTabu()[x][y].gerarPortas(tabu.getTabu(), x, y);
                                    tabu.getTabu()[x][y].setVisitado(true);

                                }
                            } else {
                                System.out.println("Não tem porta nessa direção");
                            }
                        }
                        if (y > jogador1.getPosicaoy()) {
                            if (tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()].isPortaleste() == true) {
                                jogador1.movimentar(x, y);
                                if (tabu.getTabu()[x][y].isVisitado() == false) {
                                    tabu.getTabu()[x][y].gerarPortas(tabu.getTabu(), x, y);
                                    tabu.getTabu()[x][y].setVisitado(true);

                                }
                            } else {
                                System.out.println("Não tem porta nessa direção");
                            }
                        }

                    } else {
                        System.out.println("Elimine os inimigos primeiro");
                    }
                    continue;
                } else if (opc == 'P' || opc == 'p') {
                    Setores setorAux1 = tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()];
                    //System.out.println("Tipo do setor: " + setorAux1.getTipo());
                    if (setorAux1.getTipo() != 2) {
                        int proc = random.nextInt(6) + 1;
                        if(proc < 4){
                            System.out.println("Nada encontrado na procura");
                            ciclos++;
                        }else if (proc == 4) {
                            jogador1.setDef(jogador1.getDef() + 1);
                            System.out.println("O Player1 ganhou +1 de defesa");
                            ciclos++;
                        } else if (proc == 5) {
                            jogador1.setDef(jogador1.getDef() + 2);
                            System.out.println("O Player1 ganhou +2 de defesa");
                            ciclos++;
                        } else if (proc == 6) {
                            Setores setorAux = tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()];
                            int posiInimi = 0;
                            for (Inimigo inimigo : setorAux.getInimigos()) {
                                inimigo.setDef(inimigo.getDef() - 1);
                                if (inimigo.getDef() <= 0) {
                                    setorAux.getInimigos().remove(posiInimi);
                                }
                            }
                            System.out.println("Um ou mais inimigos sofreram dano");
                            ciclos++;
                        }
                    } else {
                        System.out.println("O setor é privado");
                    }
                    
                } else if (opc == 'A' || opc == 'a') {
                    Setores setorAux1 = tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()];
                    if (setorAux1.getInimigos().size() > 0) {
                        int posiInimi = 0;
                        //do {
                        System.out.println("Digite 1 para atacar o primeiro inimigo ou assim respectivamente: ");
                        posiInimi = input.nextInt();
                        //} while (posiInimi != 1 || posiInimi != 2 || posiInimi != 3 || posiInimi != 4 || posiInimi != 5);
                        posiInimi--;
                        Inimigo inimigo = setorAux1.getInimigos().get(posiInimi);

                        if (setorAux1.getTipo() == 1) {
                            int dodge = 0;
                            dodge = random.nextInt(4);
                            if (dodge != 0) {
                                inimigo.setDef(inimigo.getDef() - jogador1.getAtk());
                                if (inimigo.getDef() <= 0) {
                                    setorAux1.getInimigos().remove(posiInimi);
                                }
                            } else {
                                System.out.println("O inimigo desviou");
                            }
                        } else {
                            inimigo.setDef(inimigo.getDef() - jogador1.getAtk());
                            if (inimigo.getDef() <= 0) {
                                setorAux1.getInimigos().remove(posiInimi);
                            }
                        }
                    } else {
                        System.out.println("Não há inimigos para atacar");
                    }
                    ciclos++;
                }
            } else if (ciclos == 3 || ciclos == 4 || ciclos == 7 || ciclos == 8 || ciclos == 11 || ciclos == 12 || ciclos == 15 || ciclos == 16 || ciclos == 19 || ciclos == 20 || ciclos == 23 || ciclos == 24 || ciclos == 27 || ciclos == 28 || ciclos == 31 || ciclos == 32 || ciclos == 35 || ciclos == 36 || ciclos == 39 || ciclos == 40 || ciclos == 43 || ciclos == 44 || ciclos == 47 || ciclos == 48) {

                if (opc == 'M' || opc == 'm') {
                    Setores setorAux1 = tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()];
                    if (setorAux1.getInimigos().size() <= 0) {
                        int x = 0;
                        int y = 0;
                        do {
                            System.out.print("P2 Digite a linha que deseja ir: ");
                            x = input.nextInt();
                            x--;

                            if (x > 4 || x < 0) {
                                System.out.println("Tamanho não permitido");
                                continue;
                            }

                            System.out.print("P2 Digite a coluna que deseja ir: ");
                            y = input.nextInt();
                            y--;

                            if (y > 4 || y < 0) {
                                System.out.println("Tamanho não permitido");
                                continue;
                            }

                            int difex = jogador2.getPosicaox() - x;
                            int difey = jogador2.getPosicaoy() - y;

                            if (difex < 0) {
                                difex = difex * -1;
                            }

                            if (difey < 0) {
                                difey = difey * -1;
                            }

                            if ((difex == 1 && difey == 0) || (difex == 0 && difey == 1)) {
                                break;
                            } else {
                                System.out.println("Movimente somente para os setores vizinhos");
                                continue;
                            }

                        } while (true);

                        if (x < jogador2.getPosicaox()) {
                            if (tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()].isPortanorte() == true) {
                                jogador2.movimentar(x, y);
                                if (tabu.getTabu()[x][y].isVisitado() == false) {
                                    tabu.getTabu()[x][y].gerarPortas(tabu.getTabu(), x, y);
                                    tabu.getTabu()[x][y].setVisitado(true);

                                }
                            } else {
                                System.out.println("Não tem porta nessa direção");
                            }
                        }
                        if (x > jogador2.getPosicaox()) {
                            if (tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()].isPortasul() == true) {
                                jogador2.movimentar(x, y);
                                if (tabu.getTabu()[x][y].isVisitado() == false) {
                                    tabu.getTabu()[x][y].gerarPortas(tabu.getTabu(), x, y);
                                    tabu.getTabu()[x][y].setVisitado(true);

                                }
                            } else {
                                System.out.println("Não tem porta nessa direção");
                            }
                        }
                        if (y < jogador2.getPosicaoy()) {
                            if (tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()].isPortaoeste() == true) {
                                jogador2.movimentar(x, y);
                                if (tabu.getTabu()[x][y].isVisitado() == false) {
                                    tabu.getTabu()[x][y].gerarPortas(tabu.getTabu(), x, y);
                                    tabu.getTabu()[x][y].setVisitado(true);

                                }
                            } else {
                                System.out.println("Não tem porta nessa direção");
                            }
                        }
                        if (y > jogador2.getPosicaoy()) {
                            if (tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()].isPortaleste() == true) {
                                jogador2.movimentar(x, y);
                                if (tabu.getTabu()[x][y].isVisitado() == false) {
                                    tabu.getTabu()[x][y].gerarPortas(tabu.getTabu(), x, y);
                                    tabu.getTabu()[x][y].setVisitado(true);

                                }
                            } else {
                                System.out.println("Não tem porta nessa direção");
                            }
                        }

                    } else {
                        System.out.println("Elimine os inimigos primeiro");
                    }
                    continue;
                } else if (opc == 'R' || opc == 'r') {
                    System.out.print("(W) para recuperar sua defesa ou (E) para recuperar defesa do P1: ");
                    char recu = 'o';
                    recu = input.next().charAt(0);
                    if (recu == 'W' || recu == 'w') {
                        jogador2.setDef(jogador2.getDef() + 2);
                    } else if (recu == 'E' || recu == 'e') {
                        if (jogador1.getPosicaox() == jogador2.getPosicaox() && jogador1.getPosicaoy() == jogador2.getPosicaoy()) {
                            jogador1.setDef(jogador1.getDef() + 2);
                        } else {
                            System.out.println("O jogador não está no mesmo setor");
                        }
                    }
                    ciclos++;
                } else if (opc == 'P' || opc == 'p') {
                    Setores setorAux1 = tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()];
                    //System.out.println("Tipo do setor: " + setorAux1.getTipo());
                    if (setorAux1.getTipo() != 2) {
                        int proc = random.nextInt(6) + 1;
                        
                        if(proc < 4){
                            System.out.println("Nada encontrado na procura");
                            ciclos++;
                        } else if (proc == 4) {
                            jogador2.setDef(jogador2.getDef() + 1);
                            System.out.println("O Player2 ganhou +1 de defesa");
                            ciclos++;
                        } else if (proc == 5) {
                            jogador2.setDef(jogador2.getDef() + 2);
                            System.out.println("O Player2 ganhou +2 de defesa");
                            ciclos++;
                        } else if (proc == 6) {
                            Setores setorAux = tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()];
                            int posiInimi = 0;
                            for (Inimigo inimigo : setorAux.getInimigos()) {
                                inimigo.setDef(inimigo.getDef() - 1);
                                if (inimigo.getDef() <= 0) {
                                    setorAux.getInimigos().remove(posiInimi);
                                }
                            }
                            System.out.println("Um ou mais inimigos sofreram dano");
                            ciclos++;
                        }
                    } else {
                        System.out.println("O setor é privado");
                    }
                } else if (opc == 'A' || opc == 'a') {
                    Setores setorAux1 = tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()];
                    if (setorAux1.getInimigos().size() > 0) {
                        int posiInimi = 0;
                        //do {
                        System.out.println("Digite 1 para atacar o primeiro inimigo ou assim respectivamente: ");
                        posiInimi = input.nextInt();
                        //} while (posiInimi != 1 || posiInimi != 2 || posiInimi != 3 || posiInimi != 4 || posiInimi != 5);
                        posiInimi--;
                        Inimigo inimigo = setorAux1.getInimigos().get(posiInimi);
                        if (setorAux1.getTipo() == 1) {
                            int dodge = 0;
                            dodge = random.nextInt(4);
                            if (dodge != 0) {
                                inimigo.setDef(inimigo.getDef() - jogador2.getAtk());
                                if (inimigo.getDef() <= 0) {
                                    setorAux1.getInimigos().remove(posiInimi);
                                }
                            } else {
                                System.out.println("O inimigo desviou");
                            }
                        } else {
                            inimigo.setDef(inimigo.getDef() - jogador2.getAtk());
                            if (inimigo.getDef() <= 0) {
                                setorAux1.getInimigos().remove(posiInimi);
                            }
                        }
                    } else {
                        System.out.println("Não há inimigos para atacar");
                    }
                    ciclos++;
                }
            }
            ciclos--;
            if (ciclos %4 == 0) {
                Setores setorAux1 = tabu.getTabu()[jogador2.getPosicaox()][jogador2.getPosicaoy()];
                if (setorAux1.getInimigos().size() > 0) {
                    for (Inimigo inimigo : setorAux1.getInimigos()) {
                        jogador2.setDef(jogador2.getDef() - inimigo.getAtk());
                    }
                }
                Setores setorAux = tabu.getTabu()[jogador1.getPosicaox()][jogador1.getPosicaoy()];
                if (setorAux.getInimigos().size() > 0) {

                    for (Inimigo inimigo : setorAux.getInimigos()) {
                        jogador1.setDef(jogador1.getDef() - inimigo.getAtk());
                    }
                }

            }
            ciclos++;
            if(jogador1.getDef() < 0){
                jogador1.setDef(0);
            }
            if(jogador2.getDef() < 0){
                jogador2.setDef(0);
            }
            if(ciclos == 50){
            System.out.println("Limite de turnos excedido ou algum player ganhou");
            break;
            }
        } while (ciclos <= 50);//Quando ciclos chegar até 50 ou um jogador chegar na fonte X ou quando a defesa dos dois forem 0
        }catch(IndexOutOfBoundsException e){
            System.err.println("Erro ao atacar inimigo inexistente");
        }
    }

}
