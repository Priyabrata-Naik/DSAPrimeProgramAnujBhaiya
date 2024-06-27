package graph.liveSession_1;

import java.util.LinkedList;
import java.util.Queue;

public class WaterFlowProblem {
    public static void main(String[] args) {

        int a[][] = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        int ans = flowWater(a);

        System.out.println(ans);

    }
    static int flowWater(int a[][]){
        int row = a.length;
        int col = a[0].length;
        int ans[][] = new int[row][col];
        int count = 0;

        Queue<Cell> q = new LinkedList<>();

        for(int i = 0; i < col; i++){
            q.add(new Cell(0, i));
        }
        for(int i = 0; i < row; i++){
            q.add(new Cell(i, 0));
        }

//        System.out.println("First Q insertion");
//        System.out.println(q);
        bfsFlowWater(a, ans, q);

        q.clear();

        for(int i = 0; i < col; i++){
            q.add(new Cell(row-1, i));
        }
        for(int i = 0; i < row; i++){
            q.add(new Cell(i, col-1));
        }

//        System.out.println("Second Q insertion");
//        System.out.println(q);
         bfsFlowWater(a, ans, q);

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(ans[i][j] == 2) count++;
            }
        }
        return count;
    }

    static void bfsFlowWater(int[][] a, int[][] ans, Queue<Cell> q) {
        int row = a.length;
        int col = a[0].length;
        boolean vis[][] = new boolean[row][col];

        while(!q.isEmpty()){
//            System.out.println(q);
            Cell cur = q.poll();
//            System.out.println("Inside bfs");
//            System.out.println(cur.toString());


            if(vis[cur.x][cur.y]) continue;
            vis[cur.x][cur.y] = true;
            ans[cur.x][cur.y]++;

            int x[] = {0, 0, -1, 1};
            int y[] = {-1, 1, 0, 0};

            for(int ind = 0; ind < 4; ind++){
                int nextI = cur.x + x[ind];
                int nextJ = cur.y + y[ind];

                if(isSafeWaterFlow(a, nextI, nextJ) && !vis[nextI][nextJ] && a[nextI][nextJ] >= a[cur.x][cur.y])
                    q.add(new Cell(nextI, nextJ));
            }
        }

    }

    static boolean isSafeWaterFlow(int[][] a, int i, int j) {
        int row = a.length;
        int col = a[0].length;

        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
