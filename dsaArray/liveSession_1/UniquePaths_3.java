package dsaArray.liveSession_1;

public class UniquePaths_3 {
    public static void main(String[] args) {

        int grid[][] = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        int res = uniquePaths(grid);

        System.out.println(res);

    }
    static int uniquePaths(int grid[][]){
        int sx = 0;
        int sy = 0;
        int countZero = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    countZero++;
                }else if(grid[i][j] == 1){
                    sx = i;
                    sy = j;
                }
            }
        }
        System.out.println("Total countZero -> " + countZero);
        return helper(grid,sx,sy,countZero);
    }
    static int helper(int grid[][], int x, int y, int countZero){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1){
            return 0;
        }
        if(grid[x][y] == 0) countZero--;
        if(grid[x][y] == 2){
            System.out.println("countZero -> " + countZero);
            if(countZero == 0){
                return 1;
            }else{
                return 0;
            }
        }
        grid[x][y] = -1;
        int totalPath = helper(grid,x,y-1,countZero)+
                helper(grid,x-1,y,countZero)+
                helper(grid,x,y+1,countZero)+
                helper(grid,x+1,y,countZero);
        grid[x][y] = 0;
        countZero++;
        return totalPath;
    }
}
