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
public class Starships extends Force {
    
//    private int activationfee;
//    private int battlestrength;
//
//    
    int activationFee;
    int battlestrength; 


  
    
    public Starships(String fleetref, String fullname, int lasers, int photon, ForceState state){

        super(fleetref,fullname,0,0, state);
        if(lasers>0) {
            this.setActivationfee(lasers*30);
        }
            
        if (photon>0) {
            this.setBattlestrength(photon*5);
        }
        
    }
        
} 
