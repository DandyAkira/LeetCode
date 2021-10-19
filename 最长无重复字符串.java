import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
class LongestStringWithNoRepeat {
    public static int LengthofLongestString(String s){
        int res = 0;
        int end = -1;
        HashSet<Character> str = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            while(end<s.length() - 1){
                if(!str.contains(s.charAt(end+1))){
                    str.add(s.charAt(end+1));
                    end ++;
                }
                else{
                    break;
                }
            }
            if(str.size() > res){
                res = str.size();
            }
            str.remove(s.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "asdfdsa";
        System.out.println(LengthofLongestString(s));
        int[] a = new int[]{1,2,3};
        Arrays.sort(a);
    }
}
