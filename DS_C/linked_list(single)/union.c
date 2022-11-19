#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
    int data;
    struct node* next;
}node;

node* create(int);
void display(node*);
node* unify(node*, node*);
node* append(node*, int);

int main()
{
    node* head1 = NULL, *head2 = NULL, *head3 = NULL;
    int n1, n2;

    printf("Enter how many nodes for list 1: ");
    scanf("%d", &n1);
    head1 = create(n1);

    printf("Enter how many nodes for list 2: ");
    scanf("%d", &n2);
    head2 = create(n2);

    // display(head1);
    // display(head2);

    head3 = unify(head1, head2);
    printf("\nThe union is\n");
    display(head3);

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
node* unify(node* head1, node* head2)
{
    node* head3 = NULL;
    node* p, *q, *z, *temp;

    p = head1;
    q = head2;
    while(p!=NULL && q!=NULL)
        {
            if(p->data == q->data)
                {
                    head3 = append(head3, q->data);
                    p = p->next;
                    q = q->next;
                }
            else if(p->data > q->data)
                {
                    head3 = append(head3, q->data);
                    q = q->next;
                }
            else
                {
                    append(head3, p->data);
                    p = p->next;
                }
        }

    while(p != NULL)
        {
            append(head3, p->data);
            p = p->next;
        }

    while(q != NULL)
        {
            append(head3, q->data);
            q = q->next;
        }

    return head3;
}
node* append(node* head3, int x)
{
    node* p, *temp;

    temp = (node*)malloc(sizeof(node));
    temp->data = x;
    temp->next = NULL;

    if(head3 == NULL)
        {
            head3 = temp;
        }
    else
        {
            for(p = head3; p->next != NULL; p=p->next)
                ;
            p->next = temp;
        }

    return head3;
}