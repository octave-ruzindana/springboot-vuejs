package be.octave.bootvuejs;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.BeforeClass;
import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AddTodoTest extends FluentTest {
    @BeforeClass
    public static void init() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\javadev\\tools\\chrome-driver-2.43\\chromedriver.exe");
    }

    @Page
    TodoPage todoPage;

    @Test
    public void should_add_todo() {
        String some_long_enough_description = "Some long enough description";
        goTo(todoPage)
                .waitForPageToLoad()
                .typeDescription(some_long_enough_description)
                .submitDescription()
        .assertTextIsPresentInTodoList(some_long_enough_description);
    }


}
