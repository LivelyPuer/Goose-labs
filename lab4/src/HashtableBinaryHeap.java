public class HashtableBinaryHeap {
    private int capacity;
    private BinaryHeap[] keys;

    public HashtableBinaryHeap(int capacity) {
        this.capacity = capacity;
        this.keys = new BinaryHeap[capacity];
        for (int i = 0; i < capacity; i++){
            this.keys[i] = new BinaryHeap(128);
        }
    }
    public void insert(int key) {
        keys[hash(key)].insertNode(key);
    }

    public void remove(int key) {
        int idx = keys[hash(key)].find(key);
        keys[hash(key)].removeNode(idx);
    }

    public Integer get(int key) {
        int idx = keys[hash(key)].find(key);
        keys[hash(key)].printHeap();
        if (idx != -1){
            return key;
        }
        return null;
    }
    public int hash(int key) {
        return key % capacity;
    }
}

class Test {
    public static void main(String[] args) {
        HashtableBinaryHeap hashtableBinaryHeap = new HashtableBinaryHeap(5);

        hashtableBinaryHeap.insert(10);
        hashtableBinaryHeap.insert(20);
        hashtableBinaryHeap.insert(30);

        hashtableBinaryHeap.insert(11);
        hashtableBinaryHeap.insert(21);
        hashtableBinaryHeap.insert(31);

        System.out.println("Get 10: " + hashtableBinaryHeap.get(10));
        System.out.println("Get 20: " + hashtableBinaryHeap.get(20));
        System.out.println("Get 30: " + hashtableBinaryHeap.get(30));

        System.out.println("Get 20: " + hashtableBinaryHeap.get(21));
        System.out.println("Get 30: " + hashtableBinaryHeap.get(31));

        hashtableBinaryHeap.remove(20);
        System.out.println("Get 20 after removal: " + hashtableBinaryHeap.get(20));
    }
}