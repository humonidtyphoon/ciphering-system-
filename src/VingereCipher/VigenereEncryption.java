package VingereCipher;

import Procedures.Encryption;

 public class VigenereEncryption extends Encryption
{
    
    private String msg;
    private String key;
    private int msgLen;
    private int keyLen;
    String EncryptedMsg;
    private boolean validKey;
    public tabulaRecta table;
    
    protected void CreateKey()
    {
        //override in the child
    }
    
    public VigenereEncryption()
    {
        table = new tabulaRecta();
    }
    
    @Override
    protected void CreateText()
    {
       
        this.msg = this.msg.toUpperCase();
        
        //System.out.println("msg.toUpperCase: " + msg);
    }
    @Override
    public String Encrypt(String msg, String key)
    {
        
        
        this.key = key;
        this.msg = msg;
        msgLen = msg.length();
        keyLen = key.length();
        
        
        CreateText();
        CreateKey();
        if(!validKey)
        {
            EncryptedMsg = "-1";
            
        }
        else
        {
        
            EncryptedMsg = "";

            int j = 0;


            for(int i=0; i<msgLen; i++)
            {
                if(this.msg.charAt(i) > 122 || this.msg.charAt(i) < 65 || this.msg.charAt(i) == ' ' ||
                        (this.msg.charAt(i) > 90 && this.msg.charAt(i) < 97))
                {
                    EncryptedMsg += this.msg.charAt(i);
                    continue;
                }
                EncryptedMsg += table.encryptionIntersection(this.msg.charAt(i), this.key.charAt(j));
                j++;
            }
            
        }
        setEncryptedText(EncryptedMsg);
        return EncryptedMsg;
        
    }
    
    public String getencryptedText()
    {
        return (getEncryptedText());
    }
    protected String getKey()
    {
        return key;
    }

    protected void setKey(String key)
    {
        this.key = key;
    }

    protected String getMsg() 
    {
        return msg;
    }

    public void setValidKey(boolean validKey)
    {
        this.validKey = validKey;
    }

   

   

    
    
    
    
    
}
