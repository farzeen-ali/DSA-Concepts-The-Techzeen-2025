public class StackLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node top;

    public StackLinkedList(){
        this.top = null;
    }

    public void push(int x){
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        System.out.println("Inserted: " + x );
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        return top.data;
    }
    public boolean isEmpty(){
        return top == null;
    }

    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return;
        }
        System.out.print("Stack Elements: ");
        Node current = top;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack(); // 30 20 10

        System.out.println("Top Element: " + stack.peek());

        int removed = stack.pop();
        System.out.println("Popped Elements is: " + removed); // 30
        stack.pop(); // 20
        stack.printStack();
        stack.pop(); //10
        stack.pop(); // stack underflow
    }
}
