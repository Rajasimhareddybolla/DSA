#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct node{
    int data;
    struct node* next;
}node;

node *base = NULL;
bool get_data(node* main);
bool add_p(int no,node *main);
int main(int argc , char ** argv){
    add_p(1,base);
    add_p(2,base);
    add_p(3,base);
    add_p(4,base);

    get_data(base);
}
bool add_p(int no,node *main){
    node *n = malloc(sizeof(node));
    if (n == NULL)
        return false;
    n->data = no;
    n->next = main;
    main = n;
    return true;
}
bool get_data(node* main){
    node *ptr = main;
    if (ptr == NULL){
        return false;
    }
    while(ptr->next!=NULL){
        printf("%i",ptr->data);
    }
    return true;
}