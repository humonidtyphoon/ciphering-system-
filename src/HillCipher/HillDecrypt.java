package HillCipher;

import Procedures.Decryption;

public class HillDecrypt extends Decryption {
	public float KeyMatrix[][];
	
	private float cipherMatrix[][];
	private float decryptedVector[][];
	int sqr;
	int n;
	String key = "";
	String cipher ="";
        
        
	 public float[][] getCipherMatrix() {
		return cipherMatrix;
	}



	public void setCipherMatrix(float[][] cipherMatrix) {
		this.cipherMatrix = cipherMatrix;
	}



	public float[][] getDecryptedVector() {
		return decryptedVector;
	}



	public void setDecryptedVector(float[][] decryptedVector) {
		this.decryptedVector = decryptedVector;
	}



	public boolean checkPerfectSquare(double x)  
	    {
		double sq = Math.sqrt(x); 
		return ((sq - Math.floor(sq)) == 0); 
	    }
	
	  
	
	public void setdecryptedvector()
	{
		decryptedVector = new float[sqr][n];
		 for (int i = 0; i < n; i++)  
		    { 
		        for (int j = 0; j < sqr; j++) 
		        { 
		        	decryptedVector[j][i] = 0; 
		          
		            for (int x = 0; x < sqr; x++) 
		            { 
		            	decryptedVector[j][i] += KeyMatrix[j][x] * cipherMatrix[x][i]; 
		            	
		            } 
		            
		            decryptedVector[j][i] = (int) decryptedVector[j][i] % 26;
		           if(decryptedVector[j][i] <0)
		        	   decryptedVector[j][i] = (26 - Math.abs(decryptedVector[j][i]));
		        } 
		    } 
		
		 for (int i = 0; i < n; i++) 
		 {
			 for(int j=0; j<sqr; j++)
			 {
				 //System.out.print(decryptedVector[j][i] + "k"); 
			 decryptedText += (char)(decryptedVector[j][i] + 65);
			 }
			 //System.out.print(" "); 
		 }
	}
	
	
	public String Decrypt(String c,String k)
	{
	   
		key =k ;
		cipher = c;
		
		if(checkPerfectSquare(key.length()))
		{
			sqr = (int) Math.sqrt(key.length());
			if(cipher.length() % sqr  == 0)
			{
				n=cipher.length() / sqr;
				CreateKey();
				CreateText();
				setdecryptedvector();
				return decryptedText;
				
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
	@Override
	public void CreateKey() {
		 float[][] a = new float[sqr][sqr]; 
			KeyMatrix =  new float[sqr][sqr]; 
			
			 int k = 0; 
			    for (int i = 0; i < sqr; i++)  
			    { 
			        for (int j = 0; j < sqr; j++)  
			        {
			        	if(k<key.length())
			        	{
			        	    if(key.charAt(k) >=65 && key.charAt(k)<= 90)
			        	{
			        	    
			                 a[i][j] = (key.charAt(k)) % 65; 
			                 k++; 
			        	}
			        	else if (key.charAt(k) >=97 && key.charAt(k)<= 122)
			        	{
			        		
				            a[i][j] = (key.charAt(k)) % 97; 
				            k++; 
				        }
			        	}
			        
			        }
			       
			    }
			   
			    
			    Inverse m = new Inverse();
			     float det = m.determinant(a, sqr) % 26;
			     m.adjoint(a, KeyMatrix);
			   if (det==0)
			   {
				   System.out.print("invalid key");
			   }
			   else
			   {
			           for(int i=0; i<sqr; i++)
			           {
			        	   for(int j=0; j<sqr; j++)
			        	   {
			        		   
			        		   if(KeyMatrix[i][j]>=0)
			        		   {
			        			   KeyMatrix[i][j] =   ((KeyMatrix[i][j] % 26) * det) %26;
			        		
			        		   }
			        		   else
			        		   {
			        			   KeyMatrix[i][j] =   ((26 - (KeyMatrix[i][j] * -1 % 26)) * det) %26;
			        			  
			        		   }
			        		  
			        	   }
			        	 
			           }
			   }
		
	}
	@Override
	public void CreateText() {
		
		int k=0;
		cipherMatrix = new float[sqr][n];
		
		 for (int i = 0; i < n; i++) 
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
		 //System.out.print("here");
		
//		 for (int i = 0; i < n; i++)  
//		    { 
//		        for (int j = 0; j < sqr; j++)  
//		        {
//		        	System.out.print(cipherMatrix[j][i] + " " );
//		        }
//		        System.out.print('\n');
//		    }
		
	}
	@Override
	public String getdecryptedText() {
		return decryptedText;
	} 
	
}
