package homework2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class LoginTest extends BaseTest {

    @Test
    public void testTransactionNotEmpty() {
        // Validar transacciones en la HomePage
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getTransactionsCount() > 0, "ERROR: Transactions list is empty.");
    }

    @Test
    public void testTransactionEqualtoSix() {
        // Validar transacciones en la HomePage
        HomePage homePage = new HomePage(driver);
        int transactionsSize = homePage.getTransactionsCount();
        Assert.assertEquals(transactionsSize, 6, "ERROR: Transactions not loaded correctly.");
    }

    @Test
    public void testTransactionsLoadedCorrectly() {
        HomePage homePage = new HomePage(driver);
        List<String> transactions = homePage.getTransactionsDescriptions();
        List<String> expectedTransactions = Arrays.asList("Starbucks coffee", "Stripe Payment Processing", "MailChimp Services", "Shopify product", "Ebay Marketplace", "Templates Inc");
        Assert.assertEquals(transactions, expectedTransactions, "ERROR: Transactions not loaded correctly.");

    }

}
