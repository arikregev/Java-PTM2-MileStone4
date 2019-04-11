package Main;

import java.io.EOFException;

import interpreter.Interpreter;

public class Main {

	public static void main(String[] args) {
		Interpreter i = new Interpreter() {
			@Override
			public String getLine() throws EOFException {
				String s = "openDataServer 5400 10 connect 127.0.0.1 5402"
						+ "var breaks = bind \"/controls/flight/speedbrake\""
						+ "var throttle = bind \"/controls/engines/current-engine/throttle\""
						+ "var heading = bind \"/instrumentation/heading-indicator/offset-deg\""
						+ "var airspeed = bind \"/instrumentation/airspeed-indicator/indicated-speed-kt\""
						+ "var roll = bind \"/instrumentation/attitude-indicator/indicated-roll-deg\""
						+ "var pitch = bind \"/instrumentation/attitude-indicator/internal-pitch-deg\""
						+ "var rudder = bind \"/controls/flight/rudder\""
						+ "var aileron = bind \"/controls/flight/aileron\""
						+ "var elevator = bind \"/controls/flight/elevator\""
						+ "var alt = bind \"/instrumentation/altimeter/indicated-altitude-ft\""
						+ "breaks = 0"
						+ "throttle = 1"
						+ "var h0 = heading"
						+ "while alt < 1000 {"
						+ "	rudder = (h0 – heading)/20"
						+"}";
				return s;
			}
		};
		i.run();
	}

}
