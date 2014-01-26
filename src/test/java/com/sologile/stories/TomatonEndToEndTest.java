package com.sologile.stories;


import com.shazam.gwen.collaborators.Actor;
import com.shazam.gwen.collaborators.Arranger;
import com.shazam.gwen.collaborators.Asserter;
import com.sologile.collaborators.TomatonDriver;
import com.sologile.tomaton.Tomaton;
import org.junit.After;
import org.junit.Test;

import java.awt.*;

import static com.shazam.gwen.Gwen.*;
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
        then(application).showsAPomodoroTimerAndAButton();
    }

    @Test
    public void canStartTheTimer() throws Exception {
        given(user).startsTheApplication();
        given(application).showsAPomodoroTimerAndAButton();

        when(user).clicksStartPomodoroButton();

        then(application).willStartCountingDownTheTimer();

    }

    @Test
    public void canCreateNewActivity() throws Exception {
        given(user).startsTheApplication();
        given(application).showsFieldForAddingNewActivities();

        when(user).insertsNewActivity("Activity text");
        when(user).clicksAddActivity();

        then(application).showsActivityInActivityList();

    }

    private class UserActor implements Arranger, Actor {
        public void startsTheApplication() {
            try {
                Tomaton.main(new String[]{});
            } catch (Exception e) {
                fail(e.getMessage());
            }
        }

        public void clicksStartPomodoroButton() {
            driver.clickButton("startPomodoro");
        }

        public void insertsNewActivity(String activityDescription) {
            driver.writeToTextField("newActivity", activityDescription);
        }

        public void clicksAddActivity() {
            driver.clickButton("addActivity");
        }
    }

    private class ApplicatonActor implements Asserter, Actor, Arranger {
        public void shouldHaveOpenedAWindow(String windowTitle) {
            driver.mainWindowIsOpened(windowTitle);
        }


        public void showsAWindowWithSize(int width, int height) {
            Dimension size = driver.component().component().getSize();
            assertThat(size.getHeight(), is((double)height));
            assertThat(size.getWidth(), is((double) width));
        }

        public void showsAPomodoroTimerAndAButton() {
            driver.hasTimerWithTime("25:00");
            driver.hasStartPomodoroButton("startPomodoro");
        }

        public void willStartCountingDownTheTimer() throws InterruptedException {
            driver.hasTimerWithTime("25:00");
            Thread.sleep(500);
            driver.hasTimerWithTime("25:00");
            Thread.sleep(1000);
            driver.hasTimerWithTime("24:59");
            Thread.sleep(1000);
            driver.hasTimerWithTime("24:58");
        }

        public void showsFieldForAddingNewActivities() {
            driver.showsActivityList();

        }

        public void showsActivityInActivityList() {
            driver.createsNewRowInActivityTable("Activity text");
        }
    }


}
