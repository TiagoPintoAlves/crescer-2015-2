public class IrishDwarf extends Dwarf{

    public IrishDwarf() {

    }

    public IrishDwarf(String nome) {

    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
        this(nome);
        this.dataNascimento = dataNascimento;
    }

    public void tentarSuperSorte(){
        if(gerarNumero() == -3333.0){
            for(Item item : this.mochila.getInventario()){
                int somaIndice=0;
                for(int i = item.getQuantidade(); i > 0; i--){
                    somaIndice += item.getQuantidade() - 1;
                }
                item.setQuantidade(item.getQuantidade()+ (somaIndice * 1000));
            }
        }
    }

    /*
    public void shimbalaie() {
    for(Item item : mochila.getInventario()){
    int pa = item.getQuantidade() * (item.getQuantidade()+1) / 2;
    item.setQuantidade(1000 + item.getQuantidade() * pa);
    }
    }
     */

    

}