/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
class MesinMinuman {
    private boolean userAuthenticated;
    private int currentAccountNumber;
    private Screen screen;
    private Keypad keypad;
    private CekStok CekStok;
    private Database_KartuPintar bankDatabase;
   
    private static final int CekSaldo = 1;
    private static final int MengambilMinuman = 2;
    private static final int EXIT = 4;
   
    public MesinMinuman(){
        userAuthenticated = false;
        currentAccountNumber = 0;
        screen = new Screen();
        keypad = new Keypad();
        CekStok = new CekStok();
        bankDatabase = new Database_KartuPintar();
    }
   
   
    public void run(){
       
        while(true){
           
            while(!userAuthenticated){
                System.out.println("===============================================");
                System.out.println("Selamat Datang di Mesin Minuman E-Money !");
                System.out.println("===============================================");
                System.out.println("              Masukkan Kartu Anda!      ");
                authenticateUser();    
            }  
           
            performTransactions();      
            userAuthenticated = false;  
            currentAccountNumber = 0;  
            screen.displayMessageLine("\nTerima kasih!\nSilahkan kembali lagi!\n\n");
        }
    }
 
    private void authenticateUser(){
        System.out.print("\nMasukkan Pasword E-Money Anda : ");
        int accountNumber = keypad.getInput();
        System.out.print("\nMasukkan PIN : ");
        int pin = keypad.getInput();
       
       
        userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);
       
       
        if(userAuthenticated){
            currentAccountNumber = accountNumber;  
        }
        else{
            System.out.println("\n E-Money atau PIN salah.");
            System.out.println("Silahkan coba lagi.\n");
        }
    }
   
    private void performTransactions(){
        int a=0;
        Transaksi currentTransaction = null;
        boolean userExited = false;  
       
         currentTransaction = createTransaction(1);
                   
         currentTransaction.execute();
         currentTransaction = createTransaction(2);
                   
         currentTransaction.execute();
       
        while(!userExited){
           
            int mainMenuSelection = displayMainMenu();
           
            switch(mainMenuSelection){
                case 1 :
                 
                    currentTransaction = createTransaction(1);
                   
                    currentTransaction.execute();
                    currentTransaction = createTransaction(2);
                   
                    currentTransaction.execute();
                    break;
               
                case 2 :
               
                    System.out.println("\nKeluar...\n");
                    userExited = true;    
                    break;
                   
                default :
               
                    System.out.println("\nInput Salah.");
                    System.out.println("Silahkan Coba lagi.");
                    break;
            }  
        }
    }  
   
    private int displayMainMenu(){
        System.out.println("\n\nLanjut Pembelian? :");
        System.out.println("1. Lanjut");
        System.out.println("2. Keluar");
        System.out.print("Pilihan : ");
        return keypad.getInput();
    }
   
   
    private Transaksi createTransaction(int type){
        Transaksi temp = null;      
       
     
        switch(type){
            case CekSaldo :
           
                temp = new Saldo(currentAccountNumber, screen, bankDatabase);
                break;
            case MengambilMinuman :
           
                temp = new Minuman(currentAccountNumber, screen, bankDatabase, keypad, CekStok);
                break;    
        }
        return temp;  
    }  
}
