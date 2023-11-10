package Prim;



public class Main {



    public static void main(String[] args) {
        Prim prim = new Prim();


        GrafoND grafo = new GrafoND();
        grafo.inicializarGrafo();

        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);



        grafo.agregarArista(0, 3, 5);
        grafo.agregarArista(0, 1, 6);
        grafo.agregarArista(0, 2, 1);
        grafo.agregarArista(1, 2, 5);
        grafo.agregarArista(1, 4, 3);
        grafo.agregarArista(2, 4, 6);
        grafo.agregarArista(2, 5, 4);
        grafo.agregarArista(2, 3, 5);
        grafo.agregarArista(3, 5, 2);
        grafo.agregarArista(4, 5, 6);
        prim.prim(grafo);


    }
}