
import java.util.Calendar;
import java.util.Scanner;

public class Example {
    /**
     * Check that the age is between 18 and 100
     * @param year
     * @return
     */
    public void isYearOfBirthCorrect(int year) {
        Integer yearNow = Calendar.getInstance().get(Calendar.YEAR);
        Integer difference = yearNow-year;
        if(difference<=18||difference>=100) {
            throw new IllegalYearOfBirthException("IllegalYearOfBirthException");
        }
    }

    /**
     * Checking authentification credentionals
     * @param username
     * @param password
     * @throws InvalidCredentialsException
     */
    public void auth(String username, String password) throws InvalidCredentialsException {
        if(username.equals("root")&& password.equals("pwd12345")){
            System.out.println("You have an access");
        }else{
            throw new InvalidCredentialsException("invalid credentials");
        }
    }

    //just fot example, firstly we need to have an access to app, which check input value
    public static void main(String[] args) {
        Example ex = new Example();
        String username="root";
        String password = "pwd12345"; //TODO: change value to "pwd12345" for taking access
        try (Scanner sc = new Scanner(System.in);){
            ex.auth(username,password);
            System.out.print("Enter the year of your birth: ");
            int year = Integer.parseInt(sc.nextLine());
            ex.isYearOfBirthCorrect(year);
            System.out.print("Year is OK");
        }catch (InvalidCredentialsException exception){ //self-defined Checked Exception
            System.out.println("You have an exception: "+ exception);
        } catch (NumberFormatException nfe) {
            System.out.print("Is not a number: "+ nfe);
        } catch (IllegalYearOfBirthException e) { //self-defined Unchecked Exception
            System.out.print("You are too young: " + e);
        }
    }
}
