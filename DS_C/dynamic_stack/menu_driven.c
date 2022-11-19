#include<stdio.h>
#include "dystack.h"
int main()
{
    stack* top;
    int x, choice;

    top = init(top);
    do
    {   
        printf("\n\n1: PUSH");
        printf("\n2: POP");
        printf("\n3: DISPLAY");
        printf("\n4: PEEK");
        printf("\n5: EXIT");
        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch(choice)
            {
                case 1: printf("Enter a value: ");
                        scanf("%d", &x);
                        top = push(top, x);
                        break;

                case 2: top = pop(top);
                        break;

                case 3: display(top);
                        break;
                    
                case 4: x = peek(top);
                        if(x != -1)
                            printf("Top most element is %d", x);
            }
    }while(choice != 5);   

    return 0;
}