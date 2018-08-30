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
    
    
    Force(String fleetref,String fullname, int activationfee, int battlestrength, ForceState state){
        this.fleetref = fleetref;
        this.fullname = fullname;
        this.activationfee = activationfee;
        this.battlestrength = battlestrength;
        this.ForceState = state;
      
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
    
    public ForceState get_State() {
        return ForceState;
    }
    
    @Override
    public String toString() {
           String a = "";
           
               a = a + "Fullname: " + this.get_Fullname() + "\t";
               
               a = a + "Reference: " + this.get_FleetRef() + "\t";
               
               a = a + "Activation Fee:" + this.get_activationfee() + "\t";
               
               a = a + "Battle Strength: " + this.get_battlestrength() + "\t";
               
               a = a + "Status: " + this.get_State() + "\t";
                           
               return a;           
       }

    ForceState getState() {
        return ForceState;
    }

    }
    