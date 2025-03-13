package Arrays;


import LinkedList.LinkedList;
import LinkedList.IteratorLinkedList;

import java.lang.reflect.Array;
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
//            binarySearch();
//        bubbleSort();
//        insertionSort();
//        selectionSort();
        heapSort();


        // nao estatico
//        EstruturaDados estrutura = new EstruturaDados();
//        estrutura.array();



    }

    // Metodo para gerar o vetor
    public int[] newVector(int pos) {
        int[] vector = new int[pos];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) Math.floor(Math.random() * vector.length);
        }

        return vector;

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



    // ----------------- ALGORITMOS DE ORDENAÇÃO ------------


    // Bubble Sort -> O(n^2)
    public static void bubbleSort() {
        int[] vector = new int[100000];

        // preenchendo vetor
        for(int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * vector.length);
        }

        long inicio = System.currentTimeMillis();
        long fim;
        int aux;
        // ordenando
        // vai percorrer o vetor com 2 pointeiros(i,j), i sendo fixo e j percorrendo o vetor
        // se valor na posição i for maior que o de j, invertem os valores e j passa para a próxima posição até terminar o vetor
        // quando j percorrer o vetor, i pula uma posição para voltar a repetir os passos anteriores
        for(int i = 0; i < vector.length; i++) {        // O(n)
            for(int j = i + 1; j < vector.length; j++) {    // O(n)
                if(vector[i] > vector[j]) {
                    aux = vector[j];
                    vector[j] = vector[i];
                    vector[i] = aux;
                }
            }
        }
        fim = System.currentTimeMillis();
        System.out.println("Tempo de ordenação do vetor: " + (fim - inicio) + " ms");

        // Complexidade péssima -> O(n^2)
//        for(int i = 0; i < vector.length; i++) {
//            System.out.print(vector[i] + " ");
//        }

    }


    // Insertion Sort
    public static void insertionSort() {
        int[] vector = new int[1000000];
        // Ordenação será feita durante a inserção dos valores

        for(int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * vector.length);
        }

        int aux;
        double inicio = System.currentTimeMillis();
        double fim;
        // Ordenando

        for(int i = 1; i < vector.length; i++) {
            aux = vector[i];    // pega a posição i dentro do vetor
            int j = i - 1;
            while(j >= 0 && vector[j] > aux) {
                vector[j+1] = vector[j];
                j--;
            }
            vector[j+1] = aux;
        }

//        for(int i = 0; i < vector.length; i++) {
//            System.out.print(vector[i] + " ");
//        }

        fim = System.currentTimeMillis();
        System.out.println("Tempo de ordenação do vetor: " + (fim - inicio)/1000 + " s");


    }


    // Selection Sort
    public static void selectionSort() {
        int[] vector = new int[1000];

        // preenchndo vetor
        for(int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * vector.length);
        }

        long inicio = System.currentTimeMillis();
        long fim;
        int posicao_menor, aux;
        // Vai percorrer o vetor com i fixo e j pulando as posições até encontrar um menor que o valor no vetor[i]
        // Quando encontrar, será a posicao menor que irá pular para a posição de i
        for(int i = 0; i < vector.length; i++) {
            posicao_menor = i;
            for(int j = i + 1; j < vector.length; j++) {
                if(vector[j] < vector[posicao_menor]) {
                     posicao_menor = j;
                }
                aux = vector[posicao_menor];
                vector[posicao_menor] = vector[i];
                vector[i] = aux;
            }
        }

        fim = System.currentTimeMillis();
        System.out.println("Tempo de ordenação do vetor: " + (fim - inicio) + " ms");



    }


    public static void heapSort() {
        // Criando vetor
        int[] vector = new EstruturaDados().newVector(10);

        System.out.println("Vetor desordenado");
        // Display do vetor com n posições
        for (int i : vector) {
            System.out.print(i + " ");
        }

        // Aplicando heap sort
        int tam = vector.length;

        for(int i = tam / 2 - 1; i >= 0; i--) {
            aplicaHeapSort(vector, tam, i);
        }

        System.out.println("\nQuase ordenado");
        for(int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }

        for(int i = tam-1; i > 0; i--) {
            int aux = vector[0];
            vector[0] = vector[i];
            vector[i] = aux;

            aplicaHeapSort(vector, i, 0);
        }

        System.out.println("\nVetor ordenado");
        for(int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }

    }

    public static void aplicaHeapSort(int[] vector, int tam, int i) {
        int raiz = i;
        int esquerda = 2*i + 1;
        int direita = 2*i + 2;
        if (esquerda < tam && vector[esquerda] > vector[raiz]) {
            raiz = esquerda;
        }
        if (direita < tam && vector[direita] > vector[raiz]) {
            raiz = direita;
        }

        if (raiz != i) {
            int aux = vector[i];
            vector[i] = vector[raiz];
            vector[raiz] = aux;

            aplicaHeapSort(vector, tam, raiz);
        }
    }
}



