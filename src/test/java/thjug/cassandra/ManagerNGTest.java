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

import beforetest.EmbeddedCassandra;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 *
 * @author nuboat
 */
public class ManagerNGTest {

    @BeforeClass
    public void before() {
        assert EmbeddedCassandra.isStart();
    }

    @Test
    public void testGetInstance() {
        final Manager m = Manager.getInstance();
        assert m !=  null : "manager should not be null";
    }

    @Test
    public void testGetMeta() {
        final Manager m = Manager.getInstance();
        assert m.getMeta() !=  null : "meta should not be null";
    }

    @Test
    public void testCreateSession() {
        final Manager m = Manager.getInstance();
        assert m.createSession() !=  null : "session should not be null";
    }

    @Test
    public void testCreateSessionWithExistKeySpace() {
        final Manager m = Manager.getInstance();
        assert m.createSession("system") !=  null : "session should not be null";
    }
}
