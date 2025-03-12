package LinkedList;

public class IteratorLinkedList<TIPO> {

    private Elemento<TIPO> elemento;

    public IteratorLinkedList(Elemento<TIPO> atual) {
        this.elemento = atual;
    }

    public boolean haveNextNode() {
        return elemento.getProximo() != null;
    }

    public Elemento<TIPO> getProximo() {
        elemento = elemento.getProximo();
        return elemento;
    }
}
