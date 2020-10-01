#include <bits/stdc++.h>
using namespace std;
int T[1001][1001];
int knapsack(int wt[],int val[],int w,int n)
{
    
    if(n==0 || w==0)
        {return 0;}
    if(T[n][w]!=-1)
    {
        return T[n][w];
    }
    if(wt[n-1]<=w)
    {
        return T[n][w] = max(val[n-1]+knapsack(wt,val,w-wt[n-1],n-1),knapsack(wt,val,w,n-1));
    }
    else
    {
        return T[n][w] = knapsack(wt,val,w,n-1);
    }
}

int main() {
	int t;
	cin>>t;
	while(t--)
	{
	    memset(T,-1,sizeof(T));
	    int n;
	    cin>>n;
	    int w;
	    cin>>w;
	    int wt[n]={0};
	    int v[n]={0};
	    for(int i=0;i<n;i++)
	    {
	        cin>>v[i];
	    }
	     for(int i=0;i<n;i++)
	    {
	        cin>>wt[i];
	    }
	    cout<<knapsack(wt,v,w,n)<<endl;
	}
	return 0;
}
