import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        LinearProbingHashTable hashTable = new LinearProbingHashTable(10);
        hashTable.insert(10);
        hashTable.insert(11);
        hashTable.insert(20);
        hashTable.insert(40);
        hashTable.insert(30);
        hashTable.insert(40);
        hashTable.insert(50);

        System.out.println("Hash table: " + hashTable);

        hashTable.remove(30);
        System.out.println("After removing 20: " + hashTable);

        System.out.println("Contains 40? " + hashTable.contains(40));
        System.out.println("Contains 60? " + hashTable.contains(60));

        hashTable.insert(30);
        System.out.println("Hash table: " + hashTable);
    }
}

class LinearProbingHashTable {
    private int capacity;
    private int size;
    private int[] keys;
    private int[] values;

    public LinearProbingHashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keys = new int[capacity];
        this.values = new int[capacity];
    }

    public void insert(int key) {
        if (size >= capacity) {
            throw new IllegalStateException("Hash table is full");
        }

        int index = hash(key);
        while (keys[index] != 0) {
            index = (index + 1) % capacity;
        }

        keys[index] = key;
        values[index] = size + 1;
        size++;
    }

    public void remove(int key) {
        if (size == 0) {
            throw new IllegalStateException("Hash table is empty");
        }

        int index = hash(key);
        while (keys[index] != 0 && keys[index] != key) {
            index = (index + 1) % capacity;
        }

        if (keys[index] == 0) {
            throw new IllegalArgumentException("Key not found");
        }

        keys[index] = 0;
        values[index] = 0;
        size--;

        for (int i = index; i < size; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        while (keys[index] != 0) {
            if (keys[index] == key) {
                return true;
            }
            index = (index + 1) % capacity;
        }
        return false;
    }

    private int hash(int key) {
        return key % capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(keys[i]).append(":").append(values[i]).append(", ");
        }
        if (size > 0) {
            sb.setCharAt(sb.length() - 2, ']');
        } else {
            sb.append("]");
        }
        return sb.toString();
    }
}