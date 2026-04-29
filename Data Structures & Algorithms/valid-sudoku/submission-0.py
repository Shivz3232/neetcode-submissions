class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        i = 0
        while i < len(board):
            frequencies = {}
            j = 0
            while j < len(board):
                if board[i][j] == '.':
                    j += 1
                    continue
                frequencies[board[i][j]] = frequencies.get(board[i][j], 0) + 1
                if frequencies[board[i][j]] > 1:
                    return False
                j += 1
            i += 1
        
        i = 0
        while i < len(board):
            frequencies = {}
            j = 0
            while j < len(board):
                if board[j][i] == '.':
                    j += 1
                    continue
                frequencies[board[j][i]] = frequencies.get(board[j][i], 0) + 1
                if frequencies[board[j][i]] > 1:
                    return False
                j += 1
            i += 1
        
        rowCelli = 0
        while rowCelli < len(board):
            whi
            i = rowCelli
            while i < rowCelli + 3:
                frequencies = {}
                j = rowCellj
                while j < colCellj + 3:
                    if board[i][j] == '.':
                        j += 1
                        continue
                    frequencies[board[i][j]] = frequencies.get(board[i][j], 0) + 1
                    if frequencies[board[i][j]] > 1:
                        return False
                    j += 1
                
                i += 1

            
        
        return True


