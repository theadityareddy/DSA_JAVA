#include<stdio.h>
#include<stdlib.h>
typedef struct  node
{
    int data;
    struct node* next;
}node;
node* createList(int);
void printList(node*);
node* reverseList(node*);

int main()
{
    node* head;
    int n;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = createList(n);
    printf("\nBefore reversing\n");
    printList(head);

    head = reverseList(head);    
    printf("\nAfter reversing\n");
    printList(head);

    return 0;
}

node* createList(int n)
{
    node* head, *p, *temp;
    int i;

    head = malloc(sizeof(node));
    printf("Enter data for head node: ");
    scanf("%d", &head->data);
    head->next = NULL;

    p = head;
    for(i = 1; i < n; i++)
        {
            temp = (node*)malloc(sizeof(node));
            printf("Enter data: ");
            scanf("%d", &temp->data);
            temp->next = NULL;
            p->next = temp;
            p = p->next;
        }

    return head;
}
void printList(node* head)
{
    node* p;

    for(p = head; p != NULL; p=p->next)
        printf("%d->", p->data);
    printf("NULL");
}
node* reverseList(node* head)
{
    node* q, *p;

    q = NULL;

    while(head != NULL)   
        {
            p = head;
            head = head->next;
            p->next = q;
            q = p;
        }
    return q;
}