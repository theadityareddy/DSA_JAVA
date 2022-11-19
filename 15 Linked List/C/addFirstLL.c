#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int data;
    struct node *next;
}node;

node *head = NULL;
node *tail = NULL;

void addFirst(int data){
    node *newnode;
    newnode = (node *)malloc(sizeof(node));
    newnode->data = data;
    newnode->next = NULL;

    if (head == NULL){
        head = tail = newnode;
    } else {
        newnode->next = head;
        head = newnode;
    }
}


void printLinkedList(node *temp){
    while (temp != NULL){
        printf("%d->",temp->data);
        temp = temp->next;
    }
    printf("null \n");
}

int main(){
    addFirst(1);
    addFirst(2);
    addFirst(3);
    printLinkedList(head);
    return 0;
}