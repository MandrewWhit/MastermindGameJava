package assignment2;

public class History {
	
	
		//instance variable
	
		private Node head;
		
		//linked list constructor
		public History() {
			this.head = null;
		}
		
		public History(Node head) {
			this.head = head;
		}
		/********************************************************
		 * pushNode method
		 * push a node to the back of the list
		 * 
		 * preconditions: a valid node to be pushed exists
		 * postconditions: none
		 * 
		 * 
		 * ******************************************************
		 */
		public void pushNode(Node newNode) {
			Node currentNode = head;	
			if(head==null) {
				head = newNode;
			}else {
				while(currentNode.getNext()!=null) {
					currentNode = currentNode.getNext();
				}
				currentNode.setNext(newNode);
			}			
		}
		/********************************************************
		 * printList method
		 * print all the previous guesses
		 * 
		 * preconditions: none
		 * postconditons: list is printed
		 * 
		 * ******************************************************
		 */
		public void printList() {
			Node currentNode = head;
			while(currentNode!=null) {
				System.out.println(currentNode.getGuess() + "		" + currentNode.getPegs());
				//System.out.println("");
				currentNode = currentNode.getNext();
			}
			System.out.println("");
		}
		
		
	

}
