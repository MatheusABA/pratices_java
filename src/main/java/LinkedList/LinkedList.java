package LinkedList;

public class LinkedList {
    private Elemento primeiro;
    private Elemento ultimo;
    private int tamanho;

    // Metodo construtor
    public LinkedList() {
        this.tamanho = 0;
    }

    /**
     * Retorna o primeiro valor dentro da lista
     * @return Valor retornado => 1ro Elemento
     */
    public Elemento getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Elemento primeiro) {
        this.primeiro = primeiro;
    }

    public Elemento getUltimo() {
        return ultimo;
    }

    public void setUltimo(Elemento ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void add(String value) {
        // Instanciando classe Elemento
        Elemento novoElemento = new Elemento(value);

        // Se ambas as posições estiverem vazias, o primeiro valor toma elas
        if (this.primeiro == null && this.ultimo == null) {
            // Ele será o primeiro e ultimo elemento caso for o unico valor da lista
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;
        } else {
            // Caso a primeira estiver ocupada, registra o novo valor como seu próximo, e após isso, adiciona o novo valor como último
            this.ultimo.setProximo(novoElemento);
            this.ultimo = novoElemento;
        }
        this.tamanho++;
    }

    // Remove elemento da lista
    public void remove(String value) {
        Elemento atual = this.primeiro;
        Elemento anterior = null;


        // Percorrendo a lista caso o elemento não for primeiro nem ultimo
        for (int i = 0; i < this.getTamanho(); i++) {
            // Se encontrar o elemento desejado
            if(atual.getValor().equalsIgnoreCase(value)) {


                if (this.tamanho == 1) {   // Verificando caso seja o unico elemento da lista
                    System.out.println("Elemento "+value+" eliminado");
                    this.primeiro = null;
                    this.ultimo = null;
                } else if(atual == this.primeiro) { // Verificando caso seja o primeiro
                    System.out.println("Elemento "+value+" eliminado");
                    this.primeiro = atual.getProximo();              // Ele coloca como primeiro o próximo do valor atual
                    atual.setProximo(null);
                    return;
                } else if(atual == this.ultimo) { // Verificando caso seja o último
                    System.out.println("Elemento "+value+" eliminado");
                    this.ultimo = anterior;
                    anterior.setProximo(null);
                } else {
                    //Eliminando caso nao for primeiro nem ultimo
                    System.out.println("Elemento removido: " + atual.getValor());
                    anterior.setProximo(atual.getProximo());
                    atual = null;
                }
                this.tamanho--;
                break;
            }
            // Quando o valor atual pular para a próxima posição, o anterior passa a ser o valor atual antes de pular
            anterior = atual;
            atual = atual.getProximo();
        }


    }

    public Elemento getByIndex(int index) {
        Elemento atual = this.primeiro;   // Valor atual
        for (int i = 0; i < index; i++) {   // Irá percorrer a lista
            if (atual.getProximo() != null) { // Verifica se o valor atual possui próximo
                atual = atual.getProximo();     // Se ele possui próximo, o valor atual passa a ser o próximo.
            }
        }
        return atual;
    }


}
