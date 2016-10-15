/*
 * Generates a .docx file from a summarised subject outline
 *
 * @author  Melisa Sachi (11984566)
 * @date    04/10/16
 * @version 1.0
 */

package DocumentGenerator;

import SubjectOutlineSummary.SubjectOutlineSummary;
import SubjectOutlineSummary.Assessment;
import SubjectOutlineSummary.Date;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/* Simulates a static class */
public final class DocGenerator
{
    /* USED FOR TESTING PURPOSES; TO BE TAKEN OUT IN FINAL PRODUCT */
    public static void main(String[] args)
    {
        Date date0 = new Date(5, 9, 2016);
        Date date1 = new Date(17, 10, 2016);
        
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
                                     "Test test test test",
                                     "This is a dynamic and practical subject. There is no fixed or single text book for this subject. However, students may choose to buy and consult the relevant recommended books and references.");
                
        boolean[] exclusions = {false, false, false, false, false, false};
        
        // /Users/Mel/Desktop/testDocument
        GenerateDoc(test, "testDocument", exclusions);
    }
    
    private DocGenerator()
    {
    }
    
    public static boolean GenerateDoc(SubjectOutlineSummary summary, String filepath, boolean[] fieldExclusions)
    {
        XWPFDocument doc = new XWPFDocument();
        
        try (FileOutputStream out = new FileOutputStream(new File(filepath + ".docx")))
        {            
            String labels[] = {"Key contacts: ",
                               "Content (topics): ",
                               "Minimum requirements: ",
                               "Supplementary Assessments: ",
                               "Late Penalty: ",
                               "Required Texts: "};
            
            String content[] = {summary.GetKeyContacts(),
                                summary.GetSubjectContent(),
                                summary.GetMinimumReq(),
                                summary.GetSuppAssessments(),
                                summary.GetLateAssessmentPenalty(),
                                summary.GetReqTexts()};
            
            AddHeading(doc, summary.GetSubjectNb() + " " + summary.GetSubjectName());
            
            int i;
            for (i = 0; i < 2; i++)
            {
                if (fieldExclusions[i] == false)
                {
                    AddMultipleLines(doc, labels[i], content[i], true);
                }
            }
            
            AddAssessments(doc, summary.GetAssessments());
            
            for (; i < 6; i++)
            {
                if (fieldExclusions[i] == false)
                {
                    AddMultipleLines(doc, labels[i], content[i], true);
                }
            }
            
            doc.write(out);
            System.out.println("Done");
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Error");
            return false;
        }
    }
    
    private static void AddHeading(XWPFDocument doc, String headingText)
    {
        XWPFParagraph headingPara = doc.createParagraph();
        XWPFRun headingRun = headingPara.createRun();
        headingRun.setText(headingText);
        headingRun.setBold(true);
        headingRun.setFontSize(18);
        headingPara.setAlignment(ParagraphAlignment.CENTER);
        
        AddWhitespace(doc);
    }
    
    /*
     *  Adds a new field to the document in the form
     *      label: text
     */
    private static void AddSingleLine(XWPFDocument doc, String label, String text, int tabs, boolean bShouldAddWhitespace)
    {     
        if (text == null)
        {
            return;
        }
        
        XWPFParagraph labelPara = doc.createParagraph();
        XWPFRun labelRun = labelPara.createRun();
        labelRun.setText(label);
        labelRun.setBold(true);

        XWPFRun textRun;

        for (int i = 0; i < tabs; i++)
        {
            labelRun.addTab();
        }
        
        textRun = labelPara.createRun();
        textRun.setText(text);
        
        if (bShouldAddWhitespace)
        {
            AddWhitespace(doc);
        }
    }
    
    /*
     *  Adds a new field to the document in the form
     *      label:
     *      text
     *      text etc.
     */
    private static void AddMultipleLines(XWPFDocument doc, String label, String text, boolean bShouldAddWhitespace)
    {
        if (text == null)
        {
            return;
        }
        
        XWPFParagraph labelPara = doc.createParagraph();
        XWPFRun labelRun = labelPara.createRun();
        labelRun.setText(label);
        labelRun.setBold(true);
        
        String[] paragraphs = text.split("\\r?\\n");
        
        for (String paragraph: paragraphs)
        {
            XWPFParagraph para = doc.createParagraph();
            XWPFRun textRun = para.createRun();
            textRun.setText(paragraph);
        }
        
        if (bShouldAddWhitespace)
        {
            AddWhitespace(doc);
        }
    }
    
    private static void AddAssessments(XWPFDocument doc, Assessment[] assessments)
    {
        XWPFParagraph para = doc.createParagraph();
        XWPFRun subheadingRun = para.createRun();
        subheadingRun.setText("Assessments: ");
        subheadingRun.setBold(true);
        
        for (Assessment assessment : assessments)
        {
            AddAssessment(doc, assessment);
        }
    }
    
    private static void AddAssessment(XWPFDocument doc, Assessment assessment)
    {
        XWPFParagraph para = doc.createParagraph();

        XWPFRun assessmentNameRun = para.createRun();
        assessmentNameRun.setText(assessment.GetAssessmentName());
        assessmentNameRun.setBold(true);
                
        AddSingleLine(doc, "Type: ", assessment.GetType(), 0, false);
        AddSingleLine(doc, "Groupwork: ", assessment.GetGroupwork(), 0, false);
        AddSingleLine(doc, "Weight: ", Integer.toString(assessment.GetWeighting()) + "%", 0, false);
        if (assessment.GetDueDate() != null)
        {
            AddSingleLine(doc, "Due: ", assessment.GetDueDate().toString(), 0, true);
        }
        else
        {
            AddWhitespace(doc);
        }
        AddMultipleLines(doc, "Task: ", assessment.GetDescription(), true);
    }
    
    private static void AddWhitespace(XWPFDocument doc)
    {
        XWPFParagraph whitespacePara = doc.createParagraph();
        XWPFRun whitespaceRun = whitespacePara.createRun();
        whitespaceRun.setText("");
    }
}

