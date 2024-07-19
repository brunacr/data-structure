package dataStructurePDI;

public class ImplementsNewStack {
    public static void main(String[] args) {
        NewStack stack = new NewStack();

        System.out.println(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.isEmpty());

        System.out.println(stack.peek());

        System.out.println(stack.pop());

        System.out.println(stack.peek());

        stack.displayUntil(6);
        System.out.println("--------------------");
        stack.displayInvertedUntil(6);
    }
}
