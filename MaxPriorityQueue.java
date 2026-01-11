public class MaxPriorityQueue {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxPriorityQueue(int capacity){
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    private int parent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return (2*i) + 1;
    }
    private int rightChild(int i){
        return (2*i) + 2;
    }
    private boolean hasParent(int i){
        return parent(i) >= 0;
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
        while(hasParent(index) && heap[parent(index)] < heap[index]){
            swap(parent(index), index);
            index = parent(index);
        }
    }

    public int removeMax(){
        if(size == 0){
            System.out.println("Queue is Empty!");
            return -1;
        }
        int maxValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();

        return maxValue;
    }
    private void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int largestChildIndex = leftChild(index);
            if (hasRightChild(index) && heap[rightChild(index)] > heap[largestChildIndex]){
                largestChildIndex = rightChild(index);
            }
            if (heap[index] >= heap[largestChildIndex]){
                break;
            } else {
                swap(index, largestChildIndex);
            }
            index = largestChildIndex;
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
        MaxPriorityQueue pq = new MaxPriorityQueue(10);

        pq.insert(30);
        pq.insert(10);
        pq.insert(40);
        pq.insert(5);
        pq.insert(20);

        System.out.println("Max Priority Queue: ");
        pq.printQueue();

        System.out.println("Peek Value: " + pq.peek());

        System.out.println("Removed: " + pq.removeMax());
        System.out.println("After Removal: ");
        pq.printQueue();

    }
}
