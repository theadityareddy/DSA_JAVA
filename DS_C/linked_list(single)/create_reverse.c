#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
node* createRev(int);
void printList(node*);

int main()
{
    node* head = NULL;
    int n;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = createRev(n);
    printList(head);
    
    return 0;
}

node* createRev(int n)
{
    node* head = NULL, *temp;

    while(n > 0)
        {
            temp = (node*)malloc(sizeof(node));
            printf("Enter data: ");
            scanf("%d", &temp->data);
            temp->next = NULL;

            if(head == NULL)
                head = temp;
            else
                {
                    temp->next = head;
                    head = temp;
                }

            n--;
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
