/*
Author: Kevin Bell
Course: COP3538
Project#: 1
Title: Presidents Array
Due Date: 09/12/2016

Sorts and Searches President information
*/
package ds_p1v2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Sorts and Searches President information 
 */
public class Main {
    
        //class vars
        private static PresidentsMDrvr presidentsDrvr;
        private static final int MAX_PRESIDENTS = 44;
        private static String[] key = new String[7];
        private static String[] binKey = new String[6];

    /**
    *  Sorts and searches President information
    * @return void
    * @param args
    * @throws IOException 
    * 
    */
    public static void main(String[] args) throws IOException {
        
        //sort type vars
        int sortNum = 1;
        int sortName = 2;
        int unsorted = 1;
        int sorted = 2;
        
        
        presidentsDrvr = new PresidentsMDrvr(MAX_PRESIDENTS); //creates instance of type PresidentsMDrvr
        fileReader("presidents.txt");//reads data file
        presidentsDrvr.display(unsorted); // displays unsorted array
        presidentsDrvr.bubbleSort(sortNum); //sorts array on number
        presidentsDrvr.display(sorted); //displays array sorted by number
        keyReader("key.txt"); //reads sequential search key
        presidentsDrvr.sequentialSearch(key); //searches array on party attribute
        presidentsDrvr.bubbleSort(sortName); //sorts array on name
        presidentsDrvr.display(sorted); //displays array sorted on name
        binKeyReader("binKey.txt"); //reads the binary search key
        presidentsDrvr.binarySearch(binKey); //searches array on name attribute 
    }//end main()
        
    
    /**
     * Reads records from the presidents data file
     * @return void
     * @param file The path and name of the presidents data file
     * @throws FileNotFoundException
     * @throws IOException
     */    
    public static void fileReader(String file) throws FileNotFoundException, IOException{
        
        //input vars
        int number;
        String name;
        String party;
        String code;
        int years;
        String state;
        String input;

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        
        //parse input data
        while((input = br.readLine()) != null) 
        {
            number = Integer.parseInt(input.substring(0,2).trim());
            name = input.substring(2,25).trim();
            code = input.substring(25,27).trim();
            years = Integer.parseInt(input.substring(27,29).trim());
            party = input.substring(29,49).trim();
            state = input.substring(49, input.length());
                 
            presidentsDrvr.add(new Presidents (number, name, code, years, party, state));//add input into president object           
        }//end while
    }//end fileReader()
    
    
     /**
     * Reads data from the sequential search key text file
     * @return void
     * @param file The path and name of the sequential search key
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void keyReader(String file) throws FileNotFoundException, IOException{
        
        String keyInput;
        int i = 0;
        
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
       
        //parse data into array
        while ((keyInput = br.readLine()) != null){
            key[i] = keyInput.trim(); 
            i++;
        }//end while
    }//end keyReader()
    
    
    /**
     * Reads the data from the binary search key text file
     * @return void
     * @param file The path and name of the binary search key file
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void binKeyReader(String file) throws FileNotFoundException, IOException{
        
        String keyInput;
        int i = 0;
        
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
       
        //parse data into array
        while ((keyInput = br.readLine()) != null){
            binKey[i] = keyInput.trim(); 
            i++;
        }//end while
    }//end binKeyReader()
}//end Main class
