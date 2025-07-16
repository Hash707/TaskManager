package task.manager.utility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QueryGenerator {

	private final String validDataTypes = "BIGINT, BINARY, BIT, BLOB, BOOLEAN, CHAR, CLOB, DATE, DECIMAL, DOUBLE, FLOAT, INT, INTEGER, LONGVARCHAR, NUMERIC, OTHER, REAL, SMALLINT, TIME, TIMESTAMP, TINYINT, VARBINARY, VARCHAR, UUID";
	Set<String> validDataType = new HashSet<>();
	
	
	private StringBuilder sb = new StringBuilder();

	public QueryGenerator(String tableName) {
		validDataType.addAll(Arrays.asList(validDataTypes.split(",")).stream().map(e -> e.trim()).toList());
		sb.append("create table " + tableName + "(");
	}

	public String getFinalQuery() {
		return sb.toString();
	}
	
	public void addColumn(String colName, String datatype, boolean isLastCol) throws Exception {

		if (!isValidColName(colName)) {
			throw new Exception("Please Enter valid column name for H2 database");
		}

		sb.append(colName);
		sb.append(" ");
		if(isLastCol) {
			sb.append(datatype + ");");
		}
		else {
			sb.append(datatype + ",");
		}
	}

	public void addColumn(String colName, String datatype, int length, boolean isLastCol) throws Exception {
		if (!isValidColName(datatype)) {
			throw new Exception("Please Enter valid column name for H2 database");
		}

		sb.append(colName);
		sb.append(" ");
		sb.append(datatype);
		sb.append("(");
		sb.append(length);
		if(isLastCol) {
			sb.append("));");
		}
		else {
			sb.append("),");
		}
	}

	private boolean isValidColName(String datatype) {
		System.out.println("Checked for column type : " + datatype);
		return validDataType.contains(datatype.toUpperCase());
	}

}
