package control_system;

class Sensor {
	private int temperature;
	private int humidity;
	
	Sensor(){//객체 생성 시 온도, 습도값이 저장됨
		temperature = 10+(int)(Math.random()*20);	//temperature: 10~30 degree
		humidity = (int)(Math.random()*80);			//humidity: 0~80 degree
	}
	void temperature_change(int change) {//온도 변화
		temperature += change;
	}
	int get_temperature() {//온도값 출력
		return temperature;
	}
	void humidity_change(int change) {//습도 변화
		humidity += change;
	}
	int get_humidity() {//습도값 출력
		return humidity;
	}
	void show() {//현재 온도, 현재 습도 출력
		System.out.println("--------current condition--------");
		System.out.println("> temperature : "+temperature+"℃\n> humidity : "+humidity+"%");
		System.out.println("---------------------------------");
	}
	void refresh() {//온도, 습도 데이터 갱신
		temperature = 10+(int)(Math.random()*20);	
		humidity = (int)(Math.random()*80);
	}
}
