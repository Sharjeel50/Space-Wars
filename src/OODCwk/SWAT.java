package OODCwk;
import java.io.*;
/**
 * This interface specifies the behaviour expected from the SWAT
 * system as required for 6COM1037 - Nov 2017
 * 
 * @author A.A.Marczyk 
 * @version 25/10/2017
 */
 
public interface SWAT extends Serializable 
{
 //**************** SWAT **************************  
    
    /**Returns a String representation of the state of the game,
     * including the name of the admiral, state of the resources,
     * whether defeated or not, and the forces currently in the 
     * FightingFleet,(or, "No forces" if FightingFleet is empty)
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the resources,
     * whether defeated or not, and the forces currently in the 
     * FightingFleet,(or, "No forces" if FightingFleet is empty)
     **/
    public String toString();
    
    
    /** returns true if war chest <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     * @returns true if war chest <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     */
    public boolean isDefeated();
    
    /** returns the number of bit coins in the war chest
     * @returns the number of bit coins in the war chest
     */
    public int getWarchest();
    
    
    /**Returns a String representation of all forces in the Allied Space Fleet(ASF)
     * @return a String representation of all forces in the Allied Space Fleet(ASF)
     **/
    public String getASFleet();
    
    
    /** Returns details of an ASF force with the given reference code
     * @return details of an ASF force with the given reference code
     **/
    public String findForceInASF(String ref);
    
    
    /** Returns details of any force with the given reference code
     * @return details of any force with the given reference code
     **/
    public String getForce(String ref);
    
    
 // ***************** Fighting Fleet Forces ************************   
    /** Allows a force to be activated into the admiral's FightingFleet,  
     * if there are enough resources for the activation fee.The force's 
     * state is set to "active"
     * @param ref represents the reference code of the force
     * @return 0 if force is activated, 1 if force is not in the ASF
      * 2 if not enough money, 3 if no such force
     **/       
    public int activateForce(String ref);
    
        
    /** Returns true if the force with the reference code is in 
     * the admiral's FightingFleet, false otherwise.
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the admiral's FightingFleet, false otherwise.
     **/
    public boolean isInFightingFleet(String ref);
    
    
    /** Removes a force from the FightingFleet back to the ASF dock if they 
     * are in the FightingFleet
     * pre-condition: isInFightingFleet(ref)
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref);
        
        
    /**Returns a String representation of the forces in the admiral's Fighting Fleet
     * or the message "No forces activated"
     * @return a String representation of the forces in the admiral's FightingFleet
     **/
    public String getFightingFleet();
       
    
//**********************Fights************************* 
    /** returns true if the number represents a fight
     * @param num is the number of the fight
     * @returns true if the number represents a fight
     **/
     public boolean isFight(int num);
     
     
    /** Retrieves the fight represented by the fight number.Finds 
      * a force from the Fighting Fleet which can engage in the fight.The  
      * results of fighting an fight will be one of the following: 
      * 0 - Fight won, add fight gains to the warchest, 
      * 1 - Fight lost as no suitable force available, deduct the fight losses 
      * from resources 
      * 2 - Fight lost on battle strength  - deduct fight losses warchest, 
      *   and destroy the force
      * 3 - If a fight is lost and admiral completely defeated (no resources and 
      * no forces to recall) 
      * -1 - no such fight
      * @param fightNo is the number of the fight
      * @return a int showing the result of the fight
      */ 
    public int fight(int fightNo);
    

    /** Provides a String representation of a fight given by 
     * the fight number
     * @param num the number of the fight
     * @return returns a String representation of a fight given by 
     * the fight number
     **/
    public String getFight(int num);
    
    
    /** Provides a String representation of all fights 
     * @return returns a String representation of all fights
     **/
    public String getAllFights();
 
    
//  These methods are not needed until Task 7.3
//    // ***************   file write/read  *********************
//    /** Writes whole game to the specified file
//    * @param fname name of file storing requests
//     */
//   public void saveGame(String fname);
    
//    /** reads all information about the game from the specified file 
//     * and returns a SpaceWars object
//     * @param fname name of file storing the game
//     * @return the game (as a SpaceWars object)
//     */
//    public SpaceWars restoreGame(String fname);
}
