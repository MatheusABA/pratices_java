package Arrays;


import LinkedList.LinkedList;
import LinkedList.IteratorLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EstruturaDados {

    public static void main(String[] args) {
        // metodo estatico -> não precisa instanciar a classe
        // metodo nao estatico -> precisa instanciar

        // Metodos a serem executados

        // estatico
//        matriz();
//        array();
//        linearSearch("S");
//        vectorXlinkedlistPerformance();
//        linearSearch();
            binarySearch();

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
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i].equals(valor)) {
                System.out.println("Valor encontrado na posição " + i);
                break;
            } else if (!arrayList[i].equals(valor) && i == arrayList.length - 1) {
                System.out.println("Valor não encontrado dentro do array percorrido");
                break;
            }
        }
    }

    public static void linearSearch() {
        // Pior busca, complexidade O(n)
        int[] vector = new int[10];

        System.out.print("[ ");
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 10);     // Casting passando (int) para transformar double -> int
            System.out.print(vector[i]+ " ");
        }
        System.out.print("]");

        System.out.println(" Qual numero vc deseja buscar?");
        Scanner scanner = new Scanner(System.in);
        int search = scanner.nextInt();

        boolean founded = false;
        int i;
        for(i = 0; i < vector.length; i++) {
            if (vector[i] == search) {
                founded = true;
                i = i;
                break;
            }
        }
        System.out.println((founded) ? "Valor encontrado "+i+" posição " : "Valor não encontrado");


    }

    // matriz
    public static void matriz() {
        int[][] matriz = new int[3][3];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }


    public static void array() {
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


    public static void vectorXlinkedlistPerformance() {
        // Comparando performance LinkedList x Vetor
        LinkedList<Integer> list = new LinkedList<Integer>();
        ArrayList<Integer> vector = new ArrayList<>();

        int lim = 10000000;
        long initialTime;
        long finalTime;

        // ------------------- Performance vector

        // add
        initialTime = System.currentTimeMillis();

        for(int i = 0; i < lim; i++) {
            vector.add(i);
        }
        finalTime = System.currentTimeMillis();
        System.out.println("Tempo de adição no vetor " + (finalTime - initialTime) + " ms");

        // get

        initialTime = System.currentTimeMillis();

        for(int i = 0; i < vector.size(); i++) {
            vector.get(i);
        }
        finalTime = System.currentTimeMillis();
        System.out.println("Tempo de busca no vetor " + (finalTime - initialTime) + " ms");

        // -------------------  Performance lista ligada
        initialTime = System.currentTimeMillis();

        // add
        for(int i = 0; i < lim; i++) {
            list.add(i);
        }
        finalTime = System.currentTimeMillis();
        System.out.println("Tempo de adição na lista " + (finalTime - initialTime) + " ms");

        // get with iterator
        IteratorLinkedList<Integer> iterator = list.getIterator();
        while(iterator.haveNextNode()) {
            iterator.getProximo();
        }
        finalTime = System.currentTimeMillis();
        System.out.println("Tempo de busca na lista " + (finalTime - initialTime) + " ms");
    }


    public static void binarySearch() {
        // Quebra o vetor no meio comparando o valor buscado com o valor do meio, fazendo buscas à
        // esquerda caso o valor for menor que o do meio e a direita caso contrário, voltando a quebrar em partes até achar
        // Caso o fim inveta de posição com o início, significa que o valor não foi achado
        // [ n1, n2, n3, n4, n5 ]
        // inicio   meio      fim
        // Complexidade O(log n) -> complexidade ideal


        int[] vector = new int[1000000];

        for(int i = 0; i < vector.length; i++) {
            vector[i] = i*2;
//            System.out.print(vector[i]+ " ");
        }

        System.out.println("Qual numero vc deseja buscar?");
        Scanner scanner = new Scanner(System.in);
        int search = scanner.nextInt();

        boolean founded = false;
        int inicio = 0;
        int fim = vector.length - 1;
        int meio;

        int contador = 0;       // verificar quantas iterações foram feitas

        while(inicio <= fim) {  // O loop irá existir até encontrar o valor ou inverter inicio e fim quando o valor não existir no array
            meio = (int) (inicio + fim) / 2;    // casting para pegar a parte inteira
            contador++;
            if(vector[meio] == search) {
                founded = true;
                System.out.println("Valor encontrado na posição "+meio);
                break;
            } else if(vector[meio] < search) {  // Se o valor buscado for maior que o meio, o valor estará à direita do vetor
                inicio = meio + 1;
                meio = (int) (inicio + fim) / 2;
            } else {    // Se o valor buscado for menor que o meio, estará à esquerda do vetor
                fim = meio - 1;
                meio = (int) (inicio + fim) / 2;
            }
        }
        System.out.println("Quantidade de iterações "+contador);
        if(!founded) System.out.println("Valor não encontrado");



    }


    public static void bubbleSort() {

    }

}

