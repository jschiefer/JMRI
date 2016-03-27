package jmri.jmrit.display.layoutEditor;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import jmri.util.JUnitUtil;

/**
 * Test simple functioning of LayoutEditorAuxTools
 *
 * @author	Paul Bender Copyright (C) 2016
 */
public class LayoutEditorAuxToolsTest extends TestCase {

    public void testCtor() {
        LayoutEditorAuxTools  t = new LayoutEditorAuxTools(new LayoutEditor());
        Assert.assertNotNull("exists", t );
    }

    // from here down is testing infrastructure
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        apps.tests.Log4JFixture.setUp();
        // dispose of the single PanelMenu instance
        jmri.jmrit.display.PanelMenu.instance().dispose();
        // reset the instance manager.
        JUnitUtil.resetInstanceManager();
    }
 
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        // dispose of the single PanelMenu instance
        jmri.jmrit.display.PanelMenu.instance().dispose();
        JUnitUtil.resetInstanceManager();
        apps.tests.Log4JFixture.tearDown();
    }

    public LayoutEditorAuxToolsTest(String s) {
        super(s);
    }

    // Main entry point
    static public void main(String[] args) {
        String[] testCaseName = {"-noloading", LayoutEditorAuxToolsTest.class.getName()};
        junit.swingui.TestRunner.main(testCaseName);
    }

    // test suite from all defined tests
    public static Test suite() {
        TestSuite suite = new TestSuite(LayoutEditorAuxToolsTest.class);
        return suite;
    }

}