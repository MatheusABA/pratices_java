package LinkedList;

public class ProgramClient {

    public static void main(String[] args) {

        // Criando uma lista do TIPO Client
        LinkedList<Client> clients = new LinkedList<Client>();

        clients.add(new Client("Matheus", "matheus@gmail.com","2839222","67827213391"));
        clients.add(new Client("Joao", "joao@gmail.com","283928222","67421827391"));
        clients.add(new Client("Felipe", "felipe@gmail.com","245239222","6782751391"));
        clients.add(new Client("Pedro", "pedro@gmail.com","2835129222","678265427391"));

//        clients.getTamanho();

        for(int i=0; i < clients.getTamanho(); i++) {
            System.out.println(clients.getByIndex(i).getValor());
        }

    }



}
