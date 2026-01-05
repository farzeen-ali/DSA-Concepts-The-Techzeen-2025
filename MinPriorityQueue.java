public class MinPriorityQueue {
    private int[] heap;
    private int size;
    private int capacity;

    public MinPriorityQueue(int capacity){
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private int parent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return (2*i)+1;
    }
    private int rightChild(int i){
        return (2*i)+2;
    }
    private boolean hasParent(int i){
        return parent(i) >=0;
    }
    private boolean hasLeftChild(int i){
        return leftChild(i) < size;
    }
    private boolean hasRightChild(int i){
        return rightChild(i) < size;
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int value){
        if(size == capacity){
            System.out.println("Queue is Full!");
            return;
        }
        heap[size] = value;
        size++;
        heapifyUp();
    }
    private void heapifyUp(){
        int index = size - 1;
        while(hasParent(index) && heap[parent(index)] > heap[index]){
            swap(parent(index), index);
            index = parent(index);
        }
    }

    public int removeMin(){
        if(size == 0){
            System.out.println("Queue is Empty!");
            return -1;
        }
        int minValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return minValue;
    }
    private void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallestChildIndex = leftChild(index);
            if(hasRightChild(index) && heap[rightChild(index)] < heap[smallestChildIndex]){
                smallestChildIndex = rightChild(index);
            }
            if (heap[index] <= heap[smallestChildIndex]){
                break;
            }
            else{
                swap(index, smallestChildIndex);
            }
            index = smallestChildIndex;
        }
    }
    public int peek(){
        if(size == 0){
            System.out.println("Queue is Empty!");
            return -1;
        }
        return heap[0];
    }
    public void printQueue(){
        for (int i = 0; i < size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinPriorityQueue pq = new MinPriorityQueue(10);
        pq.insert(30);
        pq.insert(10);
        pq.insert(40);
        pq.insert(5);
        pq.insert(20);

        System.out.println("Min Priority Queue: ");
        pq.printQueue();

        System.out.println("Peek (min): " + pq.peek());

        System.out.println("Removed: " + pq.removeMin());
        System.out.println("After Removal: ");
        pq.printQueue();

    }
}
