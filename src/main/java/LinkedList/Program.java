package LinkedList;

public class Program {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();


        list.add("MS");
        list.add("MT");
        list.add("CE");
        list.add("SP");
        list.add("RJ");

        System.out.println("Size: " + list.getTamanho());

        System.out.println("First node element: " + list.getPrimeiro().getValor());
        System.out.println("First element next node: " + list.getByIndex(0).getProximo().getValor());

        System.out.println("Last node element: " + list.getUltimo().getValor());

        list.remove("RJ");
        list.remove("SP");
        list.remove("CE");
        list.remove("MT");
        list.remove("MS");





        for(int i=0; i < list.getTamanho(); i++){
            if (list.getTamanho() == 0) {
                System.out.println("Linked List vazia");
                break;
            }
            System.out.println(list.getByIndex(i).getValor());
        }

    }
}
