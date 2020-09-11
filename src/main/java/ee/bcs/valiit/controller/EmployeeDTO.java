package ee.bcs.valiit.controller;

public class EmployeeDTO {      //Ei ole äriloogikat, kasutan ainult andmete liigutamiseks NB!!! Siia kunagi koodi ei kirjuta
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
