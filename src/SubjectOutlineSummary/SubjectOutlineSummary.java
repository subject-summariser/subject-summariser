/*
 * Object class representing a subject outline summary.
 * Cannot be changed after initial construction.
 * Fields can be set to NULL to indiciate that they are N/A.
 *
 * @author  Melisa Sachi (11984566)
 * @date    30/09/16
 * @version 1.0
 */

package SubjectOutlineSummary;

public class SubjectOutlineSummary
{
    private final int SubjectNb;
    private final String SubjectName;
    private final String KeyContacts;
    private final String SubjectContent;
    private final Assessment[] Assessments;
    private final String MinimumReq;
    private final String SuppAssessments;
    private final String LateAssessmentPenalty;
    private final String ReqTexts;
    
    public SubjectOutlineSummary(int subjectNb, String subjectName, String keyContacts,
                                 String subjectContent, Assessment[] assessments, String minimumReq,
                                 String suppAssessments, String lateAssessmentPenalty, String reqTexts)
    {
        SubjectNb = subjectNb;
        SubjectName = subjectName;
        KeyContacts = keyContacts;
        SubjectContent = subjectContent;
        Assessments = assessments;
        MinimumReq = minimumReq;
        SuppAssessments = suppAssessments;
        LateAssessmentPenalty = lateAssessmentPenalty;
        ReqTexts = reqTexts;
    }
    
    public int GetSubjectNb()
    {
        return SubjectNb;
    }
    
    public String GetSubjectName()
    {
        return SubjectName;
    }
    
    public String GetKeyContacts()
    {
        return KeyContacts;
    }
    
    public String GetSubjectContent()
    {
        return SubjectContent;
    }
    
    public Assessment[] GetAssessments()
    {
        return Assessments;
    }
    
    public String GetMinimumReq()
    {
        return MinimumReq;
    }
    
    public String GetSuppAssessments()
    {
        return SuppAssessments;
    }
    
    public String GetLateAssessmentPenalty()
    {
        return LateAssessmentPenalty;
    }
    
    public String GetReqTexts()
    {
        return ReqTexts;
    }
}
