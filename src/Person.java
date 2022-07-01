import java.util.Scanner;

public class Person {

    private String name;

    public Person(){
        name = new String();
    }

    public void setName(){
        Scanner input = new Scanner(System.in);
        System.out.print("Name:\t");
        name = input.nextLine();
        input.close();
    }

    public String getName(){
        return name;
    }


}
