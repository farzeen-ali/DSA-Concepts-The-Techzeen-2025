class DFSNode{
    int data;
    DFSNode next;

    DFSNode(int data){
        this.data = data;
        this.next = null;
    }
}

class DFSGraph{
    private DFSNode[] adjList;
    private int vertices;

    public DFSGraph(int vertices){
        this.vertices = vertices;
        adjList = new DFSNode[vertices];
    }
    public void addEdge(int src, int dest){
        DFSNode n1 = new DFSNode(dest);
        n1.next = adjList[src];
        adjList[src] = n1;

        DFSNode n2 = new DFSNode(src);
        n2.next = adjList[dest];
        adjList[dest] = n2;
    }
    public void dfs(int start){
        boolean[] visited = new boolean[vertices];
        System.out.println("DFS Visit Order: ");
        dfsRec(start, visited);
    }
    private void dfsRec(int node, boolean[] visited){
        visited[node] = true;
        System.out.print("Area " + node + " ");

        DFSNode temp = adjList[node];

        while(temp != null){
            if (!visited[temp.data]){
                dfsRec(temp.data, visited);
            }
            temp = temp.next;
        }
    }
}

public class DFS {
    public static void main(String[] args) {
    DFSGraph city = new DFSGraph(5);

    city.addEdge(0,1);
    city.addEdge(0,2);
    city.addEdge(1,3);
    city.addEdge(2,4);
// 0->2->4->1->3
    city.dfs(0);
    }
}
