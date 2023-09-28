class Solution {
    static class pair{
            int x;
            int y;
            pair(int x,int y){
                this.x=x;
                this.y=y;
            }
        }
    public int orangesRotting(int[][] grid) {
        Queue<pair>q=new LinkedList<>();
        int total=0;
        int rotten=0;
        int time=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1||grid[i][j]==2){
                    total++;
                }
                if(grid[i][j]==2){
                    q.offer(new pair(i,j));
                }
            }
        }
        if(total==0){
            return 0;
        }
        while(!q.isEmpty()){
            int size=q.size();
            rotten+=size;//at start all the oranges were rotten
            if(rotten==total){
                return time;
            }
            time++;
            for(int i=0;i<size;i++){
                pair curr=q.poll();
                if(curr.x+1<grid.length&&grid[curr.x+1][curr.y]==1){
                    grid[curr.x+1][curr.y]=2;
                    q.offer(new pair(curr.x+1,curr.y));

                }
                if(curr.x-1>=0&&grid[curr.x-1][curr.y]==1){
                    grid[curr.x-1][curr.y]=2;
                    q.offer(new pair(curr.x-1,curr.y));
                }
                if(curr.y+1<grid[0].length&&grid[curr.x][curr.y+1]==1){
                    grid[curr.x][curr.y+1]=2;
                    q.offer(new pair(curr.x,curr.y+1));
                }
                if(curr.y-1>=0&&grid[curr.x][curr.y-1]==1){
                    grid[curr.x][curr.y-1]=2;
                    q.offer(new pair(curr.x,curr.y-1));
                }
            }
            
        }
        return -1;

    }
}
