#include <iostream>
using namespace std;

int main() {
	int t;
	cin>>t;
	while(t--)
	{
	    int n;
	    cin>>n;
	    int length[n];
	    int p[n];
	    for(int i=0;i<n;i++)
	    {
	        length[i]=i+1;
	    }
	    for(int i=0;i<n;i++)
	    {
	        cin>>p[i];
	    }
	    int T[n+1][n+1];
	    for(int i=0;i<=n;i++)
	    {
	        T[i][0]=0;
	    }
	    for(int i=0;i<=n;i++)
	    {
	        T[0][i]=0;
	    }
	    for(int i=1;i<=n;i++)
	    {
	        for(int j=1;j<=n;j++)
	        {
	            if(length[i-1]<=j)
	            {
	                T[i][j] = max(p[i-1]+T[i][j-length[i-1]],T[i-1][j]);
	            }
	            else
	            {
	                T[i][j] = T[i-1][j];
	            }
	        }
	    }
	    cout<<T[n][n]<<endl;
	    
	}
	return 0;
}
