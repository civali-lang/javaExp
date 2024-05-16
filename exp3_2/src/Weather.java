public class Weather {
    WeatherState state;
    public Weather(){}
    public Weather(WeatherState state){
        this.state=state;
    }
    public void setState(WeatherState state){
        this.state=state;
    }
    
    public void show(){
        state.showState();
    }
}
