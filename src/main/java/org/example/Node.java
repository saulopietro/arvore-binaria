package org.example;

public class Node {
    public int valor;
    public Node esquerda;
    public Node direita;


    public Node(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}