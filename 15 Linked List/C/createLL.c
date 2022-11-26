#include<stdio.h>
#include<stdlib.h>

typedef struct node{
    int data;
    struct node *next;
}node;

node *head = NULL;
node *tail = NULL;

void createLL(int n){
    head = (node *)malloc (sizeof(node));

    printf ("enter your data : \n");
    scanf ("%d \n", &head->data);
    head->next = NULL;
    tail = head;

    for (int i = 1; i<n; i++){
        node *newnode;
        newnode = (node *)malloc(sizeof(node));
        scanf ("%d",&newnode->data);
        newnode->next = NULL;
        tail->next = newnode;
        tail = newnode;
    }
}

void printLL(node *temp){
    printf("\n");
    while (temp != NULL){
        printf ("%d->",temp->data);
        temp = temp->next;
    }
    printf("null \n");
} 

int main(){
    int n;

    printf ("how many linked list you want to add : ");
    scanf ("%d",&n);

    createLL(n); //addLast
    printLL(head);
    return 0;
}