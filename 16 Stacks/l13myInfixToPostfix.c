#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

typedef struct Stack {
    char data[100];
    int top;
} Stack;

void init(Stack* s){
    s->top = -1;
}

int isEmpty(Stack* s){
    return s->top == -1;
}

int isFull(Stack* s){
    return s->top == 99;
}

void push(Stack* s, char ch){
    if (isFull(s)){
        printf("Stack is FULL");
    } else {
        s->data[++s->top] = ch;
    }
}

char pop(Stack* s){
    if (isEmpty(s)){
        printf("stack is empty");
    } else {
        return s->data[s->top++];
    }
}

char peek(Stack* s){
    if (isEmpty(s)){
        printf("stack is empty");
    } else {
        return s->data[s->top];
    }
}

int precedence(char ch){
    switch (ch)
    {
    case '+':
    case '-':
        return 1;
    case '*':
    case '/':
        return 2;
    case '^':
        return 3;
    default:
        return -1;
    }
}

void infixToPostfix(char str[], char postfix[]){
    Stack s;
    init(&s);
    int j=0;
    char ans[100];

    for (int i=0; str[i]!='\0'; i++){
        char ch = str[i];
        if (isalnum(ch)){ //check if char is alphabet or numeric
            ans[j++] = ch;
        }
        else if (ch == '('){ // if '(' then push it
            push(&s, ch);
        }
        else if (ch == ')'){ //if ')', then pop and print till opening bracket is reached
            while (!isEmpty(&s) && peek(&s)!='('){
                ans[j++] = pop(&s);
            }
            pop(&s);
        }
        else{ //if the char is "OPERAND"
            while (!isEmpty(&s) && precedence(ch) <= precedence(peek(&s))){
                ans[j++] = pop(&s);
            }
            push(&s, ch);
        }
    }
    // while(!isEmpty(&s)){
    //     ans[j++] = pop(&s);
    // }
    ans[j++] = '\0';
    printf("%s",ans);
}

int main(){
    char postfix[100];
    char infix[] = "a+b*(d-a*x)";
    infixToPostfix(infix, postfix);
    return 0;
}