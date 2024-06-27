package graph.session_5;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim_sAlgorithm {
    public static void main(String[] args) {

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        int V = 6;

        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        addEdges(graph, 0, 1, 1); addEdges(graph, 0, 4, 1);
        addEdges(graph, 1, 2, 2); addEdges(graph, 4, 1, 2);
        addEdges(graph, 3, 4, 2); addEdges(graph, 3, 1, 3);
        addEdges(graph, 2, 3, 3); addEdges(graph, 5, 1, 5);
        addEdges(graph, 3, 5, 6); addEdges(graph, 5, 4, 6);
        addEdges(graph, 5, 0, 9);

        int ans = mstPrims(graph, V);

        System.out.println(ans);

    }

    static int mstPrims(ArrayList<ArrayList<Pair>> graph, int V){
        int ans = 0;
        int count = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[V];

        pq.add(new Edge(-1, 0, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(vis[cur.dest]) continue;
            vis[cur.dest] = true;

            ans += cur.wt;
            count++;
            if(count == V) break;
            ArrayList<Pair> curNeighbours = graph.get(cur.dest);
            for(Pair pair:  curNeighbours){
                if(!vis[pair.v]){
                    pq.add(new Edge(cur.dest, pair.v, pair.w));
                }
            }
        }
        return ans;
    }

    static class Edge implements Comparable<Edge>{
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge that) {
            return this.wt - that.wt;
        }
    }

    static void addEdges(ArrayList<ArrayList<Pair>> graph, int src, int dest, int wt){
        graph.get(src).add(new Pair(dest, wt));
        graph.get(dest).add(new Pair(src, wt));
    }
}

class Pair{
    int v, w;
    public Pair(int v, int w){
        this.v = v;
        this.w = w;
    }
}
