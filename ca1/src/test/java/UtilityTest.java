import junit.framework.TestCase;

import java.io.FileNotFoundException;

public class UtilityTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
//        MyUser myUser=MyUser.getInstance();
    }

    public void tearDown() {
    }

    public void testGetDefultUser() {
        try {
            assertEquals("ali", new Utility().getDefultUser().getFirstName());
//            assertTrue(new Utility().getDefultUser().getFirstName().equals("ali"));

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }
}