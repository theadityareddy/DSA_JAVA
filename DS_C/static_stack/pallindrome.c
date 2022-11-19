#include<stdio.h>
#include "cst_stack.h"
int main()
{
    stack s;
    int i, flag = 0;
    char x;
    char str[MAX];

    printf("Enter a string: ");
    scanf("%s", str);

    init(&s);

    for(i = 0; str[i]!='\0'; i++)
        push(&s, str[i]);

    i = 0;
    while(!isempty(&s))
        {
            x = pop(&s);
            if(str[i] != x)
                {
                    flag = 1;
                    break;
                }
            i++;
        }
    
    if(flag == 0)
        printf("%s is pallindrome string", str);
    else
        printf("%s is not a pallindrome string", str);

    return 0;
}