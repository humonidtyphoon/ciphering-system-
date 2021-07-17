package VingereCipher;


import java.util.HashMap;
import java.lang.*;
        
public class tabulaRecta 
{
    private static final int letters = 26;
    private static  HashMap<Character, Integer> table;
 
    
    public tabulaRecta()
    {
        table = new HashMap<>();
        createTable();
    }
    private static void createTable()
    {
        char a = 'A';
        for(int i=0; i<letters; i++, a++)
        {
           table.put(a, i);
           
        }
        
    }
    public char encryptionIntersection(char a, char b)
    {
        
            a = Character.toUpperCase(a);
            b = Character.toUpperCase(b);
            int x = table.get(a);
            int y = table.get(b);
            int z = x + y;
            if(z > 25)
            {
                a = 'A';
                z -= 26;
                return (char)(a+z);
            }
        
            
   
        return ((char)(a+table.get(b)));
    }
    
    public char decryptionIntersection(char a, char b)
    {
        a = Character.toUpperCase(a);
        b = Character.toUpperCase(b);
        int x = table.get(a);
        int y = table.get(b);
        int z = x - y;
        if(z < 0)
        {
            a = 'A';
            z += 26;
            return (char)(a+z);
        }
            
   
        return ((char)(a-table.get(b)));
    }

    
}
