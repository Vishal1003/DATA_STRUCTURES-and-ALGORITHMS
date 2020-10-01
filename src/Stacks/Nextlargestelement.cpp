#include <bits/stdc++.h>
using namespace std;
void Nextlargest(long long int arr[],long long int n)
{
    vector<long long int> v;
    stack<long long int> s;
    for(int i=n-1;i>=0;i--)    //for nearest gretatest from left for(int i =0;i<n;i++)
    {
        if(s.size()==0)
            v.push_back(-1);
        else if(s.size()>0 && s.top()>arr[i])
            v.push_back(s.top());
        else if(s.size()>0 && s.top()<arr[i])
        {
            while(s.size()>0 && s.top()<=arr[i])
                s.pop();
            if(s.size()==0)
                v.push_back(-1);
            else
            {
                v.push_back(s.top());
            }
        }
        s.push(arr[i]);
            
    }
    reverse(v.begin(),v.end());   //no need to reverse in casew of nearest greatesfrom left to right
    for(int i=0;i<v.size();i++)
        cout<<v[i]<<" ";
    

}


int main() {
	long long int t;
	cin>>t;
	while(t--)
	{
	    long long int n;
	    cin>>n;
	    long long int arr[n];
	    for(long long int i=0;i<n;i++)
	       { cin>>arr[i]; }
	    Nextlargest(arr,n);
	    cout<<endl;
	   
	}
	return 0;
}
