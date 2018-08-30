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
public class Warbirds extends Force {
    
    boolean cloaking_device = false;
//    int activationfee;
//    int battlestrength;
//    
    
    public Warbirds(String fleetref, String fullname, boolean cloak, int battlestrength, ForceState state) {// boolean cloaking_device) {
                  super(fleetref,fullname,cloak ? 400 : 300,battlestrength, state);
                  cloaking_device = cloak;
             
    }
    
     public String toString() {
       return super.toString() + " Cloaking:: "+ cloaking_device;
     }
}