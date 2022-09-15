/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class CekStok {
    private int count[]={0, 2, 2, 2, 2, 2, 2, 2}; 
 
    public void keluarkanMinuman(int pilihan)
    {
        count[pilihan] -= 1; 
    } 
 
    public boolean stokCukup(int pilihan)
    {
        if ( count[pilihan] > 0 )
            return true;
        else
            return false; 
    } 
} 
    

