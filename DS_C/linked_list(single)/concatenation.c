#include<stdio.h>
#include<stdlib.h>  
typedef struct node
{
    int data;
    struct node*next;
}node;  
node* createList(int);
void printList(node*);
node* concat(node*, node*);

int main()
{
    node* head1, *head2, *head3;
    int n1, n2;

    printf("Enter how many nodes for 1st list: ");
    scanf("%d", &n1);
    head1 = createList(n1);

    printf("Enter how many nodes for 2nd list: ");
    scanf("%d", &n2);
    head2 = createList(n2);

    head3 = concat(head1, head2);
    printList(head3);

    return 0;
}

node* createList(int n)
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
void printList(node* head)
{
    node* p;

    for(p = head; p != NULL; p=p->next)
        printf("%d->", p->data);
    printf("NULL");
}
node* concat(node* head1, node* head2)
{
    node* p;

    if(head1 == NULL)
        return head2;
    else if(head2 == NULL)
        return head1;
    else
        {
            for(p = head1; p->next != NULL; p=p->next)
                ;
    
            p->next = head2;
        }
    return head1;
}
