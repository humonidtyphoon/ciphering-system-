package railFence;


public class railFenceMain {
	public static void main(String[] args) {
		railFenceEncrypt s=new railFenceEncrypt();
		System.out.println(s.Encrypt("3","OMARHISHAM"));
                //System.out.println(s.getencryptedText());
		railFenceDecrypt m=new railFenceDecrypt();
		System.out.println(m.Decrypt("OHAMRIHMAS","3"));
		
	}

}
