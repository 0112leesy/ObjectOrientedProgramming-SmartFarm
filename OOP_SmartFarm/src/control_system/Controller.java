package control_system;
import java.util.Scanner;
public class Controller {
	private int reference_temperature;
	private int reference_humidity;
	private boolean TM_setup;//�µ� ���� ����
	private boolean HM_setup;//���� ���� ����
	
	Temperature_Machine TM = new Temperature_Machine();//Temperature_Machine �� ��������
	Humidity_Machine HM = new Humidity_Machine();//Humidity_Machine �� ��������
	Scanner sc = new Scanner(System.in);
	
	void set_reference_temperature() {//�µ� ����
		System.out.print("set temperaure:");
		int temp = sc.nextInt();
		while (temp>30 || temp<10) {//10~30�� ������ ���� ���� ����
			System.out.println("(!) set temperature must be 10 to 30 degree. please set again");
			System.out.print("set temperaure:");
			temp = sc.nextInt();
		}
		reference_temperature = temp;
		TM_setup = true;//�µ� ���� ���ΰ� ���� ��
	}
	void set_reference_humidity() {//���� ����
		
		System.out.print("set humidity:");//0~80�ۼ�Ʈ ������ ���� ���� ����
		int humid = sc.nextInt();
		while (humid>80 || humid<0) {
			System.out.println("(!) set humidity must be 0 to 80 degree. please set again");
			System.out.print("set humidity:");
			humid = sc.nextInt();
		}
		reference_humidity = humid;
		HM_setup = true;//���� ���� ���ΰ� ���� ��
	}
	void monitor() {//���� ���� �µ�, ���� ���� ���
		if (TM_setup==true&&HM_setup==true) {//�µ� ���� ����, ���� ���� ���θ� Ȯ����
			System.out.println("-----------current setup------------");
			System.out.println("> set temperature : "+reference_temperature+"��\n> set humidity : "+reference_humidity+"%");
			System.out.println("------------------------------------");
		}
		else {//������ �Ǿ����� �ʾ��� �� ���
			System.out.println("(!) setup not completed. please do setup first");
		}
	}
	
	void control_temperature(Sensor sensor) {//�µ� ������ ����
		if (reference_temperature <= sensor.get_temperature()) {//���� �µ��� ���� �µ����� ���� ��
			while(reference_temperature < sensor.get_temperature()) {//���� �µ��� ������������
				TM.cooling(sensor);//Temperature_Machine Ŭ������ cooling �޼ҵ� ���		
			}
		}
		else {//���� �µ��� ���� �µ����� ���� ��
			while(reference_temperature > sensor.get_temperature()) {//���� �µ��� ������������
				TM.heating(sensor);//Temperature_Machine Ŭ������ heating �޼ҵ� ���	
			}
		}
	}
	
	void control_humidity(Sensor sensor) {//���� ������ ����
		if (reference_humidity <= sensor.get_humidity()) {//���� ������ ���� �������� ���� ��
			while(reference_humidity < sensor.get_humidity()) {//���� ������ ������������
				HM.dehumidify(sensor);//Humidity_Machine Ŭ������ dehumidify �޼ҵ� ���
			}
		}
		else {//���� ������ ���� �������� ���� ��
			while(reference_humidity > sensor.get_humidity()) {//���� ������ ������������
				HM.humidify(sensor);//Humidity_Machine Ŭ������ humidify �޼ҵ� ���
			}
		}
	}
	
	boolean operation_determine() {//���� ���� �Ǵ�
		if (TM_setup==true&&HM_setup==true) {//�µ� ���� ���ο� ���� ���� ���� Ȯ��
			return true;//������ ��� �Ǿ��ִٸ� true ����
		}
		else {
			return false;//������ �Ǿ����� �ʴٸ� false ����
		}
	}

	
	
}
