package assignment2;

/********************************************************************
 * Linked List Node class
 * 
 * used to keep track of previous guesses in a linked list format
 * 
 * ******************************************************************
 */

public class Node {
	private Node next;
	private String guess;
	private String pegs;
	
	public Node() {
		this.next = null;
		this.guess = "";
		this.pegs = "";
	}
	
	public Node(Node next, String guess, String pegs) {
		this.next = next;
		this.guess = guess;
		this.pegs = pegs;
	}
	
	public void setGuess(String guess) {
		this.guess = guess;
	}
	
	public String getGuess() {
		return guess;
	}
	
	public void setPegs(String pegs) {
		this.pegs = pegs;
	}
	
	public String getPegs() {
		return pegs;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}
}
