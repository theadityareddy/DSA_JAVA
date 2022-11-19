#include<stdio.h>
#include<stdlib.h>
typedef struct stack
{
    int data;
    struct stack* next;
}stack;

stack* init(stack* top)
{
    top = NULL;
    return top;
}

int isempty(stack* top)
{
    if(top == NULL)
        return 1;
    else
        return 0;
}

stack* push(stack* top, int x)
{
    stack* temp;

    temp = (stack*)malloc(sizeof(stack));
    temp->data = x;
    temp->next = NULL;
    if(top == NULL)
        top = temp;
    else
        {
            temp->next = top;
            top = temp;
        }

    return top;
}

stack* pop(stack* top)
{
    stack* q;
    int x;

    if(!isempty(top))
        {
            q = top;
            top = top->next;
            x = q->data;
            printf("The deleted element is %d", x);
            q->next = NULL;
            free(q);
        }
    else
        printf("The stack is empty");

    return top;
}

void display(stack* top)
{   
    stack* p;

    if(!isempty(top))
        {
            p = top;
            while(p != NULL)
                {
                    printf("%d\n", p->data);
                    p = p->next;
                }
        }
    else
        printf("Stack is empty");
}

int peek(stack* top)
{
    if(!isempty(top))
        return top->data;
    else
        {
            printf("Stack is empty");
            return -1;
        }
}
