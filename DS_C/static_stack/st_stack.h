#include<stdio.h>
#define MAX 10

typedef struct stack
{
    int data[MAX];
    int top;
}stack;


int isfull(stack* p)
{
    if(p->top == MAX-1)
        return 1;
    else
        return 0;
}

int isempty(stack* p)
{
    if(p->top == -1)
        return 1;
    else
        return 0;
}

void init(stack* p)
{
    p->top = -1;
}

void push(stack* p, int x)
{
    if(isfull(p))
        printf("Stack is full");
    else
        {
            p->top++;
            p->data[p->top] = x;
        }
}

int pop(stack* p)
{
    int x = -1;

    if(!isempty(p))
        {
            x = p->data[p->top];
            p->top--;
        }
    
    return x;
}

void display(stack* p)
{
    int i;

    if(isempty(p))
        printf("Stack is empty");
    else
        {
            for(i = p->top; i >= 0; i--)
                printf("\n%d", p->data[i]);
        }
}

int peek(stack* p)
{
    int x = -1;

    if(!isempty(p))
        x = p->data[p->top];
        
    return x;
}