/*
Author: Kevin Bell
Course: COP3538
Project#: 1
Title: Presidents Array
Due Date: 09/12/2016

Sorts and Searches President information
*/
package ds_p1v2;

/**
 * Provides properties and methods for a president object
 */
public class Presidents {
    
        //Presidental attributes 
        private int number;
        private String name;
        private String code;
        private int years;
        private String party;
        private String state;
    
    /**
     * Creates an object instance of the Presidents class
     * @return Constructor for Presidents
     * @param pNumber President's number
     * @param pName President's name
     * @param pCode President's code
     * @param pTerm President's term
     * @param pParty President's party
     * @param pState President's state
     */    
    public Presidents( int pNumber, String pName, String pCode, int pTerm, String pParty, String pState){
    
        number = pNumber;
        name = pName;
        code = pCode;
        years = pTerm;
        party = pParty;
        state = pState;     
    }//end constructor 
    
    
    /**
     * Gets the number of a president
     * @return the number of a president
     * @param none
     */
    public int getNumber(){
        return number;
    } //end getNumber()

    
    /**
     * Gets the name of a president
     * @return the name of a president
     * @param none
     */
    public String getName(){
        return name;
    }//end getName()
    
    
    /**
     * Gets the party of a president
     * @return the party of a president
     * @param none
     */
    public String getParty(){
        return party;
    }//end getParty()
    
    
    /**
     * Gets a formatted string containing information about a president
     * @return a formatted string containing information about a president
     * @param none
     */
    @Override
    public String toString(){
        return String.format("%-3d%-20s%-20s", number, name, party);
    } //end toString()
}//end Presidents class    
