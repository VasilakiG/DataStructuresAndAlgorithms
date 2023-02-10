import java.util.NoSuchElementException;

class DoublyNode{
    int data;
    DoublyNode previous;
    DoublyNode next;

    public DoublyNode(int data){
        this.data = data;
    }
}
class DoublyLinkedList<I extends Number> {
    DoublyNode head;
    DoublyNode tail;
    int length;

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public int length(){
        return length;
    }

    public void insertFirst(int data){
        DoublyNode newNode = new DoublyNode(data);

        if (isEmpty()) {
            tail = newNode;
        }else{
            head.previous = newNode;
        }

        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertLast(int data){
        DoublyNode newNode = new DoublyNode(data);

        if (isEmpty()){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
        }

        tail = newNode;
        length++;
    }

    public DoublyNode deleteFirst(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        DoublyNode temp = head;
        if (head == tail) {
            tail = null;
        }else{
            head.next.previous = null;
        }

        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public DoublyNode deleteLast(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        DoublyNode temp = tail;
        if (head == tail) {
            head = null;
        }else{
            tail.previous.next = null;
        }

        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    public void printForward(){
        if (head == null) {
            System.out.println("-->null");
            return;
        }

        DoublyNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printBackwards(){
        if (tail == null) {
            System.out.println("-->null");
            return;
        }

        DoublyNode temp = tail;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }



    @Override
    public String toString() {

        StringBuilder string = null;

        if (head == null) {
            string.append("-->null");
            return string.toString();
        }

        DoublyNode temp = head;
        while(temp != null){
            string.append(temp.data + " --> ");
            temp = temp.next;
        }
        string.append("null\n");

        return string.toString();
    }
}

public class DoubleLists {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();

        dll.insertFirst(1);
        dll.insertFirst(2);
        dll.insertFirst(3);
        dll.insertFirst(4);
        dll.insertFirst(5);

        dll.printForward();
        dll.printBackwards();


    }
}