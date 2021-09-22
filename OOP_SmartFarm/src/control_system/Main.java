package control_system;
import java.util.Scanner;

public class Main {
	
	public static void menu() {//메뉴형식으로 구현
		System.out.println("\n*****************************");
		System.out.println("**  [ menu ]               **");
		System.out.println("**  0 : menu               **");
		System.out.println("**  1 : current condition  **");
		System.out.println("**  2 : setup              **");
		System.out.println("**  3 : view setup         **");
		System.out.println("**  4 : operate & report   **");
		System.out.println("**  5 : refresh sensor     **");
		System.out.println("**  6 : exit               **");
		System.out.println("*****************************");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("[Automatic Environment Management Functions]\n");
		Controller con = new Controller();
		Sensor sen = new Sensor();
		menu();
		int option = 0;
		while(option!=6) {
			System.out.println();
			System.out.print("> ");
			option = sc.nextInt();
			switch(option) {
			case 0://menu
				menu();
				break;
			case 1://current condition
				sen.show();
				break;
			case 2://setup
				con.set_reference_temperature();
				con.set_reference_humidity();
				System.out.print("Setup completed");
				break;		
			case 3://view setup
				con.monitor();
				break;
			case 4://operate & report
				if (con.operation_determine()) {
					con.control_temperature(sen);
					con.control_humidity(sen);		
					System.out.println("Operation Completed");
					System.out.println("---------------Report---------------");
					con.TM.show_TMcount();
					con.TM.show_TMtime();
					System.out.println();
					con.HM.show_HMcount();
					con.HM.show_HMtime();
					System.out.println("------------------------------------");
					break;
				}
				else {
					System.out.println("(!) cannot operate. please do setup first");
					break;
				}
			case 5://refresh sensor
				sen.refresh();
				System.out.println("Sensor data refreshed\nCheck current condition");
				break;
			case 6://exit
				System.out.println("Program closed");
				break;
				}
			
		}
	}

}
