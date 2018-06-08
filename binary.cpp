#include <iostream>
using namespace std;

void search(int arr[],int e,int l,int h)
{
if(l>h)
	cout<<"\nElement not found\n";
else
{

int m=(l+h)/2;

if(e==arr[m])
	cout<<"\nElement found\n";
else if(e<arr[m])
	search(arr,e,l,m-1);
else
	search(arr,e,m+1,h);	
}

}



int main(){

int a[20],n,s;
cout<<"Enter the element to be searched: ";
cin>>n;

for(int i=0; i<n; i++ ){
cin>>a[i];
}//for

for(int i=0; i<n; i++){
    for(int j=0;j<n-i-1;j++){
        if(a[j]>a[j+1]){
           int temp=a[j];
			a[j]=a[j+1];
			a[j+1]=temp;
}//if
}//for

}//for

cout<<"Enter the element to be searched: ";
cin>>s;

search(a,s,0,n-1);


}//main

