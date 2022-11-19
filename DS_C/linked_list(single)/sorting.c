#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
node* createList(int);
void printList(node*);
node* bubbleSort(node*, int);

int main()
{
    node* head = NULL;
    int n;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = createList(n);
    printf("\nBefore sorting\n");
    printList(head);

    head = bubbleSort(head, n);
    printf("\nAfter sorting\n");
    printList(head);

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
            temp = malloc(sizeof(node));
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
node* bubbleSort(node* head, int n)
{   
    node* p, *q;
    int i, j, t;

    for(i = 1; i < n; i++)
        {
            p = head;
            q = p->next;
            for(j = 0; j < n-i; j++)
                {
                    if(p->data > q->data)
                        {
                            t = p->data;
                            p->data = q->data;
                            q->data = t;
                        }
                    p = p->next;
                    q = q->next;
                }
        }
    return head;
}