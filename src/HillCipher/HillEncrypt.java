package HillCipher;

import Procedures.Encryption;

public class HillEncrypt extends Encryption{
	private int KeyMatrix[][];
	private int cipherMatrix[][];
	private int encryptedVector[][];
	
	public int[][] getKeyMatrix() {
		return KeyMatrix;
	}
	public void setKeyMatrix(int[][] keyMatrix) {
		KeyMatrix = keyMatrix;
	}
	public int[][] getCipherMatrix() {
		return cipherMatrix;
	}
	public void setCipherMatrix(int[][] cipherMatrix) {
		this.cipherMatrix = cipherMatrix;
	}
	public int[][] getEncryptedVector() {
		return encryptedVector;
	}
	public void setEncryptedVector(int[][] encryptedVector) {
		this.encryptedVector = encryptedVector;
	}

	String key = "";
	String cipher= "";
	int d;
	int sqr;
	public void CreateKey()
	{
		KeyMatrix = new int[sqr][sqr]; 
		 int k = 0; 
		    for (int i = 0; i < sqr; i++)  
		    { 
		        for (int j = 0; j < sqr; j++)  
		        {
		        	if(k<key.length())
		        	{
		        	    if(key.charAt(k) >=65 && key.charAt(k)<= 90)
		        	{
		        	    
		                 KeyMatrix[i][j] = (key.charAt(k)) % 65; 
		                 k++; 
		        	}
		        	else if (key.charAt(k) >=97 && key.charAt(k)<= 122)
		        	{
		        		
			            KeyMatrix[i][j] = (key.charAt(k)) % 97; 
			            k++; 
			        }
		        	}
		        }
		       
		    }
	}
	public void CreateText()
	{
		int k=0;
		cipherMatrix = new int[sqr][d];
		 for (int i = 0; i < d; i++) 
		 {
			 for(int j=0; j<sqr; j++)
			 {
				 if(cipher.charAt(k) >=65 && cipher.charAt(k)<= 90)
		        	{
		        	    
					 cipherMatrix[j][i] = (cipher.charAt(k)) % 65; 
		                 k++; 
		        	}
		        	else if (cipher.charAt(k) >=97 && cipher.charAt(k)<= 122)
		        	{
		        		
		        		cipherMatrix[j][i] = (cipher.charAt(k)) % 97; 
			            k++; 
			           
			        }
				 
			 }
			
		 }
		
	}
	
	

    public boolean checkPerfectSquare(double x)  
    { 

	
	double sq = Math.sqrt(x); 
	return ((sq - Math.floor(sq)) == 0); 
	
    } 
	public void setencryptedvector()
	{
		encryptedVector = new int[sqr][d];
		 for (int i = 0; i < d; i++)  
		    { 
		        for (int j = 0; j < sqr; j++) 
		        { 
		        	encryptedVector[j][i] = 0; 
		          
		            for (int x = 0; x < sqr; x++) 
		            { 
		            	encryptedVector[j][i] +=  KeyMatrix[j][x] * cipherMatrix[x][i]; 
		            	
		            } 
		            
		            encryptedVector[j][i] = encryptedVector[j][i] % 26;
		           
		        } 
		    } 
		
		 for (int i = 0; i < d; i++) 
		 {
			 for(int j=0; j<sqr; j++)
			 {
			 encryptedText += (char)(encryptedVector[j][i] + 65);
			 }
		 }
	}
	public String Encrypt(String c,String k)
	{
		key=k;
		cipher=c;
		if(checkPerfectSquare(key.length()))
		{
			int sqroot = (int) Math.sqrt(key.length());
			if(cipher.length() % sqroot  == 0)
			{
				sqr=sqroot;
				d=cipher.length() / sqr;
				CreateKey();
				CreateText();
				setencryptedvector();
                                return encryptedText;
			}
			else
			{
				return invalidCombination;
			}
		}
		else
		{
			return invalidKey;
		}
		
    }
	
	public String getencryptedText() {
		return encryptedText;
		
	}



}
