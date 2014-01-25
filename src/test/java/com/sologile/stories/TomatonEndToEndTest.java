package com.sologile.stories;


import com.shazam.gwen.collaborators.Actor;
import com.shazam.gwen.collaborators.Asserter;
import org.junit.Test;

import static com.shazam.gwen.Gwen.then;
import static com.shazam.gwen.Gwen.when;

public class TomatonEndToEndTest {

    @Test
    public void opensApplicatonsAndCloses() throws Exception {

        UserActor user = new UserActor();
        ApplicatonActor application = new ApplicatonActor();

        when(user).startsTheApplication();

        then(application).shouldHaveOpenedAWindow("Tomaton");

        when(user).closesTheApplication();

        then(application).closesWindow("Tomaton");

    }

    private class UserActor implements Actor {
        public void startsTheApplication() {

        }

        public void closesTheApplication() {

        }
    }

    private class ApplicatonActor implements Asserter {
        public void shouldHaveOpenedAWindow(String windowTitle) {

        }

        public void closesWindow(String windowName) {

        }
    }
}
