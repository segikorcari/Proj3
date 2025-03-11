public class ChangeStack {
    private Node top;
    private int numElements;

    public ChangeStack() {
        top = null;
        numElements = 0;
    }

    public void push(int item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        numElements++;
    }

    public int pop() {
        if (top == null) {
            throw new StackEmptyException("Stack is empty");
        }
        int value = top.data;
        top = top.next;
        numElements--;
        return value;
    }

    public int peekTop() {
        if (top == null) {
            throw new StackEmptyException("Stack is empty");
        }
        return top.data;
    }

    public void increaseValues(int k, int amount) {
        if (top == null) return;

        Node[] nodes = new Node[numElements];
        Node current = top;
        int index = numElements - 1;

        while (current != null) {
            nodes[index--] = current;
            current = current.next;
        }

        int limit = Math.min(k, numElements);
        for (int i = 0; i < limit; i++) {
            nodes[i].data += amount;
        }
    }

    public void decreaseValues(int k, int amount) {
        if (top == null) return;

        Node[] nodes = new Node[numElements];
        Node current = top;
        int index = numElements - 1;

        while (current != null) {
            nodes[index--] = current;
            current = current.next;
        }

        int limit = Math.min(k, numElements);
        for (int i = 0; i < limit; i++) {
            nodes[i].data -= amount;
        }
    }

    public static void main(String[] args) {
        ChangeStack stack = new ChangeStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peekTop()); // 30

        stack.increaseValues(2, 5);
        System.out.println("After increasing bottom 2 elements by 5:");
        while (stack.numElements > 0) {
            System.out.println(stack.pop());
        }

        stack.push(40);
        stack.push(50);
        stack.push(60);

        stack.decreaseValues(2, 3);
        System.out.println("After decreasing bottom 2 elements by 3:");
        while (stack.numElements > 0) {
            System.out.println(stack.pop());
        }
    }
}
