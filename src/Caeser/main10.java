package Caeser;

public class main10 {

	public static void main(String[] args) {
		   caeserEncrypt enc = new caeserEncrypt();
		          System.out.println(enc.Encrypt("f","abc"));
		   //System.out.println(enc.getencryptedText());
		   caeserDecrypt dec = new caeserDecrypt();
		          System.out.println(dec.Decrypt("g","abc"));
		   //System.out.println(dec.getdecryptedText());
		   

	}

}
