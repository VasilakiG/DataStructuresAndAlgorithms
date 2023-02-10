public class CircularSingleList {

    private SinglyNode tail;
    private int length;

    private class SinglyNode{
        private int data;
        private SinglyNode next;

        public SinglyNode(int data){
            this.data = data;
            next = null;
        }

    }

    public CircularSingleList(){
        tail = null;
    }

    public static void main(String[] args) {

    }
}