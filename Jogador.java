package projeto.oo;

public abstract class Jogador {

    protected int atk;
    protected int def;
    protected int posicaox;
    protected int posicaoy;
    protected int dado;

    public abstract void movimentar(int x, int y);

    public abstract void atacar();

    public abstract void procurar();
}
