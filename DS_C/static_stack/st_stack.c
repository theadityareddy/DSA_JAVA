#include<stdio.h>
#include "st_stack.h"
int main()
{
    stack s;
    int choice, x;

    init(&s);

    do
    {
        printf("\n\n1: Push");
        printf("\n2: Pop");
        printf("\n3: Peek");
        printf("\n4: Display");
        printf("\n5: Exit");

        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch(choice)
            {
                case 1: printf("Enter the number to be pushed: ");
                        scanf("%d", &x);
                        push(&s, x);
                        break;

                case 2: x = pop(&s);
                        if(x == -1)
                            printf("The stack is empty");
                        else
                            printf("Deleted element is %d", x);
                        break;

                case 3: x = peek(&s);
                        if(x == -1)
                            printf("The stack is empty");
                        else
                            printf("The top most element is %d", x);
                        break;

                case 4: display(&s);
                        break;
            }
    }while(choice != 5); 
    
    return 0;
}


