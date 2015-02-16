
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class MatchingSquare {

	int totalNodes = 9;
	Integer nodes[] = {1,2,3,4,5,6,7,8,9};
	int winNodes[][] = {{2,3,4},{4,5,6},{6,7,8},{8,9,2},{2,1,6},{8,1,4},{7,1,3},{9,1,5}}; 
	int pn = 1;
	int npn[] = {2,3,4,5,6,7,8,9};
	Set<Integer> aList = new HashSet<Integer>();
	Set<Integer> bList = new HashSet<Integer>();
	List<Integer> tList = new ArrayList<Integer>();
	
	private boolean isWon(String player, Set<Integer> checkList)
	{
		boolean isWon = false;
		for (int ma = 0; ma < winNodes.length; ma++) {
			List<Integer> tempList = new ArrayList<Integer>();
		    for (int mb = 0; mb < winNodes[ma].length; mb++) {
		        int p1 = winNodes[ma][mb];
		       // System.out.println(p1);
		        tempList.add(new Integer(p1));
		    }
		    if(checkList.containsAll(tempList))
		    {
		    	isWon = true;
		    	 System.out.println(player + " WON the GAME !!!!!!!!!!!!!! number are : " + tempList.toString());
		    }
		    
		}
		
		return isWon;
		
	}
	
	private int takeInput(String player)
	{
		 Scanner in = new Scanner(System.in);
		 System.out.println(player+" : Enter an integer in 1,2,3,4,5,6,7,8,9" );
		 String s = in.nextLine();
		 if(s.equals("e") || s.equals("exit"))
		 {
			 return -1;
		 }
		 else
			 return Integer.parseInt(s);
	     // int a = in.nextInt();
	      
	    // return a;
	}
	
	private boolean validateInput(int a)
	{
		 List<Integer> allNodes = Arrays.asList(nodes);
	     boolean returnVal = false;
	      if(allNodes.contains(new Integer(a)))
	      {
	    	  if(tList.contains(new Integer(a)) && tList.size() < 6)
		      {
		    	  returnVal = false;
		    	 // Integer tListArray[] = (Integer[])tList.toArray();
		    	  Set<Integer> setA = new HashSet(Arrays.asList(nodes));
		    	  Set<Integer> setB = new HashSet(tList); 
		    	  setA.removeAll(setB);
		    	 // List<Integer> tempArray = ((List)allNodes).clone();
		    	  System.out.println("Entered value is already exist, Please choose from " + setA.toString());
		    	  return returnVal;
		      }
	    	  returnVal = true;
	    	//  System.out.println("Accepted !!" );
	    	  return returnVal;
	      }
	      
	      System.out.println("Enter valid integer from 1,2,3,4,5,6,7,8,9" );
		return returnVal;
	}
	// Take the input until user enter exit or e
	public void runAlg()
	{
		int a = 0;
		String player = "Player1";
		boolean isWon = false;
	     // a = this.takeInput();
	      while( a != -1 && !isWon)
	      {
	    	 a = this.takeInput(player);
	    	 if(!validateInput(a))
	    	 {
	    		 continue;
	    	 }
	    	  System.out.println("You entered number "+a);
	    	  if(tList.size() < 6){
		    	  if(player.equals("Player1"))
		    	  {
		    		  aList.add(new Integer(a));
		    		 // System.out.println("Player1 array = "+aList.toArray().toString());
		    		  isWon = isWon("Player1",aList);
		    	  }
		    	  else 
		    	  {  
		    		  bList.add(new Integer(a));
		    		  isWon = isWon("Player2",bList);
		    	  }
		    	     	 
		    	  tList.clear();
		    	  tList.addAll(aList);
		    	  tList.addAll(bList);
		    	  
		    	  player = player.equals("Player2") ? "Player1" : "Player2";
		    	  
	    	  }
	    	  else
	    	  {
	    		  System.out.println("Lets play the game !!! ");
	    		  
	    		  
	    	  }
	    	  
	   	  }
	      System.out.println("You exited the program ");
	      
	     
	      
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 MatchingSquare ms = new MatchingSquare();
		 ms.runAlg();
	}
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int a;
	      float b;
	      String s;

	      Scanner in = new Scanner(System.in);

	      System.out.println("Enter a string");
	      s = in.nextLine();
	      System.out.println("You entered string "+s);

	      System.out.println("Enter an integer");
	      a = in.nextInt();
	      System.out.println("You entered integer "+a);

	      System.out.println("Enter a float");
	      b = in.nextFloat();
	      System.out.println("You entered float "+b);  

		
	} */

}
