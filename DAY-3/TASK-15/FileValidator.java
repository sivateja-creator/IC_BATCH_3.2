public class FileValidator {
    String fileName = "student_report.pdf";

    void validateFile() {
        if (fileName.endsWith(".pdf")) {
            System.out.println("PDF File");
        } else {
            System.out.println("Different File Format");
        }
    }

    public static void main(String[] args) {
        FileValidator f = new FileValidator();

        f.validateFile();

        f.fileName = "photo.jpg";
        f.validateFile();

        f.fileName = "document.docx";
        f.validateFile();
    }
}