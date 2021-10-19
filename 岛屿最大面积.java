import java.util.ArrayList;
import java.util.Collections;

class Max_Area_of_Island {
    public int maxAreaOfIsland(int[][] grid) {
        ArrayList<Integer> area = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    int s = 0;
                    count ++;
                    s+=dfs(grid, i, j);
                    area.add(s);
                }
            }
        }
        Collections.sort(area);
        return area.isEmpty()? 0:area.get(area.size()-1);
    }
    public int dfs(int[][] grid, int x, int y){
        int s = 0;
        if(grid[x][y] == 1){
            grid[x][y] = 0;
            s=1;
            if(x > 0){s += dfs(grid, x-1, y);}
            if(x < grid.length-1){s += dfs(grid, x+1, y);}
            if(y>0){s += dfs(grid, x, y-1);}
            if(y<grid[0].length-1){s += dfs(grid, x, y+1);}
        }
        return s;
    }
}
