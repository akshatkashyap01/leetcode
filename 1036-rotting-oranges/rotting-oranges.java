class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i=0; i<rows; i++){
            for(int j =0; j<cols; j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j,0}); //i,j,minute
                }else if (grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};

        // Bfs

        while(!queue.isEmpty()){

            int[] curr = queue.poll();
            int x= curr[0];
            int y= curr[1];
            int time = curr[2];

            minutes= Math.max(minutes, time);

            for(int d= 0; d<4; d++){
                int nx = x + dirX[d];
                int ny = y + dirY[d];

                if(nx >= 0 && ny >=0 && nx< rows && ny< cols && grid[nx][ny]==1){
                    grid[nx][ny]=2; //rot 
                    fresh--;
                    queue.offer(new int[]{nx,ny,time+1});
                    
                }
            }
        }

        return fresh == 0 ? minutes : -1;

    }
}