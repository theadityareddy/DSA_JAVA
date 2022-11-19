#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node *next;
}node;
node* create(int);
node* insert(node*, int);
void print(node*);

int main()
{
    node* head;
    int n, x;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);
    printf("Enter data for new node: ");
    scanf("%d", &x);

    head = insert(head, x);
    print(head);
    
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
node* insert(node* head, int x)
{
    node* temp;

    temp = (node*)malloc(sizeof(node));
    temp->data = x;
    temp->next = NULL;

    if(head == NULL)
        head = temp;
    else
        {
            temp->next = head;
            head = temp;
        }
        
    return head;
}
void print(node* head)
{
    node* p;

    for(p = head; p != NULL; p=p->next)
        printf("%d->", p->data);
    printf("NULL");
}