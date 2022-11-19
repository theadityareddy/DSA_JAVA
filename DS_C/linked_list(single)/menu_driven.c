#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
void print(node*);
int count(node*);
int sum(node*);
int maxData(node*);
int countEven(node*);
int replace(node*, int, int);
node* create(int);
int search(node*, int);
int occur(node*, int);

int main()
{
    node* head = NULL;
    int n, choice, ans, y, x;

    do
    {
        printf("\n1: Create linked list:");
        printf("\n2: Print Linked List:");
        printf("\n3: Count Linked List:");
        printf("\n4: Sum of Linked List:");
        printf("\n5: Max of Linked List:");
        printf("\n6: Count even data of linked list:");
        printf("\n7: Search and replace data:");
        printf("\n8: Search:");
        printf("\n9: Occurences of data:");
        printf("\n10: Exit");

        printf("\n\nEnter your choice: ");
        scanf("%d", &choice);
        switch(choice)
            {
                case 1: printf("\nEnter how many nodes: ");
                        scanf("%d", &n);
                        head = create(n);
                        break;

                case 2: if(head == NULL)
                            printf("Linked list is empty\n");
                        else
                            print(head);
                        break;

                case 3: if(head == NULL)
                            printf("Linked list is empty\n");
                        else
                            {
                                ans = count(head);
                                printf("Total nodes = %d", ans);
                            }
                        break;

                case 4: if(head == NULL)
                            printf("Linked list is empty\n");
                        else
                            {
                                ans = sum(head);
                                printf("The sum is %d", ans);
                            }
                        break;

                case 5: if(head == NULL)
                            printf("Linked list is empty\n");
                        else
                            {
                                ans = maxData(head);
                                printf("The max data is %d", ans);
                            }
                        break;

                case 6: if(head == NULL)
                            printf("Linked list is empty\n");
                        else
                            {
                                ans = countEven(head);
                                printf("Total no of even data = %d", ans);
                            }
                        break;
                    
                case 7: if(head == NULL)
                            printf("\nLinked list is empty\n");
                        else
                            {
                                printf("Enter the no you want to replace and replace with: ");
                                scanf("%d %d", &y, &x);
                                ans = replace(head, y, x);
                                if(ans == 0)
                                    printf("%d not found", y);
                                else
                                    {
                                    printf("%d replaced with %d", y, x);
                                    print(head);
                                    }
                            }
                        break;

                case 8: if(head == NULL)
                            printf("Linked list is empty\n");
                        else
                            {
                                printf("Enter the no to be searched: ");
                                scanf("%d", &x);
                                ans = search(head, x);
                                if(ans == 0)
                                    printf("%d not found", x);
                                else
                                    printf("%d found at %d location", x, ans);
                            }
                        break;
                       
                case 9: if(head == NULL)
                            printf("Linked list is empty\n");
                        else
                            {   
                                printf("Enter the number you want to know the occurence of: ");
                                scanf("%d", &x);
                                ans = occur(head, x);
                                if(ans == 0)
                                    printf("%d not found", x);
                                else
                                    printf("\n%d found %d times", x, ans);
                            }
            }           
    }while(choice != 10);
        
    return 0;
}

void print(node* head)
{
    node* p;

    p = head;
    printf("\n");
    while(p != NULL)
        {
            printf("%d->", p->data);
            p = p->next;
        }
    printf("NULL");
    printf("\n");
}
int count(node* head)
{
    node* p;
    int cnt = 0;

    for(p = head; p != NULL; p=p->next)
        cnt++;   
    return cnt;
}
int sum(node* head)
{
    node* p;
    int tot = 0;

    for(p = head; p != NULL; p=p->next)
        tot = tot + p->data;
    return tot;
}
int maxData(node* head)
{
    node* p;
    int max;

    p = head;
    max = p->data;
    for(p=p->next; p != NULL; p=p->next)
        {
            if(p->data > max)
                max = p->data;
        }
    return max;
}
int countEven(node* head)
{
    node* p;
    int cnt = 0;

    for(p = head; p != NULL; p=p->next)
        {
            if(p->data%2 == 0)
                cnt++;
        }
    return cnt;
}
int replace(node* head, int y, int x)
{
    node* p;
    int flag = 0;

    for(p = head; p != NULL; p=p->next)
        {
            if(p->data == y)
                {
                    p->data = x;
                    flag = 1;
                }
        }
    return flag;
}
node* create(int n)
{
    node* head, *p, *temp;
    int i;

    head = (node*)malloc(sizeof(node));
    printf("\nEnter data for head node: ");
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
int search(node* head, int x)
{
    node* p;
    int loc = 1, ans = 0;

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
int occur(node* head, int x)
{
    node* p;
    int loc = 1, cnt = 0;

    for(p = head; p != NULL; p=p->next) 
        {
            if(p->data == x)
                {
                    printf("\n%d found at %d location", x, loc);
                    cnt++;
                }
            loc++;
        }

    return cnt;
}