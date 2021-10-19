import java.util.ArrayList;
import java.util.List;

public class SumWindow {
    public static List<Integer> GetSumWin(int[] a, int k){
        if(a == null || a.length==0 || k<1){
            return null;
        }
        else{
            List<Integer> res = new ArrayList<>();
            if(k>a.length){
                int sum=0;
                for (int each:a) {
                    sum += each;
                }
                res.add(sum);
            }
            else{
                int count = 0;
                for(int i=0; i<a.length-k; i++){
                    int sum= 0;
                    while(count<k){
                        sum += a[i+count];
                        count++;
                    }
                    res.add(sum);
                    count=0;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,3,5,2,1,4,6};
         System.out.println(GetSumWin(a,3));
    }
}
