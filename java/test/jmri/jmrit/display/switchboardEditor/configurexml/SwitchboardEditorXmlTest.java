package jmri.jmrit.display.switchboardEditor.configurexml;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the SwitchboardEditorXml class
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class SwitchboardEditorXmlTest {

    @Test
    public void testCtor() {
        Assert.assertNotNull("SwitchboardEditorXml constructor", new SwitchboardEditorXml());
    }

    @Test
    public void testBeanSwitchXmlCtor() {
        BeanSwitchXml t = new BeanSwitchXml();
        Assert.assertNotNull("exists", t);
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
    }

    @After
    public void tearDown() {
        JUnitUtil.tearDown();
    }

}
