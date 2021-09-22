package control_system;

public class Humidity_Machine {
	private int count_dehumidify;//�������� ������ ����
	private int count_humidify;//�������� ������ ����
	void dehumidify(Sensor sensor){//���� ���� (Sensor �޼����н�)
		sensor.humidity_change(-1);//Sensor Ŭ������ humidity_change �Լ� ���
		count_dehumidify++;
	}
	void humidify(Sensor sensor) {//���� ���� (Sensor �޼����н�)
		sensor.humidity_change(1);//Sensor Ŭ������ humidity_change �Լ� ���
		count_humidify++;
	}
	void show_HMcount(){//���� ��ȭ ����Ʈ
		if(count_dehumidify>0) System.out.println("*DEHUMIDIFIED* "+count_dehumidify+" percent");
		else if (count_humidify>0) System.out.println("*HUMIDIFIED* "+count_humidify+" percent");
		else System.out.println("*Humidity Machine not runned*");
	}
	void show_HMtime() {//�ҿ� �ð� ����Ʈ
		if (count_humidify>0) {
			int HMtime = (count_humidify/10)*10;//-> 10�е��� 10 �ۼ�Ʈ ������ ������ȭ�� ����ٰ� ����
			System.out.printf("About %d~%d minutes used for humidify\n",HMtime,HMtime+10);
			count_humidify=0;
		}
		else if (count_dehumidify>0) {
			int HMtime = (count_dehumidify/10)*10;
			System.out.printf("About %d~%d minutes used for dehumidify\n",HMtime,HMtime+10);
			count_dehumidify=0;
		}
		else System.out.println("No times used for humidity change");
	}
}
