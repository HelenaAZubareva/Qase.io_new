package Ui.wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class InputCreateCase {
    protected String label;

    public InputCreateCase(String label) {
        this.label = label;
    }

    public void writeCase(String text) {
        $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'form-group')]//input", label))
                .sendKeys(text);
    }
}
