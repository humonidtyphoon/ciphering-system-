package Caeser;

import Procedures.Decryption;

public class caeserDecrypt extends Decryption{

	String Dinput;
	public String Dshift;
	
	int key;
	public String Decrypt(String text, String k) {
		Dshift = k;
		Dinput = text;
		CreateKey();
		CreateText();
		for (int i = 0; i < Dinput.length(); i++) {
			if (Dinput.charAt(i) == ' ') {
				decryptedText += " ";
				continue;
			}
			if (Dinput.charAt(i) >= 97 && Dinput.charAt(i) <= 122) {
				if (Dinput.charAt(i) - key >= 97 && Dinput.charAt(i) - key <= 122) {
					decryptedText += (char) (Dinput.charAt(i) - key);
				} else {
					decryptedText += (char) (122 - ((Math.abs(Dinput.charAt(i) - 97 - key)) % 26));
				}
			} else if (Dinput.charAt(i) >= 65 && Dinput.charAt(i) <= 90) {
				if (Dinput.charAt(i) - key >= 65 && Dinput.charAt(i) <= 90) {
					decryptedText += (char) (Dinput.charAt(i) - key);
				} else {
					decryptedText += (char) (90 - ((Math.abs(Dinput.charAt(i) - 65 - key)) % 26));
				}
			}

		}
                        return decryptedText;
	}

	@Override
		public void CreateKey() {
            if (Dshift.matches("[a-zA-Z]")){   
             int  pos =  (char) Dshift.charAt(0) - 'a';
             key = pos;
            }
                }
        @Override
	 public void CreateText() {
		Dinput.toLowerCase(); 
		
	}

	

	
        @Override
	public String getdecryptedText() {
		return decryptedText;
	}

}
