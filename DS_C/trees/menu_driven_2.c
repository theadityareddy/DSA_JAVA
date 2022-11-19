#include<stdio.h>
#include<stdlib.h>
typedef struct BSTnode
{
    struct BSTnode* left;
    int data;
    struct BSTnode* right;
}BSTnode;

BSTnode* create();
BSTnode* insert(BSTnode*, int);
void preorder(BSTnode*);
void inorder(BSTnode*);
void postorder(BSTnode*);
void display(BSTnode*);
void mirrortree(BSTnode*);
int count(BSTnode*);

int main()
{
    BSTnode* root = NULL;    
    int x, cnt, choice;

    do
    {
        printf("\n\n1: Create");
        printf("\n2: Preorder");
        printf("\n3: Inorder");
        printf("\n4: Postorder");
        printf("\n5: Count");
        printf("\n6: Mirror Display");
        printf("\n7: Print Tree");
        printf("\n8: Insert");
        printf("\n9: Quit");
        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch(choice)
            {
                case 1: root = create(root);
                        break;

                case 2: preorder(root);
                        break;

                case 3: inorder(root);
                        break;
                
                case 4: postorder(root);
                        break;

                case 5: cnt = count(root);
                        printf("\nTotal nodes = %d", cnt);
                        break;

                case 6: mirrortree(root);
                        break;
                
                case 7: display(root);
                        break;

                case 8: printf("Enter data to be inserted: ");
                        scanf("%d", &x);
                        root = insert(root, x);                        
            }
    }while(choice != 9);
        
    return 0;
}

BSTnode* create()
{
    int i, x, n;
    BSTnode* root = NULL;

    printf("Enter how many nodes: ");
    scanf("%d", &n);
    for(i = 1; i <= n; i++)
        {
            printf("Enter node value: ");
            scanf("%d", &x);
            root = insert(root, x);
        }
    
    return root;
}
BSTnode* insert(BSTnode* T, int x)
{
    BSTnode* node;

    if(T == NULL)
        {
            node = (BSTnode*)malloc(sizeof(BSTnode));
            node->data = x;
            node->left = NULL;
            node->right = NULL;
            return node;
        }
    else if(x < T->data)
        {
            T->left = insert(T->left, x);
            return T;
        }
    else
        {
            T->right = insert(T->right, x);
            return T;
        }
}
void preorder(BSTnode* T)
{
    if(T != NULL)
        {
            printf("%d ", T->data);
            preorder(T->left);
            preorder(T->right);
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
            postorder(T->left);
            postorder(T->right);
            printf("%d ", T->data);
        }
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
void mirrortree(BSTnode* T)
{
    if(T != NULL)
        {
            printf("%d ", T->data);
            mirrortree(T->right);
            mirrortree(T->left);
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