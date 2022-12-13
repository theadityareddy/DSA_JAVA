// infix to prefix
#include<stdio.h>
#include<ctype.h>
#include "cst_stack.h"
void reverse(char[]);
int priority(char);
void intopost(char[], char[]);

int main()
{
    char str1[100], str2[100];
    int i;

    printf("Enter an infix string: ");
    scanf("%s", str1);

    reverse(str1); //step 1

    for(i = 0; str1[i]!='\0'; i++)  //step 2
        {
            if(str1[i] == '(')
                str1[i] = ')';
            else if(str1[i] == ')')
                str1[i] = '(';
        }

    intopost(str1, str2); //step 3

    reverse(str2); //step 4

    printf("The prefix string is %s", str2);

    return 0;
}

void reverse(char str[])
{
    stack s;
    int i;

    init(&s);
    for(i = 0; str[i]!='\0'; i++)
        push(&s, str[i]);

    i = 0;
    while(!isempty(&s))
        str[i++] = pop(&s);
    str[i] = '\0';
}
void intopost(char str1[], char str2[])
{
    int i, j = 0;
    char ch;
    stack s;

    init(&s);
    for(i = 0; str1[i]!='\0'; i++)
        {
            if(isalnum(str1[i]))
                str2[j++] = str1[i];
            else if(str1[i] == '(')
                push(&s, str1[i]);
            else if(str1[i] == ')')
                {
                    while((ch=pop(&s)) != '(')
                        str2[j++] = ch;
                }
            else
                {
                    while(priority(peek(&s)) > priority(str1[i]))
                        str2[j++] = pop(&s);
                    push(&s, str1[i]);
                }
        }
    while(!isempty(&s))
        str2[j++] = pop(&s);
    str2[j] = '\0';
}
int priority(char ch)
{
    if(ch == '(')
        return 0;
    if(ch=='+' || ch=='-')
        return 1;
    if(ch=='*' || ch=='/')
        return 2;
    if(ch=='^' || ch=='$')
        return 3;
    return -1;
}