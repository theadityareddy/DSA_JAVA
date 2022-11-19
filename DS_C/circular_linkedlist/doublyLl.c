#include<stdio.h>
#include<stdlib.h>
typedef struct dnode
{
    struct dnode* prev;
    int data;
    struct dnode* next;
}dnode;

dnode* create(int);
void display(dnode*);
void printReverse(dnode*);
dnode* append(dnode*, int);
dnode* insertFirst(dnode*, int);

int main()
{
    dnode* rear = NULL;
    int n, x, choice;

    do
    {
        printf("\n\n1: Create");
        printf("\n2: Display");
        printf("\n3: Append");
        printf("\n4: Insert at first");
        printf("\n5: Print reverse");
        printf("\n6: Exit");

        printf("\n\nEnter your choice: ");
        scanf("%d", &choice);

        switch(choice)
            {
                case 1: printf("Enter how many nodes: ");
                        scanf("%d", &n);
                        rear = create(n);
                        break;

                case 2: display(rear);
                        break;

                case 3: printf("Enter the data to be appended: ");
                        scanf("%d", &x);
                        rear = append(rear, x);
                        break;

                case 4: printf("Enter the data to be inserted: ");
                        scanf("%d", &x);
                        rear = insertFirst(rear, x);
                        break;

                case 5: printReverse(rear);
            }
    }while(choice != 6);
    
    return 0;
}

dnode* create(int n)
{
    dnode* rear = NULL, *temp;
    int i;

    for(i = 1; i <= n; i++)
        {
            temp = (dnode*)malloc(sizeof(dnode));
            printf("Enter data: ");
            scanf("%d", &temp->data);
            temp->next = NULL;

            if(rear == NULL)
                {
                    rear = temp;
                    rear->next = rear;
                    rear->prev = rear;
                }
            else
                {
                    temp->next = rear->next;
                    (rear->next)->prev = temp;
                    rear->next = temp;
                    temp->prev = rear;
                    rear = temp;
                }
        }
    return rear;
}
void display(dnode* rear)
{
    dnode* p;

    p = rear->next;
    do
    {
        printf("%d->", p->data);
        p = p->next;
    }while(p != rear->next);
}
dnode* append(dnode* rear, int x)
{
    dnode* temp;

    temp = (dnode*)malloc(sizeof(dnode));
    temp->prev = NULL;
    temp->data = x;
    temp->next = NULL;

    if(rear == NULL)
        {
            rear = temp;
            rear->next = rear;
            rear->prev = rear;
        }
    else
        {
            temp->next = rear->next;
            (rear->next)->prev = temp;
            temp->prev = rear;
            rear->next = temp;
            rear = temp;
        }
    return rear;
}
dnode* insertFirst(dnode* rear, int x)
{
    dnode *temp;

    temp = (dnode*)malloc(sizeof(dnode));
    temp->prev = NULL;
    temp->data = x;
    temp->next = NULL;

    if(rear == NULL)
        {
            rear = temp;
            rear->next = rear;
            rear->prev = rear;
        }
    else
        {
            temp->prev = rear;
            (rear->next)->prev = temp;
            temp->next = rear->next;
            rear->next = temp;
            rear->next = temp;
        }
    return rear;
}
void printReverse(dnode* rear)
{
    dnode* p;

    p = rear;
    do
    {
        printf("%d->", p->data);
        p = p->prev;
    }while(p != rear);    
}