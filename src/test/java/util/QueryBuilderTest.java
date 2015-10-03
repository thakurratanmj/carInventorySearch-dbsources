package util;

import com.querybuilder.QueryBuilder;
import com.util.Pair;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjtsingh on 10/3/2015.
 */

public class QueryBuilderTest {

    public static QueryBuilder queryBuilder = new QueryBuilder("test");
    @Test
    public void testSelect()
    {
        queryBuilder.clearQuery();
        queryBuilder.selectAll();
        Assert.assertEquals("SELECT * FROM test ", queryBuilder.getQueryString());
    }

    @Test
    public void testAndWhere()
    {
        queryBuilder.clearQuery();
        List<Pair> whereList = new ArrayList<Pair>();
        Pair<String,String> keyValue = new Pair<String, String>("col","val");
        Pair<String,Number> keyValueNumber = new Pair<String, Number>("col", 20);
        whereList.add(keyValue);
        whereList.add(keyValueNumber);
        queryBuilder.where(whereList, true);
        Assert.assertEquals("WHERE col='val' AND col=20", queryBuilder.getQueryString());
    }

    @Test
    public void testOrWhere()
    {
        queryBuilder.clearQuery();
        List<Pair> whereList = new ArrayList<Pair>();
        Pair<String,String> keyValue = new Pair<String, String>("col","val");
        Pair<String,Number> keyValueNumber = new Pair<String, Number>("col", 20);
        whereList.add(keyValue);
        whereList.add(keyValueNumber);
        queryBuilder.where(whereList, false);
        Assert.assertEquals("WHERE col='val' OR col=20", queryBuilder.getQueryString());
    }

    @Test
    public void fullLengthQuery()
    {
        queryBuilder.clearQuery();
        List<Pair> whereList = new ArrayList<Pair>();
        Pair<String,String> keyValue = new Pair<String, String>("col","val");
        Pair<String,Number> keyValueNumber = new Pair<String, Number>("col", 20);
        whereList.add(keyValue);
        whereList.add(keyValueNumber);
        Assert.assertEquals("SELECT * FROM test WHERE col='val' AND col=20", queryBuilder.selectAll()
                .where(whereList, true).getQueryString());
    }
}
