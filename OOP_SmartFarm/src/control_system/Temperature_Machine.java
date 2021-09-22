package control_system;

public class Temperature_Machine {
	private int count_cooling;//�ù����� ������ �µ�
	private int count_heating;//�������� ���� �µ�
	void cooling(Sensor sensor){//�ù� ���� (Sensor �޼����н�)
		sensor.temperature_change(-1);//Sensor Ŭ������ temperature_change �Լ� ���
		count_cooling++;
	}
	void heating(Sensor sensor) {//���� ���� (Sensor �޼����н�)
		sensor.temperature_change(1);//Sensor Ŭ������ temperature_change �Լ� ���
		count_heating++;
	}
	void show_TMcount(){//�µ� ��ȭ ����Ʈ
		if (count_cooling>0) System.out.println("*COOLED* "+count_cooling+" degrees");
		else if (count_heating>0) System.out.println("*HEATED* "+count_heating+" degrees");
		else System.out.println("*Temperature Machine not runned*");
		
	}
	void show_TMtime() {//�ҿ� �ð� ����Ʈ	
		if (count_cooling>0) {
			int TMtime = (count_cooling/3)*10;//-> 10�е��� 3�� ������ �µ���ȭ�� �ִٰ� ����
			System.out.printf("About %d~%d minutes used for cooling\n",TMtime,TMtime+10);
			count_cooling=0;
		}
		else if (count_heating>0) {
			int TMtime = (count_heating/3)*10;
			System.out.printf("About %d~%d minutes used for heating\n",TMtime,TMtime+10);
			count_heating=0;
		}
		else System.out.println("No times used for temperature change");
	}
		
}
