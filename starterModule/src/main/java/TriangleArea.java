public class TriangleArea {

		public static double calcArea(int a, int b, int c) {
			if (a<=0 || b<=0 || c<=0) {
				return 0;
			}
			double p = (a+b+c)/2;
			double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
			System.out.println("Площадь треугольника = " + s);
			return s;
		}


}
