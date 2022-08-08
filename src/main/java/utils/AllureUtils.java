package utils;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;

public class AllureUtils {
    @Attachment(type = "image/png")
    public static byte[] screenshot()  {
        File screenshot = Screenshots.takeScreenShotAsFile();
        try {
            return screenshot == null ? null : Files.toByteArray(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
