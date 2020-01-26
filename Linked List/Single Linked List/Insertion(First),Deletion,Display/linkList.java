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
}

class LinkListApp{
	public static void main(String[] args) {
		LinkList theList = new LinkList();		//make new list
		theList.insertFirst(25,2.5);			//insert items
		theList.insertFirst(50,5.0);
		theList.insertFirst(75,7.5);
		theList.insertFirst(95,9.5);

		theList.displayList();					//display list

		while(!theList.isEmpty()){
			Link aLink = theList.deleteFirst();		//delete link
			System.out.print("Deleted ");
			aLink.displayLink();
			System.out.println();
		}
		theList.displayList();
	}
}