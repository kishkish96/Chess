package chess;

/**
 * 
 * @author Kishan Patel
 * @author Neal Patel
 *
 */

public class Pawn extends Piece{
	/**
	 * Constructor for pawn pieces
	 * @param color "w" is for white team, "b" is for black team
	 * @param x X location on the board
	 * @param y Y location on the board
	 * @param piece "p" to represent pawn pieces on the board
	 * @param firstMove check to see if piece made first move or not
	 */
	public Pawn(String color, int x, int y, String piece, boolean firstMove) {
		super(color, x, y, "p", firstMove);
	}

	/**
	 * Returns a string appending the "p"(pawn piece) to the color/team "b"(black) or "w"(white)
	 * @return "bp" for color black, "wp" for color white
	 */
	public String toString() {
		if(color=="b") {
			return "bp ";
		}
		else {
			return "wp ";
		}
	}
	
	/**
	 * Check if move is allowed or not for pawn piece
	 * @param currX current/old X location on the board
	 * @param currY current/old Y location on the board
	 * @param color the team/color of the piece
	 * @param board board of the game where the piece is
	 * @param newX new X location on the board
	 * @param newY new Y location on the board
	 * @param promote to handle pawn promotion
	 * @param empassant to check if an empassant move is possible
	 * @return "w" if the next turn should be whites turn to move, "b" if the next turn should be blacks turn to move
	 */
	public String move(int currX, int currY, String color, Piece[][] board, int newX, int newY, char promote, boolean empassant) {
		if(color == "w") { 
			if(board[currX][currY].isFirstMove() == true) {
				if(((newX-currX == 2 && newY - currY == 0)||(newX-currX == 1 && (newY - currY == 0 || newY - currY == 1 || newY-currY == -1))) && board[currX][currY].color != "b") {
					if(board[newX][newY] != null) {
						if((newX-currX == 1 || newX-currX == 2) && newY - currY == 0) {
							
							return "w";
						}
						if(board[newX][newY].getColor() == "b") {
							board[currX][currY].setFirstMove(false);
							board[newX][newY] = board[currX][currY];
							board[currX][currY] = null;
							
							return "b";
						} else if(board[newX][newY].getColor() == "w") {
							
							return "w";
						}
					} else if(board[(currX+newX)/2][currY] != null && newX-currX == 2) {
						return "w";
					} else if (!(newY - currY == 1 || newY-currY == -1)){
						board[currX][currY].setFirstMove(false);
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						
						return "b";
					} else {
						
						return "w";
					}
				} else {
					
					return "w";
				}
			} else {
				if((newX-currX == 1 && (newY - currY == 0 || newY - currY == 1 || newY-currY == -1)) && board[currX][currY].color != "b") {
					if(board[newX][newY] != null) {
						if(newX-currX == 1 && newY - currY == 0) {
							
							return "w";
						}
						if(board[newX][newY].getColor() == "b") {
							if(newX == 7) {
								switch(promote) {
									case 'N': 
										board[newX][newY] = new Knight("w",newX,newY,"N",false);
										break;
									case 'B':
										board[newX][newY] = new Bishop("w",newX,newY,"B",false);
										break;
									case 'R':
										board[newX][newY] = new Rook("w",newX,newY,"R",false);
										break;
									default:
										board[newX][newY] = new Queen("w",newX,newY,"Q",false);
										break;
								}
							} else {
								board[newX][newY] = board[currX][currY];
							}
							board[currX][currY] = null;
							
							return "b";
						} else if(board[newX][newY].getColor() == "w") {
							
							return "w";
						}
					} else if(empassant == true && (newY-currY == 1 && board[4][newY].getColor() == "b" && board[4][newY] instanceof Pawn) || (newY-currY == -1 && board[4][newY].getColor() == "b" && board[4][newY] instanceof Pawn)) {
						if(board[newX][newY] != null) {
							if(board[newX][newY].getColor() == "b") {
								board[newX][newY] = board[currX][currY];
								board[currX][currY] = null;
								board[newX-1][newY] = null;
								return "b";
							} else if(board[newX][newY].getColor() == "w") {
								return "w";
							} 
						} else {
							board[newX][newY] = board[currX][currY];
							board[currX][currY] = null;
							board[newX-1][newY] = null;
							return "b";
						}
					} else if(!(newY - currY == 1 || newY-currY == -1)){
						if(newX == 7) {
							switch(promote) {
								case 'N': 
									board[newX][newY] = new Knight("w",newX,newY,"N",false);
									break;
								case 'B':
									board[newX][newY] = new Bishop("w",newX,newY,"B",false);
									break;
								case 'R':
									board[newX][newY] = new Rook("w",newX,newY,"R",false);
									break;
								default:
									board[newX][newY] = new Queen("w",newX,newY,"Q",false);
									break;
							}
						} else {
							board[newX][newY] = board[currX][currY];
						}
						board[currX][currY] = null;
						
						return "b";
					} else {
						
						return "w";
					}
				} else {
					
					return "w";
				}
			}
		} else if (color == "b") {
			if(board[currX][currY].isFirstMove() == true) {
				if(((newX-currX == -2 && newY - currY == 0)||(newX-currX == -1 && (newY - currY == 0 || newY - currY == 1 || newY-currY == -1))) && board[currX][currY].color != "w") {
					if(board[newX][newY] != null) {
						if((newX-currX == -1 || newX-currX == -2) && newY - currY == 0) {
							
							return "b";
						}
						if(board[newX][newY].getColor() == "w") {
							board[currX][currY].setFirstMove(false);
							board[newX][newY] = board[currX][currY];
							board[currX][currY] = null;
							
							return "w";
						} else if(board[newX][newY].getColor() == "b") {
							
							return "b";
						}
					} else if(board[(currX+newX)/2][currY] != null && newX-currX == -2) {
						
						return "b";
					} else if(!(newY - currY == 1 || newY-currY == -1)) {
						board[currX][currY].setFirstMove(false);
						board[newX][newY] = board[currX][currY];
						board[currX][currY] = null;
						
						return "w";
					} else {
						
						return "b";
					}
				} else {
					
					return "b";
				}
			} else {
				if((newX-currX == -1 && (newY - currY == 0 || newY - currY == 1 || newY-currY == -1)) && board[currX][currY].color != "w") {
					if(board[newX][newY] != null) {
						if(newX-currX == -1 && newY - currY == 0) {
							
							return "b";
						}
						if(board[newX][newY].getColor() == "w") {
							if(newX == 0) {
								switch(promote) {
									case 'N': 
										board[newX][newY] = new Knight("b",newX,newY,"N",false);
										break;
									case 'B':
										board[newX][newY] = new Bishop("b",newX,newY,"B",false);
										break;
									case 'R':
										board[newX][newY] = new Rook("b",newX,newY,"R",false);
										break;
									default:
										board[newX][newY] = new Queen("b",newX,newY,"Q",false);
										break;
								}
							} else {
								board[newX][newY] = board[currX][currY];
							}
							board[currX][currY] = null;
							
							return "w";
						} else if(board[newX][newY].getColor() == "b") {
							
							return "b";
						}
					} else if(empassant == true && (newY-currY == 1 && board[3][newY].getColor() == "w" && board[3][newY] instanceof Pawn) || (newY-currY == -1 && board[3][newY].getColor() == "w" && board[3][newY] instanceof Pawn)) {
						if(board[newX][newY] != null) {
							if(board[newX][newY].getColor() == "w") {
								board[newX][newY] = board[currX][currY];
								board[currX][currY] = null;
								board[newX+1][newY] = null;
								return "w";
							} else if(board[newX][newY].getColor() == "b") {
								return "b";
							} 
						} else {
							board[newX][newY] = board[currX][currY];
							board[currX][currY] = null;
							board[newX+1][newY] = null;
							return "w";
						}
					} else if(!(newY - currY == 1 || newY-currY == -1)) {
						if(newX == 0) {
							switch(promote) {
								case 'N': 
									board[newX][newY] = new Knight("b",newX,newY,"N",false);
									break;
								case 'B':
									board[newX][newY] = new Bishop("b",newX,newY,"B",false);
									break;
								case 'R':
									board[newX][newY] = new Rook("b",newX,newY,"R",false);
									break;
								default:
									board[newX][newY] = new Queen("b",newX,newY,"Q",false);
									break;
							}
						} else {
							board[newX][newY] = board[currX][currY];
						}
						board[currX][currY] = null;
						
						return "w";
					} else {
						
						return "b";
					}  
				} else {
					
					return "b";
				}
			}
		}
		return null;
	}
}
