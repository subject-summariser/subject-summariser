/*
 * Generates a .ics file from a summarised subject outline
 *
 * @author  Melisa Sachi (11984566)
 * @date    04/10/16
 * @version 1.0
 */

package ICSGenerator;

import SubjectOutlineSummary.SubjectOutlineSummary;
import SubjectOutlineSummary.Assessment;
import SubjectOutlineSummary.Date;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import java.time.LocalDateTime;

/* Simulates a static class */
public final class ICSGenerator
{
    private final static String header = "BEGIN:VCALENDAR\n" +
                                         "PRODID:-//Subject Outline Summariser\n" +
                                         "VERSION:2.0\n" +
                                         "CALSCALE:GREGORIAN\n" +
                                         "METHOD:PUBLISH\n" +
                                         "X-WR-CALNAME:SOS Calendar\n" +
                                         "X-WR-TIMEZONE:Australia/Sydney\n" +
                                         "X-WR-CALDESC:\n";
    private final static String footer = "END:VCALENDAR";
    private final static String eventBegin = "BEGIN:VEVENT\n";
    private final static String eventEnd = "END:VEVENT\n";
    
    public static void main(String[] args)
    {
        Date date0 = new Date(2, 11, 2016);
        Date date1 = new Date(3, 11, 2016);
        
        Assessment[] assessments = new Assessment[3];
        assessments[0] = new Assessment("Assessment task 1: Project - Phase 1: Agile Planning, Analysis and Architecture",
                                        "Project", "Group, group and individually assessed", 30,
                                        "This assessment task will require a team of 4-6 students to analyse the assigned Agile Project Case Study problem; and produce, submit and present a group report containing\n" +
                                        "agile plan;\n" +
                                        "software requirements specifications;\n" +
                                        "agile architecture; and\n" +
                                        "software prototype\n" +
                                        "The deliverables of this assessment task also includes an oral/visual group report and prototype presentation (no PowerPoint slides), and individual contribution logbooks - as per Subject Weekly Schedule. Students may choose to work in a lab or from home. The additional information about the Agile Project Case Study and assessment tasks will be provided in the project brief. To pass this subject, the students must complete and submit this assessment task. To pass this task, the individual must earn >= net 50% marks for the task.",
                                        date0);
        assessments[1] = new Assessment("Assessment task 2: Project - Phase 3: Agile Design, Implementation and Testing",
                                        "Project", "Group, group and individually assessed", 30,
                                        "This assessment task will require a team of 4-6 students to produce, submit and present a group report, working software and individual contribution logbooks. Based on the agile plan, requirements and architecture (submitted for Assessment Items 1), and each group shall\n" +
                                        "develop the software system design;\n" +
                                        "implement the software system design; and\n" +
                                        "prepare, submit and present a report that includes the description of major software system features, non-functional aspects, and software testing results with executed tests and defect log.\n" +
                                        "The deliverables of this assessment task also includes updated agile plan, an oral/visual presentation (no PowerPoint slides) of the implemented working system, individual contribution logbooks and working software code implemented - as per Subject Weekly Schedule. Each group shall explore different ways of ensuring quality outcomes through the agile development and testing approach. This can be supported through a set of software development and testing tools. To pass this subject, the students must complete and submit this assessment task. To pass this task, the individual must earn >= net 50% marks for the task.",
                                        date1);
        assessments[2] = new Assessment("Assessment task 3: Short Quiz",
                                        "Quiz/test", "Individual", 40,
                                        "It includes 5 pre-workshop quizzes/tests (complete before the scheduled workshop session) and 5 in-workshop individual quizzes (of about maximum 20 minutes each, held as the first part of the workshop session). The quizzes shall measure the degree that the theory, as taught by the subject and practised by the individual in each of the phases of the project, is understood by each individual. No quiz submissions are allowed after the deadline. No makeup quizzes are allowed. Attendance at all workshop sessions is required. To pass this task, the individual must earn >= net 50% marks for the task.",
                                        null);
        
        SubjectOutlineSummary test = new SubjectOutlineSummary(48440, "Software Engineering Practice",
                                     "Coordinator:\n" +
                                     "Dr Asif Q. Gill\n" +
                                     "Asif.Gill@uts.edu.au\n" +
                                     "Ph: 9514 7938\n" +
                                     "Fax: 9514 4535\n" +
                                     "Room: CB11.07.119\n" +
                                     "Consultation hours (by appointment): Tuesday 3:00 PM to 4:00 PM\n" +
                                     "\n" +
                                     "Formal contact with all teaching staff is via the initial subject induction lecture (one-off) and weekly workshop sessions (tutorial and lab). A formal appointment must be made with the Subject Coordinator via email or phone prior for consultation. If you do not arrive within the first 10 minutes of the allocated appointment time, the appointment shall be abandoned - unless prior arrangements have been made.\n" +
                                     "\n" +
                                     "Lecturer:\n" +
                                     "Dr Asif Q. Gill, Asif.Gill@uts.edu.au\n" +
                                     "Tutors: TBC\n" +
                                     "Dr Asif Q. Gill, Asif.Gill@uts.edu.au\n" +
                                     "Dr. Atif Qureshi, Muhammad, Atif.Qureshi@uts.edu.au\n" +
                                     "Ms. Zahra Saeed, Zahra.Saeed@uts.edu.au\n" +
                                     "Mr. Georges Bou Ghantous, Georges.BouGhantous-1@uts.edu.au",
                                     "Software engineering lifecycle, methodologies, frameworks\n" +
                                     "Software quality, ISO standards and risks\n" +
                                     "Software planning\n" +
                                     "Software requirements, architecture, design, construction, testing, integration\n" +
                                     "Software configuration management\n" +
                                     "Tools and automation",
                                     assessments,
                                     "In order to pass the subject you must\n" +
                                     "earn an overall total of 50 marks or more for the subject; and\n" +
                                     "have submitted two project assessment tasks (Assessment Items 1-2) containing all the required items; and\n" +
                                     "have submitted an Individual Contribution Logbook with the project assessment tasks (Assessment Items 1-2) containing all the required items.\n" +
                                     "\n" +
                                     "Note: The Individual Contribution Logbook is mandatory for students to receive any individual project marks. If a student does not submit this assessment item, then he/she will receive zero for the project assessment tasks (Assessment Items 1-2)",
                                     "There shall be no supplementary assessments.",
                                     null,
                                     "This is a dynamic and practical subject. There is no fixed or single text book for this subject. However, students may choose to buy and consult the relevant recommended books and references.");
        
        ICSGenerator aGenerator = new ICSGenerator();
        
        GenerateICS(test, "testfile");
    }
    
    private ICSGenerator()
    {
    }
    
    ////////// ADD IN FILEPATH ARGUMENT LATER ///////////////////////////////////////////////////////////
    public static boolean GenerateICS(SubjectOutlineSummary summary, String filename)
    {
        try
        {
            File file = new File(filename + ".ics");
            if (!file.exists())
            {
                file.createNewFile();
            }
            
            try (FileOutputStream out = new FileOutputStream(file))
            {
                try (FileWriter writer = new FileWriter(file))
                {
                    writer.append(header);
                    int uidNb = 1;
                    for (Assessment assessment: summary.GetAssessments())
                    {
                        if (assessment.GetDueDate() != null)
                        {
                            String uid = "uid" + Integer.toString(uidNb) + "@example.com";
                            writer.append(CreateEventStr(assessment, uid));
                            uidNb++;
                        }
                    }
                    writer.append(footer);

                    writer.flush();
                }

                System.out.println("Done");
                return true;
            }
        }
        catch (Exception e)
        {
            System.out.println("Error");
            return false;
        }        
    }
    
    private static String CreateEventStr(Assessment assessment, String uid)
    {
        String dueDate = FormatDate(assessment.GetDueDate());
        String timestamp = GenerateTimestamp();
        
        String eventText = eventBegin +
                           "DTSTART;VALUE=DATE:" + dueDate + "\n" +
                           "DTEND;VALUE=DATE:" + dueDate + "\n" +
                           "DTSTAMP:" + timestamp + "\n" +
                           "UID:" + uid + "\n" +
                           "CREATED:" + timestamp + "\n" +
                           "DESCRIPTION:\n" +
                           "LAST-MODIFIED:" + timestamp + "\n" +
                           "LOCATION:\n" +
                           "SEQUENCE:1\n" +
                           "STATUS:CONFIRMED\n" +
                           "SUMMARY:" + assessment.GetAssessmentName() + "\n" +
                           "TRANSP:OPAQUE\n" +
                           eventEnd;
        
        return eventText;
    }
    
    /*
     *  Formats date as YYYYMMDD
     */
    private static String FormatDate(Date date)
    {
        return FormatDateTimeStr(date.GetYear()) + FormatDateTimeStr(date.GetMonth()) + FormatDateTimeStr(date.GetDay());
    }
    
    private static String FormatDateTimeStr(int nb)
    {
        if(nb < 10)
        {
            return "0" + Integer.toString(nb);
        }
        else
        {
            return Integer.toString(nb);
        }
    }
    
    private static String GenerateTimestamp()
    {
        LocalDateTime dateTime = LocalDateTime.now();
        
        String dateStr = FormatDateTimeStr(dateTime.getYear()) + FormatDateTimeStr(dateTime.getMonthValue()) + FormatDateTimeStr(dateTime.getDayOfMonth()) +
                         "T" + FormatDateTimeStr(dateTime.getHour()) + FormatDateTimeStr(dateTime.getMinute()) + FormatDateTimeStr(dateTime.getSecond());     
        
        return dateStr;
    }
}
