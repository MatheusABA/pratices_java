package LinkedList;

public class Program {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();


        list.add("MS");
        list.add("MT");

        System.out.println("Size: " + list.getTamanho());

        System.out.println("First node element: " + list.getPrimeiro().getValor());
        System.out.println("First element next node: " + list.getByIndex(0).getProximo().getValor());

        System.out.println("Last node element: " + list.getUltimo().getValor());

    }
}
