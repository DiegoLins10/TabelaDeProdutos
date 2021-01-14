
/**
 *
 * @author tecnico
 */
public class ListaLigada {
    private No inicio, fim;
    
    public ListaLigada(){
        inicio=null;
        fim=null;
    }
    
    public void adiciona(Produto p){
        if (inicio == null)
            adicionaInicio(p);
        else
            if (p.getCodigo() < inicio.dado.getCodigo()){
                adicionaInicio(p);
            } else if (p.getCodigo() > fim.dado.getCodigo()){
                adicionaFinal(p);
            } else{
                No aux1=inicio, aux2=inicio;
                No novo = new No(p);
                while (aux1!=null && p.getCodigo() > aux1.dado.getCodigo()){
                    aux2=aux1;
                    aux1=aux1.prox;
                }
                aux1.ant = novo;
                aux2.prox = novo;
                novo.ant = aux2;
                novo.prox = aux1;
            }
    }
    
    public void adicionaFinal(Produto p){
        No novo=new No(p);
        if (fim == null){
            inicio = novo;
        } else{
            novo.ant=fim;
            fim.prox =novo;
        }
        fim=novo;
    }
    
    public void adicionaInicio(Produto p){
        No novo=new No(p);
        if (inicio == null)
            fim = novo;
        novo.prox=inicio;
        inicio=novo;
    }
    
    public Produto remove(int codigo){
        Produto p=null;
        if (inicio==null){
            System.out.println("ERRO! Lista Vazia");
        } else {
            if (inicio.prox==null){
                if (inicio.dado.getCodigo()==codigo){
                    p=inicio.dado;
                    inicio=null;
                    fim=null;
                }
            } else {
                if (fim.dado.getCodigo()==codigo){
                    p=fim.dado;
                    fim=fim.ant;
                    fim.prox=null;
                }else
                if (inicio.dado.getCodigo()==codigo){
                    p=inicio.dado;
                    inicio=inicio.prox;
                    inicio.ant=null;
                } else {
                    No aux1=inicio,aux2=null;
                    while (aux1.prox!=null && aux1.dado.getCodigo()!=codigo){
                        aux2=aux1;
                        aux1=aux1.prox;
                    }
                    if (aux1.dado.getCodigo()==codigo){
                        p=aux1.dado;
                        aux2.prox=aux1.prox;
                    } else {
                        System.out.println("Produto nao encontrado");
                    }
                }
             }
          }
        return p;
    }
    
    public String toString(){
        String s="";
        if (inicio == null){
            System.out.println("Lista Vazia");
        } else {
            No aux=inicio;
            while (aux!=null){
                //System.out.print(" "+aux.dado.getCodigo()+"-"+aux.dado.getQuantidade());
                s = s + '\n' + aux.dado.toString();
                aux=aux.prox;
        }
        }
        return s;
    }
}
