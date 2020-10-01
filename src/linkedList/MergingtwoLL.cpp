** Question link - https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1

-Given two sorted linked lists consisting of N and M nodes respectively. The task is to merge both of the list (in-place) and return head of the merged list.
Note: It is strongly recommended to do merging in-place using O(1) extra space.

/* Link list Node
struct Node {
  int data;
  struct Node *next;
  
  Node(int x) {
    data = x;
    next = NULL;
  }
};
*/

Node* sortedMerge(Node* first, Node* second)  
{  
    struct Node* third=NULL;
    struct Node* last=NULL;
    if(first->data<second->data)
    {
        third=last=first;
        first=first->next;
        last->next=NULL;
    }
    else
    {
        third=last=second;
        second=second->next;
        last->next=NULL;
    }
    while(first!=NULL && second!=NULL)
    {
    if(first->data<second->data)
    {
        last->next=first;
        last=first;
        first=first->next;
        last->next=NULL;
    } 
    else
    {
        last->next=second;
        last=second;
        second=second->next;
        last->next=NULL;
    }
    }
    if(first!=NULL) 
        last->next=first;
    else
    {
        last->next=second;
    }
    return third;
        
}  
