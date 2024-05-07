/*
* Двои́чная ку́ча, пирами́да, или сортиру́ющее де́рево — такое двоичное дерево, для которого выполнены три условия:

Значение в любой вершине не меньше, чем значения её потомков.
Глубина всех листьев (расстояние до корня) различается не более чем на 1 слой.
Последний слой заполняется слева направо без «дырок».
* */
public class BinaryHeap {
    private Integer[] heapArray;
    private int maxSize;
    private int currentSize;

    public BinaryHeap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        heapArray = new Integer[maxSize];
    }

    public void printHeap() {

        for (int n = 0; n < currentSize; n++) {
            if (heapArray[n] != null) {
                System.out.println(heapArray[n] + " ");
            }
            else {
                System.out.println("-");
            }
        }
        System.out.println();

        int countOfGaps = 32;
        int itemsPerRow = 1;
        int columnNumber = 0;
        for (int i = 0; i < currentSize; i++) {
            if (columnNumber == 0) {
                for (int k = 0; k < countOfGaps; k++) {
                    System.out.print(' ');
                }
            }
            System.out.print(heapArray[i]);

            if (++columnNumber == itemsPerRow) {
                countOfGaps /= 2;
                itemsPerRow *= 2;
                columnNumber = 0;
                System.out.println();
            }
            else {
                for (int k = 0; k < countOfGaps * 2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }
    }

    public boolean insertNode(int value) {
        if (currentSize == maxSize) {
            return false;
        }
        Integer newNode = value;
        heapArray[currentSize] = newNode;
        displaceUp(currentSize++);
        return true;
    }

    public Integer removeNode(int index) {
        if(index > 0 && currentSize > index) {
            Integer root = heapArray[index];
            heapArray[index] = heapArray[--currentSize];
            heapArray[currentSize] = null;
            displaceDown(index);
            return root;
        }
        return null;
    }

    public boolean changeNode(int index, int newValue) {
        if (index < 0 || currentSize<=index) {
            return false;
        }
        int oldValue = heapArray[index];
        heapArray[index] = newValue;

        if (oldValue < newValue) {
            displaceUp(index);
        }
        else {
            displaceDown(index);
        }
        return true;
    }
    //log n
    private void displaceUp(int index) {
        int parentIndex = (index - 1) / 2;
        Integer bottom = heapArray[index];
        while (index > 0 && heapArray[parentIndex] < bottom) {
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    //log n
    private void displaceDown(int index) {
        int largerChild;
        Integer top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild] < heapArray[rightChild]) {
                largerChild = rightChild;
            }
            else {
                largerChild = leftChild;
            }

            if (top >= heapArray[largerChild]) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }
}