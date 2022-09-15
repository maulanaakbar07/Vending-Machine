/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Minuman extends Transaksi{
     private int amount;
    private Keypad keypad;
    private CekStok CekStok;
    int input;
   
    private final static int CANCELED = 8;
   
    public Minuman(int userAccountNumber, Screen usrScreen, Database_KartuPintar atmBankDatabase, Keypad usrKeypad, CekStok stokminuman){
        super(userAccountNumber, usrScreen, atmBankDatabase);
       
        keypad = usrKeypad;
        CekStok = stokminuman;
    }
   
    @Override
    public void execute()
    {
        boolean minumanKeluar = false;
        double saldo;
       
        Database_KartuPintar bankDatabase = getBankDatabase();
        Screen screen = getScreen();
       
        do{
            amount = displayMenuOfAmounts();
           
            if(amount != CANCELED){
                saldo = Database_KartuPintar.getSaldo(getAccountNumber());
               
                if(amount <= saldo){
                    if(CekStok.stokCukup(input)){
                       
                        Database_KartuPintar.beli(getAccountNumber(), amount);
                       
                        CekStok.keluarkanMinuman(input);
                        minumanKeluar = true;
                        System.out.println("\nTransaksi sukses. Silahkan Ambil minuman anda.");
                    }
                    else
                    {
                        System.out.println("\nMaaf, minuman pilihan anda habis.");
                    }
                }
                else
                {
                     System.out.println("\nMaaf, saldo anda tidak cukup.");
                }
            }
            else{
                System.out.println("\nMembatalkan Transaksi...");
                return;
            }
        }   while(!minumanKeluar);
    }
   
    private int displayMenuOfAmounts(){
        int harga = 0;
       
        Screen screen = getScreen();
       
        int[] amounts = {0, 12000, 6000, 7000, 2000, 8000, 5000, 8000};
       
        while(harga == 0){
            System.out.println("\n\nDaftar Minuman : ");
            System.out.println("1 - Bear Brand Rp 12000,00");
            System.out.println("2 - Mizone Rp 6000,00");
            System.out.println("3 - Adem Sari Chingku Rp 7000,00");
            System.out.println("4 - Aqua Rp 2000,00");
            System.out.println("5 - Buavita Rp 8000,00");
            System.out.println("6 - Cola Cola Rp 5000,00");
            System.out.println("7 - Sprite Rp 8000,00");
            System.out.println("8 - Batalkan Pembelian");
            System.out.print("\nPilih Minuman Anda : ");
           
            input = keypad.getInput();
           
 
            switch(input){
                case 1 :
                case 2 :
                case 3 :
                case 4 :
                case 5 :
                case 6 :
                case 7 :
                    harga = amounts[input];
                    break;
               
                case 8 :
                    harga = CANCELED;
                    break;
               
                default :
                    System.out.println("\nInput Salah");
                    System.out.println("Silahkan Coba lagi");
            }
        }
       
        return harga;
    }
}
    

