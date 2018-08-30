/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

/**
 *
 * @author sj15abm
 */
public class Force {

    public void setFleetref(String fleetref) {
        this.fleetref = fleetref;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setActivationfee(int activationfee) {
        this.activationfee = activationfee;
    }

    public void setBattlestrength(int battlestrength) {
        this.battlestrength = battlestrength;
    }

    public void setForceState(ForceState ForceState) {
        this.ForceState = ForceState;
    }
    private String fleetref;
    private String fullname; 
    private int activationfee;
    private int battlestrength;
    private ForceState ForceState;
    //public String status;
    
    
    Force(String fleetref,String fullname, int activationfee, int battlestrength){
        this.fleetref = fleetref;
        this.fullname = fullname;
        this.activationfee = activationfee;
        this.battlestrength = battlestrength;
       
    }
    
    public String get_FleetRef() {
      return fleetref;

    }
    
    public String get_Fullname() {
      return fullname;
    }
    
    public int get_activationfee() {
       return activationfee;
    }
    
    public int get_battlestrength() {
        return battlestrength;
    }
    
 
    public String toString() {
           String a = "";
           
               a = a + "Fullname: " + this.get_Fullname() + "\n";
               
               
               a = a + "Reference: " + this.get_FleetRef() + "\n";
               
            //   a = a + "Status: " + ForceState.ACTIVE() + "\n";
               
               a = a + "Activation Fee:" + this.get_activationfee() + "\n";
               
               a = a + "Battle Strength: " + this.get_battlestrength() + "\n";
               


               return a;           
       }

    ForceState getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }
    