public class Elfo {
    
    private String nome;
    private int flechas = 42;
    private int experiencia = 0;
    
    public Elfo(String n, int arrows) {   // Constroi Elfo conforme informaçoes e testa o numero de flechas
        if(arrows > 0){
            GeradorElfo(n, arrows);       // Flechas = nao default
        }else{
            GeradorElfo(n, this.flechas); // Flechas = default
        }
    }
    
    public void GeradorElfo(String n, int arrows){ // Método gerador de elfos.
        nome = n;
        flechas = arrows;
    }
    
    public void atirarFlecha(int arrows){ // Possibilitando a ação do personagem.
            flechas--; 			// Já descontando as flechas e acrecentando Exp.
            experiencia++;
    }
}
