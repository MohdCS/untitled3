import java.util.*;

public class Main {
    private static int size;
    private static String[] array;

    public static void main(String[] args){
        size();
        choice();
    }

    static void choice(){
        try{
            Scanner input = new Scanner(System.in);
            System.out.print("1) Add (or Re-Modify) " + size + " object(s)" +
                    "\n2) View Array" +
                    "\n3) Modify a certain Object" +
                    "\n4) Search for an Object" +
                    "\n5) Reset Array Size" +
                    "\n6) Exit the Program" +
                    "\n" +
                    "\nSelection:\t");
            int choice = input.nextInt();
            switch (choice) {
                case 1: {
                    add();
                    choice();
                }
                case 2: {

                    if(array == null || Arrays.stream(array).toList().contains(null)){
                        System.out.println("Array is empty!");
                    }

                    else{
                        System.out.println("String Array:\t" + Arrays.toString(array));
                    }
                    System.out.println("##########################################");
                    choice();
                }
                case 3: {
                    modify(array);
                    choice();
                }
                case 4: {
                    search(array);
                    choice();
                }
                case 5: {
                    size();
                    System.out.println("Array size has been reset to:\t" + size);
                    array = new String[size];
                    System.out.println("##########################################");
                    choice();
                }
                case 6: {
                    System.out.println("Farewell!");
                    System.exit(0);
                }
                default: {
                    System.out.println("Input [" + choice + "] is not a valid choice, try again!");
                    choice();
                }
            }
        }

        catch(InputMismatchException e){
            System.out.println("Invalid input, try again!");
            choice();
        }
    }

    // 1)
    static void add(){
        array = new String[size];
        for(int x = 0; x < array.length; x++){
            Scanner inputString = new Scanner(System.in);
            System.out.print("At index #" + x + ":\t");
            array[x] = inputString.nextLine();
        }
        System.out.println("String Array:\t" + Arrays.toString(array));
        System.out.println("##########################################");
    }

    // 3
    static void modify(String[] array){
        if(array == null || Arrays.stream(array).toList().contains(null)){
            System.out.println("Array is empty!");
            System.out.println("##########################################");
        }
        else{
            System.out.print("Enter target name (or exit):\t");
            Scanner input = new Scanner(System.in);
            String target = input.nextLine();
            for(int s = 0; s < array.length; s++){
                if (target.equalsIgnoreCase("Exit")) {
                    choice();
                }
                else if(!Arrays.stream(array).toList().contains(target)){
                    System.out.println(target + " could not be found!");
                    modify(array);
                }
                else if(array[s].equals(target)) {
                    System.out.print("Modify to:\t");
                    array[s] = input.nextLine();
                    System.out.println(target + " has been modified to:\t" + array[s]);
                    System.out.println("##########################################");
                    choice();
                }
            }
        }
    }

    // 4)
    static void search(String[] array){
        if(array == null || Arrays.stream(array).toList().contains(null)){
            System.out.println("Array is empty!");
            System.out.println("##########################################");
        }
        else{
            System.out.print("Enter target name (or exit):\t");
            Scanner input = new Scanner(System.in);
            String target = input.nextLine();
            for(int s = 0; s < array.length; s++){
                if (target.equalsIgnoreCase("Exit")) {
                    break;
                }
                else if(!Arrays.stream(array).toList().contains(target)){
                    System.out.println(target + " could not be found!");
                    search(array);
                }
                else if(array[s].equals(target)) {
                    System.out.println(target + " is located at index #" + s + ".");
                    System.out.println("##########################################");
                    choice();
                }
            }
        }
    }

    // 5)
    public static void size(){
        try{
            System.out.print("Size of Array:\t");
            Scanner input = new Scanner(System.in);
            size = input.nextInt();
        }

        catch(Exception e){
            System.out.println("Invalid input, try again!");
            size();
        }
    }
}
