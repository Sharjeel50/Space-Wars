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
public class Wings extends Force {
        
    private int strikers;
    //private int battlestrength;
    //private int activationfee = 200;
    

   
    public Wings(String fleetref, String fullname, int activationfee, int strikers, ForceState state) {

        super(fleetref,fullname,activationfee,strikers*20, state);
        this.strikers = strikers;
     
        
    }
    
     public String toString() {
       return super.toString() + " Strikers " + strikers;   
     }

    
    
    
}
