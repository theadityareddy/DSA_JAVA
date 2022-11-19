#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
node* createList(int);
void printList(node*);
node* deleteLoc(node*, int);
int countNode(node*);

int main()
{
    node* head;
    int n, loc;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = createList(n);
    printList(head);

    printf("Enter the location to be deleted: ");
    scanf("%d", &loc);

    head = deleteLoc(head, loc);
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
            temp = (node*)malloc(sizeof(node));
            temp->next = NULL;
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
node* deleteLoc(node* head, int loc)
{
    node* p, *q;
    int i, cnt;

    if(head == NULL)
        printf("There is nothing to delete");
    else if(loc < 0 || loc > cnt)
        printf("Invalid location");
    else
        {
            p = head;
            q = p->next;
            for(i = 1; i < loc-1; i++)
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
int countNode(node* head)
{
    node* p;
    int cnt = 0;

    for(p = head; p != NULL; p=p->next)
        cnt++;
    return cnt;
}