package graph.liveSession_1;

import java.util.LinkedList;
import java.util.Queue;

public class IsPathPresentBtwTwoCells {
    public static void main(String[] args) {

        int a[][] = {
                {0, 3, 1, 0},
                {3, 0, 3, 3},
                {2, 3, 0, 3},
                {0, 3, 3, 3}
        };

        boolean ans = pathExistInMatrix(a);

        System.out.println(ans);

    }

    static boolean pathExistInMatrix(int a[][]){
        int row = a.length;
        int col = a[0].length;
        boolean vis[][] = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(a[i][j] == 1) {
//                    return dfs(a, i, j, vis);
                    return bfs(a, i, j);
                }
            }
        }
        return false;
    }

    static boolean dfs(int a[][], int i, int j, boolean vis[][]){

        if(!isSafe(a, i, j)) return false;
        if(vis[i][j]) return false;

        if(a[i][j] == 2) return true;

        vis[i][j] = true;
        int row = a.length;
        int col = a[0].length;

        int x[] = {0, 0, -1, 1};
        int y[] = {1, -1, 0, 0};

        for(int ind = 0; ind < 4; ind++){
            int nextI = i + x[ind];
            int nextJ = j + y[ind];

            if(dfs(a, nextI, nextJ, vis)) return true;
        }

////        Right
//        if(j+1 < col && !vis[i][j+1]){
//            if(dfs(a, i, j+1, vis)) return true;
//        }
////        Left
//        if(j-1 >= 0 && !vis[i][j-1]){
//            if(dfs(a, i, j-1, vis)) return true;
//        }
////        Up
//        if(i-1 >= 0 && !vis[i-1][j]){
//            if(dfs(a, i-1, j, vis)) return true;
//        }
////        Down
//        if(i+1 < row && !vis[i+1][j]){
//            if(dfs(a, i+1, j, vis)) return true;
//        }


        return false;
    }

    static boolean isSafe(int a[][], int i, int j){
        int row = a.length;
        int col = a[0].length;

        return i >= 0 && i < row && j >= 0 && j < col && a[i][j] != 0;
    }

    static boolean bfs(int a[][], int i, int j){
        Queue<Cell> q = new LinkedList<>();
        int row = a.length;
        int col = a[0].length;
        boolean vis[][] = new boolean[row][col];

        q.add(new Cell(i, j));

        while(!q.isEmpty()){
            Cell cur = q.poll();
            if(a[cur.x][cur.y] == 2) return true;

            vis[cur.x][cur.y] = true;

            int x[] = {0, 0, -1, 1};
            int y[] = {1, -1, 0, 0};

            for(int ind = 0; ind < 4; ind++){
                int nextI = cur.x + x[ind];
                int nextJ = cur.y + y[ind];

                if(isSafe(a, nextI, nextJ) && !vis[nextI][nextJ]) q.add(new Cell(nextI, nextJ));
            }
        }
        return false;
    }
}
class Cell {
    int x, y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}