package chess;

/**
 * 
 * @author Kishan Patel
 * @author Neal Patel
 *
 */

public class Knight extends Piece{
	/**
	 * Constructor for knight pieces
	 * @param color "w" is for white team, "b" is for black team
	 * @param x X location on the board
	 * @param y Y location on the board
	 * @param piece "N" to represent knight pieces on the board
	 * @param firstMove check to see if piece made first move or not - no need to handle for this piece
	 */
	public Knight(String color, int x, int y, String piece, boolean firstMove) {
		super(color, x, y, "N", firstMove);
	}
	 
	/**
	 * Returns a string appending the "N"(knight piece) to the color/team "b"(black) or "w"(white)
	 * @return "bN" for color black, "wN" for color white
	 */
	public String toString() {
		if(color=="b") {
			return "bN ";
		}
		else {
			return "wN ";
		}
	}
	
	/**
	 * Check if move is allowed or not for knight pieces
	 * @param currX current/old X location on the board
	 * @param currY current/old Y location on the board
	 * @param color the team/color of the piece
	 * @param board board of the game where the piece is
	 * @param newX new X location on the board
	 * @param newY new Y location on the board
	 * @param promote to handle pawn promotion - no need to handle for this piece
	 * @param empassant to check if an empassant move is possible - no need to handle for this piece
	 * @return "w" if the next turn should be whites turn to move, "b" if the next turn should be blacks turn to move
	 */
	public String move(int currX, int currY, String color, Piece[][] board, int newX, int newY, char promote, boolean empassant) {
		if(color == "w") {
			if(((Math.abs(newX-currX) == 2 && Math.abs(newY - currY) == 1) || (Math.abs(newX-currX) == 1 && Math.abs(newY - currY) == 2)) && board[currX][currY].color != "b") {
				if(board[newX][newY]!=null) {
					if(board[newX][newY].getColor() == "b") {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						
						return "b";
					}
					else if(board[newX][newY].getColor() == "w"){
						
						return "w";
					}
				}
				else {
					board[newX][newY] = board[currX][currY];
					board[currX][currY] = null;
					
				}
				return "b";
			} else {
				
				return "w";
			}
		} 
		else{
			if(((Math.abs(newX-currX) == 2 && Math.abs(newY - currY) == 1) || (Math.abs(newX-currX) == 1 && Math.abs(newY - currY) == 2)) && board[currX][currY].color != "w") {
				if(board[newX][newY]!=null) {
					if(board[newX][newY].getColor() == "w") {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						
						return "w";
					}
					else if(board[newX][newY].getColor() == "b"){
						
						return "b";
					}
				}
				else {
					board[newX][newY] = board[currX][currY];
					board[currX][currY] = null;
					
				}  
				return "w";
			} else {
				
				return "b";
			}
		}
	}
}
