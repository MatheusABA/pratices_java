package LinkedList;

import java.util.Iterator;

public class LinkedList<TIPO> {
    private Elemento<TIPO> primeiro;
    private Elemento<TIPO> ultimo;
    private int tamanho;

    // Metodo construtor
    public LinkedList() {
        this.tamanho = 0;
    }

    /**
     * Retorna o primeiro valor dentro da lista
     * @return Valor retornado => 1ro Elemento
     */
    public Elemento<TIPO> getPrimeiro() {

        return primeiro;


    }

    public void setPrimeiro(Elemento<TIPO> primeiro) {
        this.primeiro = primeiro;
    }

    public Elemento<TIPO> getUltimo() {

        return ultimo;
    }

    public void setUltimo(Elemento<TIPO> ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void add(TIPO value) {
        // Instanciando classe Elemento
        Elemento<TIPO> novoElemento = new Elemento<TIPO>(value);

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
    public void remove(TIPO value) {
        Elemento<TIPO> atual = this.primeiro;
        Elemento<TIPO> anterior = null;


        // Percorrendo a lista caso o elemento não for primeiro nem ultimo
        for (int i = 0; i < this.getTamanho(); i++) {
            // Se encontrar o elemento desejado
            if(atual.getValor().equals(value.toString())) {

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

    public Elemento<TIPO> getByIndex(int index) {
        Elemento<TIPO> atual = this.primeiro;   // Valor atual
        for (int i = 0; i < index; i++) {   // Irá percorrer a lista
            if (atual.getProximo() != null) { // Verifica se o valor atual possui próximo
                atual = atual.getProximo();     // Se ele possui próximo, o valor atual passa a ser o próximo.
            }
        }
        return atual;
    }


    public IteratorLinkedList<TIPO> getIterator() {
        return new IteratorLinkedList<TIPO>(this.primeiro);
    }

}
