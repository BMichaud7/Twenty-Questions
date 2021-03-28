import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwentyQuestions {
    public BTree<String> Questions;



    Scanner scan = new Scanner(System.in);
    /*
    Returns false if no there is no root.
     */
    public boolean play() throws IOException{
        Questions = new BTree<>();
        BTNode currentNode = new BTNode<String>();
            Questions.setSource(new File("output.txt"));
        Questions.load();
        //tree builds correctly
        
        currentNode = Questions.getRoot();
        // currentNode = Questions.getRoot();
        boolean winConditionR = false;
        boolean winConditionL = false;
        boolean noFile = (Questions.getRoot()!=null);
        System.out.println("Welcome to 20 Questions");
        char userInputchar;

        do{
            System.out.println(currentNode.getElement());
             userInputchar = scan.next().charAt(0);
            if (userInputchar == 'y' || userInputchar == 'Y') {
                if (currentNode.getRight() != null) {
                    System.out.println("You Selected Yes");
                    currentNode = currentNode.getRight();
                } else {
                    winConditionR = true;
                }

            } else if (userInputchar == 'n'||userInputchar == 'N') {
                System.out.println("You Selected No");
                if (currentNode.getLeft() != null) {
                    currentNode = currentNode.getLeft();
                } else {
                    winConditionL = true;
                }
            }
            System.out.println("winConditionR: "+ winConditionR +"winConditionL: " + winConditionL);
//            System.out.println("currentNode:" + currentNode.getElement() + " currentNode.getLeft(): " + currentNode.getLeft().getElement()+" currentNode.getRight(): " + currentNode.getRight().getElement());
        }while (winConditionR == false && winConditionL == false);
        System.out.println("winConditionR: "+ winConditionR +"winConditionL: " + winConditionL);


         if(winConditionL == true){
             System.out.println("I cant think of what you're thinking of.");
             scan.nextLine();
             System.out.println("What were you thinking of?");

             String userGuess = scan.nextLine();
             System.out.println(userGuess);

             System.out.println("What Question would lead you to answer no to the question " + currentNode.getElement());
            String userQuestion = scan.nextLine();
             //if(!Questions.contains(userInput)){

            String currentGuess = (String) currentNode.getElement();
             currentNode.setElement(userQuestion);
             currentNode.setRight(new BTNode(userGuess));
             currentNode.setLeft(new BTNode(currentGuess));
             Questions.contians(currentNode);
             //should be good here
             
             Questions.save();
            Questions.contians(currentNode);
                /*
                If node is Yes and has no children dont add, Computer Wins
                 */
             //scan.next();
             
        }else{
             System.out.println("The Computer Won!");
         }
            //Questions.setRoot(first);
           
            //Questions.load();
           // Questions.save(fileOutTest);
         //}else
         {
             //System.out.println("That Question is already known. You Must have entered a wrong input.");
         }
        return noFile;
    }
    public static void main(String[] args) throws IOException {
        TwentyQuestions game20Questions = new TwentyQuestions();

        game20Questions.play();

    }



}
