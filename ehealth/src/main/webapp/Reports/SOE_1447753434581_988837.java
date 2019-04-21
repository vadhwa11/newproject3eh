/*
 * Generated by JasperReports - 17/11/15 3:13 PM
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
public class SOE_1447753434581_988837 extends JREvaluator
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
    private JRFillField field_cr = null;
    private JRFillField field_dr_amount0 = null;
    private JRFillField field_a0 = null;
    private JRFillField field_b0 = null;
    private JRFillField field_dr_amount1 = null;
    private JRFillField field_cr_amount0 = null;
    private JRFillField field_op_amount0 = null;
    private JRFillField field_location_id = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_d = null;
    private JRFillVariable variable_g = null;
    private JRFillVariable variable_h = null;


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
        field_cr = (JRFillField)fm.get("cr");
        field_dr_amount0 = (JRFillField)fm.get("dr_amount0");
        field_a0 = (JRFillField)fm.get("a0");
        field_b0 = (JRFillField)fm.get("b0");
        field_dr_amount1 = (JRFillField)fm.get("dr_amount1");
        field_cr_amount0 = (JRFillField)fm.get("cr_amount0");
        field_op_amount0 = (JRFillField)fm.get("op_amount0");
        field_location_id = (JRFillField)fm.get("location_id");
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
        variable_d = (JRFillVariable)vm.get("d");
        variable_g = (JRFillVariable)vm.get("g");
        variable_h = (JRFillVariable)vm.get("h");
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
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr_amount0.getValue()).add(((java.math.BigDecimal)field_cr.getValue())));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount0.getValue()).add(((java.math.BigDecimal)field_dr_amount1.getValue())));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.math.BigDecimal)(($(F{op_amount0}.add(((java.math.BigDecimal)field_cr_amount0.getValue()).add(((java.math.BigDecimal)field_cr.getValue())))).integer().substract(((java.math.BigDecimal)field_dr_amount0.getValue()).add(((java.math.BigDecimal)field_dr_amount1.getValue()))).integer));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)variable_COLUMN_COUNT.getValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)(((java.lang.String)field_a0.getValue()));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_op_amount0.getValue()));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr_amount0.getValue()));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr.getValue()));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_d.getValue()));//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount0.getValue()));//$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount1.getValue()));//$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_g.getValue()));//$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_h.getValue()));//$JR_EXPR_ID=24$
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
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr_amount0.getOldValue()).add(((java.math.BigDecimal)field_cr.getOldValue())));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount0.getOldValue()).add(((java.math.BigDecimal)field_dr_amount1.getOldValue())));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.math.BigDecimal)(($(F{op_amount0}.add(((java.math.BigDecimal)field_cr_amount0.getOldValue()).add(((java.math.BigDecimal)field_cr.getOldValue())))).integer().substract(((java.math.BigDecimal)field_dr_amount0.getOldValue()).add(((java.math.BigDecimal)field_dr_amount1.getOldValue()))).integer));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)variable_COLUMN_COUNT.getOldValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)(((java.lang.String)field_a0.getOldValue()));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_op_amount0.getOldValue()));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr_amount0.getOldValue()));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr.getOldValue()));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_d.getOldValue()));//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount0.getOldValue()));//$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount1.getOldValue()));//$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_g.getOldValue()));//$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_h.getOldValue()));//$JR_EXPR_ID=24$
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
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr_amount0.getValue()).add(((java.math.BigDecimal)field_cr.getValue())));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount0.getValue()).add(((java.math.BigDecimal)field_dr_amount1.getValue())));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.math.BigDecimal)(($(F{op_amount0}.add(((java.math.BigDecimal)field_cr_amount0.getValue()).add(((java.math.BigDecimal)field_cr.getValue())))).integer().substract(((java.math.BigDecimal)field_dr_amount0.getValue()).add(((java.math.BigDecimal)field_dr_amount1.getValue()))).integer));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.math.BigDecimal)(new BigDecimal(0));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)variable_COLUMN_COUNT.getEstimatedValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)(((java.lang.String)field_a0.getValue()));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_op_amount0.getValue()));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr_amount0.getValue()));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr.getValue()));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_d.getEstimatedValue()));//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount0.getValue()));//$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount1.getValue()));//$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_g.getEstimatedValue()));//$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_h.getEstimatedValue()));//$JR_EXPR_ID=24$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
