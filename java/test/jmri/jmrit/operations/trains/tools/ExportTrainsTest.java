package jmri.jmrit.operations.trains.tools;

import java.awt.GraphicsEnvironment;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import jmri.InstanceManager;
import jmri.jmrit.operations.OperationsTestCase;
import jmri.jmrit.operations.trains.Train;
import jmri.jmrit.operations.trains.TrainManager;
import jmri.util.JUnitOperationsUtil;
import jmri.util.swing.JemmyUtil;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class ExportTrainsTest extends OperationsTestCase {

    @Test
    public void testCTor() {
        ExportTrains t = new ExportTrains();
        Assert.assertNotNull("exists", t);
    }

    @Test
    public void testCreateFile() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        ExportTrains exportTrains = new ExportTrains();
        Assert.assertNotNull("exists", exportTrains);

        JUnitOperationsUtil.initOperationsData();
        
        // built trains increase coverage
        TrainManager tmanager = InstanceManager.getDefault(TrainManager.class);
        Train train = tmanager.getTrainByName("STF");
        Assert.assertTrue(train.build());

        // next should cause export complete dialog to appear
        Thread export = new Thread(new Runnable() {
            @Override
            public void run() {
                exportTrains.writeOperationsTrainsFile();
            }
        });
        export.setName("Export Trains"); // NOI18N
        export.start();

        jmri.util.JUnitUtil.waitFor(() -> {
            return export.getState().equals(Thread.State.WAITING);
        }, "wait for prompt");

        JemmyUtil.pressDialogButton(Bundle.getMessage("ExportComplete"), Bundle.getMessage("ButtonOK"));

        java.io.File file = new java.io.File(ExportTrains.defaultOperationsFilename());
        Assert.assertTrue("Confirm file creation", file.exists());
        
        JUnitOperationsUtil.checkOperationsShutDownTask();
        JUnitOperationsUtil.checkIdTagsShutDownTask();
    }

    // private final static Logger log = LoggerFactory.getLogger(ExportTrainsTest.class);

}
