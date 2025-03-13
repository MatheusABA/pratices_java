package Recursividade;

public class Recursividade {

    public static void main(String[] args) {

        int[] vetor = new int[5];

//        for (int i = 0; i < vetor.length; i++) {
//            vetor[i] = (int) (Math.random() * vetor.length);
//            System.out.print(vetor[i] + " ");
//        }

//        System.out.println("\nResultado: " + soma(0,0, vetor));
        int num = 3;
//        System.out.println("Potência de 2^"+num+potencia_de_2(num));
//        System.out.println("Fatorial de "+num+": "+fatorial(num));
    }


    private static int soma(int res, int posicao, int[] vetor) {
        // vai chamar a função soma pulando de posição até chegar ao final
        if (posicao < vetor.length) {
            res = res + vetor[posicao];
            return soma(res,posicao+1, vetor);
        } else {
            return res;
        }

    }

    private static int potencia_de_2(int num) {

        if (num == 0) return 1;
        else return 2 * potencia_de_2(num-1);
    }

    private static int fatorial(int num) {
        if (num == 0) return 1;
        // ex -> num:2;     2 * fatorial(2-1) -> 2 * 1 * fatorial(0) -> 2 * 1 * 1 => 2
        else return num * fatorial(num-1);
    }
}
