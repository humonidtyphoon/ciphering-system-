package PlayFair;

import PlayFair.*;
import Procedures.Decryption;

public class PlayFairDecrypt extends Decryption{
	String key;
	String plaintext;
	char[][] matrix;
	String result="";
	String matrixchar;
        @Override
   public String Decrypt(String k,String plainText)
   {
	   k= k.toLowerCase();
	   plainText=plainText.toLowerCase();
	   k = k.replaceAll("\\s","");
	   plainText = plainText.replaceAll("\\s","");
        plaintext = new String(plainText);
        key = k+"abcdefghijklmnopqrstuvwxyz";
        matrixchar="";
       // result =new StringBuilder();
        matrix=new char[5][5];
        CreateKey();
        CreateText();
        for(int i=0;i<plaintext.length();i+=2)
          {
             char res1,res2;
              int pos1[]=findpos(matrix,plaintext.charAt(i));
              int pos2[]=findpos(matrix,plaintext.charAt(i+1));
              
              if(pos1[0]==pos2[0])
              {   
                  res1=matrix[pos1[0]][Math.floorMod(pos1[1]-1, 5)];
                  //System.out.println(Math.floorMod(pos1[1]-1, 5));
                 // System.out.println(res1);
                  res2=matrix[pos2[0]][Math.floorMod(pos2[1]-1, 5)];
                 // System.out.println(Math.floorMod(pos2[1]-1, 5));
                 // System.out.println(res2);
              }
              else if(pos1[1]==pos2[1])
              {
                  res1=matrix[Math.floorMod(pos1[0]-1, 5)][pos1[1]];
                  res2=matrix[Math.floorMod(pos2[0]-1, 5)][pos2[1]];
              }
              else 
              {
                  res1=matrix[pos1[0]][pos2[1]];
                  res2=matrix[pos2[0]][pos1[1]];
                  
              }
             result =  result + res1;
             result =  result + res2;
             //result.append(res2);
          }
    return result;
   }
   static int[] findpos(char mats[][],char c)
   {
      for(int i=0;i<5;i++)
      {
          for(int j=0;j<5;j++)
          {
              if(mats[i][j]==c)
              {
                  return new int[]{i,j};
              }
          }
      }
       
       return null;
   }
@Override
public void CreateKey() {
	 for(int i=0;i<key.length();i++)
     {
         if(key.charAt(i)!= 'j' && matrixchar.indexOf(key.charAt(i))== -1 )
         {
             matrixchar+=key.charAt(i);
         }
     }
     
     for(int i=0;i<5;i++)
     {
  	   for(int j=0;j<5;j++)
         {
             matrix[i][j]+=matrixchar.charAt(i*5+j);
            
         }
        

     }
 
   
	
}
@Override
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
             // plaintext.insert(i+1,'z');
          }
          else{
              String temp = plaintext.substring(0,i+1)+'x'+plaintext.substring(i+2);
              //plaintext.insert(i+1,'x');
          }
      }
      }
  }
   
 if(plaintext.length()%2 != 0)
{
   
        if(plaintext.charAt(plaintext.length()-1)=='x') 
              {
                    plaintext= plaintext + "z";
              }
              else
              {
                  plaintext= plaintext + "x";
                   
              }
   
}
   
	
}

@Override
public String getdecryptedText() {
	decryptedText = new String(result);
	return decryptedText;
}

//    void Encrypt(String key, String word) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    boolean getencryptedText() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
}
