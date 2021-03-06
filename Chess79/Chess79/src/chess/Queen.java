package chess;

/**
 * 
 * @author Kishan Patel
 * @author Neal Patel
 *
 */

public class Queen extends Piece{
	/**
	 * Constructor for queen pieces
	 * @param color "w" is for white team, "b" is for black team
	 * @param x X location on the board
	 * @param y Y location on the board
	 * @param piece "Q" to represent queen pieces on the board
	 * @param firstMove check to see if piece made first move or not - no need to handle for this piece
	 */
	public Queen(String color, int x, int y, String piece, boolean firstMove) {
		super(color, x, y, "Q", firstMove);
	}
	
	/** 
	 * Returns a string appending the "Q"(queen piece) to the color/team "b"(black) or "w"(white)
	 * @return "bQ" for color black, "wQ" for color white
	 */
	public String toString() {
		if(color=="b") {
			return "bQ ";
		}
		else {
			return "wQ ";
		}
	}
	
	/**
	 * Check if move is allowed or not for queen pieces
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
			}
			else if((Math.abs(newX-currX) == 0 || Math.abs(newY-currY) == 0) && !(Math.abs(newX-currX) == 0 && Math.abs(newY-currY) == 0) && board[currX][currY].color != "b") {
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
							
							return "b";
						}
						else if(board[newX][newY].getColor() == "w"){
							 
							return "w";
						}
					}
					else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						
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
							
							return "b";
						}
						else if(board[newX][newY].getColor() == "w"){
							 
							return "w";
						}
					}
					else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						
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
							
							return "b";
						}
						else if(board[newX][newY].getColor() == "w"){
							 
							return "w";
						}
					}
					else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
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
							return "b";
						}
						else if(board[newX][newY].getColor() == "w"){
							 
							return "w";
						}
					}
					else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						return "b";
					}
				}
			}
			
			else if((Math.abs(newX - currX) == Math.abs(newY - currY)) && board[currX][currY].color != "b") {
				if(currX<newX && currY<newY) {
					int i = currX+1;
					int j = currY+1;
					while(i<newX && j<newY) {
						if(board[i][j] != null) {
							 
							return "w";
						}
						i++;
						j++;
					}
					if(board[newX][newY] != null) {
						if(board[newX][newY].getColor() == "b") {
							board[newX][newY] = board[currX][currY];
							board[currX][currY] = null;
							return "b";
						} else if(board[newX][newY].getColor() == "w") {
							 
							return "w";
						}
					} else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						return "b";
					}
				} else if(currX<newX && currY>newY) {
					int i = currX+1;
					int j = currY-1;
					while(i<newX && j>newY) {
						if(board[i][j] != null) {
							 
							return "w";
						}
						i++;
						j--;
					}
					if(board[newX][newY] != null) {
						if(board[newX][newY].getColor() == "b") {
							board[newX][newY] = board[currX][currY];
							board[currX][currY] = null;
							return "b";
						} else if(board[newX][newY].getColor() == "w") {
							 
							return "w";
						}
					} else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						return "b";
					}
				} else if(currX>newX && currY>newY) {
					int i = currX-1;
					int j = currY-1;
					while(i>newX && j>newY) {
						if(board[i][j] != null) {
							 
							return "w";
						}
						i--;
						j--;
					}
					if(board[newX][newY] != null) {
						if(board[newX][newY].getColor() == "b") {
							board[newX][newY] = board[currX][currY];
							board[currX][currY] = null;
							return "b";
						} else if(board[newX][newY].getColor() == "w") {
							 
							return "w";
						}
					} else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						return "b";
					}
				} else if(currX>newX && currY<newY) {
					int i = currX-1;
					int j = currY+1;
					while(i<newX && j>newY) {
						if(board[i][j] != null) {
							 
							return "w";
						}
						i--;
						j++;
					}
					if(board[newX][newY] != null) {
						if(board[newX][newY].getColor() == "b") {
							board[newX][newY] = board[currX][currY];
							board[currX][currY] = null;
							return "b";
						} else if(board[newX][newY].getColor() == "w") {
							 
							return "w";
						}
					} else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						return "b";
					}
				}
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
			} 
			
			else if((Math.abs(newX-currX) == 0 || Math.abs(newY-currY) == 0) && !(Math.abs(newX-currX) == 0 && Math.abs(newY-currY) == 0) && board[currX][currY].color != "w") {
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
							return "w";
						}
						else if(board[newX][newY].getColor() == "b"){
							 
							return "b";
						}
					}
					else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
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
							return "w";
						}
						else if(board[newX][newY].getColor() == "b"){
							 
							return "b";
						}
					}
					else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
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
							return "w";
						}
						else if(board[newX][newY].getColor() == "b"){
							 
							return "b";
						}
					}
					else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
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
							return "w";
						}
						else if(board[newX][newY].getColor() == "b"){
							 
							return "b";
						}
					}
					else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						return "w";
					}
				}	
			}
			
			else if((Math.abs(newX - currX) == Math.abs(newY - currY)) && board[currX][currY].color != "w") {
				if(currX<newX && currY<newY) {
					int i = currX+1;
					int j = currY+1;
					while(i<newX && j<newY) {
						if(board[i][j] != null) {
							 
							return "b";
						}
						i++;
						j++;
					}
					if(board[newX][newY] != null) {
						if(board[newX][newY].getColor() == "w") {
							board[newX][newY] = board[currX][currY];
							board[currX][currY] = null;
							return "w";
						} else if(board[newX][newY].getColor() == "b") {
							 
							return "b";
						}
					} else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						return "w";
					}
				} else if(currX<newX && currY>newY) {
					int i = currX+1;
					int j = currY-1;
					while(i<newX && j>newY) {
						if(board[i][j] != null) {
							 
							return "b";
						}
						i++;
						j--;
					}
					if(board[newX][newY] != null) {
						if(board[newX][newY].getColor() == "w") {
							board[newX][newY] = board[currX][currY];
							board[currX][currY] = null;
							return "w";
						} else if(board[newX][newY].getColor() == "b") {
							 
							return "b";
						}
					} else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						return "w";
					}
				} else if(currX>newX && currY>newY) {
					int i = currX-1;
					int j = currY-1;
					while(i>newX && j>newY) {
						if(board[i][j] != null) {
							 
							return "b";
						}
						i--;
						j--;
					}
					if(board[newX][newY] != null) {
						if(board[newX][newY].getColor() == "w") {
							board[newX][newY] = board[currX][currY];
							board[currX][currY] = null;
							return "w";
						} else if(board[newX][newY].getColor() == "w") {
							 
							return "b";
						}
					} else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						return "w";
					}
				} else if(currX>newX && currY<newY) {
					int i = currX-1;
					int j = currY+1;
					while(i<newX && j>newY) {
						if(board[i][j] != null) {
							 
							return "b";
						}
						i--;
						j++;
					}
					if(board[newX][newY] != null) {
						if(board[newX][newY].getColor() == "w") {
							board[newX][newY] = board[currX][currY];
							board[currX][currY] = null;
							return "w";
						} else if(board[newX][newY].getColor() == "w") {
							 
							return "b";
						}  
					} else {
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						return "w";
					}
				}
			}
			
			else {
				 
				return "b";
			}
		}
		return null;
	}
}
