/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porta;

/**
 *
 * @author Fernandinha
 */
public class PortaMain {
     public static void main (String [] args){
    //criando o objeto porta
    Porta porta1 = new Porta();
    //abrindo e fechando a porta
    porta1.abre();
    porta1.fecha();
    //pintando de azul
    porta1.pinta("azul");
    //pintando de vermelho
    porta1.pinta("vermelho");
    //verificando se está ou não aberta
    porta1.estaAberta();
   }
//fim da main
}
