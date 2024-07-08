
import java.util.*;
public class quesd {
	public static List<List<String>> mainout(char[][] board,List<List<String>> output) {
		List<String> n=new ArrayList<>();
		String r;
		for(int i=0;i<board.length;i++) {
			r="";
			for(int j=0;j<board.length;j++) {
				r=r+board[i][j];
			}
			n.add(r);
		}
		output.add(n);
		return output;
	}
    public static boolean check(char[][] board){
        List<Integer> hor=new ArrayList<>(0);
        List<Integer> ab=new ArrayList<>(0);
        List<Integer> ba=new ArrayList<>(0);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
            	if('Q'==board[i][j]) {
            		if(!hor.contains(i)) {
            			hor.add(i);
            		}else return false;
            		if(!ab.contains(i-j)) {
            			ab.add(i-j);
            		}else return false;
            		if(!ba.contains(i+j)) {
            			ba.add(i+j);
            		}else return false;
            	}
            }
        }
        return true;
    }
    public static List<List<String>> nqueen(char[][] board,List<List<String>> output,int col){
    	if(col==board.length) {
    		output=mainout(board,output);
    		return output;
    	}
    	for(int i=0;i<board.length;i++) {
    		board[i][col]='Q';
    		if(check(board)) {
    			nqueen(board,output,col+1);
    		}
    		board[i][col]='.';
    	}
    	return output;
    }
    public static void main(String[] args) {
    	int n=4;
        char[][] board=new char[n][n];
        for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				board[i][j]='.';
			}
		}
        List<List<String>> output = new ArrayList<>();
        output=nqueen(board,output,0);
        System.out.println(output);
    }
}