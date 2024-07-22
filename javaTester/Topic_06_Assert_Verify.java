import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Topic_06_Assert_Verify {

    @Test
    public void TC_01() {

        Topic_06_Assert_Verify frodo = new Topic_06_Assert_Verify();
        Topic_06_Assert_Verify sauron = new Topic_06_Assert_Verify();

        // basic assertions
        assertThat(frodo.getName()).isEqualTo("Frodo");
        assertThat(frodo).isNotEqualTo(sauron);

        // chaining string specific assertions
        // Fluent assert
        assertThat(frodo.getName())
                .startsWith("Fro")
                .endsWith("don")
                .isEqualToIgnoringCase("frodo");
    }


    public String getName() {
        return "Frodo";
    }
}
