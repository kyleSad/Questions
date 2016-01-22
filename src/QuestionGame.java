import java.io.*;
import java.util.*;


public class QuestionGame {
	
	public static void main(String[] args) throws FileNotFoundException, InvalidBinaryTreeOpException{
	Scanner stdin = new Scanner(System.in);  // for reading console input
	Scanner inputFile = null;
	int k = 0; // should be a zero for file input
	try{
		//get the scanner object of the file
		inputFile = new Scanner (new File(args[0]));
	} catch (FileNotFoundException exception){
		//if the file does not exist
		System.out.println( "Error: cannot access input file");
		 k = 1;
	}
	BinaryTree<String> tree = new BinaryTree<String>();
	boolean done = false;
    while (!done) {
        System.out.println("Enter option - p, r, o, or q: ");
        try{
        	if( !inputFile.hasNextLine()){
                 k = 1;
        	}
        }catch(NullPointerException not){
        	
        }
        String input = "";
        String option = "";
        if(k == 1){
        	input = stdin.nextLine();
        }
        else{
            option = inputFile.nextLine();
        }
        if (input.length() > 0 || option.length() > 0) {  // or option.length() > 0   
         	char choice = ' ';
        	if(k != 1){
        		 choice = option.charAt(0); 
        	}
        	else{
        		 choice = input.charAt(0);  // strip off option character
        	}
            switch (choice) {
            
                
            case 'o' :
               tree.print();
                
                break;
                
            case 'p' :
                
                if( tree.getCurrent()== null){

                	//return a new binary tree
                  	tree.start(); 
                  	tree.changeCurrent(null);
                  	System.out.println("Please enter a question.");
                  	//scanner for new question
                  	Scanner stdin2 = new Scanner(System.in);
                  	if( k== 1){
                  		 String newq = stdin2.nextLine();
                  		 //add that node to root
                  		 tree.changeCurrent(newq);
                  	}
                  	else{
                  		String newq2 = inputFile.nextLine();
                  	    //add that node to root
                      	tree.changeCurrent(newq2);
                  	}
                  	System.out.println("Please enter an animal that is true for that question.");
                  	//scanner for yes answer
                  	if (k == 1){
                  		String tanswer = stdin2.nextLine();
                        tree.addLeftChild(tanswer);
                      	//add that node to left child

                  	}
                  	else{
                  		String tanswer2 = inputFile.nextLine();
                      	//add that node to left child
                        tree.addLeftChild(tanswer2);
                  	}
                  	System.out.println("Please enter an animal that is false for that question.");
                  	//scanner for no answer
                  	if( k == 1){
                  		String fanswer = stdin2.nextLine();
                      	//add that node to right child
                        tree.addRightChild(fanswer); 
                  	}
                  	else{
                  		String fanswer2 = inputFile.nextLine();
                  	    //add that node to right child
                        tree.addRightChild(fanswer2); 
                  	}
                }              
                //get back to the root
                tree.start();
                Scanner stdin1 = new Scanner(System.in);
                while(!tree.isLeaf()){
                	//should ask the question then go down?
                	System.out.println(tree.getCurrent());
                	char answer;
                	if(k == 1){
                		String prompt = stdin1.nextLine();
                    	 answer = prompt.charAt(0);
                	}
                	else{
                		String prompt2 = inputFile.nextLine();
                		 answer = prompt2.charAt(0);
                	}
                	if(answer == 'y'){
                       tree.goLeft();
                	}
                	if(answer == 'n'){
                	   tree.goRight();
                   	}
                	
                }
                
                System.out.println( "I guess:" + tree.getCurrent() + " Was I right?");
                char check;
                if(k == 1){
                	String guess = stdin1.nextLine();
                    check = guess.charAt(0);

                }
                else{
                	String guess2 = inputFile.nextLine();
                    check = guess2.charAt(0);
                }
                if( check == 'y'){
                	System.out.println("I win");
                }
                if( check == 'n'){
                	System.out.println("Darn. Ok, tell me a question that is true for your answer, but false for my guess.");
                	if(k == 1){
                		String question = stdin1.nextLine();
                	    String temp = tree.getCurrent();
                	    tree.changeCurrent(question);
                  	    tree.addRightChild(temp);
                   	    System.out.println("Thanks. And what animal were you thinking of?");
                	    String animal = stdin1.nextLine();
                	    tree.addLeftChild(animal);
                	}
                	else{
                		String question = inputFile.nextLine();
                	    String temp = tree.getCurrent();
                	    tree.changeCurrent(question);
                  	    tree.addRightChild(temp);
                   	    System.out.println("Thanks. And what animal were you thinking of?");
                	    String animal = inputFile.nextLine();
                	    tree.addLeftChild(animal);
                	}
                }
            	
                break;
            case 'r' :
               //return a new binary tree
            	tree = new BinaryTree<String>();
            	//return a new binary tree
              	tree.start(); 
              	tree.changeCurrent(null);
              	System.out.println("Please enter a question.");
              	//scanner for new question
              	Scanner stdin2 = new Scanner(System.in);
              	if( k== 1){
              		 String newq = stdin2.nextLine();
              		 //add that node to root
              		 tree.changeCurrent(newq);
              	}
              	else{
              		String newq2 = inputFile.nextLine();
              	    //add that node to root
                  	tree.changeCurrent(newq2);
              	}
              	System.out.println("Please enter an animal that is true for that question.");
              	//scanner for yes answer
              	if (k == 1){
              		String tanswer = stdin2.nextLine();
                    tree.addLeftChild(tanswer);
                  	//add that node to left child

              	}
              	else{
              		String tanswer2 = inputFile.nextLine();
                  	//add that node to left child
                    tree.addLeftChild(tanswer2);
              	}
              	System.out.println("Please enter an animal that is false for that question.");
              	//scanner for no answer
              	if( k == 1){
              		String fanswer = stdin2.nextLine();
                  	//add that node to right child
                    tree.addRightChild(fanswer); 
              	}
              	else{
              		String fanswer2 = inputFile.nextLine();
              	    //add that node to right child
                    tree.addRightChild(fanswer2); 
              	}
           
            	
            	break;
                
            case 'q' :
                System.out.println("quit");
                done = true;
                break;
                
            default :
                System.out.println("Unknown Command");
                break;
           }
        }
    }
  }
}