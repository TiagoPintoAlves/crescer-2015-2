public class Elfo {
    private String nome;
    private int flechas = 42;
    private double experiencia = 0.0;
    
    public Elfo(String n, int flech) {
        nome = n;
        flechas = flech;
    }
    
    public atirarFlecha(this.flechas, this.experiencia){
        if(boolean acertar == true){
            flechas--;
            experiencia++;
        }else{
            flechas--;
        }
    }
}
