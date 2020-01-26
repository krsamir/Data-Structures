import java.util.*;
class Link{
   Link next;
   int data;

   public Link(int value){
       next = null;
       data = value;
   }

   public void display(){
       System.out.print("{"+data+"}\t");
   }
}
class linklist{
    Link first;
    Link last;
    Link last_node = first;

    public linklist(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return (first == null);
    }
    public void insertfirst(int value){                 //-->> Insertion at first
        
        Link node = new Link(value);
        if(isEmpty()){
            last = node;
        }   
        else{
            node.next = first;
        }
        first = node;
    }
    public void insertlast(int value){                  //-->> Insertion at last
        Link node = new Link(value);
        if(isEmpty()){
            first = node;
        }
        else{
            last.next = node; 
        }
        last = node;
    }
    public void display(){
        Link current = first;
        if(first==null)
            System.out.println("Empty !!\n");
        else{
            while(current != null){
                    current.display();
                    current = current.next;
            }
        }
    }
    public Link deletefirst(){
        Link temp = first;
        if (!isEmpty()) {
            first = first.next;
        }
        else{
            System.out.println("Cannot Delete Node as there is no node present in the list.");
        }
        return temp;
    }

    public void insert_sort(int value){
        Link previous = null;
        Link current = first;
        Link node = new Link(value);
        while (current != null && value > current.data) {               //traverse to the point where value is to be inserted.
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = node;
        }
        else{
            previous.next = node;
        }
        node.next = current;

    }
    
}
class main_class{
    public static void menu(){
        System.out.println("\n\tMenu\t");
        System.out.println("1. Insert Node at first");
        System.out.println("2. Insert Node at last");
        System.out.println("3. Insert Node in sorted list");
        System.out.println("4. Display Node");
        System.out.println("5. Delete Node from Front");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        linklist x = new linklist();
        int choice;
        menu();
        System.out.println("Enter your choice : ");
        choice = sc.nextInt();
        do{
            switch (choice) {
                case 1: 
                    System.out.print("Enter the data value : ");
                    int value = sc.nextInt();
                    x.insertfirst(value); 
                    break;
                
                case 2:
                System.out.print("Enter the data value : ");
                int value1 = sc.nextInt();
                x.insertlast(value1); 
                    break;

                case 3:
                System.out.print("Enter the data value : ");
                int value2 = sc.nextInt();
                x.insert_sort(value2);

                    break;
                case 4:
                    System.out.print("The list is >> ");
                    x.display();
                    System.out.println();
                    break;


                case 5:
                    Link y = null;
                try{
                    y = x.deletefirst();
                }
                 catch (Exception e) {
                    System.out.println("Null value");
                }
                System.out.println(y);
                    break;


                case 0 : System.exit(0); 
                break;

                default:
                System.out.println("Wrong Choice !!");
                    break;
                
            }  
            menu();
            System.out.println("Enter your choice or press the corresponding button to exit : ");
            choice = sc.nextInt();
        }while(choice != 0);                                      
        
    }
}
