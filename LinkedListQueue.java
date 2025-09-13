class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedListQueue {
    private Node front, rear;
    private int size;

    public LinkedListQueue(){
        this.front = this.rear = null;
        this.size = 0;
    }
    public void enqueue(int item){
        Node newNode = new Node(item);
        if (rear == null){
            front = rear = newNode;
            System.out.println("Inserted: " + item);
        }
        else {
            rear.next = newNode;
            rear = newNode;
            System.out.println("Inserted: " + item);
        }
        size++;
    }

    public int dequeue(){
        if(front == null) {
            System.out.println("Queue Underflow - Nothing to Delete!");
            return -1;
        }
        int value = front.data;
        front = front.next;
        if (front == null){
           rear = null;
        }
        size--;
        return value;
    }

    public int peek(){
        if (front == null){
            System.out.println("Queue is Empty!");
            return -1;
        }
        return front.data;
    }
    public int getSize(){
        return size;
    }
    public void printQueue(){
        if (front == null){
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Queue Elements: ");
        Node temp = front;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue();
        int size = queue.getSize();
        System.out.println("Size: " + size);

        System.out.println("Front Element: " + queue.peek());

        int removed = queue.dequeue();
        System.out.println("Removed: " + removed);
        queue.printQueue();
    }
}
