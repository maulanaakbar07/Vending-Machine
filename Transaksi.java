/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public abstract class Transaksi {
    private int accountNumber;
    private Screen screen;
    private Database_KartuPintar Database;
   
    public Transaksi( int userAccountNumber, Screen userScreen, Database_KartuPintar BankDatabase)
    {
        accountNumber = userAccountNumber;
        screen = userScreen;
        Database = BankDatabase;
    }
   
    public int getAccountNumber()
    {
        return accountNumber;
    }
   
    public Screen getScreen()
    {
        return screen;
    }
   
    public Database_KartuPintar getBankDatabase()
    {
        return Database;
    }
   
    abstract public void execute();
}
    

