public class DoublyLinkedListInsertion {
    static class Node {
        int data;
        Node prev, next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head;

    public void insertAtStart(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void insertAtIndex(int index, int data){
        if(index == 0){
            insertAtStart(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        int count = 0;

        while(current != null && count < index - 1){
            current = current.next;
            count ++;
        }
        if (current == null){
            System.out.println("Index out bounds!");
            return;
        }
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null){
            current.next.prev = newNode;
        }
        current.next = newNode;
    }

    public void display(){
        Node current = head;
        System.out.print("DLL: ");
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedListInsertion dll = new DoublyLinkedListInsertion();

        dll.insertAtStart(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtIndex(1, 15);
        dll.display();

    }
}
