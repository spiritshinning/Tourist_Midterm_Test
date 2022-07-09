package crawJena;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;

import java.io.*;
import java.util.Scanner;

import static crawJena.SaveTxtFile.que;

public class SaveFormFile  {
    public static void main(String args[]) throws IOException{
        GetQuery preQuery=new GetQuery();
        String location = preQuery.Relocation();
        ParameterizedSparqlString queryStr = preQuery.getQuery(que);
        Query query = queryStr.asQuery();
        QueryExecution x=QueryExecutionFactory.sparqlService(location,query);
        String pathName="src/fliesaved/";
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Name of file you want to save:");
        String text =sc.nextLine();
        File file = new File(pathName+text);
        file.createNewFile();
        OutputStream outputStream = new FileOutputStream(file);
        Model model=x.execConstruct();
        String dinhdang="TURTLE";
        model.write(outputStream, dinhdang);
    }
}