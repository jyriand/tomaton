package com.sologile.stories;


import com.shazam.gwen.collaborators.Actor;
import com.shazam.gwen.collaborators.Asserter;
import com.sologile.collaborators.TomatonDriver;
import com.sologile.tomaton.Tomaton;
import org.junit.Test;

import static com.shazam.gwen.Gwen.then;
import static com.shazam.gwen.Gwen.when;
import static junit.framework.TestCase.fail;

public class TomatonEndToEndTest {

    private TomatonDriver driver;

    @Test
    public void opensApplicatonsAndCloses() throws Exception {

        UserActor user = new UserActor();
        ApplicatonActor application = new ApplicatonActor();

        when(user).startsTheApplication();

        then(application).shouldHaveOpenedAWindow(Tomaton.APP_NAME);

        when(user).closesTheApplication();

        then(application).closesWindow(Tomaton.APP_NAME);

    }

    private class UserActor implements Actor {
        public void startsTheApplication() {
            try {
                Tomaton.main(new String[]{});
            } catch (Exception e) {
                fail(e.getMessage());
            }
        }

        public void closesTheApplication() {

        }
    }

    private class ApplicatonActor implements Asserter {
        public void shouldHaveOpenedAWindow(String windowTitle) {
            driver = new TomatonDriver(1000);

            driver.mainWindowIsOpened(windowTitle);
        }

        public void closesWindow(String windowName) {

        }
    }


}
