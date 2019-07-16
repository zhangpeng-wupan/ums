package cn.tedu.springbootums.util;

public class JsonResult<T> {
	private Integer state;
	private String message;
	private T data;
	
	public JsonResult() {
		super();
	}
	public JsonResult(Integer state) {
		super();
		this.state = state;
	}
	public Integer getState() {
		return state;
	}
	public String getMessage() {
		return message;
	}
	public T getData() {
		return data;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
}
