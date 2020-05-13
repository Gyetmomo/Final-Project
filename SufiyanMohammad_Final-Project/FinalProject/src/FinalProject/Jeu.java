/**
 * @author Sufiyan Mohammad
 */

package FinalProject;

import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class Jeu {

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        
        keyboard.useLocale(Locale.ENGLISH);
        String menu;
        
        //Default value of a game
        int codeLength = 4;
        int colorNb = 8;
        int nbAttempt = 10;
        boolean success = false;
        int i = 1;
        
        // Welcome title
        System.out.println(" \\\\ WELCOME TO SUFIYAN'S MASTERMIND ///// " + "\n" + "\n");    
        
        //Loop Menu
        char choice = menu();
        while (choice != 'q') {
            switch (choice) {
                case 'c':
                    System.out.println(" // Game Begin //  \n ");
                    
                    //Secret code generator
                    String[] combination = generate(codeLength,colorNb);
                    Attempt secretCode = new Attempt(codeLength,colorNb,combination);
                    
                    //Start of the MasterMind game
                    MasterMind Jeu = new MasterMind(secretCode, success);
                    
                    // Creation of an Attempt for the user on behalf of essay  
                    Attempt essay = new Attempt(codeLength,colorNb);
                    
                    // Message d'instructions pour l'usager
                    System.out.println("By default we will take eight Colors : (R,B,Y,V,M,O,T,G)");
                    System.out.println("Please enter one color at a time " + "\n");
                    
                    // Loop the x Attempts of the player to find the Secret Code
                    do{
                        
                        // Insertion of colors by the user
                        System.out.println("Attempt numbers " + i + "\n");
                        String combinationUser[] = new String[codeLength];
                        
                        for(int z = 0; z < codeLength ; z++){
                            System.out.print("Please enter color numbers " + (z+1) + " : ");
                            combinationUser[z] = keyboard.nextLine();
                        }
                        
                        //set essay in MasterMind
                        essay.setCombination(combinationUser);
                        essay.display();
                        Jeu.setEssay(essay);   
                        
                        // suppression of combinationUser
                        combinationUser = null;
                       
                        // Comparison 
                        success = Jeu.comparison();
                        i++;
                        
                    }while(success == false && i < nbAttempt);
                    
                    //Si l utilisateur a trouver ou n'a pas trouver le code secret 
                    if(success == true){
                        System.out.println(" \n Congratulations you have succeeded !!! \n ");
                    }
                    else{
                        System.out.println(" \n Sorry you didn't succeed"); 
                        System.out.print("The Secret Code was : "); 
                        secretCode.display();
                        System.out.println("");                        
                    }
                    
                    // reinitilization of the loop 
                    success = false;
                    i = 0;
                    
                    // Suppression of the Objects and String[]
                    combination = null;
                    secretCode = null;
                    Jeu = null;
                    essay = null;

                    break;
                
                // The Rules of the game
                case 'r':
                    System.out.println("Here are the rules of the game"); 
                    regle();
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
            }
            choice = menu();
        }
    
    
     }
    
    // Msg du menu
    private static char menu() {
        System.out.println("----------------------- ");
        System.out.println("--- Main menu --- ");
        System.out.println("----------------------- ");
        System.out.println("Enter (c) to start a game ...." );
        System.out.println("Enter (r) to find out the rules of the game ...." );        
        // System.out.println ("Enter (b) to start a game with your code ...." );
        // System.out.println(""Enter (c) to start a game with special parameters ....");        
        System.out.println("Enter (q) to Quit ...." );

        System.out.print("\n\t\tYour choice :");
        String ans = keyboard.nextLine();
        char choice;
        if (ans.length() > 0) {
            choice = ans.charAt(0);
        } else {
            choice = 'x';
        }
        return choice;
    }
    
    // Creation of an automatically generated combination
    private static String[] generate(int longCode ,int keyboardNb){
       
        if (keyboardNb > 10){
            keyboardNb = 10;
            System.out.println("WARNING: The maximum number of colors is 10, so we will put 10.");           
        }
        
        //Banque de color
        String[] ColorBank = {"R","B","V","Y","M","O","G","T","N","L"};
        
        //initialization after declaration
        String[] combin = new String[longCode];
        String[] color = new String[keyboardNb];
        
        //Insertion des colors choisis
        for(int i=0 ; i<keyboardNb ; i++ ){
            color[i] = ColorBank[i];
        }
        
        //Creation du code secret
        Random rand = new Random();
        for(int i=0; i<longCode; i++)
            combin[i] = color[rand.nextInt(keyboardNb-1)];
        
        return combin;
        
    } 

    // Regle du jeu
    private static void regle(){
        System.out.println("The Game consists of trying to guess a secret code by doing");
        System.out.println("several Attempts. The code is a combination in a very precise order. At");
        System.out.println(" each Attempt, the player receives a return indicating how well he guessed correctly");
        System.out.println(" example : [2(good) - 2(bad)].");
        System.out.println("Here are the available colors : ");
        System.out.println("R : Red | B : Blue | Y : Yellow | V : Violet | M : Magenta ");
        System.out.println("O : Orange | T : Turquoise | G : Gray |  N : Navy ,  L : Lavender");
        System.out.println("By default we will take the first 8 Colors : (R,B,Y,V,M,O,T,G)");
    
    }
    
}

