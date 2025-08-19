package DSA.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class visitSubDomains {

    public List<String> subdomainVisits(String[] cpdomains) {

        String[] web;
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<cpdomains.length;i++){

            web = cpdomains[i].split(" ");

            String domains[] = web[1].split("\\.");

            String dom = domains[domains.length-1];

            if(map.containsKey(dom)){
                map.put(dom, map.get(dom) + Integer.valueOf(web[0]));
            }

            else{
                map.put(dom, Integer.valueOf(web[0]));
            }

            for(int j=domains.length-2;j>=0;j--){
                dom = domains[j] + "." + dom;

                if(map.containsKey(dom)){
                    map.put(dom, map.get(dom) + Integer.valueOf(web[0]));
                }

                else{
                    map.put(dom, Integer.valueOf(web[0]));
                }
            }
        }

        List<String> result = new ArrayList<>();

        for(String key: map.keySet()){
            result.add(String.valueOf(map.get(key)) + " "+ key);
        }

        return result;

    }

    public static void main(String[] args){
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        visitSubDomains v = new visitSubDomains();
        List<String> result = v.subdomainVisits(cpdomains);
    }
}
