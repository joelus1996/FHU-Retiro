package pe.com.intralot.loto.layer.model.bean;


import org.apache.commons.lang3.builder.ToStringStyle;

public class JsonStyle extends ToStringStyle {
	  
	private static final long serialVersionUID = -3066347688241757784L;
	private static final String FIELD_NAME_QUOTE = "\"";

	public JsonStyle() { //constructor is copied from ToStringStyle.JSON_STYLE
    	super();

        this.setUseClassName(false);
        this.setUseIdentityHashCode(false);

        this.setContentStart("{");
        this.setContentEnd("}");

        this.setArrayStart("[");
        this.setArrayEnd("]");

        this.setFieldSeparator(", ");
        this.setFieldNameValueSeparator(":");

        this.setNullText("null");

        this.setSummaryObjectStartText("\"<");
        this.setSummaryObjectEndText(">\"");

        this.setSizeStartText("\"<size=");
        this.setSizeEndText(">\"");
        
    }

	//override this to do checking of null, so only non-nulls are printed out in toString
	@Override
	public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
	    if (value != null) {
	       super.append(buffer, fieldName, value, fullDetail);
	    } 
	}

	//override this to do checking of null, so only non-nulls are printed out in toString
	@Override
    protected void appendDetail(final StringBuffer buffer, final String fieldName, final Object value) {
	    if (value != null) {
	       // super.append(buffer, fieldName, value, fullDetail);

            if (value instanceof String || value instanceof Character) {
                appendValueAsString(buffer, value.toString());
                return;
            }

            if (value instanceof Number || value instanceof Boolean) {
                buffer.append(value);
                return;
            }

            final String valueAsString = value.toString();
            if (isJsonObject(valueAsString) || isJsonArray(valueAsString)) {
                buffer.append(value);
                return;
            }

            appendDetail(buffer, fieldName, valueAsString);
	    } 
	}
	
	private void appendValueAsString(final StringBuffer buffer, final String value) {
        buffer.append('"').append(value).append('"');
    }
	
	private boolean isJsonObject(final String valueAsString) {
        return valueAsString.startsWith(getContentStart())
                && valueAsString.endsWith(getContentEnd());
    }
	
    private boolean isJsonArray(final String valueAsString) {
        return valueAsString.startsWith(getArrayStart())
                && valueAsString.startsWith(getArrayEnd());
    }
    
    @Override
    protected void appendFieldStart(final StringBuffer buffer, final String fieldName) {

        if (fieldName == null) {
            throw new UnsupportedOperationException(
                    "Field names are mandatory when using JsonToStringStyle");
        }

        super.appendFieldStart(buffer, FIELD_NAME_QUOTE + fieldName
                + FIELD_NAME_QUOTE);
    }
	
}