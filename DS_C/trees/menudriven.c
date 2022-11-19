#include<stdio.h>
#include<stdlib.h>
typedef struct BSTnode
{
    struct BSTnode* left;
    int data;
    struct BSTnode* right;
}BSTnode;

BSTnode* create(int);
BSTnode* insert(BSTnode*, int);
void preorder(BSTnode*);
void inorder(BSTnode*);
void postorder(BSTnode*);
void display(BSTnode*);
void mirror(BSTnode*);
int count(BSTnode*);
int countleaf(BSTnode*);
int search(BSTnode*, int);

int main()
{
    BSTnode* root = NULL;
    int i, x, n, cnt, choice;

    printf("Enter how many nodes: ");
    scanf("%d", &n);
    root = create(n);

    do
    {
        printf("\n\n1: Insert");
        printf("\n2: Preorder");
        printf("\n3: Inorder");
        printf("\n4: Postorder");
        printf("\n5: Display");
        printf("\n6: Mirror Image");
        printf("\n7: Count nodes"); 
        printf("\n8: Count leaf nodes"); 
        printf("\n9: Search");
        printf("\n10: Degree of each node");
        printf("\n11: Delete");
        printf("\n12: Quit");
        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch(choice)
            {
                case 1: printf("Enter data to be inserted: ");
                        scanf("%d", &x);
                        root = insert(root, x);
                        break;

                case 2: preorder(root);
                        break;

                case 3: inorder(root);
                        break;

                case 4: postorder(root);
                        break;

                case 5: display(root);
                        break;

                case 6: mirror(root);
                        break;
                
                case 7: cnt = count(root);
                        printf("Total nodes = %d", cnt);
                        break;

                case 8: cnt = countleaf(root);
                        printf("Total leaf nodes = %d", cnt);
                        break;

                case 9: printf("Enter the data to be searched: ");
                        scanf("%d", &x);
                        if(search(root, x))
                            printf("%d found", x);
                        else
                            printf("%d not found", x);
                        break;

                case 10: //degree(root);
                         break;
            
                case 11:
                         break;         
            }   
    }while(choice != 12);
    


    return 0;
}

BSTnode* insert(BSTnode* T, int x)
{
    BSTnode* node;

    if(T == NULL)
        {
            node = (BSTnode*)malloc(sizeof(BSTnode)); //create node
            node->data = x;
            node->left = NULL;
            node->right = NULL;
            return node;
        }
    else if(x >= T->data)
        T->right = insert(T->right, x);   //create node on right side
    else
        T->left = insert(T->left, x);       //create node on left side

    return T;
}
void display(BSTnode* T)
{
    if(T != NULL)
        {
            printf("%d ", T->data); 
            display(T->left);
            display(T->right);
        }
}
BSTnode* create(int n)
{
    BSTnode* root = NULL;
    int i, x;

    for(i = 1; i <= n; i++)
        {
            printf("Enter node value: ");
            scanf("%d", &x);
            root = insert(root, x);
        }
    
    return root;
}
void preorder(BSTnode* T)
{
    if(T != NULL)
        {
            printf("%d ", T->data); 
            display(T->left);
            display(T->right);
        }
}
void inorder(BSTnode* T)
{
    if(T != NULL)
        {
            inorder(T->left);
            printf("%d ", T->data); 
            inorder(T->right);
        }
}
void postorder(BSTnode* T)
{
    if(T != NULL)
        {
            display(T->left);
            display(T->right);
            printf("%d ", T->data); 
        }
}
void mirror(BSTnode* T)
{
    if(T != NULL)
        {
            printf("%d ", T->data); 
            display(T->right);
            display(T->left);
        }
}
int count(BSTnode* T)
{
    int cnt = 0;

    if(T != NULL)
        {
            cnt++;
            cnt = cnt + count(T->left);
            cnt = cnt + count(T->right);
        }

    return cnt;
}
int countleaf(BSTnode* T)
{
    int cnt = 0;

    if(T != NULL)
        {
            if(T->left==NULL && T->right==NULL)
                {
                    cnt++;
                    // printf("%d ", T->data);
                }
            cnt = cnt + countleaf(T->left);
            cnt = cnt + countleaf(T->right);    
        }

    return cnt;
}
int search(BSTnode* T, int x)
{
    int flag = 0;

    while(T != NULL)
        {
            if(x == T->data)
                {
                    flag = 1;
                    break;
                }
            else if(x > T->data)
                T = T->right;
            else
                T = T->left;
        }

    return flag;
}