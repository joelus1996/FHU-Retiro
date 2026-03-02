package pe.com.intralot.loto.layer.dto.reniec;

public class ReniecWsResponse {

		private Object  data;
		private Integer error_code;
		private String error_message;
		public Object  getData() {
			return data;
		}
		public Integer getError_code() {
			return error_code;
		}
		public void setError_code(Integer error_code) {
			this.error_code = error_code;
		}
		public String getError_message() {
			return error_message;
		}
		public void setError_message(String error_message) {
			this.error_message = error_message;
		}
		public void setData(Object  data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return "ReniecWsResponse [data=" + data + ", error_code=" + error_code + ", error_message=" + error_message
					+ "]";
		}
		
		
		
		
		
}
