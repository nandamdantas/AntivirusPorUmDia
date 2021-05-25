package projeto.oo;

public class JogadorSuporte extends Jogador {

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

    public int getDado() {
        return this.dado;
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
    public JogadorSimples P1;

    public JogadorSuporte() {
        //implementar: o suporte só pode ser criado se existir um jogador simples
        this.setAtk(1);
        this.setDef(7);
        this.setPosicaox(2);//Terceira posicao do print
        this.setPosicaoy(2);//Terceira posicao do print
    }

    public void setDado(int d) {
        if (dado > 0 && dado <= 6) {
            this.dado = d;
        }
    }

    public void movimentar(int x, int y) {
        this.posicaox = x;
        this.posicaoy = y;
    }

    public void atacar() {

    }

    public void procurar() {
        //sortear um número aleatório de 1 a 6 (dado)
        if (this.dado > 1 && this.dado <= 3) {
            //nada é encontrado no setor
        }
        if (this.dado == 4) {
            this.def += 1;
        }
        if (this.dado == 5) {
            this.def += 2;
        }
        if (this.dado == 6) {
        }

    }

}
