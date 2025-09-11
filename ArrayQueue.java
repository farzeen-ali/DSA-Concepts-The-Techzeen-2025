public class ArrayQueue {
    int[] arr;
    int front, rear;
    int capacity;
    int count;

    public ArrayQueue(int size){
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(int item){
        if(isFull()){
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
        System.out.println("Inserted: " + item);
    }

    public int dequeue(){
        if (isEmpty()){
            System.out.println("Queue Underflow");
            return -1;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        count--;
        return item;
    }
    public int peek(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }
    public boolean isEmpty(){
        return (count == 0);
    }
    public boolean isFull(){
        return (count == capacity);
    }
    public void printQueue(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue Elements: ");
        for (int i = 0; i < count; i++){
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.printQueue();

        int removed = queue.dequeue();
        System.out.println("Dequeued element is: " + removed);

        queue.enqueue(50);
        queue.printQueue();
    }
}
