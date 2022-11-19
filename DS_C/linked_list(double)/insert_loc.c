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
int count(dnode*);
dnode* insert(dnode*, int, int);

int main()
{
    dnode* head = NULL;
    int n, x, loc;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);
    printf("\nBefore inserting\n");
    display(head);

    printf("\nEnter the data to be inserted: ");
    scanf("%d", &x);
    printf("Enter its location: ");
    scanf("%d", &loc);

    head = insert(head, x, loc);
    printf("\nAfter inserting\n");
    display(head);

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
    printf("%d<--", p->data);
    printf("NULL");
}
dnode* insert(dnode* head, int x, int loc)
{
    dnode* p, *temp;
    int i, cnt;

    temp = (dnode*)malloc(sizeof(dnode));
    temp->data = x;
    temp->prev = NULL;
    temp->next = NULL;
    cnt = count(head);

    if(head == NULL)
        printf("There must be atleast one node to delete");
    else if(loc > cnt)
        {
            for(p = head; p->next != NULL; p=p->next)
                ;
            p->next = temp;
            temp->prev = p;
        }
    else if(loc == 1)
        {
            temp->next = head;
            head->prev = temp;
            head = temp;
        }
    else
        {
            p = head;
            for(i = 1; i < loc-1; i++)
                p = p->next;

            temp->next = p->next;
            (p->next)->prev = temp;
            temp->prev = p;
            p->next = temp;
        }

    return head;
}
int count(dnode* head)
{
    dnode* p;
    int cnt = 0;

    for(p = head; p != NULL; p=p->next)
        cnt++;
    return cnt;
}