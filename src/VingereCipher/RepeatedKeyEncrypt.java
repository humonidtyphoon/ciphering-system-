package VingereCipher;


public class RepeatedKeyEncrypt extends VigenereEncryption
{
    protected  boolean valid = true;
    
    @Override
    protected void CreateKey()
    {
        valid = true;
        String key = getKey();
        String msg = getMsg();
        
        for(int j=0; j<key.length(); j++)
        {
            
   
            if(key.charAt(j) > 122 || key.charAt(j) < 65 || key.charAt(j) == ' ' ||
                        (key.charAt(j) > 90 && key.charAt(j) < 97))
                {
                        valid = false;
                        setValidKey(valid);
                        return;
                }
        }
        setValidKey(valid);
        
        
        key = key.toUpperCase();
        
        
        while(key.length() < msg.length())
        {
            key += key;
        }
        
        setKey(key);
    }

   
   
    
}
