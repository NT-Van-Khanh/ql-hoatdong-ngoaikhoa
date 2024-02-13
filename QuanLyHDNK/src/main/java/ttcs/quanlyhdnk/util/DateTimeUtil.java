package ttcs.quanlyhdnk.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;
public class  DateTimeUtil {

    public static  String  LocalDateTimeToString(LocalDateTime localDateTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        return localDateTime.format(dateTimeFormatter);
    }
    
    public static  LocalDateTime StringToLocalDateTime(String string){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        return LocalDateTime.parse(string,dateTimeFormatter);
    }
    
}
