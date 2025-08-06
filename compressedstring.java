public class compressedstring {
    public static String compressedString(String str){
        StringBuilder sb= new StringBuilder("");
       
        for(int i=1;i<str.length()-1;i++){
            int count=1;
             sb.append(str.charAt(i));
            while(str.charAt(i-1)==str.charAt(i)){
                count++;
                i++;

            }
            sb.append(count);
        }
        return sb.toString();
    }

    public static void main(String args[]){
        String str="aaaabbbccddddd";
        System.out.println(compressedString(str));
    }
}
