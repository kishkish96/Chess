package chess;

/**
 * 
 * @author Kishan Patel
 * @author Neal Patel
 *
 */

public class Rook extends Piece{
	/**
	 * Constructor for rook pieces
	 * @param color "w" is for white team, "b" is for black team
	 * @param x X location on the board
	 * @param y Y location on the board
	 * @param piece "R" to represent rook pieces on the board
	 * @param firstMove check to see if piece made first move or not
	 */
	public Rook(String color, int x, int y, String piece, boolean firstMove) {
		super(color, x, y, "R", firstMove);
	}
	
	/** 
	 * Returns a string appending the "R"(rook piece) to the color/team "b"(black) or "w"(white)
	 * @return "bR" for color black, "wR" for color white
	 */
	public String toString() {
		if(color=="b") {
			return "bR ";
		}
		else {
			return "wR ";
		}
	}
	
	/**
	 * Check if move is allowed or not for rook piece
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
			if((Math.abs(newX-currX) == 0 || Math.abs(newY-currY) == 0) && !(Math.abs(newX-currX) == 0 && Math.abs(newY-currY) == 0) && board[currX][currY].color != "b") {
				if(newX>currX) {
					for(int count = currX + 1; count<newX; count++) {
						if(board[count][newY] != null) {
							return "w"; 
						}
					}
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
						return "b";
					}
				}
				else if(newX<currX) {
					for(int count = currX - 1; count>newX; count--) {
						if(board[count][newY] != null) {
							return "w"; 
						}
					}
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
						return "b";
					}
				}
				else if(newY<currY) {
					for(int count = currY - 1; count>newY; count--) {
						if(board[newX][count] != null) {
							return "w"; 
						}
					}
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
						return "b";
					}
				}
				else{
					for(int count = currY + 1; count<newY; count++) {
						if(board[newX][count] != null) {
							
							return "w"; 
						}
					}
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
						return "b";
					}
				}
			}
			else {
				return "w";
			}
		}

		else{
			if((Math.abs(newX-currX) == 0 || Math.abs(newY-currY) == 0) && !(Math.abs(newX-currX) == 0 && Math.abs(newY-currY) == 0) && board[currX][currY].color != "w") {
				if(newX>currX) {
					for(int count = currX + 1; count<newX; count++) {
						if(board[count][newY] != null) {
							
							return "b"; 
						}
					}
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
						return "w";
					}
				}
				else if(newX<currX) {
					for(int count = currX - 1; count>newX; count--) {
						if(board[count][newY] != null) {
							
							return "b"; 
						}
					}
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
						return "w";
					}
				}
				else if(newY<currY) {
					for(int count = currY - 1; count>newY; count--) {
						if(board[newX][count] != null) {
							
							return "b"; 
						}
					}
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
						return "w";
					}
				}
				else{
					for(int count = currY + 1; count<newY; count++) {
						if(board[newX][count] != null) {
							
							return "b"; 
						}
					}
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
						return "w";
					}
				}	 
			}
			else {
				
				return "b";
			}
		}

		return color;
	}
}
