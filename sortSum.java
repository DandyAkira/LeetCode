import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sortSum {
    public static List<List<Integer>> groupSort(List<Integer> arr) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer num:arr){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }
            else{
                map.put(num, 1);
            }
        }
        int key, max;
        while(map.size()>0){
            key = -1;
            max = 0;
            for(Integer i:map.keySet()){
                if(map.get(i)>max){
                    key = i;
                    max = map.get(i);
                }
            }
            if(key != -1 && max != 0){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(key);
                tmp.add(map.remove(key));
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        System.out.println(groupSort(arr));
    }
}
