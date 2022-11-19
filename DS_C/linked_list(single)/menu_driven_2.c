#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
node* create(int);
void display(node*);
int count(node*);
node* append(node*, int);
node* insert(node*, int, int);
int search(node*, int);
node* delete(node*, int);

int main()
{
    node* head = NULL;
    int choice, n, x, loc;

    while(1)
        {
            printf("\n\n1: Create");
            printf("\n2: Print");
            printf("\n3: Append");
            printf("\n4: Insert Location wise");
            printf("\n5: Delete location wise");
            printf("\n6: Find");
            printf("\n7: Exit");

            printf("\n\nEnter your choice: ");
            scanf("%d", &choice);
            if(choice == 7)
                break;
            else
                {
                    switch(choice)
                        {
                            case 1: printf("\nEnter how many nodes: ");
                                    scanf("%d", &n);
                                    head = create(n);
                                    printf("\nLinked list created\n");
                                    break;

                            case 2: display(head); 
                                    break;

                            case 3: printf("\nEnter the value to be inserted: ");
                                    scanf("%d", &x);
                                    head = append(head, x);
                                    printf("\nValue appended\n");
                                    break;

                            case 4: printf("\nEnter location and its data: ");  
                                    scanf("%d %d", &loc, &x);
                                    head = insert(head, loc, x);
                                    printf("\nData inserted\n");
                                    break;

                            case 5: printf("\nEnter location: ");
                                    scanf("%d", &loc);
                                    head = delete(head, loc);
                                    printf("\nData deleted");
                                    break;

                            case 6: printf("\nEnter data to be searched: ");
                                    scanf("%d", &x);
                                    loc = search(head, x);
                                    if(loc == -1)
                                        printf("\nData not found");
                                    else
                                        printf("\n%d found at %d location", x, loc);
                                    break;

                            default: printf("\n\nInvalid choice\n");
                        }
                }
        }
    
    return 0;
}

node* create(int n)
{
    node* head, *p, *temp;
    int i;

    head = malloc(sizeof(node));
    printf("\nEnter data for head node: ");
    scanf("%d", &head->data);
    head->next = NULL;

    p = head;
    for(i = 1; i < n; i++)
        {
            temp = malloc(sizeof(node));
            printf("Enter data: ");
            scanf("%d", &temp->data);
            temp->next = NULL;
            p->next = temp;
            p = p->next;
        }
    return head;
}
void display(node* head)
{
    node* p;

    for(p = head; p != NULL; p=p->next)
        printf("%d->", p->data);
    printf("NULL\n");
}
int count(node* head)
{
    node* p;
    int cnt = 0;

    for(p = head; p != NULL; p=p->next)
        cnt++;
    return cnt;
}
node* append(node* head, int x)
{
    node* p, *temp;

    temp = (node*)malloc(sizeof(node));
    temp->data = x;
    temp->next = NULL;

    if(head == NULL)
        head = temp;
    else
        {   
            for(p = head; p->next != NULL; p=p->next)
                ;

            p->next = temp;
        }
    return head;
}
node* insert(node* head, int loc, int x)
{
    node* temp, *p;
    int cnt, i;

    temp = (node*)malloc(sizeof(node));
    temp->data = x;
    temp->next = NULL;

    cnt = count(head);
    if(head == NULL)
        printf("\nLinked list is empty");
    else if(loc > cnt)
        head = append(head, x);
    else if(loc == 1)
        {
            temp->next = head;
            head = temp;
        }
    else
        {
            p = head;
            for(i = 1; i < loc-1; i++)
                p = p->next;

            temp->next = p->next;
            p->next = temp;
        }
    return head;
}
int search(node* head, int x)
{
    node* p;
    int loc = 1, ans = -1;

    for(p = head; p != NULL; p=p->next)
        {
            if(p->data == x)
                {
                    ans = loc;
                    break;
                }
                
            loc++;
        }
    return ans;
}
node* delete(node* head, int loc)
{
    node* q, *p;
    int i, cnt;

    cnt = count(head);
    if(head == NULL)
        printf("\nNo data to delete");
    else if(loc > cnt)
        printf("\nGive location not available");
    else if(loc == 1)
        {
            q = head;
            head = head->next;
            q->next = NULL;
            free(q);
        }
    else
        {
            p = head;
            q = head->next;
            for(i = 1; i < loc-1; i++)
                {
                    q = q->next;
                    p = p->next; 
                }
            p->next = q->next;
            q->next = NULL;
            free(q);
        }

    return head;
}