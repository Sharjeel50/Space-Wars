package OODCwk;

import static com.sun.jmx.snmp.EnumRowStatus.active;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class implements the behaviour expected from a SWAT
 * system as required for 6COM1037 - Nov 2017
 * 
 * @author 
 * @version 
 */

public class SpaceWars  implements SWAT 
{
    // fields
    public  ArrayList<Force> all_Force = new ArrayList<>();
    public ArrayList<Fight> all_Fights = new ArrayList<>();
    int warchest = 1000;

    
//**************** SWAT **************************  
    /** Constructor requires the name of the admiral
     * @param admiral the name of the admiral
     */  
    public SpaceWars(String admiral)
    {
     //   setupForces();
        
                
        
    }
    
    
        
    /**Returns a String representation of the state of the game,
     * including the name of the admiral, state of the resources,
     * whether defeated or not, and the forces currently in the 
     * FightingFleet,(or, "No forces" if FightingFleet is empty)
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the resources,
     * whether defeated or not, and the forces currently in the 
     * FightingFleet,(or, "No forces" if FightingFleet is empty)
     **/
    public String toString()
    {
        return "";
    }
    
    
    /** returns true if war chest <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     * @returns true if resources <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     */
    public boolean isDefeated()
    {
        if (warchest <= 0){
        
        }
            
            
        return false;
    }
    
    
    /** returns the number of talents in the resources
     * @returns the number of talents in the resources
     */
    public int getWarchest()
    {
        return warchest;
    }
    
    /**Returns a String representation of all forces in the Allied Space Fleet(ASF)
     * @return a String representation of all forces in the Allied Space Fleet(ASF)
     **/
    public String getASFleet()
    {   
       
//
        StringBuilder a = new StringBuilder();
        setupForces();
        for(Force force_mem: all_Force){
            a.append(force_mem + "\n");
            
        }
        return a.toString();
    }
    
    /** Returns details of an ASF force with the given reference code
     * @return details of an ASF force with the given reference code
     **/
    
    public String findForceInASF(String ref)
    {
        String a = "";
        
        for(Force h: all_Force){
            if(h.getState()== ForceState.ACTIVE){
            
            a = a + h.toString();
            }
        }
        return a;
    }
    
    /** Returns details of any force with the given reference code
     * @return details of any force with the given reference code
     **/
    public String getForce(String ref)
    {    
       
  StringBuilder safe = new StringBuilder();
  
        for (Force needdatforce: all_Force)
           if( needdatforce.get_FleetRef().equals(ref)) { // loop
               safe.append("FleetRef: " + needdatforce.get_FleetRef() + "\t");
               safe.append("Fullname: " + needdatforce.get_Fullname() + "\t");
               safe.append("ActivationFee: " + needdatforce.get_activationfee() + "\t");
               safe.append("BattleStrength: " + needdatforce.get_battlestrength() + "\t");

        //return safe.toString();
    }
     return safe.toString();   
    }
        
    // ***************** Fighting Fleet Forces ************************   
    /** Allows a force to be activated into the admiral's FightingFleet,  
     * if there are enough resources for the activation fee.The force's 
     * state is set to "active"
     * @param ref represents the reference code of the force
     * @return 0 if force is activated, 1 if force is not in the ASF
      * 2 if not enough money, 3 if no such force
     **/        
    public int activateForce(String ref)
    {
      //setupForces();
     // warchest = getWarchest();
        int b = 0;
        
        for(Force active: all_Force){
            if(active.get_FleetRef().equals(ref)){
                active.setForceState(ForceState.ACTIVE);
                warchest = warchest - active.get_activationfee();
                b = 0;
                
            }
            else if(active.get_FleetRef() != (ref)){
                b = 3;
            }        
            else if(active.get_activationfee() > getWarchest()){
                b = 2;  
            }
            else if(active.getState() == ForceState.ACTIVE){
                b = 1;
            }           
    }
                
        return b;
        
    }

        

    /** Returns true if the force with the reference code is in 
     * the admiral's FightingFleet, false otherwise.
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the admiral's FightingFleet, false otherwise.
     **/
    public boolean isInFightingFleet(String ref)
    {
        for(Force isin: all_Force) {
            if((ref).equals(isin.getState() == ForceState.ACTIVE)){
                return true;
            }
        }
        return false;
    }
    
            
    /** Removes a force from the FightingFleet back to the ASF dock, if they 
     * are in the FightingFleet
     * pre-condition: isInAdmiralsForce(ref)
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref)
    {
      
        for(Force recall: all_Force) {
            if(recall.getState() == ForceState.ACTIVE)
                System.out.println("Force Recalled");
                recall.setForceState(ForceState.DOCKED);
                
    }
                //(recall.getState() = ForceState.DOCKED);
        
    }    
      
    /**Returns a String representation of the forces in the admiral's Fighting Fleet
     * or the message "No forces activated"
     * @return a String representation of the forces in the admiral's FightingFleet
     **/
    
    public String getFightingFleet()
    {
       
        StringBuilder FF = new StringBuilder();
        //System.out.println(all_Force);
        for(Force fightingfleet: all_Force){
            if (fightingfleet.getState()==ForceState.ACTIVE) {
                
               FF.append("FleetRef: " + fightingfleet.get_FleetRef() + "\t");
               
               FF.append("Fullname: " + fightingfleet.get_Fullname() + "\t");
               FF.append("ActivationFee: " + fightingfleet.get_activationfee() + "\t");
               FF.append("BattleStrength: " + fightingfleet.get_battlestrength() + "\t");

            }
             
            else if (fightingfleet.getState() != ForceState.ACTIVE) {
                System.out.println("No Forces Activated");
            }
                
        }       
    return FF.toString();
         
    }
//**********************Fights************************* 
    /** returns true if the number represents a fight
     * @param num is the number of the fight
     * @returns true if the number represents a fight
     **/
     public boolean isFight(int num)
     {
       for(Fight thenumber: all_Fights){
           if(thenumber.get_FightNo() == (num)){
               
               }
        
     }
       return true;
     }
     
     
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

    public int fight(int fightNo)
    {
        for(Fight fighting: all_Fights){
            if(fighting.get_FightNo() == (fightNo)){
                for(Force newfighting: all_Force){
                    if(newfighting.getState() == ForceState.ACTIVE) {
                        if (fighting.get_EnemyStrength() < newfighting.get_battlestrength()){
                        warchest = warchest + fighting.get_Gains();
                        return 0;
                        }
                    }
                        
                        else if (newfighting.getState() != ForceState.ACTIVE){
                            warchest = warchest - fighting.get_Losses();
                            return 1;
                        }
                        else if (fighting.get_EnemyStrength() > newfighting.get_battlestrength()){
                            warchest = warchest - fighting.get_Gains();
                            return 2;
                        }
                        else if(fighting.get_EnemyStrength() > newfighting.get_battlestrength()){
                            if(warchest <= 0) {
                                return 3;
                            }  
                        }
                }
            }                   
                                
        }                          
                   
        
     return -1;
    }
    
    

    /** Provides a String representation of a fight given by 
     * the fight number
     * @param num the number of the fight
     * @return returns a String representation of a fight given by 
     * the fight number
     **/
    public String getFight(int num)
    {
       
        StringBuilder thefight = new StringBuilder();
        
        for(Fight a: all_Fights)
            if(a.get_FightNo() == (num))
                thefight.append(a);
        
        return thefight.toString();
    }
    
    /** Provides a String representation of all fights 
     * @return returns a String representation of all fights
     **/
    public String getAllFights()
    {
      
        StringBuilder allfights = new StringBuilder();
        for(Fight gettingfights: all_Fights){
            if(gettingfights.get_Type() == FightType.BATTLE)
                allfights.append(gettingfights);
        }
        return allfights.toString();
    }
    

    //****************** private methods for Task 4 functionality*******************
    //*******************************************************************************
    private void setupForces() 
    {
   
        Starships SS2 = new Starships("SS2", "Starships", 10, 20, ForceState.DOCKED);
        Starships SS6 = new Starships("SS6", "Starships",15, 10, ForceState.DOCKED);
        Starships SS7 = new Starships("SS7", "Starships", 4, 5, ForceState.DOCKED);
        
        Warbirds WB3 = new Warbirds("WB3", "Warbirds",false ,100, ForceState.DOCKED);
        Warbirds WB5 = new Warbirds("WB5", "Warbirds",true, 300, ForceState.DOCKED);
        Warbirds WB9 = new Warbirds("WB9", "Warbirds",false ,400, ForceState.DOCKED);
        
        
        Wings IW1 = new Wings("IW1", "Wings", 200, 10, ForceState.DOCKED);
        Wings IW4 = new Wings ("IW4", "Wings", 200,20, ForceState.DOCKED);
        Wings IW10 = new Wings ("IW10", "Wings", 200,5, ForceState.DOCKED);
        
        
     
        all_Force.add(SS2);
        all_Force.add(SS6);
        all_Force.add(SS7);
        
        
        all_Force.add(WB3);
        all_Force.add(WB5);
        all_Force.add(WB9);
        
        all_Force.add(IW1);
        all_Force.add(IW4);
        all_Force.add(IW10); 
        
    }
    
    
    private void setupFights()
    {
        
     Fight f1 = new Fight(1, FightType.BATTLE , "Borg", 200, 300, 100);
     Fight f2 = new Fight(2,FightType.SKIRMISH, "Kardassians", 700, 200, 100);
     Fight f3 = new Fight(3, FightType.AMBUSH, "Ferengi", 100, 400, 150);
     Fight f4 = new Fight(4, FightType.BATTLE, "Ewoks", 600, 600, 200);
     Fight f5 = new Fight(5, FightType.AMBUSH, "Borg", 500, 400, 90);
     Fight f6 = new Fight(6,FightType.SKIRMISH, "Groaners", 150, 100, 100);
     
     all_Fights.add(f1);
     all_Fights.add(f2);
     all_Fights.add(f3);
     all_Fights.add(f4);
     all_Fights.add(f5);
     all_Fights.add(f6);
     
  
    }
    //*******************************************************************************
    //*******************************************************************************
  
    // These methods are not needed until Task 7.3
    // ***************   file write/read  *********************
    /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
    public void saveGame(String fname)
    {    
          SpaceWars saveFile = this;
       
        try {
              
              FileOutputStream  F = new FileOutputStream (fname);
              ObjectOutputStream O = new ObjectOutputStream (F);
              O.writeObject(this);
              
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
              
         
         

         } catch (IOException ex) {
            Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /** reads all information about the game from the specified file 
     * and returns 
     * @param fname name of file storing the game
     * @return the game (as a Admiral object)
     */
    public SpaceWars restoreGame(String fname)
    {   
        
     FileInputStream F;
     SpaceWars a = null;
     
        try {
            F = new FileInputStream(fname);
            ObjectInputStream I = new ObjectInputStream (F);
            a = (SpaceWars)I.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    } 
    
}



