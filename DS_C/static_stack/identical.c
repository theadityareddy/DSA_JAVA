#include<stdio.h>
#include "st_stack.h"

int isidentical(stack*, stack*);

int main()
{
    stack s1, s2;
    int i, x, ans, choice;

    init(&s1);
    init(&s2);

    printf("Enter content for 1st stack\n");
    do
    {
        printf("Enter a number: ");
        scanf("%d", &x);
        push(&s1, x);

        printf("Do you want to continue? ");
        scanf("%d", &choice);
    }while(choice != 0);

    printf("\nEnter content for 2nd stack\n");
    do
    {
        printf("Enter a number: ");
        scanf("%d", &x);
        push(&s2, x);

        printf("Do you want to continue? ");
        scanf("%d", &choice);
    }while(choice != 0);

    ans = isidentical(&s1, &s2);
    if(ans == 1)
        printf("Both stacks are identical");
    else
        printf("Both stacks are not identical");

    return 0;
}

int isidentical(stack* p1, stack* p2)
{
    int flag = 1;
    int x, y;

    if(p1->top != p2->top)
        flag = 0;
    else
        {
            while(!isempty(p1) && !isempty(p2))
                {
                    x = pop(p1);
                    y = pop(p2);
                    if(x != y)
                        {
                            flag = 0;
                            break;
                        }
                }
        }

    return flag;
}
