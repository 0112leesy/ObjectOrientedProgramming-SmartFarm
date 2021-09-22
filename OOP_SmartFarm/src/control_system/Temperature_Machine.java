package control_system;

public class Temperature_Machine {
	private int count_cooling;//냉방으로 낮춰진 온도
	private int count_heating;//난방으로 오른 온도
	void cooling(Sensor sensor){//냉방 가동 (Sensor 메세지패싱)
		sensor.temperature_change(-1);//Sensor 클래스의 temperature_change 함수 사용
		count_cooling++;
	}
	void heating(Sensor sensor) {//난방 가동 (Sensor 메세지패싱)
		sensor.temperature_change(1);//Sensor 클래스의 temperature_change 함수 사용
		count_heating++;
	}
	void show_TMcount(){//온도 변화 리포트
		if (count_cooling>0) System.out.println("*COOLED* "+count_cooling+" degrees");
		else if (count_heating>0) System.out.println("*HEATED* "+count_heating+" degrees");
		else System.out.println("*Temperature Machine not runned*");
		
	}
	void show_TMtime() {//소요 시간 리포트	
		if (count_cooling>0) {
			int TMtime = (count_cooling/3)*10;//-> 10분동안 3도 정도의 온도변화가 있다고 가정
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
