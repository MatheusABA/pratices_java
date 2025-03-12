package LinkedList;

public class ProgramInteger {

    public static void main(String[] args) {

        // Criando uma lista do TIPO Integer
        LinkedList<Integer> listInteger = new LinkedList<Integer>();


        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);

//        System.out.println(listInteger.getPrimeiro().getValor());
//        System.out.println(listInteger.getPrimeiro().getProximo().getValor());


        for(int i=0; i < listInteger.getTamanho(); i++) {
            System.out.println(listInteger.getByIndex(i).getValor());
        }
    }
}
