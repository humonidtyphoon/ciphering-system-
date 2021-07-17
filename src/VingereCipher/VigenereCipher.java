package VingereCipher;

//import ui.AutoKeyEncrypt;
//import ui.AutokeyDecrypt;
//import Procedures.RepeatedKeyDecrypt;
//import Procedures.RepeatedKeyEncrypt;
import java.util.Scanner;

/**
 *
 * @author Ahmed Ayman
 */
public class VigenereCipher {

  
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        
        AutoKeyEncrypt a = new AutoKeyEncrypt();
        RepeatedKeyEncrypt r = new RepeatedKeyEncrypt();
        AutokeyDecrypt ad = new AutokeyDecrypt();
        RepeatedKeyDecrypt rd = new RepeatedKeyDecrypt();
        
        
        String msg;
        String key;
        String res = null;
        
        System.out.println("1.Encrypt with Repeated key.\t2.Decrypt with Vigenere Repeated key.\n"
                + "3.Encrypt with Vigenere Auto key.\t4.Decrypt with Vigenere Auto key.\t5.Exit.");
        
        int choose = in.nextInt();
        in.nextLine();
        while(choose != 5)
        {
            switch (choose)
            {
                case 1: 
                        System.out.println("Encrypt with Repeated key\nEnter the msg:\t");
                        msg = in.nextLine();
                        System.out.println("Enter the key:\t");
                        key = in.nextLine();
                        res = r.Encrypt(msg, key);
                        break;
                case 2:
                        System.out.print("Decrypt with Repeated key\nEnter the ciphertext:\t\n");
                        msg = in.nextLine();
                        System.out.print("Enter the key:\t\n");
                        key = in.nextLine();
                        res = rd.Decrypt(msg, key);
                        break;
                case 3:
                        System.out.println("Encrypt with Auto key\nEnter the msg:\t");
                        msg = in.nextLine();
                        System.out.println("Enter the key:\t");
                        key = in.nextLine();
                        res = a.Encrypt(msg, key);
                        break;
                case 4:
                        System.out.println("Decrypt with Auto key\nEnter the ciphertext:\t");
                        msg = in.nextLine();
                        System.out.println("Enter the key:\t");
                        key = in.nextLine();
                        res = ad.Decrypt(msg, key);
                        //res = ad.getdecryptedText();
                        break;
                default:
                        System.out.println("Invalid Choice");
            }
            
            
            if(!res.equals("-1"))
                System.out.println("Result:\t" + res);
            else
                System.out.print("INVALID KEY");
            
            System.out.println("\n\n1.Encrypt with Repeated key.\t2.Decrypt with Vigenere Repeated key.\n"
                + "3.Encrypt with Vigenere Auto key.\t4.Decrypt with Vigenere Auto key.\t5.Exit.");
             
             choose = in.nextInt();
             in.nextLine();
        }
        
    }
    
}
