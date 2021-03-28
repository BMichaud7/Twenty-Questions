import javafx.util.Pair;

import java.io.*;
import java.util.Comparator;

import java.util.*;
public class BTree <T> {
    BTNode<String> root;
    File source;
    Comparator Comp;

    public File getSource() {
        return source;
    }

    public void setSource(File source) {
        this.source = source;
    }

    public void save()
    {
        try {
            PrintWriter pt = new PrintWriter(source);
            printToFile(root, pt);
            pt.close();
        }
        catch(IOException e)
        {
            System.out.println("File Not Found");
        }

    }

    private void printToFile(BTNode<String> r, PrintWriter pw) {
        if(r != null)
        {
            if (r.getRight()== null && r.getLeft()== null) {
                pw.println(r.getElement() + " #");
                System.out.println("Printed: " + r.getElement());
            } else {
                pw.println(r.getElement() + " $");
                printToFile(r.getLeft(), pw);
                printToFile(r.getRight(), pw);
            }
        }
    }


    public void load()  {
        try {
            Scanner sc = new Scanner(source);
            if(sc.hasNextLine()) {
                String s = sc.nextLine();
                root = new BTNode(s.substring(0,s.length()-2));
                char symbol = s.charAt(s.length()-1);
                if(symbol != '#')
                {
                    readFromFile(root, sc);
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void readFromFile(BTNode<String> node, Scanner sc)
    {
        if(sc.hasNextLine()) {
            //build the left
            String leftString = sc.nextLine();
            node.setLeft((leftString.substring(0, leftString.length() - 2)));
            char symbol = leftString.charAt(leftString.length() - 1);
            if (symbol != '#')//is it a leaf
            {
                readFromFile(node.getLeft(), sc);
            }
        }
        if(sc.hasNextLine()) {

            String rightString = sc.nextLine();
            node.setRight(rightString.substring(0, rightString.length() - 2));
            char symbol = rightString.charAt(rightString.length() - 1);
            if (symbol != '#')//is it a leaf
            {
                readFromFile(node.getRight(), sc);
            }

          
        }
          System.out.println("hello");
    }




    public boolean find(String s,BTNode<String> node){
        {
            if (node == null)
                return false;       // target is not found
            else if (Comp.compare((T)s, node.getElement())<0)
                return find(s, node.getLeft());   // Search left subtree
            else if (Comp.compare((T)s, node.getElement())>0)
                return find(s, node.getRight());  // Search right subtree
            else
                return true;        // target is found
        }
    }
    public boolean contains (String target)
    {
        return find(target, root);
    }



    public BTNode<String> getRoot() {
        return root;
    }


    public void setRoot(BTNode<String> root) {
        this.root = root;
    }
    public void print(BTNode n){
        if(n != null ) {
            System.out.println(n.getElement());
            print(n.getLeft());
            print(n.getRight());
        }
    }
    private boolean containsHelper( String subject, BTNode<String> node )
    {
        if( node == null )
        {
            return false;
        }   
        boolean contains = (subject == reducedString(node));
        if( contains==false){
            contains =  containsHelper(subject, node.getLeft()); //Still Looking
            
            if( contains==false){
            contains = containsHelper(subject, node.getRight());
            }
            return contains;
        }
        else
            return true;    // Match
    }  
    public void contians(BTNode<String> node){
        boolean containsQuestion = false;
        containsQuestion = containsHelper(reducedString(node),root);
        if(containsQuestion == true){
            System.out.println("Another path to their answer exists");
        }
        
    }
    public String reducedString(BTNode<String> node){
       String target =  node.getElement();
        target = target.trim();
        String[] wordseperated = target.split(" ");
        return wordseperated[wordseperated.length-1];
    }


}
