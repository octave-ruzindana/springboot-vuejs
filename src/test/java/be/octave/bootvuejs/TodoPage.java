package be.octave.bootvuejs;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@PageUrl("http://localhost:8080")
public class TodoPage extends FluentPage {

    @FindBy(id ="Title")
    private FluentWebElement addTodoFormInput;

    @FindBy(id="add_todo_button")
    private FluentWebElement addTodoSubmitButton;

    public FluentWebElement getAddTodoFormInput() {
        return addTodoFormInput;
    }

    public FluentWebElement getAddTodoSubmitButton() {
        return addTodoSubmitButton;
    }

    TodoPage typeDescription(String title){
        this.addTodoFormInput.write(title);
        return this;
    }

    TodoPage submitDescription(){
        await().atMost(2,TimeUnit.SECONDS).until(addTodoSubmitButton).clickable();
        this.addTodoSubmitButton.click();
        return this;
    }

    public TodoPage waitForPageToLoad() {
        await().atMost(5, TimeUnit.SECONDS).until(addTodoFormInput).present();
        return this;
    }

    public void assertTextIsPresentInTodoList(String description) {
        assertThat($(".table").textContents()).anyMatch(item -> item.contains(description));
    }
}
