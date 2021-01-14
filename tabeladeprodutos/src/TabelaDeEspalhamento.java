
/**
 *
 * @author tecnico
 */
public class TabelaDeEspalhamento {
    private ListaLigada tabela[];
    
    public TabelaDeEspalhamento (int capMax){
        tabela = new ListaLigada[capMax];
    }
    
    public int funcaoDeEspalhamento(int chave){
        return chave/1000 - 2;
    }
    
    public void adiciona(int codigo, int quantidade){
        int i = funcaoDeEspalhamento(codigo);
        if (tabela[i]==null){
            tabela[i]=new ListaLigada();
        }
        tabela[i].adiciona(new Produto(codigo,quantidade));
    }
    
    public Produto remove (int codigo){
        Produto p = null;
        int i = funcaoDeEspalhamento(codigo);
        if (tabela[i] != null){
           p=tabela[i].remove(codigo);
        }
        else {
            System.out.println("Produto não encontrado");
        }
        return p;
    }
    
    public String toString(){
        String s = "";
        for (int i=0;i<tabela.length;i++){
            if (tabela[i]!=null){
                s = s + '\n' + tabela[i].toString();
            }
        }
        return s;
    }
}
