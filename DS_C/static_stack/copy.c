#include<stdio.h>
#include "st_stack.h"

void copy(stack*, stack*);

int main()
{
    int x, choice;
    stack s1, s2;
    
    init(&s1);
    init(&s2);

    do
    {
        printf("Enter a number: ");
        scanf("%d", &x);
        push(&s1, x);

        printf("Do you want to continue?(1/0) ");
        scanf("%d", &choice);
    }while(choice != 0);  

    copy(&s1, &s2);

    printf("The copied stack is\n");
    display(&s2);

    return 0;
}

void copy(stack* p1, stack* p2)
{
    stack t;

    init(&t);

    while(!isempty(p1))
        push(&t, pop(p1));

    while(!isempty(&t))
        push(p2, pop(&t));
}