package task.model;

public class PersonWithWeather {
    private Person person;
    private Object weather;

    public PersonWithWeather() {}

    public PersonWithWeather(Person person, Object weather) {
        this.person = person;
        this.weather = weather;
    }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }

    public Object getWeather() { return weather; }
    public void setWeather(Object weather) { this.weather = weather; }
}
