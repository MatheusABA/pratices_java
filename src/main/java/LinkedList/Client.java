package LinkedList;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {

    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    public Client(String nome, String email, String cpf, String telefone) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String toString() {
        return this.nome + " " + this.email + " " + this.cpf + " " + this.telefone;
    }
}
