/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

/**
 *
 * @author Sufiyan Mohammad
 */
public class MasterMind {
    
    private Attempt secretCode;
    private Attempt essay; 
    private boolean success;
    
    public MasterMind(){
    
        this.secretCode = new Attempt(); 
        this.essay = new Attempt();
        this.success = false;
    }
    
    
    public MasterMind(Attempt secretCode) {
        
        this.secretCode = secretCode; 
        this.essay = new Attempt();
        this.success = false;
    
    }
    
    public MasterMind(Attempt secretCode, Attempt essay ) {
        

        this.secretCode = secretCode; 
        this.essay = essay;
        this.success = false;
    
    }  
   
    public MasterMind(Attempt secretCode, boolean success ) {
        
        this.secretCode = secretCode; 
        this.essay = new Attempt();
        this.success = false;
    
    }  
  
    public MasterMind(Attempt secretCode, Attempt essay, boolean success) {
        
        this.secretCode = secretCode; 
        this.essay = essay;
        this.success = success;
    
    }   
    
    
    public Attempt getSecretCode(){
    
        return secretCode;
    }
    
    public Attempt getEssay(){
    
        return essay;
    }

    public boolean getSuccess(){
    
        return success;
    }
    
    public void setSecretCode(Attempt secretCode){
    
        this.secretCode = secretCode;
    }
    
    public void setEssay(Attempt essay){
    
        this.essay = essay;
    }
    
    public void getSuccess(boolean success){
    
        this.success = success;
    }
    
    public boolean comparison(){
        
        int goodAnswer = 0;
        int badAnswer = 0;
        int codeLength = secretCode.getLength();
        String[] myEssay = essay.getCombination();
        String[] mySecretCode = secretCode.getCombination();
        
        //Inserrtion 
        for(int i = 0; i < codeLength; i++){
                
            if (myEssay[i].equals(mySecretCode[i]) == true){   

                
                goodAnswer++;
            }
            else{
                badAnswer++;
            }    
        } 
        
        System.out.println("[" + goodAnswer + "-" + badAnswer + "]");
        
        if (badAnswer == 0){
            success = true;
        }
        
        return success;
        

        
    }
}
