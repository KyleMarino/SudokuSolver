import java.util.ArrayList;

import Exceptions.ValueNotSetException;
import Exceptions.ValueSetException;

public class SudokuSquare {
	//Represents a single square of the game board. 
	
	private int value;
	private ArrayList<Integer> possibilities;
	private boolean valueSet;
	
	public SudokuSquare(){
		//Creates a blank square
		
		value = 0;
		valueSet = false;
		possibilities = new ArrayList<Integer>();
		//Fill the list of possibilities
		for(int i = 1; i < 10; i++){
			possibilities.add(i);
		}
	}
	public SudokuSquare(int initialValue){
		//Creates a square with a set value.
		
		value = initialValue;
		valueSet = true;
	}
	
	public void setValue(int newValue) throws ValueSetException{
		//Sets the value of the square and eliminates all possibilities.
		if(valueSet == true){
			throw new ValueSetException();
		}else{
			value = newValue;
			valueSet = true;
			if (possibilities != null){ possibilities = null;}
		}
	}
	
	public void eliminatePossibility(int rValue){
		//Removes a possibility from the list of possibilities.
		for(Integer i : possibilities){
			if (i.intValue() == rValue){
				possibilities.remove(possibilities.indexOf(i));
			}
		}
		//Checks to see if there is only one possibility left
		if(possibilities.size() == 1){
			try {
				this.setValue(possibilities.get(0).intValue());
			} catch (ValueSetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getValue() throws ValueNotSetException{
		//Returns the value of the square if set
		if(valueSet==false){
			throw new ValueNotSetException();
		}else{
			return value;
		}
	}
}
