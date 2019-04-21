
package com.jkt.entities.indentkmcl;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jkt.entities.indentkmcl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jkt.entities.indentkmcl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IndentType }
     * 
     */
    public IndentType createIndentType() {
        return new IndentType();
    }

    /**
     * Create an instance of {@link ItemListType }
     * 
     */
    public ItemListType createItemListType() {
        return new ItemListType();
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link IndentListResponseType }
     * 
     */
    public IndentListResponseType createIndentListResponseType() {
        return new IndentListResponseType();
    }

    /**
     * Create an instance of {@link IndentList }
     * 
     */
    public IndentList createIndentList() {
        return new IndentList();
    }

    /**
     * Create an instance of {@link BusinessFaultType }
     * 
     */
    public BusinessFaultType createBusinessFaultType() {
        return new BusinessFaultType();
    }

    /**
     * Create an instance of {@link IndentListRequestType }
     * 
     */
    public IndentListRequestType createIndentListRequestType() {
        return new IndentListRequestType();
    }

}
