#include<stdio.h>
#include<stdlib.h>

typedef struct node
{   
    int data;
    struct node* next;
}node;

node* create(int);
void display(node*);
void reverseDisplay(node*);

int main()
{
    node* head = NULL;
    int n;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);

    printf("\nNormal display\n");
    display(head);

    printf("\nReverse display\n");
    reverseDisplay(head);
    
    return 0;
}

node* create(int n)
{
    node* head, *p, *temp;
    int i;

    head = (node*)malloc(sizeof(node));
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
void display(node* head)
{
    node* p;

    for(p = head; p != NULL; p=p->next)
        printf("%d->", p->data);
    printf("NULL");
}
void reverseDisplay(node* head)
{
    node* p;

    p = head;
    if(p != NULL)
        {
            reverseDisplay(p->next);
            printf("%d ", p->data);
        }
}