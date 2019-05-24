package test;

import java.io.EOFException;

import interpreter.Interpreter;

public class MyInterpreter {

	public static int interpret(String[] lines){
		String[] paths = {"/instrumentation/airspeed-indicator/indicated-speed-kt",
				"/instrumentation/altimeter/indicated-altitude-ft", 
				"/instrumentation/altimeter/pressure-alt-ft",
				"/instrumentation/attitude-indicator/indicated-pitch-deg",
				"/instrumentation/attitude-indicator/indicated-roll-deg",
				"/instrumentation/encoder/indicated-altitude-ft",
				"/instrumentation/encoder/pressure-alt-ft",
				"/instrumentation/gps/indicated-altitude-ft",
				"/instrumentation/gps/indicated-ground-speed-kt",
				"/instrumentation/gps/indicated-vertical-speed",
				"/instrumentation/heading-indicator/indicated-heading-deg",
				"/instrumentation/magnetic-compass/indicated-heading-deg",
				"/instrumentation/slip-skid-ball/indicated-slip-skid",
				"/instrumentation/turn-indicator/indicated-turn-rate",
				"/instrumentation/vertical-speed-indicator/indicated-speed-fpm",
				"/controls/flight/aileron",
				"/controls/flight/elevator",
				"/controls/flight/flaps",
				"/controls/engines/engine/throttle",
				"/engines/engine/rpm"
				};
		String[] paths2 = {"simX", "simY", "simZ"};
		Interpreter ipter = new Interpreter(paths2) {
			int i = 0;
			@Override
			public String getLine() throws EOFException {
				if (i >= lines.length)
					throw new EOFException();
				return lines[i++];
			}
			
		};
		ipter.run();
		return (int) ipter.getReturnValue();
	}
}
