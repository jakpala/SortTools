// SortTools.java 
/*  
 * EE422C Project 1 submission by  
 * Replace <...> with your actual data.  
 * Joseph Akpala  
 * jfa442  
 * <5-digit Unique No.>  
 * Summer 2016  */

package assignment1;

//import java.util.Arrays;

/**
 * 
 *This is my first assignment
 * @author Joseph Akpala
 *
 */

public class SortTools {
	/**
	 * check if the array is sorted
	 * @param x input array
	 * @param n first elements of x array
	 * @return true if array is sorted. False if not
	 */

	public static boolean isSorted(int[] x, int n) {
		//if one of the cover cases is true, return false
		if(x.length==0 || x==null || n<=0 || n>x.length){
			return false;
		}		
		for(int i=0; i<n-1; i++){
			if(x[i]>x[i+1]){
				return false;
			}
		}		
		return true;
	} 	

	/**
	 * check if an integer v is in an array
	 * @param x input array
	 * @param v integer to look for
	 * @param n first elements of x array
	 * @return index of v in array
	 */

	public static int find(int[] x, int n, int v) {
		if(x.length==0 || x==null || n<=0 || n>x.length){
			return -1;
		}	
		for(int j=0; j<n; j++){
			if(x[j]==v){
				return j;
			}
		}
		return -1;
	} 	

	/**
	 * insert an integer v into a new array
	 * @param x input array
	 * @param v integer to insert
	 * @param n first elements of x array
	 * @return new array
	 */

	public static int[] insertGeneral(int[] x, int n, int v) {
		int[] newArray = new int[n+1];

		if(x.length==0 || x==null || n<=0 || n>x.length){
			newArray = x;
			return newArray;
		}
		for(int k=0;k<n;k++){//check if v is already in array
			if(x[k]==v){
				newArray = x;
				return newArray;
			}
		}
		int m =0;
		int l = 0;
		while(l<n){
			if(v>x[n-1]){
				newArray[n]=v; //length of new array is n+1, so to access last element its n+1-1=n
				break;
			}
			if(v<x[l]){
				newArray[m]=v;
				newArray[m+1]=x[l];
				m=m+2;
				l++;
				break;
			}
			else{
				newArray[m]=x[l];
				l++;
				m++;
			}
		}
		while(l<n){//fill in the rest of the array
			newArray[m]=x[l];
			m++;
			l++;
		}

		return newArray;
	} 	

	/**
	 * modify x to insert v in non decreasing order
	 * @param x input array
	 * @param v integer to insert
	 * @param n first elements of x array
	 * @return modified array x
	 */

	public static int insertInPlace(int[] x, int n, int v) {
		if(x.length==0 || x==null || n<=0 || n>x.length){
			return n;
		}
		for(int k=0;k<n;k++){//check to see if v is already in x array
			if(x[k]==v){
				return n;
			}
		}
		int temp1=0;
		int temp2=0;
		int l = 0;
		while(l<n){
			if(v>x[n-1]){//if v is >= last element than add to the end
				x[n]=v; //length of x is at least n+1, so the index of last element is n
				return n+1;
			}
			if(v<x[l]){
				temp1 = x[l]; //so to not lose previous element and add later
				x[l]=v;
				l++;
				break;		
			}
			l++;
		}
		while(l<n+1){ //add previous element to array as well as the rest
			temp2 = x[l];
			x[l]=temp1;
			temp1=temp2;
			l++;			
		}
		return n+1;
	} 	

	/**
	 * sort array in non decreasing order
	 * @param x input array
	 * @param n first elements of x array
	 * @return modified input array
	 */

	public static void insertSort(int[] x, int n) {
		int temp3;
		for(int i=0; i<n-1; i++){
			if(x[i]>x[i+1]){
				temp3 = x[i];
				x[i]=x[i+1];
				x[i+1]=temp3;
				insertSort(x,n);
			}
		}
	} 	

}