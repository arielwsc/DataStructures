/*Author: Ariel Souza de Carvalho
 * netID: 2021438357
 */
package cs3345_project1;

import java.util.Scanner;
//import java.lang.Math;

public class CS3345_Project1 {

    public static void main(String[] args) {
        
        int n;
        boolean A[];
        Scanner input = new Scanner(System.in);
        
        /**
         * Validation of user input: number entered has to be greater than 1
         */
        do{
            System.out.println("Enter an int n greater than 1");
            n = input.nextInt();
        }
        while(n<= 1);
        
        A = new boolean[n+1];
        
        /**
         * Initialize all indexes of array to true
         */
        for(int i = 2; i<=n; i++){
            A[i] = true;
        }
        
        /**
         * This is the algorithm of Sieve of Erotosthenes to calculate
         * all prime numbers given a maximum integer 'n'
         */
        for(int i = 2; i<=java.lang.Math.sqrt(n);i++){
            if (A[i] == true){ //Check to not repeat an index that has already
                //been set to false
                int j = (int)java.lang.Math.pow(i, 2);
                for(int k=0; j<=n; k++){
                    A[j] = false; //Cross out index that is checked to not be prime
                    j = (int)java.lang.Math.pow(i, 2) + k*i;
                }
            }
        }
        System.out.print("The prime numbers are: ");
        for(int i=2; i<=n; i++){
            if (A[i] == true){
                System.out.print(i+", "); //Print only the prime numbers less 
                //or equal to n
            }
        }     
    }
}
