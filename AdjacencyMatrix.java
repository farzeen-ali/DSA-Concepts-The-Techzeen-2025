class AdjacencyMatrixGraph{
    private int[][] matrix;
    private int vertices;

    public AdjacencyMatrixGraph(int vertices){
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    public void addEdge(int src, int dest, int weight){
        matrix[src][dest] = weight;
        matrix[dest][src] = weight;
    }
    public void removeEdge(int src, int dest){
        matrix[src][dest] = 0;
        matrix[dest][src] = 0;
    }
    public boolean hasEdge(int src, int dest){
        return matrix[src][dest] != 0;
    }
    public void display(){
        System.out.println("Adjacency Matrix: ");
        for (int i = 0; i < vertices; i++){
            for (int j = 0; j < vertices; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class AdjacencyMatrix {
    public static void main(String[] args) {
    AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(4);

    graph.addEdge(0,1,10);
    graph.addEdge(0,2,15);
    graph.addEdge(1,3,20);
    graph.addEdge(2,3,25);

    graph.display();

        System.out.println("Is City 0 connected to 2? " + graph.hasEdge(0,2));
        graph.removeEdge(0,2);
        System.out.println("Is City 0 connected to 2? " + graph.hasEdge(0,2));
    }
}
