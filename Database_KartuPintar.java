/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Database_KartuPintar {
     private static Akun[] accounts;
 
    public Database_KartuPintar()
    {
        accounts = new Akun[ 2 ];
        accounts[ 0 ] = new Akun( 51030, 12345, 100000.0);
        accounts[ 1 ] = new Akun( 51140, 54321, 100000.0 );
    }
 
    public static Akun getAccount( int accountNumber )
    {
        for ( Akun currentAccount : accounts )
        {
            if ( currentAccount.getAccountNumber() == accountNumber )
            return currentAccount;
        }
        return null;
    }
 
    public boolean authenticateUser( int userAccountNumber, int userPIN )
    {
        Akun userAccount = getAccount( userAccountNumber );
        if ( userAccount != null )
        return userAccount.validatePIN( userPIN );
        else
        return false;
    }
 
    public static double getSaldo( int userAccountNumber )
    {
        return getAccount( userAccountNumber ).getSaldo();
    }
 
    public static void beli( int userAccountNumber, double amount )
    {
        getAccount( userAccountNumber ).beli( amount );
    }
}
    

