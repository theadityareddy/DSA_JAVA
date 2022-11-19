#include<stdio.h>
#include<stdlib.h>
typedef struct dnode
{
    struct dnode* prev;
    int data;
    struct dnode* next;
}dnode;
dnode* create(int);
void print(dnode*);
int count(dnode*);
int sum(dnode*);
void printReverse(dnode*);

int main()
{
    dnode* head = NULL;
    int choice, n;

    while(1)
        {
            printf("\n\n1: Create");
            printf("\n2: Print");
            printf("\n3: Count");
            printf("\n4: Sum");
            printf("\n5: Print Reverse");
            printf("\n6: Exit");

            printf("\n\nEnter your choice: ");
            scanf("%d", &choice);

            if(choice == 6)
                break;
            else
                {
                    switch(choice)
                        {
                            case 1: printf("\nEnter how many nodes: ");
                                    scanf("%d", &n);
                                    head = create(n);
                                    break;

                            case 2: print(head);
                                    break;

                            case 3: printf("\nTotal no of nodes = %d", count(head));
                                    break;

                            case 4: printf("\nThe sum is %d", sum(head));
                                    break;

                            case 5: printReverse(head);
                                    break;

                            default: printf("\nInvalid choice\n");
                        }
                }
        }   
    
    return 0;
}

dnode* create(int n)
{
    dnode* head, *p, *temp;
    int i;

    head = (dnode*)malloc(sizeof(dnode));
    printf("\nEnter data for head node: ");
    scanf("%d", &head->data);
    head->prev = NULL;
    head->next = NULL;

    p = head;
    for(i = 1; i < n; i++)
        {
            temp = (dnode*)malloc(sizeof(dnode));
            printf("Enter data: ");
            scanf("%d", &temp->data);
            temp->next = NULL;
            p->next = temp;
            temp->prev = p;
            p = p->next;
        }
    return head;
}
void print(dnode* head)
{
    dnode* p;

    if(head == NULL)
        printf("\nLinked list is empty\n");
    else
        {
            printf("\nNULL<--"); 
            for(p = head; p->next != NULL; p=p->next)
                printf("%d<-->", p->data);
            printf("%d-->", p->data);
            printf("NULL");
        }
}
int count(dnode* head)
{
    dnode* p;
    int cnt = 0;

    for(p = head; p != NULL; p=p->next)
        cnt++;

    return cnt;
}
int sum(dnode* head)
{
    dnode* p;
    int sum = 0;

    for(p = head; p != NULL; p=p->next)
        sum = sum + p->data;

    return sum;
}   
void printReverse(dnode* head)
{
    dnode* p;

    if(head != NULL)
        {
            for(p = head; p->next != NULL; p=p->next)
                ;

            printf("NULL ");
            while(p != NULL)
                {
                    printf("%d ", p->data);
                    p=p->prev;
                }
        }
    printf("NULL");
}