package org.moon.figura_custom_api;

import org.moon.figura.trust.FiguraTrust;
import org.moon.figura.trust.Trust;

import java.util.Collection;
import java.util.List;

public class TestTrust implements FiguraTrust {

    /**
     * the title used to label this section
     */
    @Override
    public String getTitle() {
        return "The Test";
    }

    /**
     * a list with the all trusts to be added
     */
    @Override
    public Collection<Trust> getTrusts() {
        return List.of(
                new Trust("Slider", 0, 100, 0, 0, 100, 100,100), //normal slider
                new Trust("Step", 0, 100, 20, 0, 25, 50, 75, 100), //stepped slider
                new Trust("Toggle", 0, 0, 1, 1, 1) //toggle
        );
    }
}
