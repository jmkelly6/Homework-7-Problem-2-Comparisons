public class MaxHeap {
    int capacity;
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        data = new Integer[capacity];
        size = 0;
    }

    // return position of parent
    private Integer parent(Integer pos) {
        return (pos - 1) / 2;
    }

    // return left child
    private Integer leftChild(Integer pos) {
        return (2 * pos) + 1;
    }

    // return right child
    private Integer rightChild(Integer pos) {
        return (2 * pos) + 2;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        for(int i = 0; i < data.length; i++) {
            add(data[i]);
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        size = data.length;
        for(int i = 0; i < size; i++) {
            this.data[i] = data[i];
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {
        if(size >= capacity) {
            return false;
        }
        data[size] = item;
        heapIfyUp(size);
        size++;
        return true;
    }

    // helper function to swap items in the heap
    public void swap(Integer index, Integer parentN) {
        int temp = data[index];
        data[index] = data[parentN];
        data[parentN] = temp;
    }

    // return the max item in the heap
    public Integer get() {
        if(size == 0) {
            return null;
        }
        return data[0];
    }

    // remove the root item
    public Integer pop() {
        if(size == 0) {
            return null;
        }
        Integer found = data[0];
        data[0] = data[size-1];
        heapIfyDown(data, 0);
        data[size-1] = null;
        size--;
        return found;
    }

    private void heapIfyDown(Integer[] heap, int index){
        Integer largest = index;
        Integer l = leftChild(index);
        Integer r = rightChild(index);
        if (l >= size || r >= size) {
            return;
        }
        if (heap[l] >= heap[r]) {
            largest = l;
        } else {
            largest = r;
        }
        if(largest != index) {
            swap(largest, index);
            heapIfyDown(heap, largest);
        }
    }

    private void heapIfyUp(Integer item) {
        if(item != 0 && data[item] > data[parent(item)]) {
            swap(item, parent(item));
            heapIfyUp(parent(item));
        }
    }
}
