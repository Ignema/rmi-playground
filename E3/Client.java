import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.text.MessageFormat;

public class Client {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 1236);
			IClassroom classroom = (IClassroom) registry.lookup("classroom");

			// Add students
			List<IStudent> students = new ArrayList<>();
			students.add(new Student("John", "Doe", 1));
			students.add(new Student("Jane", "Doe", 2));
			students.add(new Student("John", "Smith", 3));
			students.add(new Student("Rick", "Roll", 4));
			
			// Add students to classroom
			classroom.setStudents(students);

			// Add grades
			classroom.getStudents().forEach(student -> {
				Random rand = new Random();
				try {
					student.addExam(new Exam("Math", rand.nextFloat(20), 0.9));
					student.addExam(new Exam("English", rand.nextFloat(20), 0.6));
					student.addExam(new Exam("History", rand.nextFloat(20), 0.5));
					student.addExam(new Exam("Science", rand.nextFloat(20), 0.8));
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			});

			// Show exams for each student
			classroom.getStudents().forEach(student -> {
				try {
					System.out.println(MessageFormat.format("\nStudent {0} {1} ({2}) has the following exams:", student.getFirstName(), student.getLastName(), student.getStudentId()));
					student.displayExams();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			});

			// Compute grades
			System.out.println("\nGlobal grades:");
			classroom.getStudents().forEach(student -> {
				try {
					System.out.println(MessageFormat.format("Student {0} has a global grade of {1}", student.getStudentId(), student.computeGlobalGrade()));
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			});

			// Compute classroom average
			System.out.println(MessageFormat.format("\nThe classroom average is {0}", classroom.computeClassroomAverage()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}