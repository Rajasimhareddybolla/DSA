#include <stdio.h>
int main(){
    double no = 0b011101;
    printf("%d ",no);
}
void byte(int no ){
    int binery[32];
    int counter = 31 ;
    while (no != 0 || no !=1)
    {
        counter--;
        no = no /2;
        
    }
    
}