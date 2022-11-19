#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
    int data;
    struct node* next;
}node;

node* create(int);
void display(node*);
void reverseDisplay(node*, int);
int count(node*);

int main()
{
    node* head = NULL;
    int n, cnt;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);
    cnt = count(head);
    display(head);

    printf("\nThis is the reverse display: \n");
    reverseDisplay(head, cnt);

    return 0;
}

node* create(int n)
{
    node* head = NULL, *p, *temp;
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
void reverseDisplay(node* head, int n)
{   
    node* p;
    int i;

    while(n >= 1)
        {
            p = head;
            for(i = 1; i <= n-1; i++)
                p = p->next;

            printf("%d ", p->data);
            n--;
        }
}
int count(node* head)
{
    node* p;
    int cnt = 0;

    for(p = head; p != NULL; p=p->next)
        cnt++;
    return cnt;
}
