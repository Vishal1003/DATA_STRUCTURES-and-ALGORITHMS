def trace_toldsum(mx,n):
    s=0
    for i in range(n):
        s+=mx[i][i]
    return s
 
def make_matrix(ordersq, l_num):
    rows_c = 0
    ll=[]
    for rows in range(1, ordersq + 1):
        num_req = l_num + (rows - 1)
        if num_req > ordersq:
            num_req = 1 + rows_c
            rows_c += 1
        row_counter = 0
        l=[]
        
        for row in range(1, ordersq + 1):
            l.append(num_req)
            num_req += 1
            if num_req > ordersq:
                num_req = 1 + row_counter
                row_counter += 1
        ll.append(l)

    return ll

 
def main():
     for _ in range(1,int(input())+1):
        ordersq, trace_told=map(int, input().split())
        flag=False
        for i in range(ordersq, 0, -1):
            x=make_matrix(ordersq,i)
            if trace_toldsum(x,ordersq)==trace_told:
                flag=True
                break
                
        if flag:
            print("Case #",end="")
            print(_,end="")
            print(": POSSIBLE")
            for i in x:
                print(*i,sep=" ")
        else:
            print("Case #",end="")
            print(_,end="")
            print(": IMPOSSIBLE")
            

main()