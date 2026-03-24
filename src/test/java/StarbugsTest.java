import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class StarbugsTest {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeEach
    void setup() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://starbugs-qa.vercel.app/");
    }

    @AfterEach
    void tearDown() {
        browser.close();
        playwright.close();
    }

    @Test
    void deveComprarCafeComSucesso() {
        page.locator(".coffee-item", new Page.LocatorOptions().setHasText("Expresso Gelado"))
            .locator(".buy-coffee").click();

        page.locator("input[name='cep']").fill("04538133");
        page.click("input[type=button][value='Buscar CEP']");

        page.waitForFunction("document.querySelector('input[name=\"street\"]').value !== ''");
        
        page.locator("input[name='number']").fill("14");
        page.click("label:has-text('Cartão de Crédito')");
        page.click("button:has-text('Confirmar pedido')");

        assertThat(page.locator("h1")).containsText("Uhull! Pedido confirmado");
    }
}