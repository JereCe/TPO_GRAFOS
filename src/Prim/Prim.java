package Prim;

import java.util.ArrayList;


public class Prim {
    private ArrayList<Arista> aristasDelArbol = new ArrayList<>();

    public int prim(GrafoND grafo) {
        int cantNodos = grafo.cantNodos;
        int[] padre = new int[cantNodos];
        int[] peso = new int[cantNodos];
        boolean[] visitado = new boolean[cantNodos];

        // Inicialización y lógica del algoritmo de Prim...

        for (int i = 0; i < cantNodos; i++) {
            peso[i] = Integer.MAX_VALUE;
            visitado[i] = false;
        }

        peso[0] = 0;
        padre[0] = -1;

        for (int i = 0; i < cantNodos - 1; i++) {
            int u = minPeso(peso, visitado, cantNodos);
            visitado[u] = true;

            for (int v = 0; v < cantNodos; v++) {
                if (grafo.existeArista(u, v) && !visitado[v] && grafo.pesoArista(u, v) < peso[v]) {
                    padre[v] = u;
                    peso[v] = grafo.pesoArista(u, v);
                }
            }
        }

        for (int i = 1; i < cantNodos; i++) {
            int origen = padre[i];
            int destino = i;
            int pesoArista = peso[i];
            aristasDelArbol.add(new Arista(origen, destino, pesoArista));
        }

        printArbolMinimo();
        int pesoTotal = calcularPesoTotal(grafo);
        System.out.println("Peso total del árbol de expansión mínima: " + pesoTotal);

        return pesoTotal;
    }

    private int minPeso(int[] peso, boolean[] visitado, int cantNodos) {
        int min = Integer.MAX_VALUE;
        int minIndice = -1;

        for (int v = 0; v < cantNodos; v++) {
            if (!visitado[v] && peso[v] < min) {
                min = peso[v];
                minIndice = v;
            }
        }

        return minIndice;
    }

    private int calcularPesoTotal(GrafoND grafo) {
        int pesoTotal = 0;
        for (Arista arista : aristasDelArbol) {
            pesoTotal += arista.peso;
        }
        return pesoTotal;
    }

    private void printArbolMinimo() {
        System.out.println("Árbol de recorrido mínimo:");

        for (Arista arista : aristasDelArbol) {
            System.out.println(arista.origen + " - " + arista.destino + "    " + arista.peso);
        }
    }
}