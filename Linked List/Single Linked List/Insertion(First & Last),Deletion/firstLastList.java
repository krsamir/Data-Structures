class Link{
    public long dData;
    public Link next;

    public Link(long d){
        dData = d;                          //data part of the node
        next = null;                        //address part of the node
    }
    public void displayLink(){
        System.out.print(dData + " ");      //displaying the data part
    }
}      
class FirstLastList{
    private Link first;                     //Since this is a double linked list so,it requires two addressing parts
    private Link last;

    public FirstLastList(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return (first==null);             //to check if node is present in the list or not
    }
    public void insertFirst(long dd){      /* Insert Function */
        Link newLink = new Link(dd);    

        if(isEmpty()){                      //if the linked list is empty then first node can be called as last node
            last = newLink;                 //As nodes are entering from first in the list so the node first entered will be the last node 
                                            
        }
        newLink.next = first;               //referencing to the first node is done
        first = newLink;                    //reference to both first and last is newlink address for first time and henceforth 
                                            //there is only update in the first node 
    }
    public void insertLast(long dd){
        Link newLink = new Link(dd);
        if(isEmpty()){                      //while entering from last,if the list is completely empty 
            first = newLink;                //then the inserted node for the first time will be at first
        }
        else{
            last.next = newLink;            
        }
        last = newLink;                     //reference to both first and last is newlink address for first time and henceforth 
                                            //there is only update in the last node
    }
    public long deleteFirst(){              /* Deletion of Node from first */
    
        if (isEmpty()){                 //If no Node is present
            System.out.println("Cannot delete node since no node is present in the list !!\n");
            return -1;
        }
        long temp = first.dData;
        if(first.next == null){             //if first.next is null that means there is only a single node present
            last = null;                    //the only node preesent is being deleted
        }
        first = first.next;                 //same as index = index + 1
        return temp;    
    }
    public void displayList(){
        System.out.println("List (First --> Last): ");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class FirstLastApp{
    public static void main(String[] args) {
        FirstLastList theList = new FirstLastList();

       theList.insertFirst(10);
        theList.insertFirst(20);
        theList.insertFirst(30);

        theList.insertLast(40);
        theList.insertLast(50);
        theList.insertLast(60);

        theList.displayList();

        theList.deleteFirst();
        theList.deleteFirst();
        System.out.println("After deletion of nodes : ");
        theList.displayList();

    }
}