package ttcs.quanlyhdnk.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Date;
public class  DateTimeUtil {

    public static  String  LocalDateTimeToStringDayTime(LocalDateTime localDateTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        return localDateTime.format(dateTimeFormatter);
    }
    public static  String  LocalDateTimeToStringDay(LocalDateTime localDateTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDateTime.format(dateTimeFormatter);
    }
    public static  LocalDateTime StringToLocalDateTime(String string){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        return LocalDateTime.parse(string,dateTimeFormatter);
    }
    public static LocalDateTime DateToLocalDateTime(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    public static Date LocalDateTimeToDate(LocalDateTime localDate){
        return Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
    }

}
