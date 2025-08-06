
//perfect example of 1st DSA algorithm
public class trappedwater{
    public static void trappedwater(int height[]){


        //firstly we calculate left max boundary and make an array of that boundary
        int n = height.length;
        int leftmaxbound[]=new int[n];
        leftmaxbound[0]=height[0];
        for(int i=1;i<n;i++){
            leftmaxbound[i]=Math.max(height[i],leftmaxbound[i-1]);
        }


        //now we calculate right max boundary using another auxillary array
        int rightmaxbound[]=new int [n];
        rightmaxbound[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightmaxbound[i]=Math.max(height[i],rightmaxbound[i+1]);
        }

        //now applying formula to find totaltrapped water

        int width =1;
         int totaltrappedwater=0;
        for(int i=0;i<n;i++){
            int waterlevel=Math.min(rightmaxbound[i],leftmaxbound[i]);
            totaltrappedwater=totaltrappedwater+(waterlevel-height[i])*width;
        }
        System.out.println("the total trapped water is"+ totaltrappedwater);


        
    }
    public static void main(String args[]){
        int height[]={4,2,0,6,3,2,5};
        trappedwater(height);
    }


}
