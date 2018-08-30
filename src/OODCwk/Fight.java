/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

/**
 *
 * @author yousu
 */
public class Fight {
  
    private int FightNo;
    private FightType Type; 
    private String Enemy;
    private int EnemyStrength;
    private int Losses;
    private int Gains;
    private FightType FightType;
    
    Fight(int FightNo,FightType Type, String Enemy, int EnemyStrength, int Losses, int Gains){
        this.FightNo = FightNo;
        this.EnemyStrength = EnemyStrength;
        this.Gains = Gains;
        this.Type = Type;
        this.Losses = Losses;
    }
    
    public int get_FightNo() {
      return FightNo;

    }
    
    public int get_EnemyStrength() {
      return EnemyStrength;
    }
    
    public int get_Losses() {
       return Losses;
    }
    
    public int get_Gains() {
        return Gains;
    }
    
    public String get_Enemy() {
        return Enemy;
    }
    
    public FightType get_Type() {
        return Type;
    }

    public String toString() {
           String a = "";
           
               a = a + "Fight No: " + this.get_FightNo() + "\n";
               
               a = a + "Type: " + this.get_Type() + "\n";
                
               a = a + "Enemy: " + this.get_Enemy() + "\n";
               
               a = a + "Enemy Strength: " + this.get_EnemyStrength() + "\n";
               
               a = a + "Losses: " + this.get_Losses() + "\n";
               
               a = a + "Gains: " + this.get_Gains() + "\n";
               
              
               return a;           
       }
}