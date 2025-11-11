README — Árvore Binária de Busca (BST) com Recursividade
Parte 1 – Conceito e Explicação
1. O que é recursividade?

Recursividade é uma técnica de programação em que uma função chama a si mesma para resolver subproblemas menores de um mesmo tipo até atingir um caso base, que é a condição de parada. Cada chamada reduz o problema até chegar a uma situação simples que pode ser resolvida diretamente.

Exemplo:

int fatorial(int n) {
    if (n == 0) return 1; // caso base
    return n * fatorial(n - 1); // chamada recursiva
}
2. Como a recursividade é usada na percorrência (travessia) de uma árvore binária?

A recursividade é usada para visitar os nós de uma árvore de forma estruturada, pois cada subárvore é uma nova árvore. A função visita o nó atual e chama a si mesma para visitar os nós à esquerda e à direita.

Pré-ordem: raiz → esquerda → direita

Em-ordem: esquerda → raiz → direita

Pós-ordem: esquerda → direita → raiz

Cada chamada recursiva cuida de uma subárvore, e o caso base ocorre quando o nó é null (ou seja, a árvore terminou naquele caminho).

3. Qual a diferença entre recursão e laço (for/while)?

Recursão: usa chamadas de função para repetir uma tarefa. É mais natural para estruturas como árvores ou grafos, pois cada parte é uma subestrutura. Usa a pilha de chamadas da linguagem para armazenar o estado.

Laço (for/while): repete blocos de código até uma condição ser falsa. É mais eficiente em termos de memória, mas menos intuitivo para estruturas hierárquicas.

Resumo: a recursão é mais intuitiva para problemas que se dividem em partes menores, enquanto os laços são melhores para repetições lineares.

Parte 2 – Implementação da Árvore Binária de Busca (BST)
Estrutura de classes

Node.java: representa cada nó da árvore.

ArvoreBinaria.java: contém os métodos recursivos de inserção, busca e percursos.

Main.java: executa testes práticos.

Código fonte
Node.java
public class Node {
    int valor;
    Node esquerda, direita;


    public Node(int valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}
ArvoreBinaria.java
import java.util.ArrayList;
import java.util.List;


public class ArvoreBinaria {
    private Node raiz;


    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }


    private Node inserirRec(Node atual, int valor) {
        if (atual == null) {
            return new Node(valor); // caso base
        }
        if (valor < atual.valor)
            atual.esquerda = inserirRec(atual.esquerda, valor);
        else if (valor > atual.valor)
            atual.direita = inserirRec(atual.direita, valor);
        return atual;
    }


    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }


    private boolean buscarRec(Node atual, int valor) {
        if (atual == null) return false; // caso base
        if (atual.valor == valor) return true;
        return valor < atual.valor ? buscarRec(atual.esquerda, valor) : buscarRec(atual.direita, valor);
    }


    public List<Integer> preOrdem() {
        List<Integer> lista = new ArrayList<>();
        preOrdemRec(raiz, lista);
        return lista;
    }


    private void preOrdemRec(Node atual, List<Integer> lista) {
        if (atual == null) return; // caso base
        lista.add(atual.valor);
        preOrdemRec(atual.esquerda, lista);
        preOrdemRec(atual.direita, lista);
    }


    public List<Integer> emOrdem() {
        List<Integer> lista = new ArrayList<>();
        emOrdemRec(raiz, lista);
        return lista;
    }


    private void emOrdemRec(Node atual, List<Integer> lista) {
        if (atual == null) return;
        emOrdemRec(atual.esquerda, lista);
        lista.add(atual.valor);
        emOrdemRec(atual.direita, lista);
    }


    public List<Integer> posOrdem() {
        List<Integer> lista = new ArrayList<>();
        posOrdemRec(raiz, lista);
        return lista;
    }


    private void posOrdemRec(Node atual, List<Integer> lista) {
        if (atual == null) return;
        posOrdemRec(atual.esquerda, lista);
        posOrdemRec(atual.direita, lista);
        lista.add(atual.valor);
    }
}
Main.java
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();


        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) {
            arvore.inserir(v);
        }


        System.out.println("Buscar 40: " + arvore.buscar(40));
        System.out.println("Buscar 25: " + arvore.buscar(25));


        List<Integer> pre = arvore.preOrdem();
        List<Integer> em = arvore.emOrdem();
        List<Integer> pos = arvore.posOrdem();


        System.out.println("Pré-ordem: " + pre);
        System.out.println("Em-ordem: " + em);
        System.out.println("Pós-ordem: " + pos);
    }
}
Evidências de execução

Saída esperada:

Buscar 40: true
Buscar 25: false
Pré-ordem: [50, 30, 20, 40, 70, 60, 80]
Em-ordem: [20, 30, 40, 50, 60, 70, 80]
Pós-ordem: [20, 40, 30, 60, 80, 70, 50]
Critérios atendidos
