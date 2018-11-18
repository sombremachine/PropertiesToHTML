package myPackage.view;

import myPackage.bean.User;
import org.apache.log4j.helpers.LogLog;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static myPackage.bean.UserUtils.getTestUser;
@Ignore
public class ViewTest {
    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @BeforeClass
    public static void disableLogging(){
        LogLog.setQuietMode(true);
    }

    @Test
    public void testViewNoError() throws IOException {
        File outFile= folder.newFile("tmp.html");
        View view = new ViewToHTMLImpl(outFile.toString());
        User user = getTestUser();
        view.update(user);
    }
}
