#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
node* create(int);
int firstOccur(node*, int);
int lastOccur(node*, int);
int count(node*, int);

int main()
{
    node* head;
    int n, ans, x;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);
    printf("\nEnter the number you want to search: ");
    scanf("%d", &x);

    // ans = search(head, x);
    // if(ans == -1)
    //     printf("%d not found", x);
    // else
    //     printf("%d found at %d location", x, ans);

    ans = lastOccur(head, x);
    if(ans == 0)
        printf("%d not found", x);
    else
        printf("%d last found at %d location", x, ans);

    // ans = count(head, x);
    // if(ans == 0)
    //     printf("%d not found", x);
    // else
    //     printf("%d found %d times", x, ans);

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
            printf("\nEnter data: ");
            scanf("%d", &temp->data);
            temp->next = NULL;
            p->next = temp;
            p = p->next;
        }

    return head;
}
int search(node* head, int x)
{
    node* p;
    int loc = 1;

    for(p = head; p != NULL; p=p->next)
        {
            if(p->data == x)
                return loc;
            loc++;
        }
    return -1;
}
int lastOccur(node* head, int x)
{
    node* p;
    int loc = 1, ans = 0;

    for(p = head; p != NULL; p=p->next)
        {
            if(p->data == x)
                ans = loc;

            loc++;
        }

    return ans;
}
int count(node* head, int x)
{
    node* p;
    int cnt = 0, loc = 1;

    for(p = head; p != NULL; p=p->next)
        {
            if(p->data == x)
                {
                    cnt++;
                    printf("%d found at %d location", x, loc);
                }

            loc++;      
        }

    return cnt;
}