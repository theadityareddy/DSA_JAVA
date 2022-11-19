#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
node* create(int);
void print(node*);
int sum(node*);

int main()
{
    int n, tot;
    node* head;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);
    print(head);
    tot = sum(head);
    printf("\nThe sum is %d", sum);

    return 0;
}

node* create(int n)
{
    node* head, *temp, *p;
    int i;

    head = (node*)malloc(sizeof(int));
    printf("Enter data of head node: ");
    scanf("%d", &head->data);
    head->next = NULL;

    p = head;
    for(i = 1; i < n; i++)
        {
            temp = (node*)malloc(sizeof(node));
            printf("\nEnter data: ");
            scanf("%d", &temp->data);
            temp->next = NULL;
            p->next = temp;
            p = p->next;
        }
}
void print(node* head)
{
    node* p;

    p = head;
    while(p != NULL)
        {
            printf("%d->", p->data);
            p = p->next;
        }
    printf("NULL");
}
int sum(node* head)
{
    node* p;
    int sum = 0;

    p = head;
    while(p != NULL)
        {
            sum = sum + p->data;
            p = p->next;
        }
    return sum;
}
