package projeto.oo;

public class Inimigo extends Jogador {
    //Métodos get

    public int getAtk() {
        return this.atk;
    }

    public int getDef() {
        return this.def;
    }

    public int getPosicaox() {
        return this.posicaox;
    }

    public int getPosicaoy() {
        return this.posicaoy;
    }
    //Métodos set

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setPosicaox(int posicaox) {
        this.posicaox = posicaox;
    }

    public void setPosicaoy(int posicaoy) {
        this.posicaoy = posicaoy;
    }

    public Inimigo(int atk, int def) {
        this.setAtk(atk);
        this.setDef(def);
    }

    public void atacar() {
    }

    public void procurar() {
    }

    public void movimentar(int x, int y) {
    }
}
