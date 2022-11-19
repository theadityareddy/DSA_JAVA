#include <stdio.h>
#include <stdlib.h>
typedef struct node
{
    int data;
    struct node *next;
} node;
node *create(int);
void print(node *);
node *insert(node *, int, int);
int count(node *);
node *append(node *, int);

int main()
{
    node *head = NULL;
    int n, x, loc, choice;

    while (1)
    {
        printf("\n\n1: Create");
        printf("\n2: Print");
        printf("\n3: Insert location wise");
        printf("\n4: Exit");

        printf("\nEnter your choice: ");
        scanf("%d", &choice);
        if (choice == 4)
            break;
        else
        {
            switch (choice)
            {
            case 1:
                printf("Enter how many nodes: ");
                scanf("%d", &n);
                head = create(n);
                break;

            case 2:
                print(head);
                break;

            case 3:
                printf("Enter the value and the location of new node: ");
                scanf("%d %d", &x, &loc);
                head = insert(head, loc, x);
                break;

            default:
                printf("Invalid choice");
            }
        }
    }

    return 0;
}

node *create(int n)
{
    node *head, *p, *temp;
    int i;

    head = (node *)malloc(sizeof(node));
    printf("Enter data for head node: ");
    scanf("%d", &head->data);
    head->next = NULL;

    p = head;
    for (i = 1; i < n; i++)
    {
        temp = (node *)malloc(sizeof(node));
        printf("Enter data: ");
        scanf("%d", &temp->data);
        temp->next = NULL;
        p->next = temp;
        p = p->next;
    }
    return head;
}
void print(node *head)
{
    node *p;

    for (p = head; p != NULL; p = p->next)
        printf("%d->", p->data);
    printf("NULL");
}
node *insert(node *head, int loc, int x)
{
    node *p, *temp;
    int i, cnt;

    temp = (node *)malloc(sizeof(node));
    temp->data = x;
    temp->next = NULL;

    cnt = count(head);
    if (head == NULL)
        printf("Linked  list is empty");
    else if (loc > cnt)
        head = append(head, x);
    else if (loc == 1)
    {
        temp->next = head;
        head = temp;
    }
    else
    {
        p = head;
        for (i = 1; i < loc - 1; i++)
            p = p->next;
        temp->next = p->next;
        p->next = temp;
    }

    return head;
}
int count(node *head)
{
    node *p;
    int cnt = 0;

    for (p = head; p != NULL; p = p->next)
        cnt++;
    return cnt;
}
node *append(node *head, int x)
{
    node *p, *temp;

    temp = (node *)malloc(sizeof(node));
    temp->data = x;
    temp->next = NULL;

    if (head == NULL)
        head = temp;
    else
    {
        for (p = head; p->next != NULL; p = p->next)
            ;
        p->next = temp;
    }
    return head;
}