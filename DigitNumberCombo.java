import java.util.*;

public class DigitNumberCombo {
    public static List<String> GetDigitCombo(String digits){
        List<String> res = new ArrayList<>();
        if(digits.length() != 0){
            HashMap<Character,String> phonetable = new HashMap<>();
            phonetable.put('2', "abc");
            phonetable.put('3',"def");
            phonetable.put('4',"ghi");
            phonetable.put('5',"jkl");
            phonetable.put('6',"mno");
            phonetable.put('7',"pqrs");
            phonetable.put('8',"tuv");
            phonetable.put('9',"wxyz");
            for(int x=0; x<phonetable.get(digits.charAt(0)).length();x++){
                res.add(String.valueOf(phonetable.get(digits.charAt(0)).charAt(x)));
            }
            for (int i = 1; i < digits.length(); i++) {
                for (int j = 0; j < res.size(); j++) {
                    StringBuilder temp = new StringBuilder(String.valueOf(res.remove(0)));
                    for (int k=0; k<phonetable.get(digits.charAt(i)).length(); k++){
                        temp.append(phonetable.get(digits.charAt(i)).charAt(k));
                        res.add(String.valueOf(temp));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(GetDigitCombo("23456"));
    }
}
