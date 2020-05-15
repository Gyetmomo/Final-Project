/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

/**
 *
 * @author Sufiyan Mohammad
 * Handles the amount of attempts used by the user.
 * An attempt is comprised of a number of colors in a specific order.
 */
public class Attempt {

    private int codeLength;
    private int colorNb;
    private String[] combination;

    // Constructors

    /**
     *
     */
    public Attempt() {

        this.codeLength = 4;
        this.colorNb = 8;

        String[] myCombination = new String[codeLength];
        this.combination = myCombination;
    }

    /**
     *
     * @param codeLength : length of the code
     */
    public Attempt(int codeLength) {

        this.codeLength = codeLength;
        this.colorNb = 8;

        String[] myCombination = new String[codeLength];
        this.combination = myCombination;
    }

    /**
     *
     * @param codeLength : length of the code
     * @param colorNb : this for the number of colors that will be used in the game, if ever i want to change it.
     */
    public Attempt(int codeLength, int colorNb) {

        this.codeLength = codeLength;
        this.colorNb = colorNb;

        String[] myCombination = new String[codeLength];
        this.combination = myCombination;
    }

    /**
     *
     * @param codeLength
     * @param myCombination : this is the user's combination of colors.
     */
    public Attempt(int codeLength, String[] myCombination) {

        this.codeLength = codeLength;
        this.colorNb = 8;
        this.combination = myCombination;

    }

    /**
     *
     * @param codeLength
     * @param colorNb
     * @param myCombination
     */
    public Attempt(int codeLength, int colorNb, String[] myCombination) {

        this.codeLength = codeLength;
        this.colorNb = colorNb;
        this.combination = myCombination;

    }

    // Set attribute and Get attribute

    /**
     *
     * @return : returns the length
     */
    public int getLength() {

        return codeLength;
    }

    /**
     *
     * @return : returns the color number
     */
    public int getColorNb() {

        return colorNb;
    }

    /**
     *
     * @return : returns the combination
     */
    public String[] getCombination() {

        return combination;
    }

    /**
     *
     * @param length
     */
    public void setLength(int length) {

        this.codeLength = length;
    }

    /**
     *
     * @param colorNb
     */
    public void setColorNb(int colorNb) {

        this.colorNb = colorNb;
    }

    /**
     *
     * @param combination 
     */
    public void setCombination(String[] combination) {

        this.combination = combination;
    }

    void display() {

        System.out.print("[  ");

        for (int i = 0; i < combination.length; i++) {
            System.out.print(combination[i] + "  ");
        }

        System.out.print("] ");
    }

}
