import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CompareNumberTest {
    private CompareNumber compareNumber;

    @Before
    public void setup() {
        compareNumber = new CompareNumber();
    }

    @Test
    public void compare_return_0A0B_when_neither_matched_nor_contained() {

        assertThat(compareNumber.compare("1234", "5678"), is("0A0B"));
    }

    @Test
    public void compare_return_0A4B_when_no_matched_but_all_contained() {

        assertThat(compareNumber.compare("1234", "4321"), is("0A4B"));
    }

    @Test
    public void compare_return_4A0B_when_all_matched() {

        assertThat(compareNumber.compare("1234", "1234"), is("4A0B"));
    }



}
