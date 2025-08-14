public class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void displayInfo() {
        System.out.println("Roll No: " + rollNumber + ", Name: " + name);
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Rajat", 8.5);
        pg.displayInfo();
        System.out.println("CGPA: " + pg.getCGPA());
    }
}
