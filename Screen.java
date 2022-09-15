/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Screen {
   public void displayMessage( String message )
    {
        System.out.println( message );
    }
    public void displayMessageLine( String message )
    {
        System.out.println( message );
    }
    public void displaySaldo( double amount )
    {
        System.out.printf( "Rp %,.2f", amount );
    }
} 

