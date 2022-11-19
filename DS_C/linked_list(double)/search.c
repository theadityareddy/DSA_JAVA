#include<stdio.h>
#include<stdlib.h>
typedef struct dnode
{
    struct dnode* prev;
    int data;
    struct dnode* next;
}dnode;
dnode* create(int);
void display(dnode*);
int search(dnode*, int);

int main()
{
    dnode* head = NULL;
    int n, x, ans;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);
    printf("Enter the data to be searched: ");
    scanf("%d", &x);

    ans = search(head, x);
    if(ans == -1)
        printf("%d not found", x);
    else 
        printf("%d found at %d location", x, ans);
    
    return 0;
}

dnode* create(int n)
{
    dnode* head, *p, *temp;
    int i;

    head = (dnode*)malloc(sizeof(dnode));
    printf("Enter data for head node: ");
    scanf("%d", &head->data);
    head->prev = NULL;
    head->next = NULL;

    p = head;
    for(i = 1; i < n; i++)
        {
            temp = (dnode*)malloc(sizeof(dnode));
            printf("Enter data: ");
            scanf("%d", &temp->data);
            temp->prev = NULL;
            temp->next = NULL;
            p->next = temp;
            temp->prev = p;
            temp->prev = p;
            p = p->next;
        }
    return head;
}
void display(dnode* head)
{
    dnode* p;

    printf("NULL<-");
    for(p = head; p->next != NULL; p=p->next)
        printf("%d<-->", p->data);
    printf("%d-->", p->data);
    printf("NULL");
}
int search(dnode* head, int x)
{
    dnode* p;
    int ans = -1, loc = 1; 

    for(p = head; p != NULL; p=p->next)
        {   
            if(p->data == x)
                {
                    ans = loc;
                    break;
                }
            loc++;
        }
    return ans;
}