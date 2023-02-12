import java.util.NoSuchElementException;

public class CircularSingleList {

    private SinglyNode tail;
    private int length;

    private static class SinglyNode{
        private int data;
        private SinglyNode next;

        public SinglyNode(int data){
            this.data = data;
            next = null;
        }

    }

    public CircularSingleList(){
        tail = null;
        length = 0;
    }

    public int lenght(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void createCircularSinglyLinkedList(){
        SinglyNode first = new SinglyNode(1);
        SinglyNode second = new SinglyNode(5);
        SinglyNode third = new SinglyNode(10);
        SinglyNode fourth = new SinglyNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        tail = fourth;
    }

    public void insertFirst(int data){
        SinglyNode temp = new SinglyNode(data);

        if (tail == null) {
            tail = temp;
        }else{
            temp.next = tail.next;
        }

        tail.next = temp;
        length++;
    }

    public void insetLast(int data){
        SinglyNode temp = new SinglyNode(data);

        if (tail == null) {
            tail = temp;
            tail.next = tail;
        }else{
            temp.next = tail.next;
            tail.next = temp;
            tail = temp;
        }
        length++;
    }

    public SinglyNode deleteFirst(){
        if (isEmpty()) {
            throw new NoSuchElementException("Circular Singly Linked List is already empty");
        }

        SinglyNode temp = tail;

        if (tail.next == tail) {
            tail = null;
        }else{
            tail.next = temp.next;
        }

        temp.next = null;
        length--;
        return temp;
    }

    public void print(){
        if (tail == null) {
            return;
        }

        SinglyNode head = tail.next;
        while (head != tail) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        CircularSingleList cssl = new CircularSingleList();

        cssl.createCircularSinglyLinkedList();
        cssl.print();
    }
}