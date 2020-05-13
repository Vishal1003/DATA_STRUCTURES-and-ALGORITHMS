package codesulApril;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IndexOutOfBoundsException {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0) {
		String str = s.next();
		char arr1[] = str.toCharArray();
		String rtr = s.next();
		char arr2[] = rtr.toCharArray();
		int n = str.length();
        long l = 0, k= 0,gl = 0;
        ArrayList<Long> al = new ArrayList<>();
        boolean flag = false;
        if(n==1) {
        	if(arr1[0]==arr2[0])
        		System.out.println("0");
        	else
        		System.out.println("1");
        }
        else {	
        for(int i = 0;i<n;i++) {
        	if(arr1[i]==arr2[i]) {
        		if(flag)
        			gl++;
        	}
        	else {
        		if(!flag)
        		   k++;
        		flag = true;
        		l++;
        		if(gl>0) {
        			k++;
        			al.add(gl);
        		}
        	}
        }
   		Collections.sort(al);
   		long res = k*l;
   		for(int i = 0;i<al.size();i++) {
   		    l += al.get(i);
   		    k = k--;
   		    res = Math.min(res,k*l);
   		}
        
   		System.out.println(res);
	}
		}
}
}
