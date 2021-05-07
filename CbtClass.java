import java.util.Scanner;
import java.util.Arrays;
public class CbtClass {

    static String[][] candidates = new String[0][3];
    static String errorMessage = "*Invalid Request !";
    static String[][] questionAnswer = {{"How many fingers do human have?", "10"}, 
        {"Which color is synonymous to chelsea?", "blue"}};
    

        public static void main(String[] args) {
            menu();
                
             }
    
            
            public static void menu() {
                System.out.println("\nWelcome to CBT ussd menu ! \n1. Register Candidates \n2. Take cbt exam \n3. Check top candidate(s)\n4. Exit");
                Scanner userInput = new Scanner(System.in);
                 int selectedOption = userInput.nextInt();
    
                 switch (selectedOption) {
                     case 1:
                         registerCandidates();
                         break;
                    case 2:
                         takeExam();
                         break;
                    case 3:
                         topCandidates();
                         break;
                    case 4:
                         break;
                     default:
                     System.out.println(errorMessage);
                     menu();
                     break;
                    
                      
                 }
    
            }
            public static void subMenu(String actionMessage, int type) {
                System.out.println(actionMessage);
                Scanner optionInput = new Scanner(System.in);
                int optionSelected = optionInput.nextInt();
                if (optionSelected == 1) {
                    switch (type) {
                        case 1:
                        registerCandidates();
                            break;
                        case 2:
                        takeExam();
                            break;
                        case 3:
                        topCandidates();
                            break;
                        default:
                            break;
                    }
                   
                } else if (optionSelected == 2) {
                    menu();
                }else {
                    System.out.println(errorMessage); 
                    subMenu(actionMessage, optionSelected);
                }
            }

        public static void registerCandidates() {
            Scanner candidateInput = new Scanner(System.in);
            System.out.println("How many candidates do you want to register?");
            int numOfCandidates = candidateInput.nextInt();
            String[][] currCandidates = new String[numOfCandidates][3];
          
            //Register candidates
            for(int i=0; i < numOfCandidates; i++) {
                Scanner userInput = new Scanner(System.in);
                int currentCandidateNumber = i+1;
                 System.out.println("\nWhat's the name of candidate " + currentCandidateNumber);
                 String currentCandiateName = userInput.nextLine();
                 System.out.println("What's the matric number of candidate " + currentCandidateNumber);
                 String currentCandiateMatric = userInput.nextLine();
                 currCandidates[i][0] = currentCandiateName;
                 currCandidates[i][1] = currentCandiateMatric;
                 currCandidates[i][2] = "0";
            }
    
            // Add to global candidates 
    
              int candidatesLength = candidates.length;        
              int currCandidateslength = currCandidates.length;  
              String[][] finalCandidates = new String[candidatesLength + currCandidateslength][3]; 
              System.arraycopy(candidates, 0, finalCandidates, 0, candidatesLength);  
              System.arraycopy(currCandidates, 0, finalCandidates, candidatesLength, currCandidateslength);
              candidates = finalCandidates;  
            //   System.out.println(Arrays.toString(candidates));   
    
                subMenu("\n1. Add more candidate(s) 2. Menu", 1);
            }
            

    
    public static void takeExam() {
        Scanner loginInput = new Scanner(System.in);
        System.out.println("\nEnter your matric:" );
        String matric = loginInput.nextLine();
        int currCandidateIndex = -1;

        //search array for matric
        for(int i=0; i < candidates.length; i++) {
            if (candidates[i][1].equals(matric)) {
                currCandidateIndex = i;
            }
        }

        //Administer Questions
        if (currCandidateIndex > -1) {
            System.out.println("Welcome " + candidates[currCandidateIndex][0] + ", your exam starts now !" );
            for(int k=0; k < questionAnswer.length; k++) {
                Scanner answerInput = new Scanner(System.in);
                  int currentQuestionNumber = k+1;
                  System.out.println("\nQuestion " + currentQuestionNumber + ": \n" + questionAnswer[k][0]);
                   String currentAnswer = answerInput.nextLine();
                   if (currentAnswer.toLowerCase().equals(questionAnswer[k][1].toLowerCase())){
                    System.out.println("Correct!");
                        candidates[currCandidateIndex][2] = Integer.toString(Integer.parseInt(candidates[currCandidateIndex][2]) + 1);    
                   } else {
                    System.out.println("Wrong!"); 
                    
                   }
                  
                  
                } 
    
                   System.out.println("\nFinally " + candidates[currCandidateIndex][0] + ", you have completed the exam\nYour score is " +   candidates[currCandidateIndex][2]);
        }else {
            System.out.println("Invalid Matric Number !");
        }

        subMenu("\n1. Take exam 2. Menu", 2);

      
}

    public static void topCandidates() {

        //set max score
        int maxScore = 0;
            for(int i=0; i < candidates.length; i++) {
                    if (i == 0) {
                   maxScore = Integer.parseInt(candidates[i][2]);
               };
               if (i > 0) {
                   maxScore = Math.max(Integer.parseInt(candidates[i][2]), maxScore);
               }

     }

        if (maxScore > 0) {
            System.out.println("\nThe candidate(s) with maximum scores are/is:");
            for(int i=0; i < candidates.length; i++) {
               if (candidates[i][2].equals(Integer.toString(maxScore))) {
                   System.out.println(candidates[i][0] + " - " + candidates[i][2]);
                   
               }
               
            }
        }else {
            System.out.println("\nNo top candidate currently!");
        }    
     
       

            subMenu("\n1. Check top candidate(s) 2. Menu", 3);

    }



}