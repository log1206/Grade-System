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
		985002002 林芯妤 99 81 91 92 95	id = 13
		林芯妤:　15
		0 1 0 0 0 
		E
		Q
	 */
	@Test
	void test() {
		
		PrintStream orig = System.out;
		//login
		//985002002 林芯妤 99 81 91 92 95		id == 13
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
		String ans3 = "親～您的排名為第15";
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
		String ans0 = "親～您的排名為第56";
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
		String ans4 = "輸入指令：\n1) G顯示成績\n2) R顯示排名\n3) A顯示平均\n4) W更新配分\n5) E離開選單\n";
		assertEquals(ans4,testout4.toString());
		System.setOut(orig);
		System.out.println("林芯妤 actually logout!");
		
		
		//test Q
		String exit_cmd = "Q";
		ByteArrayInputStream testIn4 = new ByteArrayInputStream(exit_cmd.getBytes());
		System.setIn(testIn4);
		ByteArrayOutputStream testout5 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout5));
		student_test.wrapper();
		String ans5 = "結束了掰掰\n";
		assertEquals(ans5,testout5.toString());
		System.setOut(orig);
		System.out.println("grading System close!!");
		
		
		//End
		System.out.println("\n\n");
		System.out.println("~ Congradulation!! integration test 2 ALL PASS ~");
		System.out.println("\n\n");
		
		
		
		
	}

}
