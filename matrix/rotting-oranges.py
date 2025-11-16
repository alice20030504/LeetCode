class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #Get grid dimensions
        rows, cols = len(grid),len(grid[0])
        queue = deque()
        fresh = 0

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    queue.append((r,c))
                elif grid[r][c] == 1:
                    fresh += 1
        
        if fresh == 0:
            return 0

        minutes = 0
        direction = [(-1,0),(1,0),(0,-1),(0,1)]

        while queue and fresh > 0:
            minutes += 1
            for _ in range(len(queue)):
                x,y = queue.popleft()
                for dx, dy in directions:
                    nx,ny =x+dx,y+dy
                    if 0<=nx<rows and 0<=ny<cols and grid[nx][ny]==1:
                        grid[nx][ny]=2
                        fresh -=1
                        queue.append((nx,ny))
        return minutes if fresh ==0 else -1