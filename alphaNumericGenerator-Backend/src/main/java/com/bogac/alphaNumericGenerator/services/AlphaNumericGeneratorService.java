package com.bogac.alphaNumericGenerator.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AlphaNumericGeneratorService {

    static HashMap<Character, char[]> letterMappings  = new HashMap<Character, char[]>();
    ArrayList<String> results = new ArrayList<String>();

    AlphaNumericGeneratorService() {
        letterMappings.put('0', new char[]{'0'});
        letterMappings.put('1', new char[]{'1'});
        letterMappings.put('2', new char[]{'a','b','c'});
        letterMappings.put('3', new char[]{'d','e','f'});
        letterMappings.put('4', new char[]{'g','h','i'});
        letterMappings.put('5', new char[]{'j','k','l'});
        letterMappings.put('6', new char[]{'m','n','o'});
        letterMappings.put('7', new char[]{'p','q','r','s'});
        letterMappings.put('8', new char[]{'t','u','v'});
        letterMappings.put('9', new char[]{'w','x','y','z'});
    }

    public ArrayList<String> generateCombos(String digits){

        results.clear();

        if(digits == null||digits.length() == 0){
            return results;
        }
        helper(results,digits,0);

        return results;
    }

    private void helper(List<String> results, String digits, int index) {
        char[] alpha = new char[5];
        for (int i = index; i < digits.length(); i++) {
            String change = "";
            alpha = letterMappings.get(digits.charAt(i));

            if (alpha != null) {
                for (int idx_alpha = 0; idx_alpha < alpha.length; idx_alpha++) {// a, b, c
                    change = digits.substring(0, i) + alpha[idx_alpha] + digits.substring(i + 1);

                    //System.out.println(results.size());
                    if (!results.contains(change))
                        results.add(change);
                    helper(results, change, i + 1);
                }
            }
        }
    }
}
