#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
node* create(int);
void printEven(node*);

int main()
{
    int n;
    node* head;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);
    printEven(head);

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
            temp = malloc(sizeof(node));
            printf("Enter data: ");
            scanf("%d", &temp->data);
            temp->next = NULL;
            p->next = temp;
            p = p->next;
        }   
    return head;
}
void printEven(node* head)
{
    node* p;

    for(p = head; p != NULL; p=p->next)
        {
            if(p->data%2 == 0)
                printf("%d->", p->data);
        }
}