import java.util.ArrayList;

public class Massive<T> implements Stack<T> {
    private ArrayList<T> data;
    private int size = 0;

    public Massive(){
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
