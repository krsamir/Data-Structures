import java.util.Scanner;
class Link{
    Link previous;
    Link next;
    int data;

    public Link(int value){
        data = value;
        previous = null;
        next = null;
    }
    public void display() {
        System.out.print("{"+data+"}\t");
    }
}
class double_link{
    Link first;
    Link last;

    public double_link(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return (first == null);
    }

    public void insertfirst(int value){
        Link node = new Link(value);
        if (isEmpty()) {
            last = node;
        }
        else{
            first.previous = node;
            node.next = first;
        }
        
        first = node;
    }
    public void insertlast(int value){
        Link node = new Link(value);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
            node.previous = last;
        }
        last = node;
    }
    public void display_forward(){
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

    public void display_backward(){
        Link current = last;
        if(first==null)
            System.out.println("Empty !!\n");
        else{
            while(current != null){
                    current.display();
                    current = current.previous;
            }
        }
    }

    public Link delete_first(){
        Link temp = first;
        if(first.next == null){                     //If only one node is present in the list
            last = null;                            //then that node is the first and last both.
        }
        else{
            first.next.previous = null;            
        }
        first = first.next;                        //deleting or overwriting the first node.
        return temp;
    }
    public Link delete_last(){
        Link temp = last; 
        if(first.next == null){                     //If only one node is present in the list
            first = null;
        }
        else{
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    public boolean insert_after(int value,int key){
        Link current = first;
        while(current.data != key){
            current = current.next;
            if(current == null)
                return false;
        }
        Link node = new Link(value);
        if (current == last){
            node.next = null;
            last = node;
        }
        else{
            node.next = current.next;
            current.next.previous = node;
        }
        node.previous = current;
        current.next = node;

        return true;
    }
    public boolean delete_key_node(int key){
        Link current = first;
        while(current.data != key){
            current = current.next;
            if(current == null)
            return false;
        }
        if (current == first){
            first = current.next;
        }
        else{
            current.previous.next = current.next;
        }

        if(current == last){
            last = current.previous;
        }
        else{
            current.next.previous = current.previous;
        }

        return true;
    }
    public void delete_list(){
        first = null;
        last = null;
    }
    

}
    
class dl_main{

    public static void menu(){
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("\n\tMenu\t");
       /* System.out.println("1. Insert Node at first");
        System.out.println("2. Insert Node at last");*/
        System.out.println("3. Insert Node after Certain Node");
        System.out.println("4. Display Node from Front");
        System.out.println("5. Display Node from Last");
        System.out.println("6. Delete Node from Front");
        System.out.println("7. Delete Node from Last");
        System.out.println("8. Delete Certain Node");
        System.out.println("9. Delete the Complete List");
        System.out.println("0. Exit\n");
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        double_link x = new double_link();
        int choice;
        menu();
        /**For testing purpose
        
        System.out.println("Auto inserting values ....................");
        Thread.sleep(1500);
        System.out.println("Inserted !!\n");

        x.insertlast(5);
        x.insertlast(10);
        x.insertlast(15);
        x.insertlast(20);
        x.insertlast(25);
        */
        System.out.println("Enter your choice : ");
        choice = sc.nextInt();
        do{

            System.out.println("Processing......................\n");
            Thread.sleep(1000);                         //For delaying


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
                    System.out.println("After Which Node do you Want to insert ?");
                    int insert_after_node = sc.nextInt();
                    System.out.print("Enter the data value : ");
                    int value = sc.nextInt();
                    boolean check = x.insert_after(value,insert_after_node); 
                    if(check == false)
                    System.out.println("The Node after which you wanted to insert was not found in the list.");

                    
                    break;

                case 4:System.out.println("From to first to last : ");
                    System.out.print("The list is >> ");
                    x.display_forward();
                    System.out.println("");
                    break;

                case 5: System.out.println("From to last to first : ");
                        System.out.print("The list is >> ");
                        x.display_backward();
                        System.out.println("");

                    break;

                case 6:
                    Link y = null;
                try{
                    y = x.delete_first();
                }
                 catch (Exception e) {
                    System.out.println("List is Empty !!");
                }
                System.out.println(y);
                    break;

                case 7:
                    Link z = null;
                try{
                    z = x.delete_last();
                }
                 catch (Exception e) {
                    System.out.println("List is Empty !!");
                }
                System.out.println(z);
                    break;

                case 8:
                System.out.print("Enter which Node You want to delete >> ");
                int delete_key = sc.nextInt();
                check = x.delete_key_node(delete_key);
                if(check == false)
                    System.out.println("Unable to find the element you want to delete.");

                break;
                case 9 : 
                    x.delete_list();
                    System.out.println("Deleting complete List......................\n");
                    Thread.sleep(2000);
                    System.out.println("List is Empty Now !!");

                    break;
                case 0 : System.exit(0); 
                break;

                default:
                System.out.println("Wrong Choice !!");
                    break;
                
            }  
            menu();
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();
        }while(choice != 0);                                      
        
    }
        
    }
