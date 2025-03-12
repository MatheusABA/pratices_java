package LinkedList;

public class Program {
    public static void main(String[] args) {


        LinkedList<String> list = new LinkedList<String>();


        list.add(String.valueOf(3));
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

        System.out.println("Size: " + list.getTamanho());
        for(int i=0; i < list.getTamanho(); i++){
            System.out.println(list.getByIndex(i).getValor());
        }

    }
}
