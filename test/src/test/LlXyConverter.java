package test;

import java.util.*;

public class LlXyConverter {

	private static final int NX = 149, NY = 253;
	private static final double PI = Math.PI, DEGRAD = PI / 180.0, RADDEG = 180.0 / PI;
	private static final double GRID = 5.0f;
	private static final double RE = 6371.00877 / GRID;
	private static final double OLON = 126.0 * DEGRAD;
	private static final double XO = 210 / GRID, YO = 675 / GRID;
	private static double SN, SF, RO;
	private static boolean isInitalized = false;

	public static void init() {
		if (isInitalized)
			return;
		double slat1 = 30.0 * DEGRAD;
		double slat2 = 60.0 * DEGRAD;
		double OLAT = 38.0 * DEGRAD;
		SN = Math.tan(PI * 0.25 + slat2 * 0.5) / Math.tan(PI * 0.25 + slat1 * 0.5);
		SN = Math.log(Math.cos(slat1) / Math.cos(slat2)) / Math.log(SN);
		SF = Math.tan(PI * 0.25 + slat1 * 0.5);
		SF = Math.pow(SF, SN) * Math.cos(slat1) / SN;
		RO = Math.tan(PI * 0.25 + OLAT * 0.5);
		RO = RE * SF / Math.pow(RO, SN);
		isInitalized = true;
	}

	public static boolean isXyValid(double x, double y) {
		if (x < 1 || x > NX || y < 1 || y > NY)
			return false;
		return true;
	}

	public static boolean isXyValid(Point2D p) {
		return isXyValid(p.x, p.y);
	}

	public static Point2D LonLat2xy(double lon, double lat) { // (경도, 위도) -> (x, y)
		if (!isInitalized)
			return null;
		double ra, theta;
		ra = Math.tan(PI * 0.25 + lat * DEGRAD * 0.5);
		ra = RE * SF / Math.pow(ra, SN);
		theta = lon * DEGRAD - OLON;
		if (theta > PI)
			theta -= 2.0 * PI;
		if (theta < -PI)
			theta += 2.0 * PI;
		theta *= SN;
		double x = Math.floor(ra * Math.sin(theta) + XO + 1.5);
		double y = Math.floor(RO - ra * Math.cos(theta) + YO + 1.5);
		return new Point2D(x, y);
	}

	public static Point2D xy2LonLat(double x, double y) { // (x, y) -> (경도, 위도)
		if (!isInitalized)
			return null;
		double xn, yn, ra, theta, alat, alon;
		xn = x - XO;
		yn = RO - y + YO;
		ra = Math.sqrt(xn * xn + yn * yn);
		if (SN < 0.0)
			ra -= ra;
		alat = Math.pow((RE * SF / ra), (1.0 / SN));
		alat = 2.0 * Math.atan(alat) - PI * 0.5;
		if (Math.abs(xn) <= 0.0) {
			theta = 0.0;
		} else if (Math.abs(yn) <= 0.0) {
			theta = PI * 0.5;
			if (xn < 0.0)
				theta -= theta;
		} else
			theta = Math.atan2(xn, yn);

		alon = theta / SN + OLON;
		double lat = alat * RADDEG;
		double lon = alon * RADDEG;

		return new Point2D(lon, lat);
	}

	public static void main(String[] args) {
		init();
		System.out.println("arg: mode num1 num2 (0: lon,lat->x,y   1: x,y->lon,lat)");
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt();
		double a = sc.nextDouble(), b = sc.nextDouble();
		Point2D point;
		if (mode == 0) {
			point = LonLat2xy(a, b);
		} else
			point = xy2LonLat(a, b);
		System.out.printf("result: %f %f \n", point.x, point.y);
	}

}

class Point2D {
	public double x, y;

	public Point2D(double x_, double y_) {
		x = x_;
		y = y_;
	}
}
