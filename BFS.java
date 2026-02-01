class BFSNode{
    int data;
    BFSNode next;

    BFSNode(int data){
        this.data = data;
        this.next = null;
    }
}

class MyQueue{
    int[] arr;
    int front, rear, capacity, count;

    MyQueue(int size){
        this.capacity = size;
        arr = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }
    boolean isEmpty(){
        return count == 0;
    }
    void enqueue(int data){
        if(count < capacity){
            rear = (rear + 1) % capacity;
            arr[rear] = data;
            count++;
        }
    }
    int dequeue(){
        if(count > 0){
            int data = arr[front];
            front = (front + 1) % capacity;
            count --;
            return data;
        }
        return -1;
    }
}
 class BFSGraph{
    private BFSNode[] adjList;
    private int vertices;

    BFSGraph(int vertices){
        this.vertices = vertices;
        adjList = new BFSNode[vertices];
        for (int i = 0; i < vertices; i++){
            adjList[i] = null;
        }
    }

    void addEdge(int src, int dest){
//        source to destination
        BFSNode newNode = new BFSNode(dest);
        newNode.next = adjList[src];
        adjList[src] = newNode;
        // dest to source
        newNode = new BFSNode(src);
        newNode.next = adjList[dest];
        adjList[dest] = newNode;
    }

    void bfs(int start){
        boolean[] visited = new boolean[vertices];
        MyQueue queue = new MyQueue(vertices);

        visited[start] = true;
        queue.enqueue(start);

        System.out.println("Emergency Alert Broadcast Order: ");
        while(!queue.isEmpty()){
            int current = queue.dequeue();
            System.out.print("Area: " + current+ " ");

            BFSNode temp = adjList[current];
            while(temp != null){
                if (!visited[temp.data]){
                    visited[temp.data] = true;
                    queue.enqueue(temp.data);
                }
                temp = temp.next;
            }
        }
        System.out.println();
    }
 }

public class BFS {
//    0: Hospital, 1: Market, 2: School, 3: Mall, 4: Residential
    public static void main(String[] args) {
    BFSGraph area = new BFSGraph(5);
    area.addEdge(0,1); // H-Mt
    area.addEdge(0,2); // H - S
    area.addEdge(1,3); // Mt - M
    area.addEdge(2,4); // S - R
    // 0 -> 2 -> 1 -> 4 -> 3

    area.bfs(0);
    }
}
