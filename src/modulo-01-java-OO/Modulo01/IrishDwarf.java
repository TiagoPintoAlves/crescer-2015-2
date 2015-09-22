public class IrishDwarf extends Dwarf{

    public IrishDwarf() {
    }

    public IrishDwarf(String nome) {
        super(nome);
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
        super(nome, dataNascimento);
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
}

