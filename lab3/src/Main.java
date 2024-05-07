public class Main {
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(10);


        binaryHeap.insertNode(18);
        binaryHeap.insertNode(14);
        binaryHeap.insertNode(15);
        binaryHeap.insertNode(12);
        binaryHeap.insertNode(11);
        binaryHeap.insertNode(3);
        binaryHeap.insertNode(7);
        binaryHeap.insertNode(2);
        binaryHeap.insertNode(9);
        binaryHeap.insertNode(6);


        binaryHeap.printHeap();
//        binaryHeap.changeNode(3, 15);
//        binaryHeap.printHeap();

        Integer removedValue = binaryHeap.removeNode(4);
        System.out.println("\nRemoved value: " + removedValue);
        binaryHeap.printHeap();

        binaryHeap.insertNode(7);

        binaryHeap.printHeap();

    }
}