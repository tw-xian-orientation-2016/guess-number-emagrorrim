import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Compare_Number_Test {

    @Test
    public void has_no_right_number_no_right_place() {
        CompareNumber compareNumber = new CompareNumber();

        assertThat(compareNumber.compare("1234", "5678"), is("0A0B"));
    }


}
