#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
node* create(int);
void print(node*);
node* delete(node*);

int main()
{
    node *head;
    int n, choice;

    while(1)
        {
            printf("\n\n1: Create");
            printf("\n2: Print");
            printf("\n3: Delete first node");
            printf("\n4: Exit");

            printf("\nEnter your choice: ");
            scanf("%d", &choice);
            if(choice == 4)
                break;
            else
                {
                    switch(choice)
                        {
                            case 1: printf("Enter how many nodes: ");
                                    scanf("%d", &n);
                                    head = create(n);
                                    break;

                            case 2: print(head);
                                    break;

                            case 3: head = delete(head);
                                    break;
                        }
                }
        }

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
node* delete(node* head)
{
    node* q;

    if(head == NULL)
        printf("There is nothing to delete");
    else
        {
            q = head;
            head = head->next;
            q->next = NULL;
            free(q);
        }
    return head;
}