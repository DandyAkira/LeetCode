import java.util.ArrayList;

public class ZString {
    public static String GetZString(String a, int n){
        ArrayList<Character> res = new ArrayList<>();
        int p=0, j;
        if(n>2){
            while(p<n){
                j = p;
                if(p==0 || p==n-1){
                    while(j<a.length()){
                        res.add(a.charAt(j));
                        j += (2*n-2);
                    }
                }
                else{
                    while(j<a.length()){
                        res.add(a.charAt(j));
                        j += 2*(n-p-1);
                        if(j<a.length()){
                            res.add(a.charAt(j));
                            j += 2*p;
                        }
                        else{
                            break;
                        }
                    }
                }
                p++;
            }
        }
        else{
            if(n==1){
                return a;
            }
            else{
                for(int i=0; i<a.length(); i+=2){
                    res.add(a.charAt(i));
                }
                for(int i=1; i<a.length(); i+=2){
                    res.add(a.charAt(i));
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(Character s:res){
            result.append(s);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String a = "PAYPALISHIRING";
        System.out.println(GetZString(a,3));
    }
}
