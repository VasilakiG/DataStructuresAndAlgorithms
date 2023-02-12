import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<C> {

    private class ListNode{
        C data;
        ListNode next;

        ListNode(C data){
            this.data = data;
            next = null;
        }
    }

    private ListNode top;
    private int length;

    public MyStack(){
        top = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(C data){
        ListNode temp = new ListNode(data);

        temp.next = top;
        top = temp;

        length++;
    }

    public ListNode pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        ListNode temp= top;
        top = top.next;
        temp.next = null;

        length--;
        return temp;
    }

    public C peek(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    public void print(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        ListNode temp = top;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static String reverse(String str){

        MyStack<Character> stack = new MyStack<Character>();
        char[] chars = str.toCharArray();

        for (char c: chars) {
            stack.push(c);
        }

        for (int i = 0; i < str.length(); i++) {
            chars[i] = stack.pop().data;
        }

        return new String(chars);

    }

    public static void main(String[] args) {

        String str = "ABCD";

        System.out.println(reverse(str));

    }
}