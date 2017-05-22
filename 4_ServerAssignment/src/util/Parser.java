package util;

public class Parser {
	
	public String[] MyParser(String receiveStr){
		String splt[] = receiveStr.split(":");
		String oper = splt[0];
		String attr = splt[1];
		switch(oper){
		case "addbook": {	//addbook:bookname, author, price
			String attrs[]=attr.split(",");
			String bookname = attrs[0];
			String author = attrs[1];
			String price = attrs[2];
			String[] parsedStr = {"addbook",bookname,author,price};
			return parsedStr;
		}
		case "delbybookname":{
			String attrs[]=attr.split(",");
			String bookname = attrs[0];
			String[] parsedStr = {"delbybookname",bookname};
			return parsedStr;
		}
		case "delbyauthor":{
			String attrs[]=attr.split(",");
			String author = attrs[0];
			String[] parsedStr = {"delbyauthor",author};
			return parsedStr;
		}
		case "fndbybookname":{
			String attrs[]=attr.split(",");
			String bookname = attrs[0];
			String[] parsedStr = {"fndbybookname",bookname};
			return parsedStr;
		}
		case "fndbyauthor":{
			String attrs[]=attr.split(",");
			String author  = attrs[0];
			String[] parsedStr = {"fndbyauthor",author};
			return parsedStr;
		}
		case "fndbyprice":{
			String attrs[]=attr.split(",");
			String lowbound = attrs[0];
			String upbound = attrs[1];
			String[] parsedStr = {"fndbyprice",lowbound,upbound};
			return parsedStr;
		}
		case "altbook":{
			String attrs[]=attr.split(",");
			String cursorbookname = attrs[0];
			String bookname = attrs[1];
			String author = attrs[2];
			String price = attrs[3];
			String[] parsedStr = {"altbook",cursorbookname,bookname,author,price};
			return parsedStr;
		}
		case "prtallbook":{
			String[] parsedStr = {"prtallbook"};
			return parsedStr;
		}
		default: return null;
		}
	}
}


