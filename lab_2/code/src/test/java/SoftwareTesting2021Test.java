import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SoftwareTesting2021Test {
    @Mock
    Date mockDate;

    @Mock
    Hospital mockHospital;

    @Mock
    NYCUDatabase MyDatabase;

    SoftwareTesting2021 softwareTesting2021 = new SoftwareTesting2021();

    Student feverStudent = new Student();

    @Test
    public void test_a() throws InterruptedException {
        // set hospital
        softwareTesting2021.setHospital(mockHospital);
        // set Wednesday
        when(mockDate.getWeekday()).thenReturn(4);
        softwareTesting2021.date = mockDate;
        //student fever
        assertTrue(feverStudent.getTemperature() > 37);
        // enter class
        softwareTesting2021.enterClass(feverStudent);
        // verify is treatment
        verify(mockHospital, never()).treatment(feverStudent);
    }

    @Test
    public void test_b() throws InterruptedException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        // set hospital
        softwareTesting2021.setHospital(mockHospital);
        // set Thursday
        when(mockDate.getWeekday()).thenReturn(5);
        softwareTesting2021.date = mockDate;
        // enter class
        softwareTesting2021.enterClass(feverStudent);
        // check output
        String expectedOutput = "Have a class today!\r\n" +
                "No! This student should not  come. We will send him/her to hospital. \r\n";
        assertEquals(expectedOutput, stream.toString());
    }

    @Test
    public void test_c() throws InterruptedException {
        ArrayList spy = spy(mockHospital.getLog());

        spy.add("0856017");
        spy.add("0856018");
        spy.add("0856019");

        verify(spy).add("0856017");
        verify(spy).add("0856018");
        verify(spy).add("0856019");
    }

    @Test
    public void test_d() throws InterruptedException {
        // set database
        when(MyDatabase.getScore(feverStudent.getStudentId())).thenReturn(90);
        softwareTesting2021.MyDatabase = MyDatabase;
        assertEquals(90, softwareTesting2021.getScore(feverStudent.getStudentId()));
    }

    @Test
    public void test_e() throws InterruptedException {
        MyPaypalService myPaypalService1 = new MyPaypalService("succeed");
        assertEquals("Thank you", softwareTesting2021.donate(myPaypalService1));

        MyPaypalService myPaypalService2 = new MyPaypalService("fail");
        assertEquals("Some Bug occurred", softwareTesting2021.donate(myPaypalService2));
    }

    public class MyPaypalService implements paypalService {
        String fakeReturnValue;
        MyPaypalService(String returnValue) { this.fakeReturnValue = returnValue;}
        public String doDonate() {
            return this.fakeReturnValue;
        }
    }
}