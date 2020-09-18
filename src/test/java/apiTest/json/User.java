package apiTest.json;

public class User {
    private String userEmail;
    private String userPassword;

    public User(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String toJson() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append("{\n")
                .append("\"")
                .append("email")
                .append("\"")
                .append(" : ")
                .append("\"")
                .append(userEmail)
                .append("\", \n")
                .append("\"")
                .append("password")
                .append("\"")
                .append(" : ")
                .append("\"")
                .append(userPassword)
                .append("\"")
                .append("\n")
                .append("}").toString();
    }
}
