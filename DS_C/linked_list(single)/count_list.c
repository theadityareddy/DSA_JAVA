#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
node* create(int);
void print(node*);
int count(node*);

int main()
{
    int n, ans;
    node* head;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);    
    print(head);
    ans = count(head);
    printf("\nTotal no of nodes = %d", ans);
    
    return 0;
}

node* create(int n)
{
    node* head, *p, *temp;
    int i;

    head = malloc(sizeof(int));
    printf("Enter data for head node: ");
    scanf("%d", &head->data);
    head->next = NULL;

    p = head;
    for(i = 1; i < n; i++)
        {
            temp = malloc(sizeof(node));
            printf("\nEnter data: ");
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

    p = head;
    while(p != NULL)
        {
            printf("%d->", p->data);
            p = p->next;
        }
}
int count(node* head)
{
    node* p;
    int cnt = 0;

    p = head;
    while(p != NULL)
        {
            cnt++;
            p = p->next;
        }
    return cnt;
}