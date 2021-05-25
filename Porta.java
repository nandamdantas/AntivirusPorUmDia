
package porta;
public class Porta {

    protected boolean aberta;
    protected String cor;
    protected float altura;
    protected float largura;
 
   //get e set aberta
    
   public void setAberta(boolean aberta){
      if(aberta==true || aberta==false){
      this.aberta=aberta;
      }
   }
   
   public boolean getAberta(){
     return this.aberta;
   }

  //get e set cor

   public void setCor(String cor){
     if(!" ".equals(cor)){
     this.cor=cor;
     }
   }

   public String getCor(){
     return this.cor;
   }
  
  //get e set altura
   
   public void setAltura(float altura){
     if(altura>0){
     this.altura=altura;
     }
   }
   
   public float getAltura(){
     return this.altura;
   }
 
  //get e set largura

   public void setLargura(float largura){
     if(largura>0){
     this.largura=largura;
     }
   }

   public float setLargura(){
     return this.largura;
   }

  //método abrir porta

   public void abre(){
       this.aberta=true;
       }
 
  //método fechar porta

   public void fecha(){
     this.aberta=false;
   }       

  //método pintar porta
   
   public void pinta(String cor){
     this.cor=cor;
   }

  //verificar se esta aberta

   public boolean estaAberta(){
     if(aberta==true)
        return true;
     else
        return false;
    }
}