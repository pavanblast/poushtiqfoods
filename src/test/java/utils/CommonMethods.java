package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class CommonMethods{

    public WebDriver getWebDriver(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // Mandatory for Chrome 111+
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return new ChromeDriver(options);
    }

    public void spellCheck(@NotNull WebDriver driver) throws Exception{

        // Step 2: Extract visible text (e.g., from <p> tags)
        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
        StringBuilder contentBuilder = new StringBuilder();

        for (WebElement paragraph : paragraphs) {
            contentBuilder.append(paragraph.getText()).append(" ");
        }

        String pageText = contentBuilder.toString();
        System.out.println("Extracted Text:\n" + pageText);

        // Step 3: Check grammar/spelling with LanguageTool
        JLanguageTool langTool = new JLanguageTool(new AmericanEnglish());
        List<RuleMatch> matches = langTool.check(pageText);

        for (RuleMatch match : matches) {
            System.out.println("\nIssue: " + match.getMessage());
            System.out.println("Suggested correction(s): " + match.getSuggestedReplacements());
            System.out.println("Context: " + pageText.substring(match.getFromPos(), match.getToPos()));
        }
    }
}
