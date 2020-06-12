package GradeSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Integration test2 time cost = 0.045s (average)
 */
class test_integration_II {
    GradeSystem student_test = null;
	@BeforeEach
	void setUp() throws Exception {
		student_test = new GradeSystem();	
		student_test.readText();

	}
	
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("you Exit test");
		student_test = null;
	}
	/*
	 *Integration test
	 test function:login, showtherank(), changetheweight(), showtherank(), type_wrong, exit
	 test data:
		985002002 �L�䧱 99 81 91 92 95	id = 13
		�L�䧱:�@15
		0 1 0 0 0 
		E
		Q
	 */
	@Test
	void test() {
		
		PrintStream orig = System.out;
		//login
		//985002002 �L�䧱 99 81 91 92 95		id == 13
		String studentID = "985002002"; 
		ByteArrayInputStream testIn1 = new ByteArrayInputStream(studentID.getBytes());
		System.setIn(testIn1);
		int receive = student_test.studentLogin();
		int ans = 13;
		assertEquals(ans,receive);
		System.out.println("login success!!");
		
		
		//test rank
		ByteArrayOutputStream testout2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout2));
		student_test.showtherank(receive);
		String ans3 = "�ˡ�z���ƦW����15";
		assertEquals(ans3,testout2.toString());
		System.setOut(orig);
		System.out.println("showtherank success!!");
		
		
		//test weight
		String input1 = "0 1 0 0 0 Y"; 
		ByteArrayInputStream testIn2 = new ByteArrayInputStream(input1.getBytes());
		System.setIn(testIn2);
		ByteArrayOutputStream testout3 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout3));
		student_test.changetheweight(receive);
		if(student_test.weight[0]==0 &&
           student_test.weight[1]==1 &&
		   student_test.weight[2]==0 &&
		   student_test.weight[3]==0 &&
		   student_test.weight[4]==0 
		) {
			System.setOut(orig);
			System.out.println("changetheweight Pass!!");
		}
		
		
		//test rank
		ByteArrayOutputStream testout0 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout0));
		student_test.showtherank(receive);
		String ans0 = "�ˡ�z���ƦW����56";
		assertEquals(ans0,testout0.toString());
		System.setOut(orig);
		System.out.println("showtherank success!!");
		
				
		//test type wrong
		String type_wrong = "E";
		ByteArrayInputStream testIn3 = new ByteArrayInputStream(type_wrong.getBytes());
		System.setIn(testIn3);
		ByteArrayOutputStream testout4 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout4));
		student_test.printmenu(receive);
		String ans4 = "��J���O�G\n1) G��ܦ��Z\n2) R��ܱƦW\n3) A��ܥ���\n4) W��s�t��\n5) E���}���\n";
		assertEquals(ans4,testout4.toString());
		System.setOut(orig);
		System.out.println("�L�䧱 actually logout!");
		
		
		//test Q
		String exit_cmd = "Q";
		ByteArrayInputStream testIn4 = new ByteArrayInputStream(exit_cmd.getBytes());
		System.setIn(testIn4);
		ByteArrayOutputStream testout5 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout5));
		student_test.wrapper();
		String ans5 = "�����F�T�T\n";
		assertEquals(ans5,testout5.toString());
		System.setOut(orig);
		System.out.println("grading System close!!");
		
		
		//End
		System.out.println("\n\n");
		System.out.println("~ Congradulation!! integration test 2 ALL PASS ~");
		System.out.println("\n\n");
		
		
		
		
	}

}
