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
int count(dnode*);
dnode* delete(dnode*, int);

int main()
{
    dnode* head = NULL;
    int n, loc;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);
    printf("Enter the location to be deleted: ");
    scanf("%d", &loc);

    head = delete(head, loc);
    printf("\nAfter deleting\n");
    display(head);
    
    return 0;
}

dnode* create(int n)
{
    dnode* head, *p, *temp;
    int i;

    head = (dnode*)malloc(sizeof(dnode));
    printf("Enter data for head node: ");
    scanf("%d", &head->data);
    head->prev = NULL;
    head->next = NULL;

    p = head;
    for(i = 1; i < n; i++)
        {
            temp = (dnode*)malloc(sizeof(dnode));
            printf("Enter data: ");
            scanf("%d", &temp->data);
            temp->prev = NULL;
            temp->next = NULL;
            p->next = temp;
            temp->prev = p;
            p = p->next;
        }   
    return head;
}
void display(dnode* head)
{
    dnode* p;

    printf("NULL<--");
    for(p = head; p->next != NULL; p=p->next)
        printf("%d<-->", p->data);
    printf("%d-->", p->data);
    printf("NULL");
}
dnode* delete(dnode* head, int loc)
{
    dnode* p, *q;
    int i, cnt;

    cnt = count(head);
    if(head == NULL)
        printf("Nothing to delete");
    else if(loc > cnt)
        printf("Location doesn't exist");
    else if(loc == 1)
        {
            q = head;
            head = head->next;
            if(head != NULL)
                head->prev = NULL;
            q->next = NULL;
            free(q);
        }
    else
        {
            p = head;
            q = p->next;
            for(i = 1; i < loc-1; i++)
                {
                    q = q->next;
                    p = p->next;
                }
            p->next = q->next;
            if(q->next != NULL)
                (q->next)->prev = p;
            q->prev = NULL;
            q->next = NULL;
            free(q);
        }

    return head;
}
int count(dnode* head)
{
    dnode* p;
    int cnt = 0;

    for(p = head; p != NULL; p=p->next)
        cnt++;
    return cnt;
}