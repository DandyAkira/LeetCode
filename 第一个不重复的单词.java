import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

//class First_No_Repeat_Word{
//    public static String firstWord(final Stream input) {
//        char c; //current char of input stream
//        StringBuilder sb = new StringBuilder();
//        String word;
//        Set<String> linkedHashSet = new LinkedHashSet<String>();
//        Set<String> duplicateWords = new HashSet<String>(); //handle the case triple duplicate "the the the"
//
//        while (input.hasNext()) {
//            c = input.getNext();
//            switch (c) {
//                //The chars to specify the end of word are ' ' and '.'
//                case ' ':
//                case '.':
//                    //NOTE: need to convert to lower case, else the
//                    //      sample stream will return "The" instead of "dog"
//                    word = sb.toString().toLowerCase();
//                    if (linkedHashSet.contains(word)) {
//                        linkedHashSet.remove(word);
//                        duplicateWords.add(word);
//                    } else if (!duplicateWords.contains(word)) {
//                        linkedHashSet.add(word);
//                    }
//
//                    //Reset StringBuilder to accept the next word.
//                    sb.setLength(0);
//                    break;
//                default:
//                    sb.append(c);
//            }
//        }
//
//        if (linkedHashSet.isEmpty()) {
//            return "";
//        } else {
//            return linkedHashSet.iterator().next();
//        }
//    }
//}