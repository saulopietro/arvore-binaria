package org.example;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();


// Inserir alguns valores
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) {
            arvore.inserir(v);
        }


        System.out.println("Buscar 40: " + arvore.buscar(40)); // true
        System.out.println("Buscar 25: " + arvore.buscar(25)); // false


        List<Integer> pre = arvore.preOrdem();
        List<Integer> em = arvore.emOrdem();
        List<Integer> pos = arvore.posOrdem();


        System.out.println("Pré-ordem: " + pre); // [50, 30, 20, 40, 70, 60, 80]
        System.out.println("Em-ordem: " + em); // [20, 30, 40, 50, 60, 70, 80] (ordenado)
        System.out.println("Pós-ordem: " + pos); // [20, 40, 30, 60, 80, 70, 50]
    }
}
