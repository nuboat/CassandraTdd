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

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;
import java.util.List;


/**
 *
 * @author pasoktummarungsri
 */
public class Query {

    private static final String LOCAL = "SELECT * FROM local;";

    public List<Row> querySystem() {
        final Statement stmt = new SimpleStatement(LOCAL);
        stmt.setConsistencyLevel(ConsistencyLevel.ONE);

        final Session s = Manager.getInstance().createSession("system");
        final ResultSet r = s.execute(stmt);

        return r.all();
    }

}
