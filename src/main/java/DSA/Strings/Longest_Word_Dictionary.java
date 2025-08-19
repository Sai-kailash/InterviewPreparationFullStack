package DSA.Strings;

import java.util.Arrays;

public class Longest_Word_Dictionary {

    public String longestWord(String[] words) {

        Arrays.sort(words);
        String result = "";

        for(String word: words){
            System.out.println(word);
        }

        int pos = getStringEquals1(words, 0);

        if(pos == -1){return ""; }

        int i=pos;
        char ch = words[pos].charAt(0);
        int index_1 = i;
        while(i<words.length){

            if(i>0 && words[i].charAt(0) != words[i-1].charAt(0)){
                i = getStringEquals1(words, i);

                if(i == -1){ break; }
            }

            if(words[i].length() == 1){
                ch = words[i].charAt(0);
                index_1 = i;
                i++;
                continue;
            }

            if(words[i].length() > result.length()){

                int count = 1;
                String prev = "" + ch;
                for(int j=index_1+1;j<i;j++){

                    if(words[j].startsWith(prev) && (words[j].length() - prev.length() == 1)){
                        prev = words[j];
                        count++;
                    }
                }

                if(count == words[i].length()-1){
                    i++;
                    while(i<words.length && words[i].length() - result.length() == 1){
                        if(words[i].startsWith(result)){
                            result = words[i];
                            i++;
                        }
                    }
                }

                else{
                    i++;
                }

            }

            else{
                i++;
            }
        }

        return result;
    }

    private int getStringEquals1(String[] words, int start){
        for(int i=start;i<words.length;i++){
            if(words[i].length() == 1){
                return i;
            }
        }
        return -1;
    }
}
