package com.dgmarkt.pages;


import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;




public class EditAccountPage extends BasePage {
}




        }else if (message.contains("valid")) {BrowserUtils.waitFor(2);
            actualMessage2 = emailRedWarningMessage.getText();
            System.out.println("actualMessage = " + actualMessage2);
            assertTrue(actualMessage2.contains(message));
        }
    }
}


