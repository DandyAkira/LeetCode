import java.util.Arrays;
import java.util.Comparator;

public class ReSortLog {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split(" ", 2);
                String[] split2 = o2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                if(!isDigit1 && !isDigit2){
                    int cmp = split1[1].compareTo(split2[1]);
                    if(cmp != 0){
                        return cmp;
                    }
                    else{
                        return split1[0].compareTo(split2[0]);
                    }
                }
                return isDigit1 ? (isDigit2 ? 0:1) : -1;
            }
        });
        return logs;
    }
}
