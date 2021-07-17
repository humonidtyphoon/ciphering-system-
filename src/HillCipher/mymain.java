package HillCipher;

public class mymain {
  
	public static void main(String[] args) {
                    HillDecrypt x = new HillDecrypt();
                    x.Decrypt("Poh" , "gyBNQKURP");
		
		System.out.println(x.getdecryptedText());
                
                HillEncrypt k = new HillEncrypt();
		k.Encrypt("Poh" , "gyBNQKURP");
		
		System.out.println(k.getencryptedText());

	}

}
