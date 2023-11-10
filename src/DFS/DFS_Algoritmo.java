package DFS;

public class DFS_Algoritmo {
    public int[] DFS(int origen, GrafoMA grafo, int[] marca, int[] p){
        marca[origen] = 1; // Marca el vértice actual como gris

        // Obtener los vértices adyacentes al vértice actual
        ConjuntoTDA adyacentes = grafo.Adyacentes(origen);
        while (!adyacentes.ConjuntoVacio()) {
            int v = adyacentes.Elegir();// Selecciona un vértice adyacente
            adyacentes.Sacar(v); // Elimina el vértice seleccionado de los adyacentes

            if (marca[v] == 0) { // Si el vértice adyacente no ha sido visitado
                p[v] = origen;  // Establece el predecesor del vértice adyacente como el origen actual
                System.out.println("Se va desde " + origen + " a " + v); // Imprime el predecesor actual, se puede comentar
                DFS(v, grafo, marca, p); //Llama al DFS recursivamente para el vertice adyacente
            }
        }
        marca[origen] = 2; // marca como negro el vértice actual como negro una vez que se hayan explorado todos sus adyacentes
        return p; //Lista de predecesores
    }
    public int[] DFS_FOREST(GrafoMA grafo) {
        int v = grafo.getCantNodos(); // Obtener el tamaño de la matriz de adyacencia
        int[] marca = new int[v]; // Crear una matriz para marcar los vértices
        int[] p = new int[v]; // Crear una matriz para almacenar los predecesores


        // Inicializar todos los vértices como no visitados y sin predecesor (-1)
        for (int i = 0; i < v; i++) {
            marca[i] = 0;
            p[i] = -1;
        }

        // Iterar sobre todos los vértices
        for (int i = 0; i < v; i++) {
            if (marca[i] == 0) {
                DFS(i, grafo, marca, p); // Llamar al método DFS para cada vértice no visitado
            }
        }
        return p; // Devolver la lista de predecesores una vez completado el recorrido DFS
    }
}
