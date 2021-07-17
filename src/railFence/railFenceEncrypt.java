package railFence;

import Procedures.Encryption;

public class railFenceEncrypt extends Encryption{
	private int row, col ;
	private String key,text;
	private char[][] rail=new char[100][100];
	private boolean dirDown ;

	public void CreateKey()
	{
		row=Integer.parseInt(key);
		col=text.length();
	}
	public void CreateText()
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				rail[i][j]='\n';
			}
		}
		dirDown=false;
		int Row = 0 , Column=0;  
		for (int i=0;i<col;i++)
		{
			if(Row==0 || Row==row-1)
			{
				dirDown=!dirDown;
			}

			rail[Row][Column++]=text.charAt(i);
			if(dirDown)
			{
				Row++;
			}
			else {
				Row--; 
			}
		}
	}
	public String Encrypt(String text,String key)
	{
		this.key=key;
		this.text=text;
		CreateKey();
		CreateText();
		//System.out.println("TEXT ENCRYPTED SUCCESSFULLY:"+getencryptedText());
                for(int i=0;i<row;i++)
		{
			for(int j=0; j<col;j++)
			{
				if(rail[i][j]!='\n')
				{
					encryptedText+=rail[i][j];
				}
			}
		}
		return encryptedText;
	}
	public String getencryptedText()
	{	
		
		return encryptedText;
	}
}

