package com.sologile.stories;


import com.shazam.gwen.collaborators.Arranger;
import com.shazam.gwen.collaborators.Asserter;
import com.sologile.collaborators.TomatonDriver;
import com.sologile.tomaton.Tomaton;
import org.junit.After;
import org.junit.Test;

import java.awt.*;

import static com.shazam.gwen.Gwen.given;
import static com.shazam.gwen.Gwen.then;
import static junit.framework.TestCase.fail;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TomatonEndToEndTest {

    private final TomatonDriver driver = new TomatonDriver(1000);
    private final UserActor user = new UserActor();
    private final ApplicatonActor application = new ApplicatonActor();

    @After
    public void stopTheApplication() {
        driver.dispose();
    }

    @Test
    public void userSeesTheTimer() throws Exception {
        given(user).startsTheApplication();

        then(application).shouldHaveOpenedAWindow(Tomaton.APP_NAME);

        then(application).showsAWindowWithSize(800, 600);

        then(application).showsAPomodoroTimer();

    }

    private class UserActor implements Arranger {
        public void startsTheApplication() {
            try {
                Tomaton.main(new String[]{});
            } catch (Exception e) {
                fail(e.getMessage());
            }
        }

        public void closesTheApplication() {
            driver.clickClose();
        }
    }

    private class ApplicatonActor implements Asserter {
        public void shouldHaveOpenedAWindow(String windowTitle) {
            driver.mainWindowIsOpened(windowTitle);
        }

        public void closesWindow(String windowName) {

        }

        public void showsAWindowWithSize(int width, int height) {
            Dimension size = driver.component().component().getSize();
            assertThat(size.getHeight(), is((double)height));
            assertThat(size.getWidth(), is((double) width));
        }

        public void showsAPomodoroTimer() {


        }
    }


}
