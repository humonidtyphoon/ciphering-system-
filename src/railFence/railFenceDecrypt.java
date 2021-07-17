package railFence;

import Procedures.Decryption;

public class railFenceDecrypt extends Decryption {
	private int row, col ;
	private String key,text;
	private char[][] rail=new char[100][100];
	private boolean dirDown ;
	@Override
	public void CreateKey() {
		row=Integer.parseInt(key);
		col=text.length();
		
	}
	@Override
	public void CreateText() {
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				rail[i][j]='\n';
			}
		}
		dirDown=false;
		int Row=0,Column=0;
		for(int i=0;i<col;i++)
		{
			if(Row==0)
			{
				dirDown=true;
			}
			if(Row==row-1)
			{
				dirDown=false;
			}
			rail[Row][Column]='*';
			Column++;
			if(dirDown)
			{
				Row++;
			}
			else 
			{
				Row--;
				
			}
		}
		int index=0;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(rail[i][j]=='*' && index<col)
				{
					rail[i][j]=text.charAt(index);
					index++;
				}
			}
		}
		
	}
	
	public String Decrypt(String text, String key) {
		this.text=text;
		this.key=key;
		CreateKey();
		CreateText();
		//System.out.println("CIPHER DECRYPTED SUCCESSFULLY:"+getdecryptedText());
                int Row=0;int Column=0;
		for(int i=0;i<col;i++)
		{
			if(Row==0)
			{
				dirDown=true;
			}
			//row=key
			if(Row==row-1)
			{
				dirDown=false;
			}
			if(rail[Row][Column]!='*')
			{
				decryptedText+=rail[Row][Column];
				Column++;
			}
			if(dirDown)
			{
				Row++;
			}
			else {
				Row--;
			}
		}
		return decryptedText;
	}
	public String getdecryptedText() {
		
		return decryptedText;
	}
	
	
	
}
