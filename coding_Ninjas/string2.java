package coding_Ninjas;

public class string2 {

	public static void main(String[] args) {
		String s = "#abc#de#";
		System.out.println(ans(s));

	}
	
	
	public static String ans(String s) {
		
		
		 for(int i = s.length()-1 ; i>=0; i--){
             
             if(s.charAt(i) == '#'){
                 
                 if(i == s.length()-1)
                     s = s.substring(0, s.length()-1);
                 else if(i==0)
                     s = s.substring(1);
                 
                 else
                     s= s.substring(0,i-1)+ s.substring(i+1);
                
             }
             
         }
         
         return s;
         
	}

}
