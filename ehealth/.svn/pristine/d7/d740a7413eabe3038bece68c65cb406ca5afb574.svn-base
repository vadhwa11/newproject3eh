package jkt.hms.snomed;

import in.cdac.medinfo.csnotk.csnolib.model.Concept;
import in.cdac.medinfo.csnotk.csnolib.model.Description;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.lowagie.tools.concat_pdf;

public class TermFinderServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
  {
    HttpSession session = request.getSession(true);
    String query = URLDecoder.decode(request.getParameter("term"), "UTF-8");
    session.setAttribute("srcTerm", query);
    
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.setHeader("Cache-control", "no-cache, no-store");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "-1");
    
    //Set<Description> descriptions = new SNOMEDAgentUtil().getDescription(query);
    ArrayList<SuffixCount> suffixCountList = new SNOMEDAgentUtil().getSuffixCountbyRelationship(query);
    session.setAttribute("searchResult", suffixCountList);
    Gson gson = new Gson();
    String searchList = gson.toJson(suffixCountList);
    response.getWriter().write(searchList);
  }
  public static void main(String ar[])throws Exception{
	  	ArrayList<SuffixCount> suffixCountList = new SNOMEDAgentUtil().getSuffixCountbyRelationship("cold");
	    for(SuffixCount sf:suffixCountList){
	    	System.out.println(sf.getCount()+"\t"+sf.getSuffix()+"\t");
	    	for(Concept con: sf.getConcepts()){
	    		System.out.println("\tconcept ::");
	    		System.out.println("\t\t"+con.getId()+"\t"+con.getFullySpecifiedName());
	    		System.out.println("\tdescription ::");
	    		for(Description des:con.getDescriptions()){
	    			System.out.println("\t\t"+des.getId()+"\t"+des.getTerm());
	    		}
	    	}
	   }
  }
}
