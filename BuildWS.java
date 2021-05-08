
/**
 * Class that builds a word search.
 * 
 * @author valentino-manno 
 * @version 04 Dec 2016
 */

import java.util.Scanner;
public class BuildWS
{
    private char[][] array;   //char array
    private int[][] numArray; //int array used for overlap
    public void build()       //build method that returns nothing
    {      
        Scanner in = new Scanner(System.in);   //new scanner

        System.out.println("How many rows would you like? >");
        int dimRow = in.nextInt();             //user input for first dimension
        System.out.println("How many columns would you like? >");
        int dimCol = in.nextInt();             //user input for second dimension

        char[][] array = new char[dimRow][dimCol];    //set the arrays dimensions to those that user input
        int [][] numArray = new int[dimRow][dimCol];  //array used to track if a char was placed at a place

        String alpha = "abcdefghijklmnopqrstuvwxyz";  //create a string of all letters of the alphabet
        String word = "";

        for (int row = 0; row < array.length; row++)  //randomly generate characters for each
        {                                             //spot in the char array
            for (int col = 0; col< array[row].length; col++)
            {
                int read = (int)(Math.random() * 26);   //generates a random int, then choses the
                array[row][col] = alpha.charAt(read);   //char at that position
            }
        }

        while(!word.equals("end"))
        {
            System.out.print("Add a word to your search (end to stop) >");
            word = in.next();           //user inputs word to be put in the word search

            int randRow = (int)(Math.random() * dimRow);    //generate the location of the first letter
            int randCol = (int)(Math.random() * dimCol);
            int ori = (int)(Math.random() * 3);   //oriantation, generates an int that corresponds to
            //either horizontal, vertical, or diagonal
            if (word.equals("end"))       //if the user enters end, dont put it in the wordsearch
            {

            }
            else if (ori == 0)     //for oriantation 0 (vertical)
            {
                boolean again = true;    //boolean to re place word if overlap doesnt match
                while (again)       
                {
                    again = false;
                    while(word.length() + randRow > dimRow)  //keep generating numbers until the whole
                    {                                    //word fits
                        randRow = (int)(Math.random() * dimRow);
                        randCol = (int)(Math.random() * dimCol);
                    }

                    for(int i = 0; i < word.length(); i++)      
                    {
                        char q = array[randRow][randCol];    

                        array[randRow][randCol] = word.charAt(i);  //place char on board
                        numArray[randRow][randCol]++;      //incraments the num array

                        if(numArray[randRow][randCol] >= 2)  //if the num array detects more than one
                        {                                    //char being placed on the same spot
                            if(q == array[randRow][randCol]) //if the letters match carry on
                            {

                            }
                            else   //if they dont match, end attempt
                            {
                                array[randRow][randCol] = q;
                                i = word.length();
                                again = true;    //go back through while to re place word
                            }
                        }
                        randRow++;   //incrament the position to place the rest of the chars
                    }
                }
            }

            else if (ori == 1)    //oriantation 1 (horizontal)
            {
                boolean again = true;
                while (again)
                {
                    again = false;
                    while(word.length() + randCol > dimCol) //keep generating numbers until the whole
                    {                                       //word fits
                        randRow = (int)(Math.random() * dimRow);
                        randCol = (int)(Math.random() * dimCol);
                    }

                    for(int i = 0; i < word.length(); i++)
                    {
                        char q = array[randRow][randCol];

                        array[randRow][randCol] = word.charAt(i);  //place char on board
                        numArray[randRow][randCol]++;     //incraments the num array

                        if(numArray[randRow][randCol] >= 2)  //if the num array detects more than one
                        {                                    //char being placed on the same spot
                            if(q == array[randRow][randCol]) // if letters match carry on
                            {

                            }
                            else  //if they dont match, end attempt
                            {
                                array[randRow][randCol] = q;
                                i = word.length();
                                again = true;   //go back through while to re place word
                            }
                        }
                        randCol++;      //incrament col
                    }
                }
            }
            else  //oriantation 2 (diagonal)
            {           //keep generating numbers until the whole word fits
                boolean again = true;
                while (again)
                {
                    again = false;
                    while(word.length() + randRow > dimRow || word.length() + randCol > dimCol) 
                    {
                        randRow = (int)(Math.random() * dimRow);
                        randCol = (int)(Math.random() * dimCol);
                    }

                    for(int i = 0; i < word.length(); i++)
                    {
                        char q = array[randRow][randCol];

                        array[randRow][randCol] = word.charAt(i);  //place char on board
                        numArray[randRow][randCol]++;          //incraments num array

                        if(numArray[randRow][randCol] >= 2) //if the num array detects more than one
                        {                                    //char being placed on the same spot
                            if(q == array[randRow][randCol]) //if letters match carry on
                            {

                            }
                            else
                            {     //if they dont match, end attempt
                                array[randRow][randCol] = q;
                                i = word.length();
                                again = true;   //go back through while to re place word
                            }
                        }
                        randRow++;      //incrament row and col
                        randCol++;
                    }
                }
            }
        }

        for(int row = 0; row < array.length; row++)  //prints the entire board
        {
            for (int col = 0; col < array[row].length; col++)
            {
                System.out.print(array[row][col]);
            }
            System.out.println();
        }
    }
}

