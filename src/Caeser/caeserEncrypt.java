package Caeser;

import Procedures.Encryption;

public class caeserEncrypt extends Encryption {
	public String Einput;
	public String Eshift;
	
	int key;
	public String Encrypt(String text, String k) {
		Eshift = k;
		Einput = text;
		CreateKey();
		CreateText();
		
		for (int i = 0; i < Einput.length(); i++) {
			if (Einput.charAt(i) == ' ') {
				encryptedText += " ";
				continue;
			}
		
		
			if (Einput.charAt(i) >= 97 && Einput.charAt(i) <= 122) {
				encryptedText += (char) (97 + ((Einput.charAt(i) - 97 + key) % 26));
			} else if (Einput.charAt(i) >= 65 && Einput.charAt(i) <= 90) {
				encryptedText += (char) (65 + ((Einput.charAt(i) - 65 + key) % 26));
			}
		}
                    return encryptedText;
	}

	@Override
	public void CreateKey() {
	 if (Eshift.matches("[a-zA-Z]")){   
             int  pos =  (char) Eshift.charAt(0) - 'a';
             key = pos;
            }
            else {
                key = Integer.parseInt(Eshift);	
            }
        }
	@Override
	public void CreateText() {
		Einput.toLowerCase();
		
	}

	

	@Override
	public String getencryptedText() {
		return encryptedText;
	}

}