/*
 * Generated by JasperReports - 17/11/15 12:25 PM
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.*;

import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.net.*;

import net.sf.jasperreports.engine.*;
import java.util.*;
import net.sf.jasperreports.engine.data.*;


/**
 *
 */
public class Opening_Closing_Account_Register_1447743340869_991688 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_financialYearId = null;
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_id = null;
    private JRFillField field_cl_balance_cr = null;
    private JRFillField field_op_balance_dr = null;
    private JRFillField field_ytd_amount_cr = null;
    private JRFillField field_acc_desc = null;
    private JRFillField field_transaction_date = null;
    private JRFillField field_ytd_amount_dr = null;
    private JRFillField field_op_balance_cr = null;
    private JRFillField field_cl_balance_dr = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_opening = null;
    private JRFillVariable variable_expense = null;
    private JRFillVariable variable_balance = null;


    /**
     *
     */
    public void customizedInit(
        Map pm,
        Map fm,
        Map vm
        )
    {
        initParams(pm);
        initFields(fm);
        initVars(vm);
    }


    /**
     *
     */
    private void initParams(Map pm)
    {
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_financialYearId = (JRFillParameter)pm.get("financialYearId");
        parameter_REPORT_TIME_ZONE = (JRFillParameter)pm.get("REPORT_TIME_ZONE");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_REPORT_FORMAT_FACTORY = (JRFillParameter)pm.get("REPORT_FORMAT_FACTORY");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
    }


    /**
     *
     */
    private void initFields(Map fm)
    {
        field_id = (JRFillField)fm.get("id");
        field_cl_balance_cr = (JRFillField)fm.get("cl_balance_cr");
        field_op_balance_dr = (JRFillField)fm.get("op_balance_dr");
        field_ytd_amount_cr = (JRFillField)fm.get("ytd_amount_cr");
        field_acc_desc = (JRFillField)fm.get("acc_desc");
        field_transaction_date = (JRFillField)fm.get("transaction_date");
        field_ytd_amount_dr = (JRFillField)fm.get("ytd_amount_dr");
        field_op_balance_cr = (JRFillField)fm.get("op_balance_cr");
        field_cl_balance_dr = (JRFillField)fm.get("cl_balance_dr");
    }


    /**
     *
     */
    private void initVars(Map vm)
    {
        variable_PAGE_NUMBER = (JRFillVariable)vm.get("PAGE_NUMBER");
        variable_COLUMN_NUMBER = (JRFillVariable)vm.get("COLUMN_NUMBER");
        variable_REPORT_COUNT = (JRFillVariable)vm.get("REPORT_COUNT");
        variable_PAGE_COUNT = (JRFillVariable)vm.get("PAGE_COUNT");
        variable_COLUMN_COUNT = (JRFillVariable)vm.get("COLUMN_COUNT");
        variable_opening = (JRFillVariable)vm.get("opening");
        variable_expense = (JRFillVariable)vm.get("expense");
        variable_balance = (JRFillVariable)vm.get("balance");
    }


    /**
     *
     */
    public Object evaluate(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_op_balance_dr.getValue()).add(((java.math.BigDecimal)field_op_balance_cr.getValue()) ));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_ytd_amount_cr.getValue()).add( ((java.math.BigDecimal)field_ytd_amount_dr.getValue()) ));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cl_balance_cr.getValue()).add( ((java.math.BigDecimal)field_cl_balance_dr.getValue()) ));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=14$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateOld(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_op_balance_dr.getOldValue()).add(((java.math.BigDecimal)field_op_balance_cr.getOldValue()) ));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_ytd_amount_cr.getOldValue()).add( ((java.math.BigDecimal)field_ytd_amount_dr.getOldValue()) ));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cl_balance_cr.getOldValue()).add( ((java.math.BigDecimal)field_cl_balance_dr.getOldValue()) ));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=14$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateEstimated(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_op_balance_dr.getValue()).add(((java.math.BigDecimal)field_op_balance_cr.getValue()) ));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_ytd_amount_cr.getValue()).add( ((java.math.BigDecimal)field_ytd_amount_dr.getValue()) ));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cl_balance_cr.getValue()).add( ((java.math.BigDecimal)field_cl_balance_dr.getValue()) ));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=14$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
