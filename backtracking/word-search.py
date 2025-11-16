class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        # return
        m,n = len(board), len(board[0])
        def dfs(x,y, idx) -> bool:
            #在这里写的是退出条件1，即遍历结束返回答案的条件
            if idx == len(word):
                return True
            #在这里写的是退出条件2，即放弃一个branch的条件
            if x<0 or y<0 or x>=m or y>=n or board[x][y] != word[idx]:
                return False
            #标记这个point为访问过【暂时】
            temp = board[x][y]
            board[x][y] = '#'

            #如果这个point符合条件，找这个point附近的下一个point
            found = (
                dfs(x+1,y,idx+1) or
                dfs(x,y+1,idx+1) or
                dfs(x-1,y,idx+1) or
                dfs(x,y-1,idx+1))

            #如果到这一步说明所有的loop都返回found = True
            board[x][y]=temp
            return found

        for i in range(m):
            for j in range(n):
                if dfs(i,j,0):
                    return True
        return False