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
dnode* deleteFirst(dnode*);

int main()
{
    dnode* head = NULL;
    int n;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);
    printf("\nBefore deleting last node\n");
    display(head);

    head = deleteFirst(head);
    printf("\nAfter deleting last node\n");
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
            p = p->next;
        }
    return head;
}
void display(dnode* head)
{
    dnode* p;

    printf("NULL<--");
    for(p = head; p->next != NULL; p=p->next)
        printf("%d<-->", p->data);
    printf("%d-->", p->data);
    printf("NULL");
}
dnode* deleteFirst(dnode* head)
{
    dnode* q;

    if(head == NULL)
        printf("There is nothing to delete");
    else if(head->next == NULL)
        {
            q = head;
            head = head->next;
            free(q);
        }
    else
        {
            q = head;
            head = head->next;
            head->prev = NULL;
            q->next = NULL;
            free(q);
        }
    return head;
}