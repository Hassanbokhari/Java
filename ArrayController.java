package pkg;

public class ArrayController {
	
	private ArrayModel model;
	private ArrayView view;
	
	public ArrayController(ArrayModel Model, ArrayView View) {
		this.model = Model;
		this.view = View;
	}
	
	public void updateView() {
		view.PrintArray(model.getArray());
		System.out.println("");
	}
	
	public void sortArray() {
		this.model.Sort();
	}
	
	public void Search(int x) {
		this.model.Search(x);
	}
	
	public void max() {
		System.out.println("Max: " + this.model.max());
	}
	
	public void min() {
		System.out.println("Min: " + this.model.min());
	}
}
