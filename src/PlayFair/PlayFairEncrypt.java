/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayFair;

import PlayFair.*;
import Procedures.Encryption;

/**
 *
 * @author Riquelme
 */
public class PlayFairEncrypt extends Encryption{
   // 1- fill the matrix. 
	String key;
	String plaintext;
	char[][] matrix;
	 String result="";
	String matrixchar;
	
  
        @Override
   public String Encrypt(String Okey , String OplainText)
    {
	   
      
       String skey = Okey.replaceAll("\\s","");
         String splainText = OplainText.replaceAll("\\s","");
         key = skey.toLowerCase();
         String plainText= splainText.toLowerCase();
       matrix = new char [5][5];
         matrixchar ="";
         key = key+"abcdefghijklmnopqrstuvwxyz";
         //result= new StringBuilder(); 
          plaintext = new String(plainText);
          CreateKey();
          CreateText();

         for(int i=0;i<plaintext.length();i+=2)
          {
              
              char res1,res2;
                int []pos1= findpos(matrix,plaintext.charAt(i));
                int []pos2= findpos(matrix,plaintext.charAt(i+1));
               
                if(pos1[0]==pos2[0])
                {
                    res1=matrix[pos1[0]][Math.floorMod(pos1[1]+1, 5)];
                    res2=matrix[pos2[0]][Math.floorMod(pos2[1]+1, 5)];
                }
               else if(pos1[1]==pos2[1])
                {
                    res1=matrix[Math.floorMod(pos1[0]+1, 5)][pos1[1]];
                    res2=matrix[Math.floorMod(pos2[0]+1, 5)][pos2[1]];
                }
                else
               {
                   res1=matrix[pos1[0]][pos2[1]];
                   res2=matrix[pos2[0]][pos1[1]];
               }
                    
                    result +=res1;
                    result +=res2;
                
                    
                
                
          }
         
         return result;
    }
  static int[] findpos(char[][] mat ,char c )
          {
            
              for(int i=0;i<5;i++)
              {
                for(int j=0;j<5;j++)
                { 
                    if(mat[i][j]==c)
                        return new int[]{i,j};
                }
               
              
              }
             
                 return null;
          }

public void CreateKey() {

    for(int i=0;i<key.length();i++)
    {
        if( key.charAt(i)!= 'j' && matrixchar.indexOf(key.charAt(i))== -1 )
        {
            matrixchar+=key.charAt(i); 
        }
      
            
    }
     for(int i=0;i<5;i++)
        {
             for(int j=0;j<5;j++)
             {
                 matrix[i][j]+=matrixchar.charAt((i*5)+j);
                
             }
            
        }
     
     
	
}

public void CreateText() {
	  for(int i=0;i<plaintext.length();i+=2)
      {
        if(i<plaintext.length()-1)
        {
            if(plaintext.charAt(i)==plaintext.charAt(i+1))
          {
              if(plaintext.charAt(i)=='x')
              {
                  String temp = plaintext.substring(0,i+1)+'z'+plaintext.substring(i+2);
                  
              }
              else
              {  
                String temp = plaintext.substring(0,i+1)+'x'+plaintext.substring(i+2);  
                //plaintext.insert(i+1,'x');
              }
          }
        }
      }
      
            //System.out.println(plaintext.length());
          if(plaintext.length()%2!=0)
            {
              if(plaintext.charAt(plaintext.length()-1)=='x') 
              {
                    plaintext+="z";
                   
              }
              else
              {
                   plaintext+="x";
                 
              }
             
          }
	
}

public String getencryptedText() {
	
	encryptedText = new String(result);
	return encryptedText;
}
  
}