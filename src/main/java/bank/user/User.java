package bank.user;

public class User {

    private final int userId;

    private String name;
    private String surname;

    public User(String name, String surname, int userId) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User)
            return
                    ((User) obj).userId == this.userId;
        else
            return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return userId;
    }
}
