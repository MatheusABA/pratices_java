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

    public void remove(String value) {


    }

    public Elemento getByIndex(int index) {
        Elemento aux = this.primeiro;   // Valor atual
        for (int i = 0; i < index; i++) {   // Irá percorrer a lista
            if (aux.getProximo() != null) { // Verifica se o valor atual possui próximo
                aux = aux.getProximo();     // Se ele possui próximo, o valor atual passa a ser o próximo.
            }
        }
        return aux;
    }
}
