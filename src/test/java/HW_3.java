import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;

public class HW_3 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        Selenide.executeJavaScript("$('footer').remove()");


        // напоминалка id=#, class=.
        $("#firstName").setValue("M");
        $("#lastName").setValue("L");
        $("#userEmail").setValue("H_W_3@gmail.com");
// альтернатиынй         $("#genterWrapper").$(byText("Male")).click();
        $("#gender-radio-1").sendKeys(" ");
        $("#userNumber").setValue("8005553535");
// альтернатиынй        $("#dateOfBirthInput").setValue("");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("2000")).click();
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__month").$(byText("1")).click();
//        $("#subjectsContainer").setValue("Subjects");
        $("#hobbies-checkbox-1").parent().$(byText("Sports")).click();
        $("#hobbies-checkbox-2").parent().$(byText("Reading")).click();
        $("#hobbies-checkbox-3").parent().$(byText("Music")).click();
//        $("#uploadPicture").uploadFromClasspath("");
        $("#currentAddress").setValue("Current Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").sendKeys(Keys.ENTER);     // ?? click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }
}