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

        System.out.println("First node element: " + list.getPrimeiro().getValor());

        System.out.println("Last node element: " + list.getUltimo().getValor());


        System.out.println("Array");
        for(int i=0; i < list.getTamanho(); i++){
            System.out.println(list.getByIndex(i).getValor());
        }

    }
}
