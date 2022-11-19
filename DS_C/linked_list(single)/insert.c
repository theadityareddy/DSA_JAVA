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
void append(node *, node *);

int main()
{
    node *head = NULL;
    int n, x, loc, choice;

    while (1)
    {
        printf("\n1: Create list");
        printf("\n2: Print List");
        printf("\n3: Insert node");
        printf("\n4: Exit");

        printf("\n\nEnter your choice: ");
        scanf("%d", &choice);

        if (choice == 4)
            break;
        else
        {
            switch (choice)
            {
            case 1:
                printf("\n\nEnter how many nodes: ");
                scanf("%d", &n);
                head = create(n);
                break;

            case 2:
                if (head == NULL)
                    printf("\nLinked list is empty: ");
                else
                    print(head);
                break;

            case 3:
                printf("Enter data and location for new node: ");
                scanf("%d %d", &x, &loc);
                head = insert(head, loc, x);
                printf("\nNew node inserted\n");
                print(head);
                break;

            default:
                printf("\nInvalid choice");
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
    printf("\nEnter data for head node: ");
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

int count(node *head)
{
    node *p;
    int cnt = 0;

    for (p = head; p != NULL; p = p->next)
        cnt++;

    return cnt;
}

void append(node *head, node *temp)
{
    node *p;

    for (p = head; p->next != NULL; p = p->next)
        ;

    p->next = temp;
}

node *insert(node *head, int loc, int x)
{
    node *temp, *p;
    int i, cnt;

    cnt = count(head);
    temp = (node *)malloc(sizeof(node));
    temp->data = x;
    temp->next = NULL;

    if (head == NULL)
        head = temp;
    else if (loc == 1)
    {
        temp->next = head;
        head = temp;
    }
    else if (loc > cnt)
        append(head, temp);
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
