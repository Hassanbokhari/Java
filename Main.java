//	Created By Hassan Hussain Bokhari
//	P17-6059
//	Instructor: Sir Waqas Ali
//	Task # 2

package pkg;

public class Main {

	public static void main(String[] args) {
		ArrayModel model = new ArrayModel();
		ArrayView view = new ArrayView();
		
		ArrayController Controller = new ArrayController(model, view);
		
		Controller.updateView();
		
		Controller.sortArray();
		
		Controller.updateView();
		
		Controller.max();
		
		Controller.min();
		
		Controller.Search(3);
		
		Controller.Search(7);
	}
}
