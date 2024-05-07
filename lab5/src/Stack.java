public interface Stack<T> {
    public void push(T x);

    public T peek();

    public T pop();

    public Boolean isEmpty();

    public void Clear();

    public Boolean Contains(T x);
}
