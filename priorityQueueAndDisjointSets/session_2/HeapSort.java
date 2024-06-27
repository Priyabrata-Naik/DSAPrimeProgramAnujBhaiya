package priorityQueueAndDisjointSets.session_2;

public class HeapSort {
    public static void main(String[] args) throws Exception {

        int a[] = {4, 3, 6, 10, 2, 3};
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.heapSort(a);

        for(int e: a){
            System.out.print(e+" ");
        }

    }
    static class MaxHeap {
        int a[];
        int size, capacity;

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            a = new int[capacity];
            size = 0;
        }

        public boolean insert(int data) {
            if (size == capacity) return false;
            a[size] = data;
            int i = size;

            while (i > 0) {
                int parent = (i - 1) >> 1;
                if (a[parent] < a[i]) {
                    swap(parent, i);
                    i = parent;
                } else {
                    break;
                }
            }
            size++;
            return true;
        }

        public void buildHeap(int b[]){
            if(a.length < b.length) return;
            for(int i = 0; i < b.length; i++){
                a[i] = b[i];
            }
            size = b.length;
            for(int i = size/2; i >= 0; i--){
                heapify(i);
            }
            for(int i = 0; i < size; i++){
                b[i] = a[i];
            }
        }

        public void heapify(int i) {
            if (i >= size) return;
            int larger = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < size && a[left] > a[i]) {
                larger = left;
            }
            if (right < size && a[right] > a[larger]) {
                larger = right;
            }
            if (larger != i) {
                swap(larger, i);
                heapify(larger);
            }
        }

        public int pop() throws Exception {
            if(size == 0) throw new Exception("Empty PQ");
            size--;
            int temp = a[0];
            a[0] = a[size];
            heapify(0);
            return temp;
        }

        public void swap(int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        public void heapSort(int b[]) throws Exception {
            buildHeap(b);
            for(int i = b.length-1; i >= 0; i--){
                b[i] = pop();
            }
        }

    }
}
