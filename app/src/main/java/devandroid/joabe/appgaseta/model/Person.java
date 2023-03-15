package devandroid.joabe.appgaseta.model;

public class Person {
    private String name;
    private String secondName;
    private String nameCourse;
    private String numberContact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getNumberContact() {
        return numberContact;
    }

    public void setNumberContact(String numberContact) {
        this.numberContact = numberContact;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + name + '\'' +
                ", sobreNome='" + secondName + '\'' +
                ", cursoDesejado='" + nameCourse + '\'' +
                ", telefoneContato='" + numberContact + '\'' +
                '}';
    }
}
