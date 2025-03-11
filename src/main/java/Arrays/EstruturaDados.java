package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class EstruturaDados {

    public static void main(String[] args) {
        // metodo estatico -> não precisa instanciar a classe
        // metodo nao estatico -> precisa instanciar

        // Metodos a serem executados
        // estatico
//        matriz();
//        array();
        linearSearch("S");

        // nao estatico
//        EstruturaDados estrutura = new EstruturaDados();
//        estrutura.array();
    }

    // busca linear
    public static void linearSearch(String valor) {
        // Inicializando o array com valor já setados
        String[] arrayList = new String[]{"SP","DF","RJ","ES","PR","RS","MS","MT","AM","MA","PA","PE"};
        System.out.println("Array: " + Arrays.toString(arrayList));
        // Percorre pelo tamanho do array
        for (int i = 0; i <= arrayList.length; i++) {
            if (arrayList[i].equals(valor)) {
                System.out.println("Valor encontrado na posição " + i);
                break;
            } else if (!arrayList[i].equals(valor) && i == arrayList.length - 1) {
                System.out.println("Valor não encontrado dentro do array percorrido");
                break;
            }
        }
    }


    // matriz inicial
    public static void matriz() {
        int[][] matriz = new int[3][3];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }


    public void array() {
        // Criando matriz 3x3 inicialmente
        int[][] array = new int[3][];


        // Alterando cada linha para ter um Array de X colunas dentro
        array[0] = new int[5];  // Linha 0 -> 5 colunas
        array[1] = new int[7];  // Linha 1 -> 7 colunas
        array[2] = new int[4];  // Linha 2 -> 4 colunas

        // int[] => o que a matriz irá percorrer
        // baseArray => variável temporária que irá percorrer pelo int[]
        // array => onde a variável baseArray irá percorrer
        // pode ser substituido por -> for(int = 0; array.length(); i++)
        for (int[] baseArray: array) {
            System.out.println("-------------");
            for(int index: baseArray) {
                System.out.print(baseArray[index] + " ");
            }
            System.out.println();
        }
    }

}

