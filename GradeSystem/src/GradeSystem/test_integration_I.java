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
 * Integration test1 time cost = 0.047s (average)
 */
class test_integration_I {
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
	 test function: login, showthegrade(), showtherank(), changetheweight(), type_wrong, exit
	 test data:
	 	962001051 李威廷 81 32 50 90 93 id = 2
	 	李威廷: 63
	 	0.1 0.2 0.3 0.1 0.3
	 	QAQ 
	 	E
	 	Q
	 */
	@Test
	void test() {
		
		PrintStream orig = System.out;
		//login
		//962001051 李威廷 81 32 50 90 93 id = 2
		String studentID = "962001051"; 
		ByteArrayInputStream testIn1 = new ByteArrayInputStream(studentID.getBytes());
		System.setIn(testIn1);
		int receive = student_test.studentLogin();
		int ans = 2;
		assertEquals(ans,receive);
		System.out.println("login success!!");
		
		
		//test grade
		ByteArrayOutputStream testout1 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout1));
		student_test.showthegrade(receive);
		String ans2 = "親～您的成績為\n"+ "lab0：81分\n"+"lab1：32分\n"+"lab2：50分\n"+"lab3：90分\n"+"lab4：93分\n";
		assertEquals(ans2,testout1.toString());
		System.setOut(orig);
		System.out.println("showthegrade success!!");
		
		
		//test rank
		ByteArrayOutputStream testout2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout2));
		student_test.showtherank(receive);
		String ans3 = "親～您的排名為第63";
		assertEquals(ans3,testout2.toString());
		System.setOut(orig);
		System.out.println("showtherank success!!");
		
		
		//test weight
		String input1 = "0.1 0.2 0.3 0.1 0.3 Y"; 
		String beginning = "0.2 0.2 0.2 0.2 0.2 Y";
		ByteArrayInputStream testIn2 = new ByteArrayInputStream(input1.getBytes());
		System.setIn(testIn2);
		ByteArrayOutputStream testout3 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout3));
		student_test.changetheweight(receive);
		if(student_test.weight[0]==0.1 &&
           student_test.weight[1]==0.2 &&
		   student_test.weight[2]==0.3 &&
		   student_test.weight[3]==0.1 &&
		   student_test.weight[4]==0.3 
		) {
			ByteArrayInputStream testIn3 = new ByteArrayInputStream(beginning.getBytes());
			System.setIn(testIn3);
			student_test.changetheweight(receive);
			System.setOut(orig);
			System.out.println("changetheweight Pass!!");
		}
		
		
		//test type wrong
		String type_wrong = "QAQ E";
		ByteArrayInputStream testIn3 = new ByteArrayInputStream(type_wrong.getBytes());
		System.setIn(testIn3);
		ByteArrayOutputStream testout4 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout4));
		student_test.printmenu(receive);
		String ans4 = "輸入指令：\n1) G顯示成績\n2) R顯示排名\n3) A顯示平均\n4) W更新配分\n5) E離開選單\n親～打錯囉～請注意大小寫和智商～\n";
		assertEquals(ans4,testout4.toString());
		System.setOut(orig);
		System.out.println("type wrong resolve!! and 李威廷 actually exit!");
		
		
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
		System.out.println("~ Congradulation!! integration test 1 ALL PASS ~");
		System.out.println("\n\n");
		
		
	}

}
