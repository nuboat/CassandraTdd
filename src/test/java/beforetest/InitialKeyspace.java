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
package beforetest;

import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thjug.cassandra.Manager;

/**
 *
 * @author nuboat
 */
public class InitialKeyspace {
	
    private static final Logger LOG = LoggerFactory.getLogger("meta");

    private static final InitialKeyspace KEYSPACE = new InitialKeyspace();
	
	public static boolean verify() {
		return KEYSPACE != null;
	}
	
    private InitialKeyspace() {
        final Manager m = Manager.getInstance();
        final Session system = m.createSession();
        try {
            system.execute("CREATE KEYSPACE thjug\n"
                + " WITH replication = {\n"
                + "	'class' : 'SimpleStrategy',\n"
                + "	'replication_factor' : 1\n"
                + " };");
			
			final Session thjug = m.createSession("thjug");
			thjug.execute("CREATE TABLE hotels (\n"
				+ "	id text,\n"
				+ "	group text,\n"
				+ "	name text,\n"
				+ "	city text,\n"
				+ "	PRIMARY KEY (id)\n"
				+ ");");
			
			thjug.execute("insert into hotels (id, city, group, name) values \n"
				+ " ('1', 'Bangkok', 'Starwood', 'Sheraton');");
        } catch (final RuntimeException ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }

}
