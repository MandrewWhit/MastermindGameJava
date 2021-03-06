package assignment2;

public class Response {
	int b; int w;

	public Response(int b, int w) {
		this.b = b; this.w = w;
	}
	
	public int getBlack() {
		return b;
	}
	
	public int getWhite() {
		return w;
	}
	
	@Override 
	public boolean equals(Object o) {
		if (!(o instanceof Response))
			return false;
		Response r = (Response)o;
		return r.b == b && r.w == w;
	}
}
