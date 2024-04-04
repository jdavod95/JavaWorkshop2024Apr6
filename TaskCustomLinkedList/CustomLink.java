
public class CustomLink {

	private CustomLink nextLink;
	private Number value;
	
	CustomLink(Number value){
		this.value = value;
	}
	
	public CustomLink getNextLink() {
		return nextLink;
	}
	
	public void setNextLink(CustomLink nextLink) {
		this.nextLink = nextLink;
	}
	
	public Number getValue() {
		return value;
	}
	
	public void setValue(Number value) {
		this.value = value;
	}
	
	
}
