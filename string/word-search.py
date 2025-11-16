class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        # return
        m,n = len(board), len(board[0])
        def dfs(x,y, idx) -> bool:
            if idx == len(word):
                return True
            #
            if x<0 or y<0 or x>=m or y>=n or board[x][y] != word[idx]:
                return False

            temp = board[x][y]
            board[x][y] = '#'

            #
            found = (
                dfs(x+1,y,idx+1) or
                dfs(x,y+1,idx+1) or
                dfs(x-1,y,idx+1) or
                dfs(x,y-1,idx+1))

            board[x][y]=temp
            return found

        for i in range(m):
            for j in range(n):
                if dfs(i,j,0):
                    return True
        return False