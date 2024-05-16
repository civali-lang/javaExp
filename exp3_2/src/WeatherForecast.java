public class WeatherForecast {
    public static void main(String[] args) {
        WeatherForecast.test();//实验二
        WeatherForecast.lambdaTest();//实验三
    }
    public static void test(){//实验二
        System.out.print("星期一天气：");
        Weather weather=new Weather(new Cloudy());
        weather.show();

        System.out.print("星期二天气：");
        weather = new Weather(new Sunny());
        weather.show();

        System.out.print("星期三天气：");
        weather = new Weather(new Rainy());
        weather.show();

        System.out.print("星期四天气：");
        weather = new Weather(new Snowy());
        weather.show();
    }
    /**
     * 
     */
    public static void lambdaTest(){//实验三
        Weather weather=new Weather();
        System.out.print("星期五天气：");
        weather.setState(()->System.out.println("暴雨"));
        weather.show();

        System.out.print("星期六天气：");
        weather.setState(()->System.out.println("冰雹"));
        weather.show();

        System.out.print("星期日天气：");
        weather.setState(()->System.out.println("冻雨"));
        weather.show();
    }
}
