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
package thjug.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.Session;


/**
 *
 * @author nuboat
 */
public class Manager {

    private static final Manager manager = new Manager();

    private final Cluster cluster;

    public Manager() {
        final PoolingOptions poolingOptions = new PoolingOptions();

        cluster = Cluster.builder()
                .addContactPoints(new String[] {"localhost"})
                .withPort(9142)
                .withPoolingOptions(poolingOptions)
                .build();
    }

    public static Manager getInstance() {
        return manager;
    }

    public Metadata getMeta() {
        return cluster.getMetadata();
    }

    public void close() {
        cluster.close();
    }

    public Session createSession() {
        return cluster.connect();
    }

    public Session createSession(final String keyspace) {
        return cluster.connect(keyspace);
    }

}
