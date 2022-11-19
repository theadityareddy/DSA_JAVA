// Evaluation of postfix
#include<stdio.h>
#include<ctype.h>
#include<math.h>
#include "cst_stack.h"
void evaluate(char[]);

int main()
{
    char str[100];

    printf("Enter a postfix string: ");
    scanf("%s", str);

    evaluate(str);
    
    return 0;
}

void evaluate(char str[])
{
    int i, op1, op2, result;
    stack s;

    init(&s);
    for(i = 0; str[i]!='\0'; i++)
        {
            if(isdigit(str[i]))
                push(&s, str[i]);
            else
                {
                    op2 = pop(&s)-'0';
                    op1 = pop(&s)-'0';
                    switch(str[i])
                        {
                            case '+': result = op1+op2;
                                      break;

                            case '-': result = op1-op2;
                                      break;

                            case '*': result = op1*op2;
                                      break;

                            case '/': result = op1/op2;
                                      break;

                            case '^': 
                            case '$': result = pow(op1, op2); 
                        }
                    push(&s, result+'0');
                }
        }
    result = pop(&s)-'0';
    if(isempty(&s) == 1)
        printf("The result is %d", result);
    else
        printf("Invalid postfix string");
}