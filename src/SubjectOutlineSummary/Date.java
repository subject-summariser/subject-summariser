/*
 * Object class representing a date.
 * Cannot be changed after initial construction.
 *
 * @author  Melisa Sachi (11984566)
 * @date    30/09/16
 * @version 1.0
 */

package SubjectOutlineSummary;

public class Date
{
    private final int Day;
    private final int Month;
    private final int Year;
    
    public Date(int day, int month, int year)
    {
        Day = day;
        Month = month;
        Year = year;
    }
    
    public int GetDay()
    {
        return Day;
    }
    
    public int GetMonth()
    {
        return Month;
    }
    
    public int GetYear()
    {
        return Year;
    }
    
    @Override
    public String toString()
    {
        return Day + "/" + Month + "/" + Year;
    }
}
