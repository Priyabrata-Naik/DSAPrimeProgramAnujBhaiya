package priorityQueueAndDisjointSets.session_5;

public class ImplementingDisjointSet {
    public static void main(String[] args) {

        int n = 8;
        DisjointSet ds = new DisjointSet(n);

        ds.union(0,3);
        ds.union(4,1);
        ds.union(0,5);
        ds.union(2,6);

        System.out.println(ds.count);

    }
}
