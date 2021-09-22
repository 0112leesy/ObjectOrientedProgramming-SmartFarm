package control_system;

public class Humidity_Machine {
	private int count_dehumidify;//제습으로 낮아진 습도
	private int count_humidify;//가습으로 높아진 습도
	void dehumidify(Sensor sensor){//제습 가동 (Sensor 메세지패싱)
		sensor.humidity_change(-1);//Sensor 클래스의 humidity_change 함수 사용
		count_dehumidify++;
	}
	void humidify(Sensor sensor) {//가습 가동 (Sensor 메세지패싱)
		sensor.humidity_change(1);//Sensor 클래스의 humidity_change 함수 사용
		count_humidify++;
	}
	void show_HMcount(){//습도 변화 리포트
		if(count_dehumidify>0) System.out.println("*DEHUMIDIFIED* "+count_dehumidify+" percent");
		else if (count_humidify>0) System.out.println("*HUMIDIFIED* "+count_humidify+" percent");
		else System.out.println("*Humidity Machine not runned*");
	}
	void show_HMtime() {//소요 시간 리포트
		if (count_humidify>0) {
			int HMtime = (count_humidify/10)*10;//-> 10분동안 10 퍼센트 정도의 습도변화가 생긴다고 가정
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
