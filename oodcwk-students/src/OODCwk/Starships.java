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

    
  
    
    public Starships(String fleetref, String fullname, int lasers, int photon){

        super(fleetref,fullname,0,0);
        if(lasers>0) {
            this.setActivationfee(lasers*30);
            
        if (photon>0) {
            this.setBattlestrength(photon*5);
        }
        
        
        
        
        
                //if lasercannons is greater than 0, activation fee = lasercannons * 30
        
//        this.torpedoes = torpedoes;
//        this.lasercannons = lasercannons;
//        this.activationFee = 30 * lasercannons; // AF = acticvationfee .. yet to do 
//        this.battlestrength = 5 * torpedoes; // BS = Battlestrength .. yet to do
//         
    }
    
    

}
