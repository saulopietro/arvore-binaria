package org.example;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {

    private Node raiz;


    public ArvoreBinaria() {
        this.raiz = null;
    }


    // Inserir valor público (encapsula a chamada recursiva)
    public void inserir(int valor) {
// Chamada recursiva inicia aqui
        raiz = inserirRec(raiz, valor);
    }

    // Função recursiva que insere e retorna o nó raiz atualizado
    private Node inserirRec(Node atual, int valor) {
// Caso base: chegamos a um ponto vazio, criamos o nó
        if (atual == null) {
            return new Node(valor);
        }


// Caso recursivo: descer para a subárvore esquerda ou direita
        if (valor < atual.valor) {
// chamada recursiva para inserir na subárvore esquerda
            atual.esquerda = inserirRec(atual.esquerda, valor);
        } else if (valor > atual.valor) {
// chamada recursiva para inserir na subárvore direita
            atual.direita = inserirRec(atual.direita, valor);
        } // se for igual, não insere (ou poderia tratar duplicatas)


        return atual; // retorna o nó atual (possivelmente atualizado)
    }



    // Buscar valor na árvore — interface pública
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }


    // Função recursiva de busca
    private boolean buscarRec(Node atual, int valor) {
// Caso base: nó nulo significa não encontrado
        if (atual == null) {
            return false;
        }


        if (atual.valor == valor) {
            return true; // encontrado
        }


// escolher subárvore com base na propriedade BST
        if (valor < atual.valor) {
// chamada recursiva para a esquerda
            return buscarRec(atual.esquerda, valor);
        } else {
// chamada recursiva para a direita
            return buscarRec(atual.direita, valor);
        }
    }

    // --- Percursos que retornam listas ---


    public List<Integer> preOrdem() {
        List<Integer> resultado = new ArrayList<>();
        preOrdemRec(raiz, resultado);
        return resultado;
    }


    private void preOrdemRec(Node atual, List<Integer> res) {
// Caso base: nó nulo, nada a fazer
        if (atual == null) return;
// Visita raiz
        res.add(atual.valor);
// Percorre recursivamente a subárvore esquerda
        preOrdemRec(atual.esquerda, res);
// Percorre recursivamente a subárvore direita
        preOrdemRec(atual.direita, res);
    }


    public List<Integer> emOrdem() {
        List<Integer> resultado = new ArrayList<>();
        emOrdemRec(raiz, resultado);
        return resultado;
    }

    private void emOrdemRec(Node atual, List<Integer> res) {
// Caso base: nó nulo
        if (atual == null) return;
// Primeiro percorre a esquerda
        emOrdemRec(atual.esquerda, res);
// Depois visita a raiz
        res.add(atual.valor);
// Por fim percorre a direita
        emOrdemRec(atual.direita, res);
    }


    public List<Integer> posOrdem() {
        List<Integer> resultado = new ArrayList<>();
        posOrdemRec(raiz, resultado);
        return resultado;
    }


    private void posOrdemRec(Node atual, List<Integer> res) {
// Caso base: nó nulo
        if (atual == null) return;
// Esquerda
        posOrdemRec(atual.esquerda, res);
// Direita
        posOrdemRec(atual.direita, res);
// Raiz
        res.add(atual.valor);
    }
}
