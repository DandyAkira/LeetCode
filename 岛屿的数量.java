import java.util.ArrayList;
import java.util.Collections;

class IslandNum {
    public void dfs(char[][] grid, int x, int y){
        if(grid[x][y] == '1'){
            grid[x][y] = 0;
            dfs(grid, x-1, y);
            dfs(grid, x+1, y);
            dfs(grid, x, y-1);
            dfs(grid, x, y+1);
        }
    }
    public int numIslands(char[][] grid) {
        ArrayList<Integer> area = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    int s = 0;
                    count ++;
                    dfs(grid, i, j);
                    area.add(s);
                }
            }
        }
        Collections.sort(area);

        return area.get(area.size()-1);
    }

}
