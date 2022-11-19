#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
node* create(int);
int maxData(node*);

int main()
{
    node* head;
    int n, ans;

    printf("Enter how many nodes: ");
    scanf("%d", &n);

    head = create(n);
    ans = maxData(head);
    printf("\nThe max data is %d", ans);

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
int maxData(node* head)
{
    node* p;
    int max;
    int min;

    max = head->data;
    min = head->data;
    for(p = head->next; p != NULL; p=p->next)
        {
            if(p->data > max)
                max = p->data;
            // if(p->data < min)
            //     min = p->data;
        }

    // return min;
    return max;
}
