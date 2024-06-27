package priorityQueueAndDisjointSets.session_1;

public class InsertionInHeap {
    public static void main(String[] args) {

        MaxHeap mH = new MaxHeap(10);

        mH.insert(10);
        mH.insert(30);
        mH.insert(10);
        mH.insert(50);
        mH.insert(50);
        mH.insert(10);

        mH.print();

    }
}
