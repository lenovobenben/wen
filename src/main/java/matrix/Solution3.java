package matrix;

/**
 * 200. 岛屿数量
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
class Solution3 {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 以 x,y 坐标展开岛屿，将值设置为2
     */
    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || y >= grid[0].length || x >= grid.length || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '2';
        dfs(grid, x, y + 1);// 右
        dfs(grid, x + 1, y);// 下
        dfs(grid, x, y - 1);// 左
        dfs(grid, x - 1, y);// 上
    }

}