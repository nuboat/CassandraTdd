/**
 * Copyright © 2015 Peerapat Asoktummarungsri.
 *
 * Attribution CC BY This license lets others distribute, remix, tweak, and
 * build upon your work, even commercially, as long as they credit you for the
 * original creation. This is the most accommodating of licenses offered.
 * Recommended for maximum dissemination and use of licensed materials.
 *
 * http://creativecommons.org/licenses/by/3.0/
 * http://creativecommons.org/licenses/by/3.0/legalcode
 */
package thjug.cassandra;

import beforetest.EmbeddedCassandra;
import beforetest.InitialKeyspace;
import com.datastax.driver.core.Row;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 *
 * @author pasoktummarungsri
 */
public class QueryNGTest {

    private static final Logger LOG = LoggerFactory.getLogger(QueryNGTest.class);

    @BeforeClass
    public void before() {
        assert EmbeddedCassandra.isStart();
		assert InitialKeyspace.verify();
    }

    @Test
    public void testQuerySystem() {
        final Query q = new Query("system");
        final List<Row> result = q.querySystem();

        assert result.isEmpty() == false : "result should not empty";

        result.forEach( r -> LOG.info("{}", r));
    }
	
	@Test
    public void testQueryThjug() {
        final Query q = new Query("thjug");
        final List<Row> result = q.query("SELECT * FROM hotels where id = '1';");

        assert result.isEmpty() == false : "result should not empty";
		
		final Row row = result.get(0);
		assert "Bangkok".equals(row.getString("city"));
		assert "Starwood".equals(row.getString("group"));
		assert "Sheraton".equals(row.getString("name"));
    }

}
