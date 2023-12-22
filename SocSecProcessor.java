/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author 23684432
 */
import java.util.Scanner;
import java.io.IOException;

public class SocSecProcessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        Scanner scanner;
        String name; 
        String ssn; 
        String confirmation; 
       
        do
        {
        scanner=new Scanner(System.in);
        System.out.print("Name? ");
        name=scanner.nextLine();
        System.out.print("SSN? ");
        ssn=scanner.nextLine();
        try
        {
            isValid(ssn);
            System.out.println(name+ " " + ssn+ " is valid");
                
        }
        catch(SocSecException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Continue? ");
        scanner=new Scanner(System.in);
        confirmation=scanner.next();
        
        }
        while(confirmation.equals("y"));
       
    }
    
    
    
    
    public static boolean isValid(String ssn) throws Exception 
    {
        if(ssn.charAt(3) != '-' || ssn.charAt(6) != '-')
        {
            throw new SocSecException(" dashes at wrong positions");
            
        }
        else if(ssn.length()!=11)
        {
            throw new SocSecException(" wrong number of characters");
        }
        else if(checkDigits(ssn))
        {
            throw new SocSecException(" contains a character that is not a digit");
            
        }
        return true; 
    }
    public static boolean checkDigits(String ssn)
    {
        char[] chars=ssn.toCharArray();
        for(char a : chars)
        {
            if(a== '-')continue;
            if(!Character.isDigit(a))
            {
                return true;
            }
        }
        return false;
    }
}
