import java.util.Scanner;

public class User extends Mechanic{
    // Singleton pattern implementation
    private static User user;
    private final String name;
    private Command command;

    private User (String name) {
        super(name);
        this.name = name;
    }

    //singleton with lazy instantiation
    public static User getInstance() {
        if (user == null) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a name: ");
            String name = sc.nextLine();
            user = new User(name);
        }
        return user;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
