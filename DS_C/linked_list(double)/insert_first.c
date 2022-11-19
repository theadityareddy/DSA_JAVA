#include<stdio.h>
#include<stdlib.h>
typedef struct dnode
{
    struct dnode* prev;
    int data;
    struct dnode* next;
}dnode;
dnode* create(int);
void print(dnode*);
dnode* insertFirst(dnode*, int);

int main()
{
    dnode* head = NULL;
    int n, x;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);
    print(head);

    printf("\nEnter the data to be inserted: ");
    scanf("%d", &x);

    head = insertFirst(head, x);
    print(head);

    return 0;
}

dnode* create(int n)
{
    dnode* head, *p, *temp;
    int i;

    head = (dnode*)malloc(sizeof(dnode));
    printf("\nEnter data for head node: ");
    scanf("%d", &head->data);
    head->prev = NULL;
    head->next = NULL;

    p = head;
    for(i = 1; i < n; i++)
        {
            temp = (dnode*)malloc(sizeof(dnode));
            printf("Enter data: ");
            scanf("%d", &temp->data);
            temp->next = NULL;
            p->next = temp;
            temp->prev = p;
            p = p->next;
        }
    return head;
}
void print(dnode* head)
{
    dnode* p;

    if(head == NULL)
        printf("\nLinked list is empty\n");
    else
        {
            printf("\nNULL<--"); 
            for(p = head; p->next != NULL; p=p->next)
                printf("%d<-->", p->data);
            printf("%d-->", p->data);
            printf("NULL");
        }
}
dnode* insertFirst(dnode* head, int x)
{
    dnode* temp;

    temp = (dnode*)malloc(sizeof(dnode));
    temp->prev = NULL;
    temp->next = NULL;
    temp->data = x;

    if(head == NULL)
        head = temp;
    else
        {
            temp->next = head;
            head = temp;
        }
    return head;
}