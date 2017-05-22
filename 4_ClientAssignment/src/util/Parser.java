package util;


public class Parser {
	
	public boolean getIsSuccess(String returnStr){
		if(returnStr.equals("true"))
			return true;
		else return false;
	}
	
	
	public String[][] fndBookParser(String returnStr){
		
		/* Client的Parser
		 * 客户端收到的是查询结果：attr,attr,attr|attr,attr,attr
		 * 这里返回String[][]
		 */
		String[] firstSplit = returnStr.split("\\|");
		String[][] booklist = new String[firstSplit.length][3];
		for(int i=0;i<firstSplit.length;i++){
			String[] attrs = firstSplit[i].split(",");
			booklist[i][0] = attrs[0];
			booklist[i][1] = attrs[1];
			booklist[i][2] = attrs[2];
		}
		return booklist;
	}


	
}
