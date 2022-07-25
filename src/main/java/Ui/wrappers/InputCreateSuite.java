package Ui.wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class InputCreateSuite {
    protected String label;

    public InputCreateSuite(String label) {
        this.label = label;
    }

    public void writeSuite(String text) {
        $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'form-group')]//input", label))
                .sendKeys(text);
    }
}
