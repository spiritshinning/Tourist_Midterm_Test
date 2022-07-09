import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

import java.io.*;
import java.util.concurrent.TimeUnit;
public class Test {
    public static void main(String args[]) {
        ParameterizedSparqlString queryStr = new ParameterizedSparqlString();
        queryStr.setNsPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        queryStr.setNsPrefix("yago", "http://dbpedia.org/class/yago/");
        queryStr.setNsPrefix("dbp", "http://dbpedia.org/property/");
        queryStr.append("SELECT ?p");
        queryStr.append("{");
        queryStr.append("{?p rdf:type yago:WikicatVietnameseKings} ");
        queryStr.append("UNION ");
        queryStr.append("{?p rdf:type yago:WikicatVietnamesePoliticians}");
        queryStr.append("}");

        Query query = queryStr.asQuery();
        System.out.println(query);
        try (
                QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query)) {
            qexec.setTimeout(10000, TimeUnit.MILLISECONDS);
            ResultSet rs = qexec.execSelect();
            ResultSetFormatter.out(System.out, rs, query);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}