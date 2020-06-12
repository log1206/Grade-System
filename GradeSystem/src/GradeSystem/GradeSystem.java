package GradeSystem;

import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.io.*;
import java.util.Scanner;
import java.lang.String;
import java.util.Arrays;
//import java.util.*;


 public class GradeSystem {
    
	static String str[][] = new String[1000][8];
	static double totalscore[];// = new double[1000];
	static double weight[] = {0.2,0.2,0.2,0.2,0.2};
	static int num;
	 //header
	/**
	* Read the input txt file into the GradeSystem.
	* @param no param
	* @throws java.io.FileNotFoundException
	* @return void
	*
	* Example: settting the right file path then array str will be initualize as txt file content
	* Time estimate: O(n*m) n is the row number,m is the column number
	*/
	 static public void readText() {
		 try {
			 File file = new File( "src\\GradeSystem\\input.txt");
	         Scanner scanner = new Scanner(new BufferedReader( new InputStreamReader(new FileInputStream(file), "utf-8")));
	         int x = 0, y = 0;
	         while (scanner.hasNext()) 
	         {
	              str[x][y] = scanner.next();		//字串分割 存入陣列
	              y=(y <=6)?y+1:0;
	              if(y == 7) {
	            	  x++;
	            	  y = 0;
	              }
	         }
	         num =x;
	         totalscore = new double[num];
	         //scanner.close();//!!!
	}catch(Exception e){
		e.printStackTrace();
	}
	}	 
	//header
	 /**
	 * ask the user to enter the student ID and return its index in the str array
	 * @param no param
	 * @throws NoExceptions
	 * @return if id is found in str array return its array's index
	 *         else return -1 represent not found
	 *
	 * Example: type 955002056 when calling input() it will return 0
	 * 	       but if type xx when calling input() it will return -1
	 * Time estimate: O(n) n is the row num
	 */
	 static public int input() {

		 Scanner sc = new Scanner(System.in);
		 String userId = sc.next();
		 //System.out.println(userId);
		 if(userId.equals("Q")||userId.equals("q"))return -2;
		 for(int i =0; i<num;i++) {
			 //System.out.println(userID);
			 //System.out.println(str[i][0]);
			 	if(userId.equals(str[i][0])){
			 		System.out.println("Welcome,"+str[i][1]);
			 		// sc.close();//!!!
			 		return i;
				 }
		 //955002056 
		 //System.out.println(input);
	 }
		System.out.println("you are not the user!");
		// sc.close();//!!!
		return -1;
	 }	 
	 //header
	 /**
	 * if login fail it will let you retry again and again
	 * @param no param
	 * @throws NoExceptions
	 * @return if input() succeed , return the value input() return
	 *         else keep going in the loop
	 *
	 * Example: type 955002056 when calling input() it will return 0
	 * 	       but if type xx when calling input() it will keep staying in the while loop
	 * Time estimate: O(1)
	 */
	 static public int studentLogin() {
		 
		 int currentId = -1;
		 while(currentId==-1) {
			 
			 currentId = input();
			 if(currentId == -2)return -1;
		 }
		
		return currentId;
	 }	 
	//header
	 /**
	 * count the weighted score for every people in the GradeSystem.
	 * @param no param
	 * @throws NoExceptions
	 * @return void
	 *
	 * Example: if weights are all 0.2 than value = 0.2*lab0_score+0.2*lab1_score+0.2*lab2_score+0.2*lab3_score+0.2*lab4_score;
	 * Time estimate: O(n)
	 */
	 static public void addsum() {
		 for(int i = 0;i<num;i++) {
			 double a = Integer.valueOf(str[i][2])*weight[0];
			 double b = Integer.valueOf(str[i][3])*weight[1];
			 double c = Integer.valueOf(str[i][4])*weight[2];
			 double d = Integer.valueOf(str[i][5])*weight[3];
			 double e = Integer.valueOf(str[i][6])*weight[4];
			 totalscore[i] = a+b+c+d+e;
			
		//	 System.out.println(totalscore[i]+" "+lookupscore[i]);
		 } 
	 }	 
	//header
	 /**
	 * show the user's each score in the GradeSystem.
	 * @param id :student index in str array
	 * @throws NoExceptions
	 * @return void
	 *
	 * Example: if id == 0 print:
	 * 	親～您的成績為
	 *	lab0：88分
	 *	lab1：92分
	 *	lab2：88分
	 *	lab3：98分
	 *	lab4：91分
	 *	請再接再厲
	 * 
	 * Time estimate: O(1)
	 */
	 static public void showthegrade(int id) {
		 System.out.print("親～您的成績為\n");
		
		 System.out.print("lab0："+str[id][2]+"分\n");
		 System.out.print("lab1："+str[id][3]+"分\n");
		 System.out.print("lab2："+str[id][4]+"分\n");
		 System.out.print("lab3："+str[id][5]+"分\n");
		 System.out.print("lab4："+str[id][6]+"分\n");
	 }	 
		//header
	 /**
	 * show the user's rank in the GradeSystem.
	 * @param id :student index in str array
	 * @throws NoExceptions
	 * @return void
	 *
	 * Example: if id == 0 print:親～您的排名為第17
	 * Time estimate: O(2*n+m) = O(n), n = row number m = column number
	 */
	 static public void showtherank(int id) {
		 
		 double usertotal = 0;
		 
		 //weight[1]=0.3;
		 for(int i =2;i<=6;i++) {
			 usertotal+=weight[i-2]*Double.valueOf(str[id][i]);
		 }
		 addsum();
		 Arrays.sort(totalscore);
		 //System.out.print(totalscore[999]);
		 //System.out.print(num);
		 for(int j = num-1;j>=0;j--) {//////////////////???????????????
			 if(usertotal==totalscore[j]) {
				 System.out.print("親～您的排名為第");
				 System.out.print(num-j);
				 break;
			 }
		 }
	 }	 
		//header
	 /**
	 * show the user's average score in the GradeSystem.
	 * @param id :student index in str array
	 * @throws NoExceptions
	 * @return void
	 *
	 * Example: if id == 0 print :
	 * 親～您的平均為91.4
	 * 太神啦
	 * 
	 * Time estimate: O(m) m = column number(numbers of labs)
	 */
	 static public void showtheaverage(int id) {
		 double sum =0;
		 //weight[1]=0.3;
		 for(int i =2;i<=6;i++) {
			 sum+=weight[i-2]*Double.valueOf(str[id][i]);
		 }
		 System.out.print("親～您的平均為"+sum);
		 System.out.print("太神啦");
	 }	 
		//header
	 /**
	 * update the weight of each lab in the GradeSystem.
	 * @param id :student index in str array
	 * @throws NoExceptions
	 * @return void
	 *
	 * Example: if id == 0 each weight change to -0.2 it will ask you to make sure the change
	 *          after press Y than it will update every weight to -0.2
	 * Time estimate: O(m) m = column number(numbers of labs)
	 */
	 static public void changetheweight(int id) {//還沒做防呆  //0407_chunwang_modify_checktotalweight
		 System.out.print("原始權重為");
		 System.out.println("lab0: "+weight[0]+" lab1: "+weight[1]+" lab2: "+weight[2]+" lab3: "+weight[3]+" lab4: "+weight[4]);
		 Scanner input = new Scanner(System.in);	
		 double newweight[] = new double[5];
		 double checktotalweight = 0;//check whether sum is 1
		 for(int i = 0;i<5;i++) {
			 System.out.print("lab"+i+"您想要改成的權數是：");
			 newweight[i] = Double.valueOf(input.next()); 
			 checktotalweight += newweight[i];
			 System.out.println(newweight[i]);
		 }
		 //System.out.println("");
		 //System.out.println(checktotalweight);
		 //if(checktotalweight!=1) {/////////容我改一下
		 if(checktotalweight<0.999999 || checktotalweight>1.00001) {
			 System.out.println("");
			 System.out.println("權重錯誤！請重新設置");
			 return;
		 }
		 System.out.println("新的權重為");
		 System.out.println("lab0: "+newweight[0]+" lab1: "+newweight[1]+" lab2: "+newweight[2]+" lab3: "+newweight[3]+" lab4: "+newweight[4]);
		 System.out.println("親～您想要這樣改嗎（Y/N）");
		 String ans = input.next();
		 if(ans.equals("Y")) {
			 for(int i = 0;i<5;i++)weight[i] = newweight[i];
			 System.out.println("親～已經幫您改好囉～");
		 }
		 
	 }	 
	//header
	 /**
	 * A looping menu in the GradeSystem, can choose the function to execute
	 * input E to End this function
	 * @param id :student index in str array
	 * @throws NoExceptions
	 * @return void
	 *
	 * Example: if id == 0 input == G than it will run showthegrade(0)
	 * Time estimate: O(1) (according to the user)
	 */
	 static public void printmenu(int id) {
		 	System.out.print("輸入指令：\n");
			System.out.print("1) G顯示成績\n");
			System.out.print("2) R顯示排名\n");
			System.out.print("3) A顯示平均\n");
			System.out.print("4) W更新配分\n");
			System.out.print("5) E離開選單\n");
			Scanner cmd = new Scanner(System.in);	
			String instruction = cmd.next();
			while(!instruction.equals("E")) {
				//System.out.println(instruction);
				if(instruction.equals("G")) showthegrade(id);
				else if(instruction.equals("R"))showtherank(id);
				else if(instruction.equals("A"))showtheaverage(id);
				else if(instruction.equals("W"))changetheweight(id);
				else System.out.print("親～打錯囉～請注意大小寫和智商～\n");
				instruction = cmd.next();//wrong cmd
			}
		 }	
	 //header
	 /**
	 * main function in the GradeSystem, press Q to End or input ID to get into the Grade system,
	 * if user logout it will back to loop from login
	 * @param  no param
	 * @throws NoExceptions
	 * @return no return
	 *
	 * Example: if input ID , than get into the system
	 *          if input Q , then terminate the system
	 * Time estimate: O(1) (according to the user)
	 */
	 static public void wrapper() {
			int currentId = studentLogin();//return == -1就是打了q
			while(currentId != -1) {
				printmenu(currentId);
				System.out.print("輸入ID或Q(退出):\n");
				currentId = studentLogin();
			}
			System.out.print("結束了掰掰\n");
		}
	 //header
	 /**
	 * do some data initialization and run the grade System
	 * @param  no param
	 * @throws NoExceptions
	 * @return no return
	 *
	 * Time estimate: O(1) (according to the user)
	 */
	public static void main(String[] args) {
		 
		readText();
		addsum();//init the score
		System.out.println("輸入ID或 Q (結束使用):");
		wrapper();
		/*int currentId = studentLogin();//return == -1就是打了q
		while(currentId != -1) {
			printmenu(currentId);
			System.out.println("輸入ID或Q(退出):");
			currentId = studentLogin();
		}
		System.out.println("結束了掰掰");*/
	}
	

}