public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity){
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    private int parent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return 2*i + 1;
    }
    private int rightChild(int i){
        return 2*i + 2;
    }
    public void insert(int value){
        if(size == capacity){
            System.out.println("Heap is Full!");
            return;
        }
//        insert at end
        heap[size] = value;
        int current = size;
        size++;
//        heapify up
        while(current > 0 && heap[current] > heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMax(){
        if(size == 0){
            System.out.println("Heap is Empty!");
            return -1;
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        // heapify down
        heapify(0);
        return max;
    }

    private void heapify(int index){
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if(left < size && heap[left] > heap[largest]){
            largest = left;
        }
        if(right < size && heap[right] > heap[largest]){
            largest = right;
        }
        if(largest != index){
            swap(index, largest);
            heapify(largest);
        }
    }
    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap(){
        for (int i = 0; i < size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
    MaxHeap maxHeap = new MaxHeap(10);

    maxHeap.insert(10);
    maxHeap.insert(40);
    maxHeap.insert(20);
    maxHeap.insert(60);
    maxHeap.insert(30);

        System.out.println("Max Heap");
        maxHeap.printHeap();

        System.out.println("Extract Max: " + maxHeap.extractMax());

        System.out.println("Heap After Deletion: ");
        maxHeap.printHeap();
    }
}
