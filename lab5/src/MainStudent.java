public class MainStudent {
    public static void main(String[] args) {
        Node<Student> node = new Node<>();
        node.push(new Student(18, "Максим", 14));
        node.push(new Student());
        node.push(new Student(1, "Ярик", 12));
        node.push(new Student(43, "Бочек", 3));
        node.push(new Student(23, "Потик", 54));
        System.out.println(node);

        Student st = node.peek();
        System.out.println("Peek " + st);
        System.out.println(node);

        st = node.pop();
        System.out.println("Pop " + st);
        System.out.println(node);
    }
}