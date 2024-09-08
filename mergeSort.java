public class mergeSort{
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void MergeSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si+ (ei-si)/2;
        MergeSort(arr, si, mid); //for left side
        MergeSort(arr,  mid+1,ei);      //for right side 

        Merge(arr, si, mid, ei);
    }

    public static void Merge(int arr[], int si, int mid, int ei){
        int temp[]= new int[ei-si+1];
        int i=si; //iterator for left side
        int j=mid+1; // iterator for right side 
        int k=0; // iterator for temp arr

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        // for left part
        while(i<=mid){
            temp[k++]=arr[i++];
        }

        //for right
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        //copy temp array to original
        
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[]={6,3,9,5,2,8};
        MergeSort(arr,0,arr.length-1);
        printArr(arr);
    }
}