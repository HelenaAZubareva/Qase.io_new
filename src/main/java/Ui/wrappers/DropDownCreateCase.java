package Ui.wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class DropDownCreateCase {
    protected String label;
    public DropDownCreateCase(String label) {
        this.label = label;
    }
    public void selectForNewCase(String option) {
        $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'form-group')]//button", label)).click();

        $x(String.format("//div[text()='%s']", option)).click();
    }
}
