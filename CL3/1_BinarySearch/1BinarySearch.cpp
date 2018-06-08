
#include<iostream>
#include"stdio.h"
using namespace std;

void Binary_Search(int arr[],int num,int first,int last)
{
   if(first>last)
   {
      cout<<"\nElement not Found!!\n";
   }
   else
   {
      int mid;
      /*Calculate mid element*/
      mid=(first+last)/2;

      if(arr[mid]==num)
      {
	  cout<<"\nElement found at index:"<<mid+1<<"\n";
      }
      else if(arr[mid]>num)
      {
	  Binary_Search(arr,num,first,mid-1);
      }
      else
      {
	  Binary_Search(arr,num,mid+1,last);
      }
   }
}

int main()
{
   int arr[100],beg,mid,end,num,i,j,n,temp;
   cout<<"\nEnter size of array:";
   cin>>n;

   cout<<"\nEnter Unsorted array:";
   for(i=0;i<n;i++)
    {
       cin>>arr[i];	
    }
    for(i=0;i<n;i++)             // Loop for Pass
     {
       for(j=i+1;j<n;j++)
	{
	   if(arr[i]>arr[j])
	   {
	     temp=arr[i];                      // Interchange Values
	     arr[i]=arr[j];
	     arr[j]=temp;
	   }
	}

     }
     cout<<"\nArray after sorting:\n";
     for(i=0;i<n;i++)
     {
	cout<<arr[i]<<"\t";
     }
     beg=0;
     end=n-1;
     cout<<"\nEnter a value to be search:";
     cin>>num;

     Binary_Search(arr,num,beg,end);
     return(0);
}

/*
OUTPUT-abhishek@abhishek-HP-Notebook:~$ gedit 1BinarySearch.cpp
abhishek@abhishek-HP-Notebook:~$ g++ 1BinarySearch.cpp
abhishek@abhishek-HP-Notebook:~$ ./a.out

Enter size of array:5

Enter Unsorted array:4 1 8 2 3

Array after sorting:
1	2	3	4	8	
Enter a value to be search:3

Element found at index:3
abhishek@abhishek-HP-Notebook:~$ ./a.out

Enter size of array:3

Enter Unsorted array:2 1 5

Array after sorting:
1	2	5	
Enter a value to be search:3  */
