#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    char data;
    struct node* next;
}node;
node* create(int);
void print(node*);
void replace(node*, char, char);

int main()
{
    node* head;
    int n;
    char x, y;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);
    print(head);

    printf("Enter the character you want to replace: ");
    scanf(" %c", &y);
    printf("Enter the character you want to replace with: ");
    scanf(" %c", &x);

    replace(head, y, x);
    print(head);
    
    return 0;
}

node* create(int n)
{
    node* head, *p, *temp;
    int i;

    head = (node*)malloc(sizeof(node));
    printf("Enter data for head node: ");
    scanf(" %c", &head->data);
    head->next = NULL;

    p = head;
    for(i = 1; i < n; i++)
        {
            temp = (node*)malloc(sizeof(node));
            printf("\nEnter data: ");
            scanf(" %c", &temp->data);
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
        printf("%c->", p->data);
}
void replace(node* head, char y, char x)
{
    node* p;

    for(p = head; p != NULL; p=p->next)
        {
            if(p->data == y)
                p->data = x;
        }
}