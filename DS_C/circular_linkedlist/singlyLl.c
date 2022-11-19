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
node* insertFirst(node*, int);

int main()
{
    node* rear = NULL;
    int n, x, choice;

    do
    {
        printf("\n\n1: Create");
        printf("\n2: Print");
        printf("\n3: Append");
        printf("\n4: Insert at first");
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

                case 3: printf("Enter data to be appended: ");
                        scanf("%d", &x);
                        rear = append(rear, x);
                        break;

                case 4: printf("Enter the data to be inserted: ");
                        scanf("%d", &x);
                        rear = insertFirst(rear, x);                      
            }
    }while(choice != 6); 

    return 0;
}

node* create(int n)
{
    node* rear = NULL, *temp;
    int i;

    for(i = 1; i <= n; i++)
        {
            temp = malloc(sizeof(node));
            printf("Enter data: ");
            scanf("%d", &temp->data);
            temp->next = NULL;

            if(rear == NULL)
                {
                    rear = temp;
                    rear->next = rear;
                }
            else
                {
                    temp->next = rear->next;
                    rear->next = temp;
                    rear = temp;
                }
        }

    return rear;
}
node* append(node* rear, int x)
{
    node* temp;

    temp = (node*)malloc(sizeof(node));
    temp->data = x;
    temp->next = NULL;

    if(rear == NULL)
        rear = temp;
    else
        {
            temp->next = rear->next;
            rear->next = temp;
            rear = temp;
        }
    return rear;
}
void display(node* rear)
{
    node* p;

    p = rear->next;
    do
    {
        printf("%d->", p->data);
        p = p->next;
    }while(p != rear->next);
}
node* insertFirst(node* rear, int x)
{
    node* temp;

    temp = (node*)malloc(sizeof(node));
    temp->data = x;
    temp->next = NULL;

    if(rear == NULL)
        {
            rear = temp;
            rear->next = rear;
        }
    else
        {
            temp->next = rear->next;
            rear->next = temp;
        }

    return rear;
}