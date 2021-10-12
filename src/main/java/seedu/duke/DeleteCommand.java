package seedu.duke;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DeleteCommand {
    LocalDateTime startDate;
    int option_number = 0;

    public DeleteCommand(String date, String option){
        this.startDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-M-d"));
        option_number = Integer.parseInt(option);
    }

    public void execute(List<Bookings> bookings){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        for(Bookings booking : bookings){
            if(LocalDateTime.parse(booking.getStartDate().format(formatter), formatter)  == startDate ){
                option_number = option_number - 1;
            }
            if(option_number == 0){
                bookings.remove(booking);
                System.out.println("Successfully removed Appointment at" + booking.getStartDateString());
                return;
            }
        }

        System.out.println("Your appointment is not stored in our calendar. Please input a new command");
    }

    public static String getHelp(){
        return "del [Appointment_Start_Date] /o [Option_Number]";
    }
}
