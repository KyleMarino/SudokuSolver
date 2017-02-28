package Exceptions;

public class ValueSetException extends Exception {
	//Thrown when attempting to set a value on a square that's already been set.
	
	public ValueSetException(){
		super("Error: This square already has a set value.");
	}
}
