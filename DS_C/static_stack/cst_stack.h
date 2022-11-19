#include<stdio.h>
#define MAX 100

typedef struct stack
{
    char data[MAX];
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

void push(stack* p, char x)
{
    if(isfull(p))
        printf("Stack is full");
    else
        {
            p->top++;
            p->data[p->top] = x;
        }
}

char pop(stack* p)
{
    char x = '\0';

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
                printf("\n%c", p->data[i]);
        }
}

char peek(stack* p)
{
    char x = '\0';

    if(!isempty(p))
        x = p->data[p->top];
        
    return x;
}