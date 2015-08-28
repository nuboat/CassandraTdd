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
    private static final Logger log = LoggerFactory.getLogger("meta");

    private static final InitialKeyspace k = new InitialKeyspace();

    private boolean status = false;

    private InitialKeyspace() {
        final Manager m = Manager.getInstance();
        final Session s = m.createSession();
        try {
            s.execute("CREATE KEYSPACE prsley\n"
                + " WITH replication = {\n"
                + "	'class' : 'SimpleStrategy',\n"
                + "	'replication_factor' : 1\n"
                + " };");
            status = true;
        } catch (final RuntimeException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    public static boolean verify() {
        return k.status;
    }

}
