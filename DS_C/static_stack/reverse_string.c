#include<stdio.h>
#include "cst_stack.h"
int main()
{
    char str[MAX];
    int i;
    stack s;

    printf("Enter a string: ");
    scanf("%s", str);

    init(&s);

    for(i = 0; str[i]!='\0'; i++)
        push(&s, str[i]);
    
    i = 0;
    while(!isempty(&s))
        {
            str[i] = pop(&s);
            i++;
        }
    str[i] = '\0';
    printf("Reversed string is %s", str);
    
    return 0;
}