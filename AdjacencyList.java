class MyNode{
    int data;
    MyNode next;

    MyNode(int data){
        this.data = data;
        this.next = null;
    }
}
class Graph{
    private MyNode[] adjList;
    private int vertices;

    public Graph(int vertices){
        this.vertices = vertices;
        adjList = new MyNode[vertices];
         for (int i = 0; i < vertices; i++){
             adjList[i] = null;
         }
    }
    public void addEdge(int src, int dest){
// src -> dest
        MyNode newNode = new MyNode(dest);
        newNode.next = adjList[src];
        adjList[src] = newNode;
        // dest -> src
        newNode = new MyNode(src);
        newNode.next = adjList[dest];
        adjList[dest] = newNode;
    }
    public void removeEdge(int src, int dest){
        adjList[src] = removeNode(adjList[src], dest);
        adjList[dest] = removeNode(adjList[dest], src);
    }
    private MyNode removeNode(MyNode head, int value){
//        list empty?
        if(head == null){
            return null;
        }
//        first node delete
        if(head.data == value){
            return head.next;
        }
        // last or mid value
        MyNode current = head;
        while(current.next != null){
            if(current.next.data == value){
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
        return head;
    }
    public void display(){
        for (int i = 0; i < vertices; i++){
            System.out.print(i + " -> ");
            MyNode temp = adjList[i];
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
public class AdjacencyList {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);

        System.out.println("Before Removing Edge: ");
        graph.display();

        graph.removeEdge(0,2);
        System.out.println("After Removing Edge (0-2): ");
        graph.display();
    }
}
