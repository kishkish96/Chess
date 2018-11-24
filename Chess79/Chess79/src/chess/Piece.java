package chess;

/**
 * 
 * @author Kishan Patel
 * @author Neal Patel
 *
 */

public class Piece {
	
	/**
	 * The color of a piece
	 * "w" for white
	 * "b" for black
	 */
	public String color;
	/**
	 * X location of a piece on the board
	 */
	public int x;
	/**
	 * Y location of a piece on the board
	 */
	public int y;
	/**
	 * The type of piece
	 * "p" for pawn
	 * "R" for rook
	 * "N" for knight
	 * "B" for bishop
	 * "Q" for queen
	 * "K" for king
	 */
	public String piece;
	/**
	 * Check to see if a piece is moving for the first time or not - only needs to be handled for some pieces
	 * true = still hasn't moved
	 * false = has moved at least one time
	 */
	public boolean firstMove;
	
	/**
	 * Constructor for all pieces
	 * @param color "w" is for white team, "b" is for black team
	 * @param x X location on the board
	 * @param y Y location on the board
	 * @param piece to represent a piece on the board
	 * @param firstMove check to see if piece made first move or not - only need to be handled for some pieces
	 */
	public Piece(String color, int x, int y, String piece, boolean firstMove) {
		this.color = color;
		this.y = y;
		this.x = x;
		this.piece = piece;
		this.firstMove = firstMove;
	}

	/**
	 * Returns the X location of a piece on the board
	 * @return X location 
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the X location of a piece on the board
	 * @param x X location
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns the color of a piece on the board
	 * @return "w" for white, "b" for black
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color of a piece on the board
	 * @param color "w" for white, "b" for black
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Returns the Y location of a piece on the board
	 * @return Y location 
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the Y location of a piece on the board
	 * @param y Y location
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Returns the type of a piece on the board
	 * @return "p" for pawn, "R" for rook, "N" for knight, "B" for bishop, "Q" for queen, "K" for king
	 */
	public String getPiece() {
		return piece;
	}

	/**
	 * Sets the type of a piece on the board
	 * @param piece "p" for pawn, "R" for rook, "N" for knight, "B" for bishop, "Q" for queen, "K" for king
	 */
	public void setPiece(String piece) {
		this.piece = piece;
	}

	/**
	 * Return true or false depending on if piece moved already or not
	 * @return true means hasn't moved yet, false means moved at least one time
	 */
	public boolean isFirstMove() {
		return firstMove;
	}

	/**
	 * Sets the piece to true or false depending on if the piece moved yet or not
	 * @param firstMove true means hasn't moved yet, false means moved at least one time
	 */
	public void setFirstMove(boolean firstMove) {
		this.firstMove = firstMove;
	}


	/*public static String movepiece(int currX, int currY, String color, Piece[][] board, int newX, int newY) {
		Piece res = board[currX][currY];
		if(res.piece == "p") {
			color = Pawn.movePawn(currX, currY, color, board, newX, newY);
			return color;
		}
		if(res.piece == "N") {
			Knight.moveKnight(currX, currY, color, board, newX, newY);
		}
		if(res.piece == "R") {
			Rook.moveRook(currX, currY, color, board, newX, newY);
		}
		if(res.piece == "B") {
			Bishop.moveBishop(currX, currY, color, board, newX, newY);
		}
		if(res.piece == "K") {
			King.moveKing(currX, currY, color, board, newX, newY);
		}
		if(res.piece == "Q") {
			Queen.moveQueen(currX, currY, color, board, newX, newY);
		}
		return null;
	}*/
	
	/**
	 * Checks to see if a king is in check or not
	 * @param currX the current/old X location of a piece on the board
	 * @param currY the current/old Y location of a piece on the board
	 * @param color the team/color of the piece 
	 * @param board board of the game where the piece is
	 * @return true if king in check, false otherwise
	 */
	public boolean inCheck(int currX, int currY, String color, Piece[][] board) {
		// used only for king pieces
		if(color=="w") {
			for(int i = 0; i<board.length; i++) {
				for(int j =0; j<board.length; j++) {
					Piece[][] temp = new Piece[8][8];
					for(int k =0; k<board.length;k++) {
						for(int l = 0; l<board.length;l++) {
							if(board[k][l] instanceof Pawn) {
								temp[k][l] = new Pawn(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
							}
							else if(board[k][l] instanceof Rook) {
								temp[k][l] = new Rook(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
							}
							else if(board[k][l] instanceof Knight) {
								temp[k][l] = new Knight(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
							}
							else if(board[k][l] instanceof Queen) {
								temp[k][l] = new Queen(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
							}
							else if(board[k][l] instanceof King) {
								temp[k][l] = new King(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
							}
							else if(board[k][l] instanceof Bishop) {
								temp[k][l] = new Bishop(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
							}
						}
					}
					if(temp[i][j]!=null) {
						if(temp[i][j].getColor() == "b") {
							if(temp[i][j].move(i, j, "b", temp, currX, currY, '0', false) == "w") {
								return true;
							}
						}
					}
				}
			}
			return false;
		}
		else{
			for(int i = 0; i<board.length; i++) {
				for(int j =0; j<board.length; j++) {
					Piece[][] temp = new Piece[8][8];
					for(int k =0; k<8;k++) {
						for(int l = 0; l<8;l++) {
							if(board[k][l] instanceof Pawn) {
								temp[k][l] = new Pawn(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
							}
							else if(board[k][l] instanceof Rook) {
								temp[k][l] = new Rook(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
							}
							else if(board[k][l] instanceof Knight) {
								temp[k][l] = new Knight(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
							}
							else if(board[k][l] instanceof Queen) {
								temp[k][l] = new Queen(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
							}
							else if(board[k][l] instanceof King) {
								temp[k][l] = new King(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
							}
							else if(board[k][l] instanceof Bishop) {
								temp[k][l] = new Bishop(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
							}
						}
					}
					if(temp[i][j]!=null) {
						if(temp[i][j].getColor() == "w") {
							if(temp[i][j].move(i, j, "w", temp, currX, currY, '0', false) == "b") {
								return true;
							}
						}
					}
				}
			}
			return false;
		}
	}
	
	/**
	 * Checks to see if a move for the king piece in check is allowed or not
	 * @param currX the current/old X location of a piece on the board
	 * @param currY the current/old Y location of a piece on the board
	 * @param color the team/color of the piece 
	 * @param board board of the game where the piece is
	 * @param newX the new X location of a piece on the board
	 * @param newY the new Y location of a piece on the board
	 * @return returns true is move not allowed, false otherwise
	 */
	public boolean movesToCheck(int currX, int currY, String color, Piece[][] board, int newX, int newY) {
		// used only for king pieces
		if(color == "w") {
			Piece[][] temp = new Piece[8][8];
			for(int i =0; i<8;i++) {
				for(int j = 0; j<8;j++) {
					if(board[i][j] instanceof Pawn) {
						temp[i][j] = new Pawn(board[i][j].getColor(), board[i][j].getX(), board[i][j].getY(), board[i][j].getPiece(), board[i][j].isFirstMove());
					}
					else if(board[i][j] instanceof Rook) {
						temp[i][j] = new Rook(board[i][j].getColor(), board[i][j].getX(), board[i][j].getY(), board[i][j].getPiece(), board[i][j].isFirstMove());
					}
					else if(board[i][j] instanceof Knight) {
						temp[i][j] = new Knight(board[i][j].getColor(), board[i][j].getX(), board[i][j].getY(), board[i][j].getPiece(), board[i][j].isFirstMove());
					}
					else if(board[i][j] instanceof Queen) {
						temp[i][j] = new Queen(board[i][j].getColor(), board[i][j].getX(), board[i][j].getY(), board[i][j].getPiece(), board[i][j].isFirstMove());
					}
					else if(board[i][j] instanceof King) {
						temp[i][j] = new King(board[i][j].getColor(), board[i][j].getX(), board[i][j].getY(), board[i][j].getPiece(), board[i][j].isFirstMove());
					}
					else if(board[i][j] instanceof Bishop) {
						temp[i][j] = new Bishop(board[i][j].getColor(), board[i][j].getX(), board[i][j].getY(), board[i][j].getPiece(), board[i][j].isFirstMove());
					}
				}
			}  
			
			if(temp[currX][currY].move(currX, currY, color, temp, newX, newY, '0', false) == "b") {
				if(temp[newX][newY].inCheck(newX, newY, color, temp)) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		else {
			Piece[][] temp = new Piece[8][8];
			for(int i =0; i<8;i++) {
				for(int j = 0; j<8;j++) {
					if(board[i][j] instanceof Pawn) {
						temp[i][j] = new Pawn(board[i][j].getColor(), board[i][j].getX(), board[i][j].getY(), board[i][j].getPiece(), board[i][j].isFirstMove());
					}
					else if(board[i][j] instanceof Rook) {
						temp[i][j] = new Rook(board[i][j].getColor(), board[i][j].getX(), board[i][j].getY(), board[i][j].getPiece(), board[i][j].isFirstMove());
					}
					else if(board[i][j] instanceof Knight) {
						temp[i][j] = new Knight(board[i][j].getColor(), board[i][j].getX(), board[i][j].getY(), board[i][j].getPiece(), board[i][j].isFirstMove());
					}
					else if(board[i][j] instanceof Queen) {
						temp[i][j] = new Queen(board[i][j].getColor(), board[i][j].getX(), board[i][j].getY(), board[i][j].getPiece(), board[i][j].isFirstMove());
					}
					else if(board[i][j] instanceof King) {
						temp[i][j] = new King(board[i][j].getColor(), board[i][j].getX(), board[i][j].getY(), board[i][j].getPiece(), board[i][j].isFirstMove());
					}
					else if(board[i][j] instanceof Bishop) {
						temp[i][j] = new Bishop(board[i][j].getColor(), board[i][j].getX(), board[i][j].getY(), board[i][j].getPiece(), board[i][j].isFirstMove());
					}
				}
			}
			if(temp[currX][currY].move(currX, currY, color, temp, newX, newY, '0', false) == "w") {
				if(temp[newX][newY].inCheck(newX, newY, color, temp)) {
					return true;
				}
			}
		}
		return false;		
	}
	
	/**
	 * Checks if a move is valid. Used within kingMoves method to determine if a king in check has any possible moves
	 * @param currX current X location of King on the board
	 * @param currY current Y location of King on the board
	 * @param color the team/color of the King
	 * @param board board of the game where the piece is
	 * @param newX new X location that is checked to see if move is valid
	 * @param newY new Y location that is checked to see if move is valid
	 * @return true if move is valid, false otherwise
	 */
	public boolean validMove(int currX, int currY, String color, Piece[][] board, int newX, int newY) {
		if(board[newX][newY] != null && board[newX][newY].getColor() == color) {
			return false;
		}
		else {
			if(board[currX][currY].movesToCheck(currX, currY, color, board, newX, newY)) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Check if there are any valid moves left for a king that is in check
	 * @param currX current X location of King on the board
	 * @param currY current Y location of King on the board
	 * @param color the team/color of the King
	 * @param board board of the game where the piece is
	 * @return true if there are still valid moves left, false is there are none
	 */
	public boolean kingMoves(int currX, int currY, String color, Piece[][] board) {
		// if king is in corner
		if((currX == 0 || currX == 7) && (currY == 0 || currY == 7)) {
			if(!board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX), Math.abs(currY-1))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX-1), Math.abs(currY-1))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX-1), Math.abs(currY))
					){
				return false;
			}
			return true;
		}
	
		// if king is on x = 7 or x = 0
		else if(currX == 0 || currX == 7) {
			if(!board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX-1), Math.abs(currY))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX-1), Math.abs(currY-1))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX-1), Math.abs(currY+1))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX), Math.abs(currY-1))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX), Math.abs(currY+1))
					){
				return false;
			}
			return true;	
		}
		
		// if king is on y = 7 or y = 0
		else if(currY == 0 || currY == 7) {
			if(!board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX-1), Math.abs(currY))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX+1), Math.abs(currY))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX-1), Math.abs(currY-1))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX), Math.abs(currY-1))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX+1), Math.abs(currY+1))
					){
				return false;
			}
			return true;	
		}
		
		// if king is anywhere else
		else {
			if(!board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX), Math.abs(currY-1))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX), Math.abs(currY+1))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX-1), Math.abs(currY-1))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX-1), Math.abs(currY))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX-1), Math.abs(currY+1))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX+1), Math.abs(currY-1))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX+1), Math.abs(currY))
					&& !board[currX][currY].validMove(currX, currY, color, board, Math.abs(currX+1), Math.abs(currY+1))
					) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if non-king piece can bring King out of check
	 * @param currX current/old X location on the board
	 * @param currY current/old Y location on the board
	 * @param color the team/color of the piece
	 * @param board board of the game where the piece is
	 * @param newX new X location on the board
	 * @param newY new Y location on the board
	 * @param promote used for handling pawn promotion
	 * @param empassant to check if an empassant move is possible for pawn
	 * @return true if piece can bring king out of check, false otherwise
	 */
	
	public boolean savesKing(int currX, int currY, String color, Piece[][] board, int newX, int newY, char promote, boolean empassant ) {
		Piece[][] temp = new Piece[8][8];
		for(int k =0; k<board.length;k++) {
			for(int l = 0; l<board.length;l++) {
				if(board[k][l] instanceof Pawn) {
					temp[k][l] = new Pawn(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
				}
				else if(board[k][l] instanceof Rook) {
					temp[k][l] = new Rook(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
				}
				else if(board[k][l] instanceof Knight) {
					temp[k][l] = new Knight(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
				}
				else if(board[k][l] instanceof Queen) {
					temp[k][l] = new Queen(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
				}
				else if(board[k][l] instanceof King) {
					temp[k][l] = new King(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
				}
				else if(board[k][l] instanceof Bishop) {
					temp[k][l] = new Bishop(board[k][l].getColor(), board[k][l].getX(), board[k][l].getY(), board[k][l].getPiece(), board[k][l].isFirstMove());
				}
			}
		}
		if(color =="w") {
			if(temp[currX][currY].move(currX, currY, color, temp, newX, newY, promote, empassant) == "b"){
				for(int i =0; i<board.length;i++) {
					for(int j =0; j<board.length;j++) {
						if(temp[i][j] instanceof King && temp[i][j].getColor() == "w") {
							if(temp[i][j].inCheck(i, j, color, temp)) {
								return false;
							}
						}

					}
				}
			}
			else {
				return true;
			}
		}
		
		else if(color =="b") {
			if(temp[currX][currY].move(currX, currY, color, temp, newX, newY, promote, empassant) == "w"){
				for(int i =0; i<board.length;i++) {
					for(int j =0; j<board.length;j++) {
						if(temp[i][j] instanceof King && temp[i][j].getColor() == "b") {
							if(temp[i][j].inCheck(i, j, color, temp)) {
								return false;
							}
						}
					}
				}
			}
			else {
				return true;
			}
		}
		return true;
	}
	
	
	
	/**
	 * Check if move is allowed or not for all pieces - goes to piece specified in user input
	 * @param currX current/old X location on the board
	 * @param currY current/old Y location on the board
	 * @param color the team/color of the piece
	 * @param board board of the game where the piece is
	 * @param newX new X location on the board
	 * @param newY new Y location on the board
	 * @param promote to handle pawn promotion - only need to be handled for some pieces
	 * @param empassant to check if an empassant move is possible - only need to be handled for some pieces
	 * @return "w" if the next turn should be whites turn to move, "b" if the next turn should be blacks turn to move
	 */
	public String move(int currX, int currY, String color, Piece[][] board, int newX, int newY, char promote, boolean empassant) {
		String a = move(currX, currY, color, board, newX, newY, promote, empassant);
		return a;
	} 
	
}
