package VingereCipher;

import Procedures.Decryption;

 public class VigenereDecryption extends Decryption
{
    private String cipher;
    private String key;
    private int cipherLen;
    private int keyLen;
    private boolean validKey;
    public tabulaRecta table;
    
    protected void CreateKey()
    {
        //override in thechild
    }
    
    public VigenereDecryption()
    {
        table = new tabulaRecta();
    }
    
    @Override
    protected void CreateText()
    {
        
        this.cipher = this.cipher.toUpperCase();
        
        //System.out.println("cipher.toUpperCase: " + cipher);
    }
    
    private void completeKey(char letter)
    {
        this.key += letter;
    }
    
    @Override
    public String Decrypt(String cipher, String key)
    {
        this.cipher = cipher;
        this.key = key;
        cipherLen = this.cipher.length();
        this.keyLen = this.key.length();
        
        CreateText();
        CreateKey();
        
        String decryptedMsg;
        decryptedMsg = "";
        
        if(!validKey)
        {
            decryptedMsg = "-1";
            
        }
        else
        {
            int j =0;
            for(int i=0; i<cipherLen; i++)
            {

                if(this.cipher.charAt(i) > 122 || this.cipher.charAt(i) < 65 || this.cipher.charAt(i) == ' ' || 
                        (this.cipher.charAt(i) > 90 && this.cipher.charAt(i) < 97))
                {
                    decryptedMsg += this.cipher.charAt(i);
                    continue;
                }
                decryptedMsg += table.decryptionIntersection(this.cipher.charAt(i), this.key.charAt(j));
                completeKey(decryptedMsg.charAt(i));
                j++;

            }
        }
        setDecryptedText(decryptedMsg);
        return decryptedMsg;
    }
    
    
    protected String getKey()
    {
        return key;
    }

    protected void setKey(String key)
    {
        this.key = key;
    }

    public String getCipher() 
    {
        return cipher;
    }
    
    public void setValidKey(boolean validKey)
    {
        this.validKey = validKey;
    }

    @Override
    public String getdecryptedText() 
    {
        return getDecryptedText();
    }
    
    
    
}
