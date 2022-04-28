/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Yusuf
 */
public class Hw2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        informations[] patients=new informations[20];
        BufferedReader br = new BufferedReader(new FileReader("hw2.txt"));
        String[] asd=new String[20];
        String[] asdd;
        int i=0;
        int arrAy[]=new int[20];
        while(true){
            asd[i]=br.readLine();
            asdd=asd[i].split(" ");
            arrAy[i]=Integer.parseInt(asdd[0]);
            patients[i]=new informations();
            
            i++;
            if(i==20) break;
        }
        int heapsize=(arrAy.length/2);
        for(int j=heapsize;j>0;j--){
            heapify(arrAy,j);
        }
        int[] newArray = new int[20];
        int s=20;
        for(int k=0;k<arrAy.length;k++){
            newArray[k]=arrAy[0];
            arrAy[0]=arrAy[s-1];
            arrAy[s-1]=0;
            if(s==0) break;
            for(int f=s/2;f>0;f--){
                heapify(arrAy,f);
            }
            s--;
        }
        String[] newestArray=new String[7];
        int counter=0;
        for(int m=0;m<20;m++){
            for(int n=0;n<20;n++){
                if(asd[n]!=null){
                    if(newArray[m]==Integer.parseInt(asd[n].substring(0, 2))){
                        newestArray=asd[n].split(" ");
                        patients[m].setAge(Integer.parseInt(newestArray[0]));
                        patients[m].setName(newestArray[1]);
                        patients[m].setLastName(newestArray[2]);
                        patients[m].setProfession(newestArray[3]);
                        patients[m].setBloodType(newestArray[4]);
                        patients[m].setHeight(Integer.parseInt(newestArray[5]));
                        patients[m].setWeight(Integer.parseInt(newestArray[6]));
                        asd[n]=null;
                        n=20;
                    }
                }
            }
        }
        System.out.print("sea bozdum knk");
        for(int c=0;c<20;c++){
            System.out.print(patients[c].getAge()+" ");
            System.out.print(patients[c].getName()+" ");
            System.out.print(patients[c].getLastName()+" ");
            System.out.print(patients[c].getProfession()+" ");
            System.out.print(patients[c].getBloodType()+" ");
            System.out.print(patients[c].getHeight()+" ");
            System.out.print(patients[c].getWeight());
            System.out.println("");
        }
        
    }
    public static void heapify(int array[],int i){
        int l = i*2;
        int r = l+1;
        int largest;
        if(l <= array.length && array[l-1] >= array[i-1]){
            largest = l;
        }else{
            largest = i;
        }
        if(r <= array.length && array[r-1] > array[largest-1]){
            largest = r;
        }
        if(largest != i){
            int temp = array[i-1];
            array[i-1] = array[largest-1];
            array[largest-1] = temp;
            heapify(array, largest);
        }
    }
}
    
    

