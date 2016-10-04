/*
 * Object class representing an assessment task.
 * Cannot be changed after initial construction.
 *
 * @author  Melisa Sachi (11984566)
 * @date    30/09/16
 * @version 1.0
 */

package SubjectOutlineSummary;

public class Assessment
{
    private final String AssessmentName;
    private final String Type;
    private final String Groupwork;
    private final int Weighting;
    private final String Description;
    private final Date DueDate;
    
    public Assessment(String assessmentName, String type, String groupwork, int weighting, String description, Date dueDate)
    {
        AssessmentName = assessmentName;
        Type = type;
        Groupwork = groupwork;
        Weighting = weighting;
        Description = description;
        DueDate = dueDate;
    }
    
    public String GetAssessmentName()
    {
        return AssessmentName;
    }
    
    public String GetType()
    {
        return Type;
    }
    
    public String GetGroupwork()
    {
        return Groupwork;
    }
    
    public int GetWeighting()
    {
        return Weighting;
    }
    
    public String GetDescription()
    {
        return Description;
    }
    
    public Date GetDueDate()
    {
        return DueDate;
    }
}
