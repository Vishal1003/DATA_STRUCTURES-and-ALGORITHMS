#include <iostream>
#include <string>
using namespace std;

struct act
{
   int s;
   int e;
};

class person{
 public:
 char name;
 int n;
 struct act acts[1000];
 
 person(char _name){
  name = _name;
  n = 0;
 }
 
 void addact(act a){
  acts[n] = a;
  n++;
 }
 
 bool isBusy(act a){
  for(int i = 0; i<n; i++){
   if(a.s < acts[i].e && acts[i].s < a.e) return true;
  }
  return false;
 }
};


int main() {
 int t, n;
 
 cin >> t;

 
 for(int c = 0; c < t; c++){
  
  person cameron('C');
  person jamie('J');
  cin >> n;
  struct act allacts[1000];
  
  bool flag = false;
  string str = "";
  
  for(int i = 0; i < n; i++){
   cin >> allacts[i].s >> allacts[i].e;
  }
  
  for(int i = 0; i < n; i++){
   if(cameron.isBusy(allacts[i]) && jamie.isBusy(allacts[i])){
    flag = true;
   }else if(!cameron.isBusy(allacts[i])){
    str += 'C';
    cameron.addact(allacts[i]);
   }else{
    str += 'J';
    jamie.addact(allacts[i]);
   }
   
  
  }
  
  if(flag) cout << "Case #" << c+1 << ": IMPOSSIBLE"  << endl;
  else cout << "Case #" << c+1 << ": " + str << endl;
  
 }
 
 return 0;
}