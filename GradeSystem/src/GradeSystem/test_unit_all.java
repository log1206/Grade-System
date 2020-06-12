package GradeSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;  
import java.io.PrintStream; 
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

class test_unit_all {
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
	 * unit test all in one, time cost = 0.053s (average)
	 */
	@Test
	void test() {
			test_G();
			test_R();
			test_A();
			test_W();
			test_type_wrong_and_log_out();
			test_exit_system();
	}
	/*
	 test function: showthegrade
	 test data:
	 	962001051 李威廷 81 32 50 90 93
	 	965002044 商揚夏 85 86 80 81 88
	 */
	public void test_G() {	
		PrintStream orig = System.out;
		//test_G_1
		ByteArrayOutputStream testout1 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout1));
		
		int id = 2;
		student_test.showthegrade(id);
		String ans = "親～您的成績為\n"+ "lab0：81分\n"+"lab1：32分\n"+"lab2：50分\n"+"lab3：90分\n"+"lab4：93分\n";

		assertEquals(ans,testout1.toString());
	
		//test_G_2
		ByteArrayOutputStream testout2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout2));
		
		id = 4;
		student_test.showthegrade(id);
		ans = "親～您的成績為\n"+ "lab0：85分\n"+"lab1：86分\n"+"lab2：80分\n"+"lab3：81分\n"+"lab4：88分\n";
		assertEquals(ans,testout2.toString());
		System.setOut(orig);
		System.out.println("Showthegrade Function Pass!!");
		return;
	}
	/*
	 test function: showtherank
	 test data:
	 	李威廷 : 63
	 	商揚夏 : 62
	 */
	public void test_R() {
		PrintStream orig = System.out;
		//test_R_1
		ByteArrayOutputStream testout1 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout1));
		
		int id = 2;
		student_test.showtherank(id);
		String ans = "親～您的排名為第63";
		assertEquals(ans,testout1.toString());
		//test_R_2
		ByteArrayOutputStream testout2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout2));
		
		id = 4;
		student_test.showtherank(id);
		ans = "親～您的排名為第62";
		assertEquals(ans,testout2.toString());
		System.setOut(orig);
		System.out.println("showtherank Function Pass!!");
		return;
	}
	/*
	 test function: showtheaverage
	 test data:
	 	李威廷 : 69.2
	 	商揚夏 : 84.0
	 */
	public void test_A() {
		PrintStream orig = System.out;
		//test_A_1
		ByteArrayOutputStream testout1 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout1));
		
		int id = 2;
		student_test.showtheaverage(id);
		String ans = "親～您的平均為69.2太神啦";
		assertEquals(ans,testout1.toString());
		//test_R_2
		ByteArrayOutputStream testout2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout2));
		
		id = 4;
		student_test.showtheaverage(id);
		ans = "親～您的平均為84.0太神啦";
		assertEquals(ans,testout2.toString());
		System.setOut(orig);
		System.out.println("showtheaverage Function Pass!!");
		return;
	}
	/*
	 test function: changetheweight
	 test data:
		0.1 0.2 0.3 0.1 0.3
		0.2 0.3 0.1 0.3 0.1
	 */
	public void test_W() {
		////////////////-----------auto input method-----------///////////
        ////////////////-----------auto input finish-----------///////////
		// input string
		String input1 = "0.1 0.2 0.3 0.1 0.3 Y"; 
		//String input2 = "0.2"; 
		String input2 = "0.2 0.3 0.1 0.3 0.1 Y";
		String beginning = "0.2 0.2 0.2 0.2 0.2 Y";
		
		PrintStream orig = System.out;
		//test_W_1
		//ByteArrayOutputStream testout1 = new ByteArrayOutputStream();
		ByteArrayInputStream testIn1 = new ByteArrayInputStream(input1.getBytes());
		System.setIn(testIn1);
		
		int id = 2;
		//test_W_1
		student_test.changetheweight(id);
		if(student_test.weight[0]==0.1 &&
           student_test.weight[1]==0.2 &&
		   student_test.weight[2]==0.3 &&
		   student_test.weight[3]==0.1 &&
		   student_test.weight[4]==0.3 
		)System.out.println("changetheweight_First Pass!!");
		
		//String input2 = " 0.2 0.3 0.1 0.3 0.1 Y"; 
		ByteArrayInputStream testIn2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(testIn2);
		//test_W_2
		student_test.changetheweight(id);
		if(student_test.weight[0]==0.2 &&
           student_test.weight[1]==0.3 &&
		   student_test.weight[2]==0.1 &&
		   student_test.weight[3]==0.3 &&
		   student_test.weight[4]==0.1 
		) {System.out.println("changetheweight_Second Pass!!");}
		else System.out.println("changetheweight_Second not Pass QAQ");
		///測完weight要將weight改回去不然之後測的會錯
		ByteArrayInputStream testIn3 = new ByteArrayInputStream(beginning.getBytes());
		System.setIn(testIn3);
		//test_W_2
		student_test.changetheweight(id);
		System.out.println("the weight has recovered to origin!!");
		
		return;
	}
	
	/*
	 test function: type_wrong
	 test data:
		QAQ E
		E
	 */
	public void test_type_wrong_and_log_out() {
		PrintStream orig = System.out;
		int id = 2;
		String type_wrong = "QAQ E";
		ByteArrayInputStream testIn1 = new ByteArrayInputStream(type_wrong.getBytes());
		System.setIn(testIn1);
		ByteArrayOutputStream testout1 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout1));
		student_test.printmenu(id);
		String ans1 = "輸入指令：\n1) G顯示成績\n2) R顯示排名\n3) A顯示平均\n4) W更新配分\n5) E離開選單\n親～打錯囉～請注意大小寫和智商～\n";
		assertEquals(ans1,testout1.toString());
		System.setOut(orig);
		System.out.println("type wrong resolve!! and user actually exit!");
		
		String type_wrong2 = "E";
		ByteArrayInputStream testIn2 = new ByteArrayInputStream(type_wrong2.getBytes());
		System.setIn(testIn2);
		ByteArrayOutputStream testout2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout2));
		student_test.printmenu(id);
		String ans2 = "輸入指令：\n1) G顯示成績\n2) R顯示排名\n3) A顯示平均\n4) W更新配分\n5) E離開選單\n";
		assertEquals(ans2,testout2.toString());
		System.setOut(orig);
		System.out.println("user actually exit!");
	}
	/*
	 test function: exit_system
	 test data:
		Q q
	 */
	public void test_exit_system() {
		//test Q
		PrintStream orig = System.out;
		String exit_cmd = "Q";
		ByteArrayInputStream testIn1 = new ByteArrayInputStream(exit_cmd.getBytes());
		System.setIn(testIn1);
		ByteArrayOutputStream testout1 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout1));
		student_test.wrapper();
		String ans1 = "結束了掰掰\n";
		assertEquals(ans1,testout1.toString());
		System.setOut(orig);
		System.out.println("grading System close!!");
		//test q
		String exit_cmd2 = "q";
		ByteArrayInputStream testIn2 = new ByteArrayInputStream(exit_cmd2.getBytes());
		System.setIn(testIn2);
		ByteArrayOutputStream testout2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout2));
		student_test.wrapper();
		String ans2 = "結束了掰掰\n";
		assertEquals(ans2,testout2.toString());
		System.setOut(orig);
		System.out.println("grading System close!!");
	}

}