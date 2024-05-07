public class MainBook {
    public static void main(String[] args) {
        Stack<Book> node = new Massive<>();

        node.push(new Book("Война и мир", "Л. Н. Толстой", 12456));
        node.push(new Book());
        node.push(new Book("Война и не мир", "Л. Н. Худой", 1246));
        node.push(new Book("Не война и мир", "З. Н. Толстой", 156));
        node.push(new Book("Не война или мир", "З. Н. Средний", 1246));

        System.out.println(node);

        Book st = node.peek();
        System.out.println("Peek " + st);
        System.out.println(node);

        st = node.pop();
        System.out.println("Pop " + st);
        System.out.println(node);
    }
}
