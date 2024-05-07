import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

interface Stack<T> {
    public void push(T x);

    public T peek();

    public T pop();

    public Boolean isEmpty();

    public void Clear();

    public Boolean Contains(T x);
}


class Massive<T> implements Stack<T> {
    private ArrayList<T> data;
    private int size = 0;

    public Massive() {
        data = new ArrayList<T>(128);
    }

    @Override
    public void push(T x) {
        data.add(x);
        size++;
    }

    @Override
    public T peek() {
        return data.get(size - 1);
    }

    @Override
    public T pop() {
        if (size == 0) return null;
        return data.get(--size);
    }

    @Override
    public Boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void Clear() {
        data.clear();
    }

    @Override
    public Boolean Contains(T x) {
        return data.contains(x);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data.get(i));
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}


public class Task5 {
    public static void main(String[] args) {
        for (int i = 100000; i <= 1000000; i += 100000) {
            Stack<Integer> stack = new Massive<>();
            long startMyPush = System.currentTimeMillis();
            for (int j = 0; j < i; j++) {
                stack.push((int) (Math.random() * i));
            }
            long endMyPush = System.currentTimeMillis();

            long startInPush = System.currentTimeMillis();
            java.util.Stack<Integer> imbStack = new java.util.Stack<>();
            for (int j = 0; j < i; j++) {
                imbStack.push((int) (Math.random() * i));
            }
            long endInPush = System.currentTimeMillis();

            System.out.println(i + " " + (endMyPush - startMyPush) + " " + (endInPush - startInPush));
        }
    }
}
