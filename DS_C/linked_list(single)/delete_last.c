#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
node* create(int);
void print(node*);
node* deleteLast(node*);

int main()
{
    node* head = NULL;
    int n, choice;

    do
    {
        printf("\n\n1: Create");
        printf("\n2: Print");
        printf("\n3: Delete last node");
        printf("\n4: Exit");

        printf("\n\nEnter your choice: ");
        scanf("%d", &choice);
        switch(choice)
            {
                case 1: printf("Enter how many nodes: ");
                        scanf("%d", &n);
                        head = create(n);
                        break;

                case 2: print(head);
                        break;

                case 3: head = deleteLast(head);
            }
    }while(choice != 4);

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
node* deleteLast(node* head)
{
    node* q, *p;

    if(head == NULL)
        printf("Nothing to delete");
    else if(head->next == NULL)
        {   
            q = head;
            head = NULL;
            free(q);
        }
    else
        {
            p = head;
            q = p->next;
            while(q->next != NULL)
                {
                    p = p->next;
                    q = q->next;
                }
            p->next = NULL;
            free(q);
        }
    return head;
}   