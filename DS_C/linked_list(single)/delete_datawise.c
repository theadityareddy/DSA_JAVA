#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node*next;
}node;
node* create(int);
void print(node*);
node* deleteData(node*, int);

int main()
{
    node* head;
    int n, x, choice;

    do
    {
        printf("\n\n1: Create");
        printf("\n2: Print");
        printf("\n3: Delete data wise");
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

                case 3: printf("Enter the data to be deleted: ");
                        scanf("%d", &x);
                        head = deleteData(head, x);
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
node* deleteData(node* head, int x)
{
    node* p, *q;

    if(head == NULL)
        printf("There is nothing to delete");
    else if(head->data == x)
        {
            q = head;
            head = NULL;
            free(q);
        }
    else
        {
            p = head;
            q = p->next;
            while(q->data != x)
                {
                    p = p->next;
                    q = q->next;
                }
            p->next = q->next;
            q->next = NULL;
            free(q);
        }
    return head;
}
