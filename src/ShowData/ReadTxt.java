package ShowData;
import crawJena.GetQuery;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;

import java.io.*;
import java.util.Scanner;

public class ReadTTL  {
    public static void main(String args[]) throws IOException{

       String pathName="D:\\20212\\midtermjava\\testjena\\src\\fliesaved\\";
       String text[] = new String[20];
        text[0]="festival.ttl";
        text[1]="food.ttl";
        text[2]="tourist.ttl";
        File file = new File(pathName+text[0]);
        String name=pathName+text[0];
        InputStream inputStream = new FileInputStream(file);
        Model model=ModelFactory.createDefaultModel();
        model.read(inputStream,null,"TTL");
    }
}