
package PlayFair;


import java.util.Scanner;


public class NewMain {

 
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
      
        System.out.println("....PlayFair Algoritm.....");
         System.out.print("Enter the key : ");
         String key=input.nextLine();
         System.out.print("Enter the word : ");
         String word=input.nextLine();
         PlayFairDecrypt a = new PlayFairDecrypt();
         PlayFairEncrypt b = new PlayFairEncrypt();
         a.Decrypt(key,word);
         System.out.println(a.getdecryptedText());
         b.Encrypt(key, word);
         System.out.println(b.getencryptedText());

    }
}
