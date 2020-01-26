class Link {
										/*Data part of the Node */
	public int iData;		//data Item
	public double dData;	//data Item
										/*Addressing part of the Node */
	public Link next;		//next link in list
	
	public Link(int id,double dd) {					//Constructor
		iData = id;									//initialising data
		dData = dd;
		next = null;
	}
	public void displayLink() {
		System.out.println("{"+iData+","+dData+"}");
	}
}
class LinkList{
	private Link first;			//reference to the first link on the list
	
	public LinkList(){
		first = null;			//no items on list yet
	}
	public boolean isEmpty(){		//true if list is empty
		return (first == null);
	}
	public void insertFirst(int id,double dd){
		Link newLink = new Link(id,dd);			//making new Link (CLASS --> LINK)
												//By calling this method we have just passed datapart in the constructor
		newLink.next = first;					//newLink --> old first	(UPDATED NEWLINK)
												//updating address part of the link with the previous one 
		first = newLink;						//first --> newLink
												//setting adress to the first with current node on which we 
												//we are working
		/*
		 *************							*************
		 * 	 DATA	 *							* 	 DATA	*
		 *************		------->			*************		
		 * 	  101    *							*    NULL   *
		 ************* 							*************
LET		  ADDRESS = 100						    ADDRESS = 101
		 NEW NEWLINK (NEW NODE)					OLD NEWLINK (OLD NODE)
		 */



	}
	public Link deleteFirst(){					//delete first item (Assume that the list is not empty)
		Link temp =first;						//save reference to link
		first = first.next;						//delete it: first-->old next
		return temp;							//return deleted link
	}
	public void displayList(){
		System.out.println("List (first-->last): ");
		Link current = first;					//start at the beginning of the list
		while(current != null){
			current.displayLink();
			current = current.next;				//moves to the next link
		}
		System.out.println("");
	}
	public Link find (int key){
		Link current = first;				//starts at first
		while(current.iData != key){		//while no match
			if (current.next == null) {		//if end of list
				return null;				//if not found
			}
			else{
				current = current.next;		//go to next link
			}
		}
		return current;						//founded link
	}

	public Link delete(int key){
		Link current = first;				//reference variables <> current and previous 
		Link previous = first;
		while (current.iData != key) {		//until the key is not found
				if(current.next == null){	//If there is a single node present in the list that too does not match with key we return null
				return null;
			}
			else{
				previous = current;			
				current = current.next;		//incrementing the (so called)index to the next node(same as index = index+1)
											//as not found
			}
		}

										/*Key Found */

		if (current == first){				//If there is no change in 'current' (i.e.current = first node) that means our data has been found 
											//in first node itself so delete it by assigning the address of the next node.(index = index+1)
			first = first.next;
		}
		else{
			previous.next = current.next;	//current node is the node on which we are working
											//current.next is the address of the next node
											//and previous.next contains the address of current node
											//so current node is replaced with node next to current and thus linked with previous node.

		}
		return current;
	}
	/**Note : Working of delete function in Linked List 
	 * we run a while loop inside which it is being checked that if key is not found, then the node address is increased by on node
	 * if found it will get out of the loop
	 * and next remove that particular node and link the two intermediate nodes.
	*/

}

class LinkListApp{
	public static void main(String[] args) {
		LinkList theList = new LinkList();		//make new list
		theList.insertFirst(25,2.5);			//insert items
		theList.insertFirst(50,5.0);
		theList.insertFirst(75,7.5);
		theList.insertFirst(95,9.5);

		theList.displayList();					//display list

		Link f = theList.find(75);
		if (f != null)
			System.out.println("Found link with key "+f.iData);
		else
			System.out.println("Can't find Link");

		Link d  = theList.delete(50);
		if(d != null)
			System.out.println("Deleted link with key "+d.iData);
		else{
			System.out.println("Can't delete link");
		}
		theList.displayList();
	}
}