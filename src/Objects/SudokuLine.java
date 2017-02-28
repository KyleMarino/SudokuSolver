package Objects;

import java.util.ArrayList;

public class SudokuLine {
	//Represents a line of the board, either vertical or horizontal. 
	
	SudokuSquare[] squares;
	
	public SudokuLine(){
		//Creates an empty sudoku line.
		
		squares = new SudokuSquare[9];
	}
	
	public void addSquare(int position, SudokuSquare square){
		//Sets the square at the given position. Position 0 represents the top square for horizontal lines
		//and the left square for vertical lines. 
		
		squares[position] = square;
	}
	
	public void simplifyLine(){
		//Simplifies the line. First, gathers a list of all set values. Then, eliminates those from the possibility list
		//for all squares in the line. This may cause those squares to set their own values.
		//Does this on a loop until no changes have been made. 
		boolean changeMade = false;
		do{
			changeMade = false;
			//Gather a list of all set values:
			ArrayList<Integer> values = new ArrayList<Integer>();
			for(SudokuSquare s: squares){
				try{
					values.add(s.getValue());
				}catch(Exception e){
					//Do nothing. Move to next square.
				}
			}
			for(Integer i: values){
				//Eliminate the value from the list of possibilities for all squares in the line.
				for(SudokuSquare s: squares){
					try{
						s.eliminatePossibility(i.intValue());
						changeMade = true;
					}catch(Exception e){
						//Do nothing. Move to next square.
					}
				}
			}
		}while(changeMade == true);
	}
	
	public void displayLine(){
		//Displays the line.
		for(SudokuSquare s:squares){
			try{
				System.out.print(s.getValue());
			}catch(Exception e){
				System.out.print(e.getMessage());
			}
		}
	}
		
}
