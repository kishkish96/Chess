package chess;

/**
 * 
 * @author Kishan Patel
 * @author Neal Patel
 *
 */

public class King extends Piece{
	/**
	 * Constructor for king pieces
	 * @param color "w" is for white team, "b" is for black team
	 * @param x X location on the board
	 * @param y Y location on the board
	 * @param piece "K" to represent king pieces on the board
	 * @param firstMove check to see if piece made first move or not
	 */
	public King(String color, int x, int y, String piece, boolean firstMove) {
		super(color, x, y, "K", firstMove);
	}
	
	/**
	 * Returns a string appending the "K"(king piece) to the color/team "b"(black) or "w"(white)
	 * @return "bK" for color black, "wK" for color white
	 */
	public String toString() {
		if(color=="b") {
			return "bK ";
		}
		else {
			return "wK ";
		}
	}
	
	/**
	 * Check if move is allowed or not for king pieces
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
			if((Math.abs(newX-currX)==1 || newX-currX == 0) && (Math.abs(newY-currY)==1 || newY-currY == 0) && board[currX][currY].color != "b") {
				if(board[newX][newY]!=null) {
					if(board[newX][newY].getColor() == "b") {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						board[newX][newY].setFirstMove(false);
						return "b";
					}
					else if(board[newX][newY].getColor() == "w"){
						return "w";
					}
				}
				else {
					board[newX][newY] = board[currX][currY];
					board[currX][currY] = null;
					board[newX][newY].setFirstMove(false);
				}
				return "b";
			} 
			else if(newX-currX == 0 && newY-currY == 2 && board[newX][newY+1] instanceof Rook && board[newX][newY+1].isFirstMove() == true && board[currX][currY].isFirstMove() == true && board[newX][newY+1].getColor()!="b" && board[currX][currY+1]==null && board[currX][currY+2] == null && board[currX][currY].color != "b" && !board[currX][currY].inCheck(currX, currY, color, board) && !board[currX][currY].movesToCheck(currX, currY, color, board, newX, currY+1)) {
				board[currX][currY].move(currX, currY, color, board, newX, currY+1, '0', false);
				if(!board[currX][currY+1].movesToCheck(currX, currY+1, color, board, newX, newY)) {
					board[newX][newY] = board[currX][currY+1];
					board[newX][newY].setFirstMove(false);
					board[newX][newY-1] = board[newX][newY+1];
					board[newX][newY-1].setFirstMove(false);
					board[newX][newY+1] = null;
					return "b";
				}
				return "w";
				
			}
			else if(newX-currX == 0 && currY-newY == 2 && board[newX][newY-2] instanceof Rook && board[newX][newY-2].isFirstMove() == true && board[currX][currY].isFirstMove() == true && board[newX][newY-2].getColor()!="b" && board[currX][currY-1]==null && board[currX][currY-2] == null && board[currX][currY-3] == null && board[currX][currY].color != "b" && !board[currX][currY].inCheck(currX, currY, color, board) && !board[currX][currY].movesToCheck(currX, currY, color, board, newX, newY+1)) {
				board[currX][currY].move(currX, currY, color, board, newX, newY+1, '0', false);
				if(!board[currX][newY+1].movesToCheck(currX, newY+1, color, board, newX, newY)) {
					board[newX][newY] = board[currX][newY+1];
					board[newX][newY].setFirstMove(false);
					board[newX][newY+1] = board[newX][newY-2];
					board[newX][newY+1].setFirstMove(false);
					board[newX][newY-2] = null;
					return "b";
				}
				return "w";
			}
			else {
				return "w";
			}
		} 
		else{
			if((Math.abs(newX-currX)==1 || newX-currX == 0) && (Math.abs(newY-currY)==1 || newY-currY == 0) && board[currX][currY].color != "w") {
				if(board[newX][newY]!=null) {
					if(board[newX][newY].getColor() == "w") {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						board[newX][newY].setFirstMove(false);
						return "w";
					}
					else if(board[newX][newY].getColor() == "b"){
						
						return "b";
					}
				}
				else {
					board[newX][newY] = board[currX][currY];
					board[currX][currY] = null;
					board[newX][newY].setFirstMove(false);
				}
				return "w";
			} 
			else if(newX-currX == 0 && newY-currY == 2 && board[newX][newY+1] instanceof Rook && board[newX][newY+1].firstMove == true && board[currX][currY].firstMove == true && board[newX][newY+1].getColor()!="w" && board[currX][currY+1]==null && board[currX][currY+2] == null && board[currX][currY].color != "w" && !board[currX][currY].inCheck(currX, currY, color, board) && !board[currX][currY].movesToCheck(currX, currY, color, board, newX, currY+1)) {
				board[currX][currY].move(currX, currY, color, board, newX, currY+1, '0', false);
				if(!board[currX][currY+1].movesToCheck(currX, currY+1, color, board, newX, newY)) {
					board[newX][newY] = board[currX][currY+1];
					board[newX][newY].setFirstMove(false);
					board[newX][newY-1] = board[newX][newY+1];
					board[newX][newY-1].setFirstMove(false);
					board[newX][newY+1] = null;
					return "w";
				}
				return "b";
				
			}
			else if(newX-currX == 0 && currY-newY == 2 && board[newX][newY-2] instanceof Rook && board[newX][newY-2].firstMove == true && board[currX][currY].firstMove == true && board[newX][newY-2].getColor()!="w" && board[currX][currY-1]==null && board[currX][currY-2] == null && board[currX][currY-3] == null && board[currX][currY].color != "w" && !board[currX][currY].inCheck(currX, currY, color, board) && !board[currX][currY].movesToCheck(currX, currY, color, board, newX, newY+1)) {
				board[currX][currY].move(currX, currY, color, board, newX, newY+1, '0', false);
				if(!board[currX][newY+1].movesToCheck(currX, newY+1, color, board, newX, newY)) {
					board[newX][newY] = board[currX][newY+1];
					board[newX][newY].setFirstMove(false);
					board[newX][newY+1] = board[newX][newY-2];
					board[newX][newY+1].setFirstMove(false);
					board[newX][newY-2] = null;
					return "w";
				}
				return "b";
			}  
			else {
				return "b";
			}
		} 
	}
}
