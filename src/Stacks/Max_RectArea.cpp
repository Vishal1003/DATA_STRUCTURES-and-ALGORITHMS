#include<bits/stdc++.h>
using namespace std;
int largestrect(int h[],int n)
{
stack<int>s;
    int res=0;
    int tp=0;
    for(int i=0;i<n;i++)
    {
        while(s.size()>0 && h[s.top()]>=h[i])
        {
            tp=s.top();
            s.pop();
            int curr =h[tp]*(s.empty()? i:(i-s.top()-1));
            res = max(res,curr);
        }
        s.push(i);
    }
    while(s.size()>0)
    {
        tp=s.top();
        s.pop();
        int curr =h[tp]*(s.empty()? n:(n-s.top()-1));
            res = max(res,curr);
    }
return res;

}
int main()
{
        int t;
        cin>>t;
        while(t--)
        {
        int n;
        cin>>n;
        int arr[n];
        for(int i=0;i<n;i++)
        {
            cin>>arr[i];
        }
        cout<<largestrect(arr,n)<<endl;
        }
    return 0;
}
