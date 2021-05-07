import java.util.Scanner;

public class FirstClass {
    public static void main(String[] args) {
        float years = 2.2f;
        //narrowing means limiting the memory space- converting down e.g from float to integer it has to be explicit. Widening is automatic e.g from integer or double to float
        int myAge = (int)years;
        System.out.println(myAge);
        System.out.println("Hello java world !");
        String firstName = " Ridwan";
        String lastName = " Ijadunola";
        String fullName = firstName.concat(lastName);
        String greetWord = "Hello";
        String greeting = greetWord.toUpperCase() + fullName;
        System.out.println(greeting);
        // assign to array directly
        String[] arrAss = {"6", "bola", "ope"};
        //initialize array or pre-defined spaces which is 4
        String[] arrInit = new String[4];
        // add data to specific index - only way ?
        arrInit[1] = "shola";

        //loop is the same in  java and javascript
        for(int i=0; i < arrAss.length; i++) {
            System.out.println(arrAss[i]);
        }

        //multi-dimensional array
        //create array of 5 length that will take array of 6 length
        int[][] arrOfArrs = new int[5][6];
        //insert to the fisrt array of the arrays in a specified index
        arrOfArrs[0][0] = 1;

        //foreach in java
        for(String i : arrAss) {
            //means for i in arr
             System.out.println(i);
        }
    // for collecting user input
        Scanner userInput = new Scanner(System.in);
         System.out.println("Enter your name");
         // this is like window.prompt in javascript 
        String fname = userInput.nextLine();
         System.out.println("Your name is " + fname);

       

        
    }

      // method utilization
     // not returnning
      public static void aMethod() {
             
    }

    //returnning
    public static String aMethod() {
           
  }
  //parametized
  public static void aMethod(int a, String c ) {
         
}
// method overload is when many method with the same name is declared but with diff params type
}