#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
    int data;
    struct node* next;
}node;

node* create(int);
void display(node*);
node* append(node*, int);
node* intersect(node*, node*);

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

    head3 = intersect(head1, head2);
    display(head3);
    
    return 0;
}

node* create(int n)
{
    node* head = NULL, *p, *temp;
    int i;

    if(n == 0)
        return head;
    else
        {
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
node* intersect(node* head1, node* head2)
{
    node* p, *q;
    node* head3 = NULL;

    p = head1;

    while(p != NULL)
        {
            q = head2;
            while(q != NULL)
                {
                    if(p->data == q->data)
                        {
                            head3 = append(head3, p->data);
                            break;
                        }
                    
                    q = q->next;
                }
            p = p->next;
        }

    return head3;
}