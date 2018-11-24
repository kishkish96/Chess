package chess;

/**
 * 
 * @author Kishan Patel
 * @author Neal Patel
 *
 */

public class Board {
	
	/**
	 * The color of a piece
	 * "w" for white
	 * "b" for black
	 */
	public static String c;
	/**
	 * The type of piece
	 * "p" for pawn
	 * "R" for rook
	 * "N" for knight
	 * "B" for bishop
	 * "Q" for queen
	 * "K" for king
	 */
	public static String p;
	
	/**
	 * Returns the original/start game board
	 * @return board the starting board
	 */
	public static Piece[][] initialize(){
		Piece[][] board = new Piece[8][8];
		for(int i = 0; i<8; i++) {
			board[1][i] = new Pawn("w",1,i,"p",true); 	
			board[6][i] = new Pawn("b",6,i,"p",true);
		}
		board[0][0] = new Rook("w",0,0,"R", true);
		board[0][7] = new Rook("w",0,7,"R", true);
		board[7][0] = new Rook("b",7,0,"R", true);
		board[7][7] = new Rook("b",7,7,"R", true);
		
		board[0][1] = new Knight("w",0,1,"N", false);
		board[0][6] = new Knight("w",0,6,"N", false);
		board[7][1] = new Knight("b",7,1,"N", false);
		board[7][6] = new Knight("b",7,6,"N", false);
		
		board[0][2] = new Bishop("w",0,2,"B", false);
		board[0][5] = new Bishop("w",0,5,"B", false);
		board[7][2] = new Bishop("b",7,2,"B", false);
		board[7][5] = new Bishop("b",7,5,"B", false);
		
		board[0][3] = new Queen("w",0,3,"Q", false);
		board[0][4] = new King("w",0,4,"K", true);
		board[7][3] = new Queen("b",7,3,"Q", false);
		board[7][4] = new King("b",7,4,"K", true);
		return board;
	}
	
	/**
	 * Returns the color of a piece
	 * @param color the color of a piece
	 * @return "w" for white, "b" for black
	 */
	public static String color(Piece color) {
		if(color.getColor() == "w") {
			return "w";
		} else {
			return "b";
		}
	}

	
	/**
	 * Returns the type of a piece
	 * @param piece the type of a piece
	 * @return "p" for pawn, "R" for rook, "N" for knight, "B" for bishop, "Q" for queen, "K" for king, else invalid move  
	 */
	public static String piece(Piece piece) {
		switch(piece.getPiece()){
		   case "p" :
			   return "p";
		   case "R" :
			   return "R";
		   case "N" :
			   return "N";
		   case "B" :
			   return "B";
		   case "Q" :
			   return "Q";
		   case "K" :
			   return "K";
		}
		return "Invalid Move";
	}
	
	
	/**
	 * Prints the board after each valid move
	 * @param board the board of the game with the updated valid move
	 */
	public static void printBoard(Piece[][] board) {
		// printing of board 
		int k = 9;
		for(int i = 7; i>=0; i--) {
			for(int j = 0; j<8; j++) {
				if(board[i][j] == null) {
					if((i%2 == 0 && j%2 == 0) || (i%2 == 1 && j%2 == 1)) {
						System.out.print("## ");
					} else {
						System.out.print("   ");
					}
				}  
				else if(board[i][j] instanceof Rook) {
					c = color(board[i][j]);
					p = piece(board[i][j]);
					System.out.print(c+p+" ");
				}
				else if(board[i][j] instanceof Pawn) {
					c = color(board[i][j]);
					p = piece(board[i][j]);
					System.out.print(c+p+" ");
				}
				else if(board[i][j] instanceof Knight) {
					c = color(board[i][j]);
					p = piece(board[i][j]);
					System.out.print(c+p+" ");
				}
				else if(board[i][j] instanceof Bishop) {
					c = color(board[i][j]);
					p = piece(board[i][j]);
					System.out.print(c+p+" ");
				}
				else if(board[i][j] instanceof Queen) {
					c = color(board[i][j]);
					p = piece(board[i][j]);
					System.out.print(c+p+" ");
				}
				else if(board[i][j] instanceof King) {
					c = color(board[i][j]);
					p = piece(board[i][j]);
					System.out.print(c+p+" ");
				}
			}
			k--;
			System.out.println(k);
		}
		System.out.print(" a  b  c  d  e  f  g  h");
		System.out.println();
		System.out.println(); 
	}
}
