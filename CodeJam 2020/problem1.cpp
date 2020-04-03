#include <bits/stdc++.h>


using namespace std;

int main() {
 int tests;
 cin >> tests;
 for (int x = 1; x <= tests; x++) {
  int k = 0, r = 0, c = 0;
  int n;
  cin >> n;
  vector<vector<int>> arr(n, vector<int>(n));
   bool rdone = false;
  set<int> row;  
  for (int i = 0; i < n; i++) {
   row.clear();
   rdone = false;
   for (int j = 0; j < n; j++) {
    int value;
    cin >> value;
    arr[i][j] = value;
    if (i == j) {
     k += value;
    }
    if (!rdone && row.count(value) == 1) {
     r++;
     rdone = true;
    }
    else {
     row.insert(value);
    }
   }
  }

  set<int> column; bool cdone = false;
  for (int i = 0; i < n; i++) {
   column.clear();
   cdone = false;
   for (int j = 0; j < n; j++) {
    if (!cdone && column.count(arr[j][i]) == 1) {
     c++;
     cdone = true;
    }
    else
     column.insert(arr[j][i]);
   }
  }
  cout << "Case #" << x << ": " << k << " " << r << " " << c << "\n";
 }
 return 0;
}