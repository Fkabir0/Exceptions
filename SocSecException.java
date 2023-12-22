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
public class SocSecException extends Exception {
    
    
    
    
    
    public SocSecException(String error)
    {
        super("Invalid soscial security number " +error);
    }
    
}