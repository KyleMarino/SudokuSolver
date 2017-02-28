package Exceptions;

public class ValueNotSetException extends Exception {
	public ValueNotSetException(){
		super("Error: The value of this square is not set.");
	}
}
