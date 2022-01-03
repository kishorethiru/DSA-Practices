package sdetmeet;

/**
 * @author Kishore
 *
 */
public class Employee {
	
	
	public abstract class EmployeeAbs{
		abstract void setSalary(int salary);
		abstract int getSalary();
		abstract void setGrade(String grade);
		abstract String getGrade();		
	}
	
	public class Engineer extends EmployeeAbs{
		private int salary;
		private String grade;
		public void setSalary(int salary) {
			this.salary = salary;
		}

		@Override
		public int getSalary() {
			return salary;
			
		}

		@Override
		void setGrade(String grade) {
		  this.grade = grade;			
		}

		@Override
		public String getGrade() {
			return grade;
		}
	}
	
	public class Manager extends EmployeeAbs{
		private int salary;
		private String grade;
		@Override
		void setSalary(int salary) {
			this.salary = salary;			
		}
		@Override
		int getSalary() {
			return salary;
		}
		@Override
		void setGrade(String grade) {
			this.grade = grade;
			
		}
		@Override
		String getGrade() {
			return grade;
		}
		
	}
}
