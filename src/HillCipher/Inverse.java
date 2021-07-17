package HillCipher;

public class Inverse {
	
	static int N = 3; 
	  
	
	static void getCofactor(float[][] a, float[][] temp, int p, int q, int n) 
	{ 
	    int i = 0, j = 0; 
	  
	   
	    for (int row = 0; row < n; row++) 
	    { 
	        for (int col = 0; col < n; col++) 
	        { 
	            
	            if (row != p && col != q) 
	            { 
	                temp[i][j++] = a[row][col]; 
	  
	                
	                if (j == n - 1) 
	                { 
	                    j = 0; 
	                    i++; 
	                } 
	            } 
	        } 
	    } 
	} 
	
	static float determinant(float[][] a, int n) 
	{ 
	    int D = 0; 
	  
	  
	    if (n == 1) 
	        return a[0][0]; 
	  
	    float [][]temp = new float[n][n]; 
	    int sign = 1;  
	  
	  
	    for (int f = 0; f < n; f++) 
	    { 
	       
	        getCofactor(a, temp, 0, f, n); 
	        D += sign * a[0][f] * determinant(temp, n - 1); 
	  
	        
	        sign = -sign; 
	    } 
	  
	    return D; 
	} 
	  
	
	static void adjoint(float A[][],float[][] adj) 
	{ 
		N = A.length;
	    if (N == 1) 
	    { 
	        adj[0][0] = 1; 
	        return; 
	    } 
	  

	    int sign = 1; 
	    float [][]temp = new float[N][N]; 
	  
	    for (int i = 0; i < N; i++) 
	    { 
	        for (int j = 0; j < N; j++) 
	        { 
	         
	            getCofactor(A, temp, i, j, N); 
	  
	        
	            sign = ((i + j) % 2 == 0)? 1: -1; 
	  
	  
	            adj[j][i] = (sign)*(determinant(temp, N-1)); 
	        } 
	    } 
	} 
	  

	boolean inverse(float[][] a, float[][] keyMatrix) 
	{ 
	   
	    float det = determinant(a, N); 
	    if (det == 0) 
	    { 
	        System.out.print("Singular matrix, can't find its inverse"); 
	        return false; 
	    } 
	  
	  
	    float [][]adj = new float[N][N]; 
	    adjoint(a, adj); 
	  
	 
	    for (int i = 0; i < N; i++) 
	        for (int j = 0; j < N; j++) 
	            keyMatrix[i][j] = adj[i][j]/(int)det; 
	  
	    return true; 
	} 
}

