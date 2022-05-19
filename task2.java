import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//=====================================================================
class DictEntry2 {

    public int doc_freq = 0; // number of documents that contain the term
    public int term_freq = 0; //number of times the term is mentioned in the collection
    public HashSet<Integer> postingList;

    DictEntry2() {
        postingList = new HashSet<Integer>();
    }
}

//=====================================================================
class Index2 {
   
    HashSet<String>conc(String str)
    {
        String[] words = str.split("\\W+");
        HashSet<String> word=new HashSet<String>();
        for(String h:words)
        {
            word.add(h.toLowerCase());
        }
        return word;
    }
int And(HashSet<String> pL1, HashSet<String> pL2) {
    HashSet<String> answer = new HashSet();
        for (String x:pL1)
       {
        for (String y:pL2)
        {
            if(x.equals(y))
            answer.add(x);
        }
       }
        return answer.size();
    }     
    int OR(HashSet<String> pL1, HashSet<String> pL2) 
    {
        HashSet<String> answer = new HashSet<String>();
        for(String j:pL1)
{

    answer.add(j);
}
for(String i:pL2)
{

    answer.add(i);
}
            return answer.size();
    }

   float j (String x,String y) throws IOException
   {
       HashSet<String>a=conc(x.toLowerCase());
       HashSet<String>b=new HashSet<String>();
       BufferedReader reader = new BufferedReader(new FileReader(y));
       StringBuilder stringBuilder = new StringBuilder();
       String line = null;
       String ls = System.getProperty("line.separator");
       while ((line = reader.readLine()) != null) {
           stringBuilder.append(line);
           stringBuilder.append(ls);
       }
       stringBuilder.deleteCharAt(stringBuilder.length() - 1);
reader.close();
String content = stringBuilder.toString();
content=content.toLowerCase();
String[]r=content.split("\\W+");
for (String word : r) {
b.add(word);
}
        int q=And(a, b);
        int w=OR(a, b);
        float t=(float)q;
        float u=(float)w;
        float f=t/u;
return (float)(f);
   }
   
   public HashMap<String, Float>
    sortByValue(HashMap<String, Float> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Float> > list
            = new LinkedList<Map.Entry<String, Float> >(
                hm.entrySet());
 
        // Sort the list using lambda expression
        Collections.sort(
            list, (i2,i1) -> i1.getValue().compareTo(i2.getValue()));
 
        // put data from sorted list to hashmap
        HashMap<String, Float> temp
            = new LinkedHashMap<String, Float>();
        for (Map.Entry<String, Float> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
public static class InvertedIndex002 {
    public static void main(String args[]) throws IOException {
      try{ Index2 index = new Index2();
        HashMap<String, Float> hm = new HashMap<String, Float>(); 
               String x="ahmed is fun";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(("Enter query"));
            x = in.readLine();
           hm.put ("doc 1",(index.j(x,"C:\\Users\\modaser\\Desktop\\New folder (6)\\m,m,\\docs\\700.txt")));
           hm.put ("doc 2",(index.j(x,"C:\\Users\\modaser\\Desktop\\New folder (6)\\m,m,\\docs\\701.txt")));
           Map<String, Float> hm1 = index.sortByValue(hm);
           for (Entry<String, Float> en : hm1.entrySet()) {
          System.out.println(en.getKey()
                             + " : "
                             + en.getValue());
      }
    }
catch (Exception e) {
    System.out.println("Not found");
}
}
}
    }
