package DFS;

import java.util.ArrayList;
import java.util.Arrays;

public class MainTestDFS {
    public static void main(String[] args) {
        GrafoMA grafo = new GrafoMA();
        grafo.InicializarGrafo();
        GrafoMA grafo1 = new GrafoMA();
        grafo1.InicializarGrafo();

        // Agregar vértices
        grafo1.AgregarVertice(0);
        grafo1.AgregarVertice(1);
        grafo1.AgregarVertice(2);
        grafo1.AgregarVertice(3);
        grafo1.AgregarVertice(4);
        grafo1.AgregarVertice(5);
        grafo1.AgregarVertice(6);

        // Agregar aristas
        grafo1.AgregarArista(0, 1, 1);
        grafo1.AgregarArista(0, 2, 1);
        grafo1.AgregarArista(0, 3, 1);
        grafo1.AgregarArista(1, 4, 1);
        grafo1.AgregarArista(1, 5, 1);
        grafo1.AgregarArista(2, 6, 1);
        grafo1.AgregarArista(3, 6, 1);
        grafo1.AgregarArista(4, 5, 1);
        grafo1.AgregarArista(5, 6, 1);


        // Agregar vértices
        grafo.AgregarVertice(0);
        grafo.AgregarVertice(1);
        grafo.AgregarVertice(2);
        grafo.AgregarVertice(3);
        grafo.AgregarVertice(4);
        grafo.AgregarVertice(5);
        grafo.AgregarVertice(6);

        // Agregar aristas
        grafo.AgregarArista(0, 1, 1);
        grafo.AgregarArista(1, 2, 1);
        grafo.AgregarArista(1, 4, 1);
        grafo.AgregarArista(2, 5, 1);
        grafo.AgregarArista(4, 2, 1);
        grafo.AgregarArista(5, 4, 1);
        grafo.AgregarArista(3, 5, 1);
        grafo.AgregarArista(3, 6, 1);
        grafo.AgregarArista(6, 6, 1);


        DFS_Algoritmo dfs = new DFS_Algoritmo();
        int vv = grafo.getCantNodos();

        //System.out.println("Llamada a DFS empezando desde 0");
        //int[]a = dfs.DFS(0,grafo,new int[vv],new int[vv]);
        //System.out.println("----------------------------------");
        //System.out.println("Llamada a DFS empezando desde 3");
        //int[]b = dfs.DFS(3,grafo,new int[vv],new int[vv]);
        //System.out.println("----------------------------------");

        // Imprime la relacion entre los vertices y la lista de predecesores que retorna DFS_FOREST
        System.out.println("Llamada a DFS_FOREST");
        int[] pp = dfs.DFS_FOREST(grafo);
        System.out.println("-----------------------");
        System.out.println("Relaciones entre la lista P y los vertices: ");
        int[] n = new int[grafo.cantNodos];
        ConjuntoTDA v = grafo.Vertices();
        for(int x = grafo.cantNodos-1; x >= 0;x-- ) {
            n[x] = v.Elegir();
            v.Sacar(v.Elegir());
        }
        for (int i = 0; i < grafo.cantNodos;i++){
            System.out.println("Padre: " + pp[i] + "  Hijo: " + n[i]);

        }

    }
}
