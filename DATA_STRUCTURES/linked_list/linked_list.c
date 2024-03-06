#include <stdlib.h>
#include <stdbool.h>
#include <stdio.h>
// as head is a address having the head so we use *head to point to actual head becoz without that we can't change the things 
typedef struct  node
{
    /* data */
    int data;
    struct node *next;
}node;
int pop_front(node **head);
int pop_back(node **head);
bool push_front(node **head , int data);
int key_front(node *head );
bool push_front(node **head , int data);
bool push_back(node **head , int data);
int key_back(node *head);
bool push_back(node **head , int data);
bool find(node *head,int value);
bool erase(node **head,int value);
bool empty(node **head);  //not implemented or under implementation
bool add_before (node **head , int value );
bool add_after (node **head , int value );
node *head = NULL;
int main(){
    push_front(&head,23);
    push_back(&head,999);
    printf("%i",key_front(head));
    printf("\n last element == %i",key_back(head));
    pop_back(&head);
    empty(&head);
    printf("\n%i",key_back(head));
    if (find(head,45))
        printf("yes its there");
    else
        printf("its not there");
    
}
bool push_front(node **head , int data){
    node *new = malloc(sizeof(node));
    if (new == NULL)
        return false;
    new->data = data;
    new->next = *head;
    *head = new;
    return true;
}
int key_front(node *head ){
     return head->data;
}
int pop_front(node **head){
    int data = (*head)->data;

    *(head) = (*head)->next;
    return data;
}
int key_back(node *head){
    if(head->next == NULL || head == NULL)
        return head->data;
    return key_back(head->next);
}
bool push_back(node **head , int data){
    if ((*head)->next == NULL){
        node *new = malloc(sizeof(node));
        if (new == NULL)
            return false;
        new->data = data;
        new->next = NULL;
        (*head)->next = new;
        return true;
    }
    else
        push_back((*head)->next,data);
    return false;
    
}
int pop_back(node **head){
    node *pointer = *head;
    if (pointer==NULL)
        return false;
    while (true)
    {
        /* code */
        if(pointer->next->next != NULL){
            pointer =pointer->next;
        }
        int data = pointer->next->data;
        free(pointer->next);
        pointer->next = NULL;
        return data;
    }
    
}
bool find(node *head , int value){
    if(head->data == value)
        return true;
    if (head->next == NULL || head == NULL)
        return false;
    
    return find(head->next,value);
}
// bool erase(node **head,int value){   need to implement some cases like when data is  at the end and when it is last but one index
//     if ((*head)->next->data == value)

//         return true;
//     if((*head)->next == NULL)
//         return false;
//     return erase((*head)->next,value);
    
// }
bool empty(node **head){
    *head = NULL;
}
bool add_before (node **head , int value ){
    node *ptr = *head;
    node *prev = NULL;
    while (true)
    {
        if(ptr->data == value){

        }
        else{
            prev = ptr;
            ptr= ptr->next;
        }
        /* code */

    }
    
}