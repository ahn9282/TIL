package prototype_pattern.yc;

public class Main2 {
    public static void main(String[] args) {
        DocumentTemplateManager.addTemplate("welcome", new TextDocument("Welcome, {name}!"));
        DocumentTemplateManager.addTemplate("meeting", new TextDocument("Meeting scheduled on {date} at {time}"));

        Document welcomeDoc = DocumentTemplateManager.createDocument("welcome");
        welcomeDoc.setContent(welcomeDoc.getContent().replace("{name}", "John Doe"));

        System.out.println("Welcome document : " + welcomeDoc.getContent());

        Document meetingDoc = DocumentTemplateManager.createDocument("meeting");
        meetingDoc.setContent(meetingDoc.getContent().replace("{date}", "2025-09-29").replace("{time}", "15:00"));

        System.out.println("Meeting document : " + meetingDoc.getContent());
    }
}
