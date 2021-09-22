package control_system;
import java.util.Scanner;
public class Controller {
	private int reference_temperature;
	private int reference_humidity;
	private boolean TM_setup;//온도 설정 여부
	private boolean HM_setup;//습도 설정 여부
	
	Temperature_Machine TM = new Temperature_Machine();//Temperature_Machine 과 구성관계
	Humidity_Machine HM = new Humidity_Machine();//Humidity_Machine 과 구성관계
	Scanner sc = new Scanner(System.in);
	
	void set_reference_temperature() {//온도 설정
		System.out.print("set temperaure:");
		int temp = sc.nextInt();
		while (temp>30 || temp<10) {//10~30도 사이의 값만 설정 가능
			System.out.println("(!) set temperature must be 10 to 30 degree. please set again");
			System.out.print("set temperaure:");
			temp = sc.nextInt();
		}
		reference_temperature = temp;
		TM_setup = true;//온도 설정 여부가 참이 됨
	}
	void set_reference_humidity() {//습도 설정
		
		System.out.print("set humidity:");//0~80퍼센트 사이의 값만 설정 가능
		int humid = sc.nextInt();
		while (humid>80 || humid<0) {
			System.out.println("(!) set humidity must be 0 to 80 degree. please set again");
			System.out.print("set humidity:");
			humid = sc.nextInt();
		}
		reference_humidity = humid;
		HM_setup = true;//습도 설정 여부가 참이 됨
	}
	void monitor() {//현재 설정 온도, 설정 습도 출력
		if (TM_setup==true&&HM_setup==true) {//온도 설정 여부, 습도 설정 여부를 확인함
			System.out.println("-----------current setup------------");
			System.out.println("> set temperature : "+reference_temperature+"℃\n> set humidity : "+reference_humidity+"%");
			System.out.println("------------------------------------");
		}
		else {//설정이 되어있지 않았을 때 출력
			System.out.println("(!) setup not completed. please do setup first");
		}
	}
	
	void control_temperature(Sensor sensor) {//온도 관리기 제어
		if (reference_temperature <= sensor.get_temperature()) {//현재 온도가 설정 온도보다 높을 때
			while(reference_temperature < sensor.get_temperature()) {//설정 온도와 같아질때까지
				TM.cooling(sensor);//Temperature_Machine 클래스의 cooling 메소드 사용		
			}
		}
		else {//현재 온도가 설정 온도보다 낮을 때
			while(reference_temperature > sensor.get_temperature()) {//설정 온도와 같아질때까지
				TM.heating(sensor);//Temperature_Machine 클래스의 heating 메소드 사용	
			}
		}
	}
	
	void control_humidity(Sensor sensor) {//습도 관리기 제어
		if (reference_humidity <= sensor.get_humidity()) {//현재 습도가 설정 습도보다 높을 때
			while(reference_humidity < sensor.get_humidity()) {//설정 습도와 같아질때까지
				HM.dehumidify(sensor);//Humidity_Machine 클래스의 dehumidify 메소드 사용
			}
		}
		else {//현재 습도가 설정 습도보다 낮을 때
			while(reference_humidity > sensor.get_humidity()) {//설정 습도와 같아질때까지
				HM.humidify(sensor);//Humidity_Machine 클래스의 humidify 메소드 사용
			}
		}
	}
	
	boolean operation_determine() {//가동 여부 판단
		if (TM_setup==true&&HM_setup==true) {//온도 설정 여부와 습도 설정 여부 확인
			return true;//설정이 모두 되어있다면 true 리턴
		}
		else {
			return false;//설정이 되어있지 않다면 false 리턴
		}
	}

	
	
}
