package chess;

/**
 * 
 * @author Kishan Patel
 * @author Neal Patel
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chess {
	
	/**
	 * Main Class where the program runs the chess game
	 * @param args boilerplate
	 * @throws IOException Signals that an I/O exception of some sort has occurred
	 * @throws ArrayIndexOutOfBoundsException Signals that array index is out of bounds
	 */
	public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
		
		Piece[][] board = Board.initialize();
		Boolean gameOver = false;
		
		String input;
		String currentX;
		char currentY;
		String newestX;
		char newestY;
		int currX = 0;
		int currY = 0;
		int newX = 0;
		int newY = 0;
		String color = "w";
		char promote = 1;
		boolean draw = false;
		String oldcolor = "b";
		boolean empassant = false;
		int empX = 0;
		int empY = 0;
		  
		while(!gameOver) {
			int a = 0;
			int b = 0;
			int pieces = 0;
			for(int i =0; i<board.length; i++) {
				for(int j =0; j<board.length; j++) {
					if(board[i][j] instanceof King && board[i][j].getColor() == color) {
						a = i;
						b = j;
					}
					if(board[i][j]!=null && board[i][j].getColor() == color) {
						pieces++;
					}
				}
			}
			if(pieces == 1) {
				if(!board[a][b].kingMoves(a, b, color, board)) {
					gameOver = true;
					Board.printBoard(board);
					System.out.println("Stalemate");
					break;
				}
			}
			else if(color == "w" && board[a][b].inCheck(a, b, color, board) && !board[a][b].kingMoves(a, b, color, board)) {
				gameOver = true;
				System.out.println("Checkmate");
				System.out.println("Black wins");
				break;
			}
			else if(color == "b" && board[a][b].inCheck(a, b, color, board) && !board[a][b].kingMoves(a, b, color, board)) {
				gameOver = true;
				System.out.println("Checkmate");
				System.out.println("White wins");
				break;
			}
			if(color == oldcolor) {
				System.out.println("Illegal move, try again");
				System.out.println();
			}
			if(color == "w") {
				if(color!=oldcolor) {
					Board.printBoard(board);
				}
				for(int i = 0; i<board.length; i++) {
					for(int j =0; j<board.length; j++) {
						if(board[i][j] instanceof King && board[i][j].getColor() == "w") {
							if(board[i][j].inCheck(i, j, color, board)) {
								if(color!=oldcolor) {
									System.out.println("Check");
									System.out.println();
								}
							}
						}
					}
				}
				System.out.print("White's move: ");
			} else if (color == "b"){
				if(color!=oldcolor) {
					Board.printBoard(board);
				}
				for(int i = 0; i<board.length; i++) {
					for(int j =0; j<board.length; j++) {
						if(board[i][j] instanceof King && board[i][j].getColor() == "b") {
							if(board[i][j].inCheck(i, j, color, board)) {
								if(color!=oldcolor) {
									System.out.println("Check");
									System.out.println();
								}
							}
						}
					}
				}

				System.out.print("Black's move: ");
			}
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
				input = reader.readLine();
				System.out.println();
				if(input.charAt(2) == ' ' && (input.length() == 5 || input.length() == 7 || (input.length() == 11 && input.substring(6, 11).equals("draw?")))) {
					currentY = input.charAt(0);
					currentX = input.substring(1,2);
					currY = currentY - 'a';
					currX = Integer.parseInt(currentX)-1;
					newestY = input.charAt(3);
					newestX = input.substring(4,5);
					newY = newestY - 'a';
					newX = Integer.parseInt(newestX)-1;
					draw = false;
					/*if(empassant == true) {
						empassant = false;
						if(newX == empX && newY == empY && color == "b") {
							board[3][empY] = null;
						} else if(newX == empX && newY == empY && color == "w") {
							board[4][empY] = null;
						}
					}*/
					if(input.length() == 11 && input.substring(6, 11).equals("draw?")) {
						draw = true;
					}
					if(input.length() == 7 && board[currX][currY].getPiece() == "p" && ((color == "w" && newX == 7) || (color == "b" && newX == 0))) {
						promote = input.charAt(6);
					} 
					
					oldcolor = color;
					int kingX = 0;
					int kingY = 0;
					for(int i = 0; i<board.length; i++) {
						for(int j =0; j<board.length; j++) {
							if(board[i][j] instanceof King && board[i][j].getColor() == color) {
								kingX = i;
								kingY = j;
							}
						}
					}
					if(board[kingX][kingY].inCheck(kingX, kingY, color, board) && !(board[currX][currY] instanceof King)) {
						if(board[currX][currY].savesKing(currX, currY, color, board, newX, newY, promote, empassant)) {
							color = board[currX][currY].move(currX, currY, color, board, newX, newY, promote, empassant);
						}
						else {
							oldcolor = color;
						}
					}
					else if(board[kingX][kingY].inCheck(kingX, kingY, color, board) && board[currX][currY] instanceof King && board[kingX][kingY].movesToCheck(kingX, kingY, color, board, newX, newY)) {
						oldcolor = color;
					}
					else if(!board[kingX][kingY].inCheck(kingX, kingY, color, board) && board[currX][currY] instanceof King && board[kingX][kingY].movesToCheck(kingX, kingY, color, board, newX, newY)) {
						oldcolor = color;
					}
					else{
						if(board[currX][currY] == null) {
							oldcolor = color;
						}
						else {
							color = board[currX][currY].move(currX, currY, color, board, newX, newY, promote, empassant);
						}
					} 
					if(color!=oldcolor) {
						if(empassant == true) {
							empassant = false;
						}
					}
					
					if(newY != 7) {
						if(board[newX][newY+1] != null) {
							if(color == "b" && newY-currY == 0 && currX == 1 && newX == 3 && board[newX][newY+1].getColor().equals("b")) {
								empassant = true;
								empX = 2;
								empY = newY;
							} else if(color == "w" && newY-currY == 0 && currX == 6 && newX == 4 && board[newX][newY+1].getColor().equals("w")) {
								empassant = true;
								empX = 5;
								empY = newY;
							} 
						}
					}
					if(newY != 0) {
						if(board[newX][newY-1] != null) {
							if(color == "b" && newY-currY == 0 && currX == 1 && newX == 3 && board[newX][newY-1].getColor().equals("b")) {
								empassant = true;
								empX = 2;
								empY = newY;
							} else if(color == "w" && newY-currY == 0 && currX == 6 && newX == 4 && board[newX][newY-1].getColor().equals("w")) {
								empassant = true;
								empX = 5;
								empY = newY;
							} 
						}
					}
				} else if(input.length() == 6 && input.equals("resign")) {
					if(color == "w") {
						System.out.println("Black wins");
						gameOver = true;
					} else if(color == "b") {
						System.out.println("White wins");
						gameOver = true;
					}
				} else if(input.equals("draw") && draw == true) {
					System.out.println("draw");
					gameOver = true;
				} else {
					System.out.println("Illegal move, try again");
				}
			} catch(Exception e) {
				System.out.println("Illegal move, try again");	
			} 
		}
	}
}
