class Link{
                            /*Building of Node */
    public long dData;
    public Link next;

    public Link(long dd){
        dData = dd;
        next = null;
    }
    public void displayLink(){
        System.out.print(dData+" ");
    }
}

class LinkList{
                                        /*Building different functions */
    private Link first;

    public LinkList(){
        first = null;
    }
    public boolean isEmpty(){
        return (first == null);
    }
    public void insertFirst(long dd){
        Link newLink = new Link(dd);
        newLink.next = first;
        first = newLink;
    }
    public long deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp.dData; 
    }
    public void displayList(){
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class LinkStack{    
                                /*building stack functions */
    private LinkList theList;

    public LinkStack(){
        theList = new LinkList();
    }
    public void push(long j){
        theList.insertFirst(j);
    }
    public long pop(){
        return (theList.deleteFirst());
    }
    public boolean isEmpty(){
        return (theList.isEmpty());
    }
    public void displayStack(){
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
}

class LinkStackApp{
    public static void main(String[] args) {
        LinkStack theStack = new LinkStack();
        theStack.push(100);
        theStack.push(200);
        
        theStack.displayStack();

        theStack.push(300);
        theStack.push(400);

        theStack.displayStack();

        theStack.pop();
        theStack.pop();

        theStack.displayStack();
    }
    
}