package jmri.jmrix.powerline;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class SerialX10LightTest {

    @Test
    public void testCTor() {
        SerialTrafficController tc = new SerialTrafficController(){
            @Override
            public void sendSerialMessage(SerialMessage m,SerialListener reply) {
            }
        };
        SerialSystemConnectionMemo memo = new SerialSystemConnectionMemo();
        memo.setTrafficController(tc);
        tc.setAdapterMemo(memo);
        memo.setSerialAddress(new SerialAddress(memo));
        SerialX10Light t = new SerialX10Light("PLA1",tc);
        Assert.assertNotNull("exists",t);
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
    }

    @After
    public void tearDown() {
        JUnitUtil.clearShutDownManager(); // put in place because AbstractMRTrafficController implementing subclass was not terminated properly
        JUnitUtil.tearDown();

    }

    // private final static Logger log = LoggerFactory.getLogger(SerialX10LightTest.class);

}
