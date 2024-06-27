package graph.session_4;

import priorityQueueAndDisjointSets.session_5.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgorithm {
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

        int ans = mstKruskal(graph);

        System.out.println(ans);

    }

    static int mstKruskal(ArrayList<ArrayList<Pair>> graph){
        ArrayList<Edge> edges = new ArrayList<>();
        int v = graph.size();
        for(int i = 0; i < v; i++){
            ArrayList<Pair> adj = graph.get(i);
            for(Pair p: adj){
                edges.add(new Edge(i, p.v, p.w));
            }
        }
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(v);
        int ans = 0;
        int count = 0;

        for(Edge cur: edges){
            int src = cur.src;
            int dest = cur.dest;

            int findSrc = ds.find(src);
            int findDest = ds.find(dest);

            if(findSrc != findDest){
                ans += cur.wt;
                count++;
                if(count == v-1) break;
                ds.union(src, dest);
            }
        }
        return ans;
    }

    static class Edge implements Comparable<Edge>{
        int src, dest, wt;
        public Edge(int src, int dest, int wt){
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