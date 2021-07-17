package Procedures;


public abstract class Encryption
{
	protected String encryptedText="";
         protected String invalidCombination = "Invalid Combination";
        protected String invalidKey = "Invalid key";
	protected abstract void CreateKey();
	protected abstract void CreateText();
	public abstract String Encrypt(String key, String text);
	public String Encrypt()
	{
		return "Invalid";
	}
	public abstract String getencryptedText();

    protected void setEncryptedText(String encryptedText)
    {
        this.encryptedText = encryptedText;
    }

    protected String getEncryptedText() 
    {
        return encryptedText;
    }
        
        
}
