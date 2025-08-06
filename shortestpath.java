public class shortestpath{
    public static void shortpath( String str){
        int a=0,b=0,x=0,y=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='N'){
                y=y+1;
            }else if (str.charAt(i)=='S'){
                y=y-1;
            }else if(str.charAt(i)=='E'){
                x=x-1;
            }else{
                x=x+1;         //for west
            }
        }
        float displacement=(float)Math.sqrt(Math.pow(x-a,2)+Math.pow(y-b,2));
        System.out.println(displacement);
        return;
    }



    public static void main (String args[]){
        String str="WNEENESENNN";
        shortpath(str);
    }
}