package Procedures;


public abstract class Decryption {
	protected String decryptedText="";
    protected String invalidCombination = "Invalid Combination";
    protected String invalidKey = "Invalid key";
	protected abstract void CreateKey();
	protected abstract void CreateText();
	public abstract String Decrypt(String text, String key);
	public String Decrypt()
	{
		return "Invalid";
	}
	public abstract String getdecryptedText();

    protected void setDecryptedText(String decryptedText) {
        this.decryptedText = decryptedText;
    }

    protected String getDecryptedText() {
        return decryptedText;
    }
        
        
}
