public class Elfo extends Personagem {
    private int flechas;
    private static int qtdElfosCriados;   

    public Elfo(String nome, int flechas) {
        this.nome = nome;
        this.flechas = flechas;
        this.status = Status.VIVO;
        this.vida = 100;
        this.qtdElfosCriados++;
    }

    /* Apenas para elucidar as diferenças entre int X Integer, esta duplicação não faz sentido.
    public Elfo(String nome, Integer flechas) {
    this(nome);
    if (flechas != null) {
    this.flechas = flechas;
    }
    }
     */

    public Elfo(String nome) {
        this(nome, 42);
        
    }

    public void atirarFlecha(Object obj) {
        flechas--;
        experiencia++;

        if(obj instanceof Dwarf){
            Dwarf dwarf = (Dwarf)obj;
            dwarf.receberFlechada();
        }else if(obj instanceof Orc){
            Orc orc = (Orc)obj;
            orc.levarAtaque();
        }
    }

    public int getFlechas() {
        return this.flechas;
    }
    
    public static int getQtdElfosCriados() {
        // return Elfo.qtdElfosCriados;
        return qtdElfosCriados;
    }
    
    public static void resetaContador() {
        qtdElfosCriados = 0;
    }

    public String toString() {

        boolean flechaNoSingular = Math.abs(this.flechas) == 1;
        boolean nivelNoSingular = Math.abs(this.experiencia) == 1;

        // Ruby ou CoffeeScript:
        //"#{nome} possui #{flechas} #{textoFlechas} e #{experiencia} #{textoNiveis} de experiência."

        // C# 6:
        //"\{nome} possui \{flechas} \{textoFlechas} e \{experiencia} \{textoNiveis} de experiência."

        return String.format("%s possui %d %s e %d %s de experiência.",
            this.nome,
            this.flechas,
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            nivelNoSingular ? "nível" : "níveis");
    }
    

}
