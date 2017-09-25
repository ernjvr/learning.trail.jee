/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citymanagerweb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author admin
 */
public abstract class SeedServlet extends HttpServlet {
    
    protected String prepareResponseMessage() {
        final StringBuilder msg = new StringBuilder().append("<html><body>");
        msg.append(String.format("Attribute Retrieved Value: %s<br/>", getServletContext().getAttribute("currentSeedValue")));
        raiseCurrentSeedByFactorOf(2);
        sleepFor(5000);
        msg.append(String.format("Attribute Retrieved Value After Process: %s<br/>", getServletContext().getAttribute("currentSeedValue")));
        msg.append("</html><body>");
        return msg.toString();
    }

    protected void raiseCurrentSeedByFactorOf(final int factor) {
        final int currentSeed = (int) getServletContext().getAttribute("currentSeedValue");
        getServletContext().setAttribute("currentSeedValue", currentSeed * factor);
    }

    protected void sleepFor(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(NonThreadSafeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
