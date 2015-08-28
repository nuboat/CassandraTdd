/**
 * Copyright © 2015 Peerapat Asoktummarungsri.
 *
 * Attribution
 * CC BY
 * This license lets others distribute, remix, tweak,
 * and build upon your work, even commercially,
 * as long as they credit you for the original creation.
 * This is the most accommodating of licenses offered.
 * Recommended for maximum dissemination and use of licensed materials.
 *
 * http://creativecommons.org/licenses/by/3.0/
 * http://creativecommons.org/licenses/by/3.0/legalcode
 */
package beforetest;

import java.io.IOException;
import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author nuboat
 */
public class EmbeddedCassandra {

    private static final Logger log = LoggerFactory.getLogger("meta");

    private static boolean isStart;

    private static final EmbeddedCassandra em = new EmbeddedCassandra();

    private EmbeddedCassandra() {
        try {
            EmbeddedCassandraServerHelper.startEmbeddedCassandra("cassandra.yaml");
            isStart = true;
        } catch(final TTransportException | IOException |
                ConfigurationException ex) {
            isStart = false;
            log.error(ex.getMessage(), ex);
        }
    }

    public static boolean isStart() {
        return isStart;
    }
}
