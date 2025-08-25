public class CircularSinglyLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    public void insert(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }
    public void display(){
        if (head == null){
            System.out.println("List is Empty!");
            return;
        }
        Node current = head;

        do{
            System.out.print(current.data + " -> ");
            current = current.next;
        } while(current != head);
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csl = new CircularSinglyLinkedList();

        csl.insert(10);
        csl.insert(20);
        csl.insert(30);
        csl.insert(40);

        System.out.print("Circular Singly Linked List: ");
        csl.display();
    }
}
