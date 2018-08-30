package OODCwk;
import java.io.*;
/**
 * Task 2 - provide command line interface
 * 
 * @author A.A.Marczyk
 * @version 06/02/2013
 */
public class GameUI
{
    private static BufferedReader myIn = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)
    {
        int choice;
        String admiralName;
        int result = -1;
        SpaceWars gp;
        
        try
        {
            System.out.println("Enter admiral's name");
            String s = myIn.readLine();
 //           myIn.readLine();
            gp = new SpaceWars(s); // create
            choice = 100;
            while (choice != 0 )
            {
                choice = getMenuItem();
                if (choice == 1)  //list ASFleet
                {
                    System.out.println(gp.getASFleet());
                }
                else if (choice == 2) //List Admiral's Fighting Fleet
                {
                    System.out.println(gp.getFightingFleet());
                }
                else if (choice == 3) //get Force
                {
                    System.out.println("Enter Force reference");
                    String ref = (myIn.readLine()).trim();
                    System.out.println(gp.getForce(ref));
                } 
                else if (choice == 4) //activate Force
                {   
                    System.out.println("Enter Force reference");
                    String nme = (myIn.readLine()).trim();
                    //System.out.print("passed");
                    if(!gp.isDefeated()) //optional
                    {
   
                        result = gp.activateForce(nme);
                    }
                    System.out.println(activation(result) + "\nWar chest = " + gp.getWarchest());
                }
                else if (choice == 5) //engage in a fight
                {
                    System.out.println("Enter number of the fight");
                    String chal = myIn.readLine();
                    int number = Integer.parseInt(chal);
                    if (gp.isFight(number))
                    {
                        result = gp.fight(number);
                    }
                    
                    System.out.println(fighting(result) + "\nWar chest = " + gp.getWarchest());
                    
                }
                
                else if (choice == 6) //recall force
                {
                    System.out.println("Enter Force reference");
                    String ref = (myIn.readLine()).trim();
                    if(gp.getForce(ref) != null && gp.isInFightingFleet(ref))
                    {
                        gp.recallForce(ref);
                        System.out.println("\nForce " + ref +
                        " recalled" + "\nWar Chest: " + gp.getWarchest());
                    }
                }
                else if (choice==7) //view game state
                {
                    System.out.println(gp.toString());
                }
//                 else if (choice == 8) // Task 7.3 only
//                 {
//                     System.out.println("Write to file");
//                     gp.saveGame("olenka.txt");
//                 }
//                 else if (choice == 9) // Task 7.3 only
//                 {
//                     System.out.println("Restore from file");
//                     Player gp2=null;
//                     gp2.restoreGame("olenka.txt");
//                     System.out.println(gp2.toString());               
//                 }
            }     
        }
        catch (IOException e) {System.out.println (e);}   
        System.out.println("Thank-you");
    }
    
    private static int getMenuItem()throws IOException
    {   int choice = 100;  
        System.out.println("Main Menu");
        System.out.println("0. Quit");
        System.out.println("1. List forces in Allied Space Fleet");
        System.out.println("2. List forces in admirals fighting fleet"); 
        System.out.println("3. View a force");
        System.out.println("4. Activate a force into admiral's fighting fleet");
        System.out.println("5. Engage in a fight");
        System.out.println("6. Recall a force");
        System.out.println("7. View the state of the game");
        //Task 7 only
        //System.out.println("8. Save this game");
        //System.out.println("9. Restore a game");
       
        
        while (choice < 0 || choice  > 9)
        {
            System.out.println("Enter the number of your choice");
            choice =  Integer.parseInt(myIn.readLine());
        }
        return choice;        
    } 
    
    private static String activation(int code)
    {
        switch (code)
        {
            case 0:return "force is activated"; 
            case 1:return "force is not in the ASF"; 
            case 2:return "not enough money";
            case 3:return "no such force";
            default: return "Error";
        }
    }
    
    private static String fighting(int code)
    {
        switch (code)
        {
            case 0:return "Fight won"; 
            case 1:return "Fight lost as no suitable force available"; 
            case 2:return "Fight lost on battle strength, force destroyed";
            case 3:return "fight is lost and admiral completely defeated ";
        }
        return " no such fight ";
    }                                         
}