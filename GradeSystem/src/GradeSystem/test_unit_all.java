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
	 	962001051 ���§� 81 32 50 90 93
	 	965002044 �Ӵ��L 85 86 80 81 88
	 */
	public void test_G() {	
		PrintStream orig = System.out;
		//test_G_1
		ByteArrayOutputStream testout1 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout1));
		
		int id = 2;
		student_test.showthegrade(id);
		String ans = "�ˡ�z�����Z��\n"+ "lab0�G81��\n"+"lab1�G32��\n"+"lab2�G50��\n"+"lab3�G90��\n"+"lab4�G93��\n";

		assertEquals(ans,testout1.toString());
	
		//test_G_2
		ByteArrayOutputStream testout2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout2));
		
		id = 4;
		student_test.showthegrade(id);
		ans = "�ˡ�z�����Z��\n"+ "lab0�G85��\n"+"lab1�G86��\n"+"lab2�G80��\n"+"lab3�G81��\n"+"lab4�G88��\n";
		assertEquals(ans,testout2.toString());
		System.setOut(orig);
		System.out.println("Showthegrade Function Pass!!");
		return;
	}
	/*
	 test function: showtherank
	 test data:
	 	���§� : 63
	 	�Ӵ��L : 62
	 */
	public void test_R() {
		PrintStream orig = System.out;
		//test_R_1
		ByteArrayOutputStream testout1 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout1));
		
		int id = 2;
		student_test.showtherank(id);
		String ans = "�ˡ�z���ƦW����63";
		assertEquals(ans,testout1.toString());
		//test_R_2
		ByteArrayOutputStream testout2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout2));
		
		id = 4;
		student_test.showtherank(id);
		ans = "�ˡ�z���ƦW����62";
		assertEquals(ans,testout2.toString());
		System.setOut(orig);
		System.out.println("showtherank Function Pass!!");
		return;
	}
	/*
	 test function: showtheaverage
	 test data:
	 	���§� : 69.2
	 	�Ӵ��L : 84.0
	 */
	public void test_A() {
		PrintStream orig = System.out;
		//test_A_1
		ByteArrayOutputStream testout1 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout1));
		
		int id = 2;
		student_test.showtheaverage(id);
		String ans = "�ˡ�z��������69.2�ӯ���";
		assertEquals(ans,testout1.toString());
		//test_R_2
		ByteArrayOutputStream testout2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout2));
		
		id = 4;
		student_test.showtheaverage(id);
		ans = "�ˡ�z��������84.0�ӯ���";
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
		///����weight�n�Nweight��^�h���M��������|��
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
		String ans1 = "��J���O�G\n1) G��ܦ��Z\n2) R��ܱƦW\n3) A��ܥ���\n4) W��s�t��\n5) E���}���\n�ˡ㥴���o��Ъ`�N�j�p�g�M���ӡ�\n";
		assertEquals(ans1,testout1.toString());
		System.setOut(orig);
		System.out.println("type wrong resolve!! and user actually exit!");
		
		String type_wrong2 = "E";
		ByteArrayInputStream testIn2 = new ByteArrayInputStream(type_wrong2.getBytes());
		System.setIn(testIn2);
		ByteArrayOutputStream testout2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testout2));
		student_test.printmenu(id);
		String ans2 = "��J���O�G\n1) G��ܦ��Z\n2) R��ܱƦW\n3) A��ܥ���\n4) W��s�t��\n5) E���}���\n";
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
		String ans1 = "�����F�T�T\n";
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
		String ans2 = "�����F�T�T\n";
		assertEquals(ans2,testout2.toString());
		System.setOut(orig);
		System.out.println("grading System close!!");
	}

}