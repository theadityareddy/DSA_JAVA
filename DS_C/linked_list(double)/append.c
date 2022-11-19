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
dnode* append(dnode*, int);

int main()
{
    dnode* head = NULL;
    int n, x;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);    
    display(head);

    printf("\nEnter the data to be appended: ");
    scanf("%d", &x);

    head = append(head, x);
    display(head);

    return 0;
}

dnode* create(int n)
{
    dnode* head = NULL, *p, *temp;
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

    printf("NULL-->");
    for(p = head; p->next != NULL; p=p->next)
        printf("%d<-->", p->data);
    printf("%d-->", p->data);
    printf("NULL");
}
dnode* append(dnode* head, int x)
{
    dnode* p, *temp;

    temp = (dnode*)malloc(sizeof(dnode));
    temp->data = x;
    temp->prev = NULL;
    temp->next = NULL;

    if(head == NULL)
        head = temp;
    else if(head->next == NULL)
        {
            head->next = temp;
            temp->prev = head;
        }
    else
        {
            for(p = head; p->next != NULL; p=p->next)
                ;
            p->next = temp;
            temp->prev=  p;
        }
    return head;
}