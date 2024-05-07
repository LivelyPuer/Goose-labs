public class Node<T> implements Stack<T> {
    private T data;
    private Node prevNode;

    public Node(T inData) {
        data = inData;
    }

    public Node() {
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    @Override
    public void push(T x) {
        if (prevNode == null) {
            Node prev = new Node<T>(x);
            prevNode = prev;
            return;
        }
        Node nextNode = prevNode;
        while (nextNode != null) {
            if (nextNode.prevNode == null) {
                Node prev = new Node<T>(x);
                nextNode.prevNode = prev;
                return;
            }
            nextNode = nextNode.prevNode;
        }
    }

    @Override
    public T peek() {

        Node nextNode = this;
        do {
            if (nextNode.prevNode == null) {
                return (T) nextNode.data;
            }
            nextNode = nextNode.prevNode;
        } while (true);
    }

    @Override
    public T pop() {
        if (prevNode == null) {
            T tmp = data;
            data = null;
            return tmp;
        }
        Node nextNode = this;
        do {
            if (nextNode.prevNode.prevNode == null) {
                T tmp = (T) nextNode.prevNode.data;
                nextNode.prevNode = null;
                return tmp;
            }
            nextNode = nextNode.prevNode;
        } while (true);
    }

    @Override
    public Boolean isEmpty() {
        return prevNode == null;
    }

    @Override
    public void Clear() {
        prevNode = null;
        data = null;
    }

    @Override
    public Boolean Contains(T x) {
        if (data == x) return true;
        Node nextNode = prevNode;
        while (nextNode != null) {
            if (nextNode.data.equals(x)) {
                return true;
            }
            nextNode = nextNode.prevNode;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node nextNode = prevNode;
        while (nextNode != null) {
            sb.append(nextNode.data.toString());
            sb.append(" -> ");
            nextNode = nextNode.prevNode;
        }
        return sb.toString();
    }
}

