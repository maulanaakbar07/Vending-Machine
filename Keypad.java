/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
import java.util.Scanner;
public class Keypad {
     private Scanner input;
    public Keypad()
    {
        input = new Scanner( System.in );
    }
    public int getInput()
    {
        return input.nextInt();
    }
}
    

