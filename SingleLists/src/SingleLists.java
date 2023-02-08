class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class SinglyLinkedList<I extends Number> {
    public Node head;

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node newNode = head;

        while(newNode.next != null){
            newNode = newNode.next;
        }
        newNode.next = new Node(data);
    }

    public int getSize(){

        Node current = head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void printList(){
        if (head == null) {
            System.out.println("-->null");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class SingleLists {
    public static Node mergeTwoLists(Node a, Node b) {
        Node head = null;
        if ( a.data <= b.data ){
            head = a;
            a = a.next;
        }else{
            head = b;
            b = b.next;
        }
        Node tail = head;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a == null) {
            tail.next = b;
        }else{
            tail.next = a;
        }
        return head;
    }

    public static Node add(Node a, Node b){
        Node temp = new Node(0);
        Node tail = temp;

        int carry = 0;

        while(a != null || b != null){

            int x = 0;
            if (a != null) {
                x = a.data;
            }

            int y = 0;
            if (b != null) {
                y = b.data;
            }

            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new Node(sum % 10);

            tail = tail.next;

            if (a != null) {
                a = a.next;
            }
            if (b != null){
                b = b.next;
            }
        }

        if (carry > 0) {
            tail.next = new Node(carry);
        }

        return temp.next;
    }

    public static void main(String[] args) {

        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        list1.addLast(7);

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(6);
        list2.addLast(8);


        System.out.print("First list: ");
        list1.printList();

        System.out.print("Second list: ");
        list2.printList();

        SinglyLinkedList<Integer> result = new SinglyLinkedList<Integer>();
//        result.head = mergeTwoLists(list1.head, list2.head);
//
//        System.out.print("Result list: ");
//        result.printList();

        System.out.print("Result list: ");
        result.head = add(list1.head, list2.head);
        result.printList();
    }
}

