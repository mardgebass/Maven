package ru.gb.extensions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.gb.config.TestConfig;

public class SelenideExtension implements AfterAllCallback, BeforeEachCallback {

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        WebDriverRunner.clearBrowserCache();
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        Selenide.open(TestConfig.testConfig.URL());
        Configuration.browser = "chrome";
        Configuration.pageLoadTimeout = 30;

    }
}
