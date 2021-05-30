package projeto.oo;

import java.util.ArrayList;
import java.util.Random;

public class Setores {

    private int tipo;
    private boolean visitado;
    private boolean portanorte;
    private boolean portasul;
    private boolean portaleste;
    private boolean portaoeste;
    private int posicaox;
    private int posicaoy;
    //private Inimigo inimigo;
    private ArrayList<Inimigo> inimigos = new ArrayList<>();

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Setores(int tipo) {
        this.tipo = tipo;
    }

    /*public Inimigo getInimigo() {
        return inimigo;
    }*/
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /*public void setInimigo(Inimigo inimigo) {
        this.inimigo = inimigo;
    }*/
    public ArrayList<Inimigo> getInimigos() {
        return inimigos;
    }

    public void setInimigos(ArrayList<Inimigo> inimigos) {
        this.inimigos = inimigos;
    }

    public boolean isPortanorte() {
        return portanorte;
    }

    public void setPortanorte(boolean portanorte) {
        this.portanorte = portanorte;
    }

    public boolean isPortasul() {
        return portasul;
    }

    public void setPortasul(boolean portasul) {
        this.portasul = portasul;
    }

    public boolean isPortaleste() {
        return portaleste;
    }

    public void setPortaleste(boolean portaleste) {
        this.portaleste = portaleste;
    }

    public boolean isPortaoeste() {
        return portaoeste;
    }

    public void setPortaoeste(boolean portaoeste) {
        this.portaoeste = portaoeste;
    }

    public int getPosicaox() {
        return posicaox;
    }

    public void setPosicaox(int posicaox) {
        this.posicaox = posicaox;
    }

    public int getPosicaoy() {
        return posicaoy;
    }

    public void setPosicaoy(int posicaoy) {
        this.posicaoy = posicaoy;
    }

    public void gerarPortas(Setores tabu[][], int x, int y) {
        Random random = new Random();

        int i = 0;

        i = random.nextInt(11);
        if (i > 3) {
            this.portaleste = true;
        } else {
            this.portaleste = false;
        }

        i = random.nextInt(11);
        if (i > 3) {
            this.portaoeste = true;
        } else {
            this.portaoeste = false;
        }

        i = random.nextInt(11);
        if (i > 3) {
            this.portanorte = true;
        } else {
            this.portanorte = false;
        }

        i = random.nextInt(11);
        if (i > 3) {
            this.portasul = true;
        } else {
            this.portasul = false;
        }

        if (x < 4) {
            if (tabu[x + 1][y].isVisitado()) {
                this.portasul = tabu[x + 1][y].isPortanorte();
            }
            tabu[x + 1][y].setPortanorte(portasul);
        }

        if (x > 0) {
            if (tabu[x - 1][y].isVisitado()) {
                this.portanorte = tabu[x - 1][y].isPortasul();
            }
            tabu[x - 1][y].setPortasul(portanorte);
        }

        if (y < 4) {
            if (tabu[x][y + 1].isVisitado()) {
                this.portaleste = tabu[x][y + 1].isPortaoeste();
            }
            tabu[x][y + 1].setPortaoeste(portaleste);
        }

        if (y > 0) {
            if (tabu[x][y - 1].isVisitado()) {
                this.portaoeste = tabu[x][y - 1].isPortaleste();
            }
            tabu[x][y - 1].setPortaleste(portaoeste);
        }
        
        if (x == 0){
            this.portanorte = false;
            tabu[0][y].setPortanorte(false);
        }
        
        if (x == 4){
            this.portasul = false;
            tabu[4][y].setPortasul(false);
        }
        
        if (y == 0){
            this.portaoeste = false;
            tabu[0][y].setPortaoeste(false);
        }
        
        if (y == 4){
            this.portaleste = false;
            tabu[4][y].setPortaleste(false);
        }
    }
}
