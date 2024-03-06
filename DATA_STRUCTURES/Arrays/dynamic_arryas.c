#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
struct Array{
    int *arr;
    int size;
    int capacity;
};
struct Array initalize(int size , int capacity,int arr[]);
void show_data(struct Array arrr);
void remove_el (struct Array *base,int index);
int get(struct Array base , int i);
void pushback(struct Array *base , int value);
bool set(struct Array base , int index , int value);
int size (struct Array node);
int find(struct Array node,int value);
int pop(struct Array *node);
struct Array resize(struct Array *node); // it gave new resized array you have to free the old array due to enhance the memory managment

int main(void){
    int *array1 = malloc(sizeof(int)*4);
    *array1 = 1;
    *(array1+1) = 2;
    *(array1+2) = 3;
    *(array1+3) = 4;

    struct Array root = initalize(4,4,array1);
    
    show_data(root);
    pushback(&root,678);
    show_data(root);
    remove_el(&root,2);
    show_data(root);
    printf(" your value is at %i \n",find(root,678));
    printf(" your popped value is %i \n",pop(&root));
    show_data(root);
    printf("now new warior coming \n \n");
    struct Array resized = resize(&root);
    
    show_data(resized);
}
void show_data(struct Array arrr){
    printf("given node have :\n");
    printf("capacity of the array =  %i \n",arrr.capacity);
    printf("size of the array = %i \n",arrr.size);
    printf("element in the array :\n");
    for (int i = 0 ; i < arrr.size ; i++){
        printf("    %i : %i   \n ",i, arrr.arr[i]);
    }

}
int get(struct Array base , int i ){
    if (  0>i  || i >= base.capacity){
        return -999;
    }

    return base.arr[i];
}
bool set(struct Array base , int index , int value){
    if (index<0 || index > base.capacity){
        return false;
    }
    base.arr[index] = value;
    return true ;

}
void pushback(struct Array *base , int value){
    if (base->capacity != base->size){
        base->arr[base->size] = value;
        base->size++;
    }
    else{
        int *new_arr = (int*)malloc(base->size*2 * sizeof(int)); // if you use int new_arr[] for initilization then the new_arr going to trash after this function show our base->arr poits to an invalid location int the computer space so we have to expliciltly allocate some memory 
        for (int i = 0 ; i <base->capacity ; i++){
            new_arr[i] = base->arr[i];
        }
        free(base->arr);
        new_arr[base->size] = value;
        base->capacity = base->size*2;
        base->size ++;
        base->arr = new_arr;
    }
}
void remove_el (struct Array *base,int index){
    if ( index  < 0 || index > base-> size -1){
        printf("how you can remove without intitlizing ra buffone");
    }
    else{
        for(int i = index ; i<base->size ; i++){
            base->arr[i] = base->arr[i+1];
        }
        base->size -- ;
    }
}
int size (struct Array node){
    return node.size;
}
int find(struct Array node,int value){
    for(int i = 0 ;i<node.size;i++){
        if(node.arr[i] == value){
            return i;
        }
    }
    return -1;
}
int pop(struct Array *node){
    int last = node->arr[node->size-1]; // use pointers if something restricted to certain function
    node->arr[node->size -1 ] = 0;
    node->size = node->size -1;
    return last ;
}
struct Array initalize(int size , int capacity,int array[]){
    int *arr = malloc(sizeof(int)*capacity);
    for (int i = 0 ; i  < size;i++){
        *(arr+i) = array[i];
    }
    struct Array *node =malloc(sizeof(struct Array));
    node->arr = arr;
    node->size = size;
    node->capacity = capacity;
    return *node;
}
struct Array resize(struct Array *node){
    return initalize(node->size,node->size,node->arr);
    
}