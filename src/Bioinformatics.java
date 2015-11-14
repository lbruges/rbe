/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author B106 PC-11
 */
public class Bioinformatics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int t= StringToInt("AAGGCCTT");
       System.out.println(t);
    }
    
    public static String InvertString(String SubStrings )
    {
        String result="";
        for(int i=0;i<SubStrings.length();i++)
            result += invertChar(SubStrings.charAt(i));
        return result;
    }
    public static char invertChar(char t)
    {
        switch(t)
        {
            case 'A':
                return 'T';
            case 'C':
                return 'G';
            case 'G':
                return 'C';
            case 'T':
                return 'A';
            default:
                return 'U';
        }
    }
    public static void Kammers(String ADN, int K)
    {
        int [] Results = new int[10000];
        //int Max= Integer.MIN_VALUE;
        for (int i = 0; i < ADN.length()-K ; i++) {
            String possibleKmer=ADN.substring(i,i+K);
            int W= StringToInt(possibleKmer);
            int Winv= StringToInt(InvertString(possibleKmer));
            
            Results[W]++;
            Results[Winv]++;
            
                    
        }
    }
    public static void SlowKammers(String ADN, int K)
    {
        HashMap<String,Integer> Results= new HashMap<>();
        int Max= Integer.MIN_VALUE;
        for (int i = 0; i < ADN.length()-K ; i++) {
            String possibleKmer=ADN.substring(i,i+K);
            if(Results.containsKey(possibleKmer))
            {
                Integer cuenta=Results.get(possibleKmer);
                cuenta++;
                if(cuenta>Max)
                {
                    Max= cuenta;
                }
                Results.put(possibleKmer,cuenta);
            }
            else
            {
                Results.put(possibleKmer,0);
            }
            possibleKmer= InvertString(possibleKmer);
            if(Results.containsKey(possibleKmer))
            {
                Integer cuenta=Results.get(possibleKmer);
                cuenta++;
                if(cuenta>Max)
                {
                    Max= cuenta;
                }
                Results.put(possibleKmer,cuenta);
            }
            else
            {
                Results.put(possibleKmer,0);
            }
            for (Map.Entry<String, Integer> entry : Results.entrySet()) {
                String cadena = entry.getKey();
                Integer cuenta = entry.getValue();
                if(cuenta == Max)
                    System.out.print(cadena+" ");
            }
            
        }
    }

    private static int StringToInt(String possibleKmer) {
         if(possibleKmer.length()==0)
             return 0;
        else if(possibleKmer.length()==1)
            return CharToInt(possibleKmer.charAt(0));
        else
        {
            String temp= possibleKmer.substring(0,possibleKmer.length()-1);
            return 4*StringToInt(temp)+CharToInt(possibleKmer.charAt(possibleKmer.length()-1));
        }
    }

    private static int CharToInt(char t) {
        switch(t)
        {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return -100;
        }
    }
}
