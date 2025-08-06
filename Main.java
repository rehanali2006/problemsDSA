import java.util.*;
public class Main {

    // public static void activitySelection(int start[],int end[]){
    //     ArrayList<Integer> list=new ArrayList<>();
    //     int maxAct=0;
    //     //selecting first acitvity
    //     list.add(0);
    //     maxAct=1;
    //     int endLast=end[0];
    //     for(int i=1;i<start.length;i++){
    //         if(endLast<=start[i]){
    //             list.add(i);
    //             endLast=end[i];
    //             maxAct++;
    //         }
    //     }
    //     System.out.println("the max number of activities are" + maxAct);
    //     for(int i=0;i<list.size();i++){
    //         System.out.println("A" + list.get(i));
    //     }
    // }








    // public static void indianCoins(int remAmt){
    //     ArrayList<Integer>list=new ArrayList<>();
    //     int coins[]={1,2,5,10,20,50,100,200,500,2000};
    //     int minCoinsreq=0;
    //     int i;
    //     for( i=coins.length-1;i>=0;i--){
    //         while(coins[i]<=remAmt){
    //             remAmt -= coins[i];
    //             minCoinsreq++;
    //             list.add(coins[i]);
    //         }
    //     }
    //     System.out.println("min no of coins req is" + minCoinsreq);
    //     for( i=0;i<list.size();i++){
    //         System.out.println(list.get(i));
    //     }
    // }


    public static void chocola(Integer horcuts[],Integer vercuts[]){
        Arrays.sort(horcuts,Collections.reverseOrder());
        Arrays.sort(vercuts,Collections.reverseOrder());
        int i=0;
        int j=0;
        int vp=1;
        int hp=1;
        int cost=0;
        while(i<horcuts.length && j< vercuts.length){
            if(horcuts[i]<vercuts[j]){
                //vertical choice
                cost += (vercuts[j]*hp);
                j++;
                vp++;
            }
            else{
                //horizontal choice
                cost += (horcuts[i]*vp);
                i++;
                hp++;
            }
        }
        while(i<horcuts.length){
            cost += (horcuts[i]*vp);
                i++;
                hp++;
        }
        while(j<vercuts.length){
            cost += (vercuts[j]*hp);
            j++;
            vp++;
        }

        System.out.println("the total cost is" + cost);

    }
    public static void main(String[] args){
        Integer horcuts[]={2,1,3,1,4};
        Integer vercuts[]={4,1,2};
        chocola(horcuts, vercuts);
        
    }

}
