package control_system;

class Sensor {
	private int temperature;
	private int humidity;
	
	Sensor(){//��ü ���� �� �µ�, �������� �����
		temperature = 10+(int)(Math.random()*20);	//temperature: 10~30 degree
		humidity = (int)(Math.random()*80);			//humidity: 0~80 degree
	}
	void temperature_change(int change) {//�µ� ��ȭ
		temperature += change;
	}
	int get_temperature() {//�µ��� ���
		return temperature;
	}
	void humidity_change(int change) {//���� ��ȭ
		humidity += change;
	}
	int get_humidity() {//������ ���
		return humidity;
	}
	void show() {//���� �µ�, ���� ���� ���
		System.out.println("--------current condition--------");
		System.out.println("> temperature : "+temperature+"��\n> humidity : "+humidity+"%");
		System.out.println("---------------------------------");
	}
	void refresh() {//�µ�, ���� ������ ����
		temperature = 10+(int)(Math.random()*20);	
		humidity = (int)(Math.random()*80);
	}
}
