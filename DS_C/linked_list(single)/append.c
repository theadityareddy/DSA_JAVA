#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
node* create(int);
void print(node*);
node* append(node*, int);

int main()
{
    node* head = NULL;
    int n, x;

    printf("Enter how many nodes: ");
    scanf("%d", &n);
        
    if(n != 0)
        head = create(n);
        
    printf("\nEnter the data to be appended: ");
    scanf("%d", &x);
    head = append(head, x);
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
void print(node* head)
{
    node* p;

    for(p = head; p != NULL; p=p->next)
        printf("%d->", p->data);
    printf("NULL");
}
node* append(node* head, int x)
{
    node* temp, *p;

    temp = (node*)malloc(sizeof(node));
    temp->data = x;
    temp->next = NULL;

    if(head == NULL)
        head = temp;
    else if(head->next == NULL)
        head->next = temp;
    else
        {
            for(p = head; p->next != NULL; p=p->next)
                ;
            p->next = temp;
        }

    return head;
}