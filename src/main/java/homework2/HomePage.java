package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    private WebDriver driver;
    private By transactionsListLocator = By.cssSelector(".table tbody tr");
    private By transactionsDescriptionsLocator = By.cssSelector(".table tbody tr td.cell-with-media");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public int getTransactionsCount() {
        List<WebElement> transactions = driver.findElements(transactionsListLocator);
        return transactions.size();
    }

    public List<String> getTransactionsDescriptions() {
        List<WebElement> transactionsDescriptions = driver.findElements(transactionsDescriptionsLocator);
        return transactionsDescriptions.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
