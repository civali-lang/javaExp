public class WeatherForecast {
    public static void main(String[] args) {
        WeatherForecast.test();//实验二
        WeatherForecast.lambdaTest();//实验三
    }
    public static void test(){//实验二
        Weather weather=new Weather(new Cloudy());
        weather.show();
    }
    public static void lambdaTest(){//实验三
        Weather weather=new Weather();
        weather.setState(()->System.out.println("天气晴朗"));
        weather.show();

        weather.setState(()->System.out.println("下雨"));
        weather.show();

        weather.setState(()->System.out.println("下雪"));
        weather.show();
    }
}
