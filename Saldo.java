/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Saldo extends Transaksi {
    public Saldo( int userAccountNumber, Screen vendingScreen, Database_KartuPintar vendingBankDatabase )
    {
        super( userAccountNumber, vendingScreen, vendingBankDatabase );
    }
   
    @Override
    public void execute()
    {
        Database_KartuPintar bankDatabase = getBankDatabase();
        Screen screen = getScreen();
       
        double saldo = bankDatabase.getSaldo( getAccountNumber());
       
       
        System.out.println( "\nSaldo Anda : " );
        System.out.println( saldo );
    }
}
    

