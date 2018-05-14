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
 * Provides properties and methods for an array of Presidents objects
 * @author kbell
 */
public class PresidentsMDrvr {
    
    private Presidents[] myPresidents;
    private int nElem = 0;

    
    /**
     * Creates an object instance of the PresidentsMDrvr class and initializes the array of President objects
     * @return Constructor for PresidentsMDrvr
     * @param max The maximum size of the array, 44
     */
    public PresidentsMDrvr(int max){
        myPresidents = new Presidents[max];
    }//end constructor
    
    
    /**
     * Adds a president object to myPresidents[]
     * @return void
     * @param president The president object being added to myPresidents 
     */
    public void add(Presidents president){
       myPresidents[nElem++] = president;     
    }//end add()

    
    /**
     * Displays president objects in myPresidents
     * @return void
     * @param dispType Determines if array is sorted or unsorted
     */
    public void display(int dispType){
        switch(dispType){
            case 1:     //unsorted
                System.out.format("\n%-5s%-23s%-10s\n", " ", "Unsorted Presidents Array", " "); //prints report title
                System.out.println(String.format("\n%-3s%-20s%-20s\n", "#", "Name", "Party")); //format header

                for (int j = 0; j<myPresidents.length; j++){ //loop thru array
                    System.out.println(myPresidents[j].toString()); //print out each element of array
                }//end for
                
                System.out.println(" "); //print a blank line
                break;
                
            case 2:     //sorted
                System.out.format("\n%-5s%-23s%-10s\n", " ", "Sorted Presidents Array", " "); //prints report title
                System.out.println(String.format("\n%-3s%-20s%-20s\n", "#", "Name", "Party")); //format header
                
                for (int j = 0; j<myPresidents.length; j++){ //loop thru array
                    System.out.println(myPresidents[j].toString()); //print out each element of array
                }//end for
                System.out.println(" "); //print a blank line
                break;
        }//end switch
    }//end display()
    
    
    /**
     * Sorts the presidents data by number and owner using bubble sort algorithm
     * @return void
     * @param sortType Determines the attribute to be sorted by 
     */
    public void bubbleSort(int sortType){
        int out, in;
        
        if(sortType == 1){ //sort by number
            for(out = myPresidents.length-1; out>1; out--)
                for (in = 0; in<out; in++)
                    if(myPresidents[in].getNumber() > myPresidents[in+1].getNumber())
                        swap(in, in+1);
                    //end if
                //end for
            //end for
        }
        else{ //sort by name
            for (out = myPresidents.length-1; out>1; out--)
                for(in = 0; in<out; in++)
                    if(myPresidents[in].getName().compareTo(myPresidents[in+1].getName()) > 0)
                        swap(in, in+1);
                    //end if
                //end for
            //end for
        }//end if
    }//end bubbleSort()
   
    
    /**
     * Swaps the values between the two specified locations in the array
     * @return void
     * @param pos1 The position of the first value to swap
     * @param pos2 The position of the second value to swap
     */
    private void swap(int pos1, int pos2){
        Presidents temp = myPresidents[pos1];
        myPresidents[pos1] = myPresidents[pos2];
        myPresidents[pos2] = temp;  
    } // end swap()
    
    
    /**
     * Searches the array and counts hits using the sequential search algorithm
     * @return void
     * @param inKey The search key array
     */
    public void sequentialSearch(String[] inKey){ 
        int[] hits = new int[7];
        
        for (int a = 0; a<inKey.length; a++){
            for (int i = 0; i<myPresidents.length; i++){ 
                if(myPresidents[i].getParty().equals(inKey[a])){
                    hits[a]++;
                }//end if
            }//end for
        } //end for
        displaySeqSearch(inKey, hits);   
    }//end sequentialSearch()
    
    
    /**
     * Displays results of sequentialSearch()
     * @return void
     * @param inKey The search key array
     * @param hits Number of hits for each search argument 
     */
    public void displaySeqSearch(String[] inKey, int[] hits){
        
        System.out.format("\n%-1s%-36s%-7s\n\n%-18s%-13s%-18s\n", " ", "Results of Sequential Search on Party", " " ,"Search Args", "Result", "# of Hits"); //displays header
        
        for (int a = 0; a<inKey.length; a++){  //displays search results
            if (hits[a] > 0){
               System.out.format("\n%-18s%-13s%-3d%-15s", inKey[a], "Found", hits[a], "hits");
            }else{
               System.out.format("\n%-18s%-13s%-3d%-15s", inKey[a], "Not found", hits[a], "hits");
            }//end if
        }//end for
            System.out.println("\n"); //displays a blank line
    }//end displaySeqSearch()
  
    
    /**
     * Searches the array using the binary search algorithm 
     * @return void
     * @param binKey The search key array
     */
    public void binarySearch(String[] binKey){
        
        int lowerBound = 0;
        int upperBound = myPresidents.length-1;
        int curIn;
        int[] binaryFound = new int[6];
        int[] probes = new int[6];
        
        for (int i = 0; i<binKey.length; i++){ //loops through all 6 search arguments   
            while(true){ //performs binary search
                
                curIn = (lowerBound + upperBound) /2;
                if (myPresidents[curIn].getName().equals(binKey[i])){
                    probes[i]++;
                    binaryFound[i]++;
                    break;
                }
                else if (lowerBound > upperBound){
                    break;
                }
                else {
                    if (myPresidents[curIn].getName().compareTo(binKey[i]) < 0){
                        lowerBound = curIn+1;
                        probes[i]++;
                    }else{
                        upperBound = curIn-1;
                        probes[i]++;
                    }//end if
                }//end if
            }//end while
            lowerBound = 0;
            upperBound = myPresidents.length-1;
        } //end for
        displayBinSearch(binKey, probes, binaryFound);
    } //end binarySearch()   
    
    
    /**
     * Displays results of binarySearch()
     * @return void
     * @param binKey The search key array 
     * @param probes The number of probes for each search argument
     * @param binaryFound Was the search argument found?
     */
    public void displayBinSearch(String[] binKey, int[] probes, int[] binaryFound){
        
        System.out.format("\n%-4s%-36s%-7s\n\n%-18s%-13s%-18s\n", " ", "Results of Binary Search on Name", " " ,"Search Args", "Result", "# of Probes"); //displays header
            
        for (int i = 0; i<binKey.length; i++){ //displays search results
            if(binaryFound[i] > 0){
                System.out.format("\n%-18s%-13s%-2d%-15s", binKey[i], "Found", probes[i], "probes");
            }
            else{
                System.out.format("\n%-18s%-13s%-2d%-15s", binKey[i], "Not Found", probes[i], "probes");
            }//end if    
        }//end for
    }//end displayBinSearch()
}//end PresidentsMDrvr class
