package ShowData;

import crawJena.CrawRDF;
import crawJena.GetResultSet;
import org.apache.jena.query.ResultSet;

public class TouristD implements PrintData {
    private int selectQuery=0;
    public void setSelectQuery(int qu)
    {
        this.selectQuery=qu;
    }

    private GetResultSet resultset = new GetResultSet(selectQuery);
    public TouristD(int selectQuery) {
        this.selectQuery=selectQuery;
        this.resultset= new GetResultSet(selectQuery);
    }
    public TouristD() {
    }

    private ResultSet results = resultset.GetSet();
    private CrawRDF Dataget = new CrawRDF();
    private String[][] Datatourism = Dataget.Craw(results);
    private int dem=Dataget.Craw(results,0);
    private int sizes=Dataget.Craw(results,0,0);

    public int getDem() {
        return dem;
    }

    public int getSizes() {
        return sizes;
    }
    public String[][] getDatatourism()
    {
        return this.Datatourism;
    }
    public String[] ReturnData(int d)
    {
        String[] Image = new String[100];
        for(int i=0;i<dem;i++)Image[i]=this.Datatourism[i][d-1];
        return Image;
    }
    @Override
     public void PrintData() {
        for(int i=0;i<this.dem;i++)
        {
            for(int j=0;j<this.sizes;j++)
                System.out.print(this.Datatourism[i][j]+'\n');
            System.out.print("\n");
        }
    }
}