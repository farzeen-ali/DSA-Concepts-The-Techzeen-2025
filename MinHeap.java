public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity){
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
            System.out.println("Heap is Full");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;
//        Heapify up
        while(current > 0 && heap[current] < heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMin(){
        if(size == 0){
            System.out.println("Heap is Empty!");
            return -1;
        }
        int min = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapify(0);
        return min;
    }
    private void heapify(int index){
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if(left < size && heap[left] < heap[smallest]){
            smallest = left;
        }
        if(right < size && heap[right] < heap[smallest]){
            smallest = right;
        }
        if(smallest!= index){
            swap(index, smallest);
            heapify(smallest);
        }
    }
    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap(){
        for (int i =0; i < size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
    MinHeap minHeap = new MinHeap(10);
    minHeap.insert(20);
    minHeap.insert(15);
    minHeap.insert(30);
    minHeap.insert(5);
    minHeap.insert(10);

        System.out.println("Min Heap");
        minHeap.printHeap();

        System.out.println("Extract Min: " + minHeap.extractMin());

        System.out.println("Heap After Deletion: ");
        minHeap.printHeap();
    }
}
