/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Akun {
    private int accountNumber;
    private int pin;
    private double sisasaldo;
 
    public Akun( int theAccountNumber, int thePIN, double saldo)
    {
        accountNumber = theAccountNumber;
        pin = thePIN;
        sisasaldo = saldo;
    }
 
    public boolean validatePIN( int userPIN )
    {
        if( userPIN == pin )
        return true;
        else
        return false;
    }
 
    public double getSaldo()
    {
        return sisasaldo;
    }
 
    public void beli( double amount )
    {
        sisasaldo -= amount;
    }
 
    public int getAccountNumber()
    {
        return accountNumber;
    }
}

