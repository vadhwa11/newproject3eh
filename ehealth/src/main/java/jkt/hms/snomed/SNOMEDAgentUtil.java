package jkt.hms.snomed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import in.cdac.medinfo.csnotk.csnolib.agents.SNOMEDAgent;
import in.cdac.medinfo.csnotk.csnolib.api.ISNOMEDAgent;
import in.cdac.medinfo.csnotk.csnolib.commons.EnumSuffix;
import in.cdac.medinfo.csnotk.csnolib.model.Concept;
import in.cdac.medinfo.csnotk.csnolib.model.Description;
import in.cdac.medinfo.csnotk.csnolib.util.CSNOLogger;

public class SNOMEDAgentUtil
{
  private ISNOMEDAgent agent = new SNOMEDAgent();
  
  public Set<Description> getDescription(String query)
  {
    return this.agent.search(query);
  }
  
  public ArrayList<SuffixCount> getSuffixCountbyRelationship(String query)
  {
    Set<Description> descriptions = this.agent.search(query);
    List<String> ids = new ArrayList<String>();
    HashMap<EnumSuffix, List<Concept>> map = new HashMap<EnumSuffix, List<Concept>>();
    ArrayList<SuffixCount> suffixCountList = new ArrayList<SuffixCount>(map.size());
    
    Set<String> conceptIds = new HashSet<String>();
    for (Description description : descriptions) {
      conceptIds.add(String.valueOf(description.getConceptId()));
    }
    ids.addAll(conceptIds);
    
    List<Concept> concepts = this.agent.getConcepts(ids);
    for (Concept concept : concepts)
    {
      EnumSuffix suffix = null;
      try
      {
        suffix = concept.getSuffix();
      }
      catch (Exception e)
      {
        StackTraceElement[] arrStackTraceElement = e.getStackTrace();
        String strMessage = e.getClass() + "\r\n" + "Class Name: " + arrStackTraceElement[0].getClassName() + "\r\n" + "Method Name: " + arrStackTraceElement[0].getMethodName() + "\r\n" + "Line Number: " + arrStackTraceElement[0].getLineNumber() + "\r\n" + "Message: " + e.getMessage();
        
        CSNOLogger.logException(strMessage);
      }
      if (!map.containsKey(suffix))
      {
        List<Concept> set = new ArrayList();
        set.add(concept);
        map.put(suffix, set);
      }
      else
      {
        List<Concept> list = (List)map.get(suffix);
        list.add(concept);
        map.put(suffix, list);
      }
    }
    for (Entry<EnumSuffix, List<Concept>> entry : map.entrySet())
    {
      SuffixCount count = new SuffixCount();
      if((entry.getKey()==entry.getKey().DISORDER)||(entry.getKey()==entry.getKey().FINDING/*||(entry.getKey()==entry.getKey().PROCEDURE)*/)){
    	  count.setSuffix(entry.getKey().getValue());
    	  count.setCount(((List)entry.getValue()).size());
          count.setConcepts((List)entry.getValue());
          suffixCountList.add(count);
      }      
    }
    return suffixCountList;
  }
}