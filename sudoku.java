
import java.util.*;
public class quesc{
	public static boolean safe(char[][] board,int row,int col,int num) {
		for(int i=0;i<board.length;i++) {
				if(board[i][col]==(char)(num+'0')) {
					return false;
				}
		}
		for(int i=0;i<board.length;i++) {
			if(board[row][i]==(char)(num+'0')) {
				return false;
			}
		}
		int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == (char)(num + '0')) {
                    return false;
                }
            }
        }
        return true;
	}
	public static boolean sud(char[][] board,int row,int col) {
		if(col==board.length) {
			col=0;
			row=row+1;
		}
		if(row==board.length) {
			for(int i=0;i<board.length;i++) {
				for(int j=0;j<board.length;j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			return true;
		}
		if(board[row][col]!='.') {
			return sud(board,row,col+1);
		}
		else {
			for(int i=1;i<10;i++) { 
				if(safe(board,row,col,i)) {
					board[row][col]=(char)(i+'0');
					if(sud(board,row,col+1)){
						return true;
					}
					board[row][col]='.';
				}
			}
		}
		return false;
	}
	public static void print(char[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
			}
	public static void main(String[] args) {
		char[][] board= {
				{'3','.','.','7','2','5','.','8','.'},
				{'1','.','.','.','4','.','.','3','.'},
				{'.','.','.','.','.','.','7','2','4'},
				{'6','.','.','.','3','4','.','9','.'},
				{'.','8','5','9','.','6','1','4','.'},
				{'.','9','.','5','1','.','.','.','6'},
				{'9','3','6','.','.','.','.','.','.'},
				{'.','1','.','.','8','.','.','.','9'},
				{'.','4','.','6','9','1','.','.','2'}
						};
		sud(board,0,0);
	}
}