public class StackArray {
    int[] arr;
    int top;
    int capacity;

    StackArray(int size){
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x){
        if(isFull()){
            System.out.println("Stack Overflow - Cannot Push");
            return;
        }
        arr[++top] = x;
        System.out.println("Insertion Done: " + x);
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return -1;
        }
        return arr[top--];
    }

    public int peek(){
        if(!isEmpty()){
            return arr[top];
        }
        System.out.println("Stack is Empty!");
        return -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == capacity - 1;
    }

    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return;
        }
        System.out.print("Stack Elements: ");
        for (int i = 0; i <= top; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(3);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack();
        stack.push(40);
        stack.printStack();

        System.out.println("Top Element: " + stack.peek());

        int removed = stack.pop();
        System.out.println("Popped element is: " + removed);
        stack.printStack();
        stack.pop(); // 20
        stack.pop(); // 10
        stack.pop(); // Stack is Empty

    }
}
