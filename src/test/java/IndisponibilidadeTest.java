import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class IndisponibilidadeTest {
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
    void validarProdutoIndisponivel() {
        page.locator(".coffee-item", new Page.LocatorOptions().setHasText("Expresso Cremoso"))
            .locator(".buy-coffee").click();

        Locator popupMensagem = page.locator("text=Produto indisponível");
        assertThat(popupMensagem).isVisible();

        page.click("button:has-text('Voltar')");

        assertThat(popupMensagem).isHidden();
    }
}