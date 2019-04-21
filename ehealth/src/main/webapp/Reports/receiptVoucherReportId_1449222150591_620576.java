/*
 * Generated by JasperReports - 4/12/15 3:12 PM
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
public class receiptVoucherReportId_1449222150591_620576 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_voucherDate = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_voucherType = null;
    private JRFillParameter parameter_fYearId = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_hospital_id = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_vhId = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillParameter parameter_accId = null;
    private JRFillField field_hospital_name = null;
    private JRFillField field_sub_led_desc = null;
    private JRFillField field_cr_amount = null;
    private JRFillField field_issue_date = null;
    private JRFillField field_main_acc = null;
    private JRFillField field_hn = null;
    private JRFillField field_voucher_date = null;
    private JRFillField field_dr_amount = null;
    private JRFillField field_address = null;
    private JRFillField field_voucher_no = null;
    private JRFillField field_voucher_header_id = null;
    private JRFillField field_dn = null;
    private JRFillField field_cheque_no = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_Sub_voucher_COUNT = null;
    private JRFillVariable variable_VoucherNo_COUNT = null;
    private JRFillVariable variable_voucherDate_COUNT = null;
    private JRFillVariable variable_cur_Date = null;
    private JRFillVariable variable_balanceDrCr = null;
    private JRFillVariable variable_SUM_dr_amount_1 = null;
    private JRFillVariable variable_SUM_cr_amount_1 = null;
    private JRFillVariable variable_sum_1 = null;
    private JRFillVariable variable_sum_2 = null;


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
        parameter_REPORT_TIME_ZONE = (JRFillParameter)pm.get("REPORT_TIME_ZONE");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_voucherDate = (JRFillParameter)pm.get("voucherDate");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_voucherType = (JRFillParameter)pm.get("voucherType");
        parameter_fYearId = (JRFillParameter)pm.get("fYearId");
        parameter_REPORT_FORMAT_FACTORY = (JRFillParameter)pm.get("REPORT_FORMAT_FACTORY");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_hospital_id = (JRFillParameter)pm.get("hospital_id");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_vhId = (JRFillParameter)pm.get("vhId");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
        parameter_accId = (JRFillParameter)pm.get("accId");
    }


    /**
     *
     */
    private void initFields(Map fm)
    {
        field_hospital_name = (JRFillField)fm.get("hospital_name");
        field_sub_led_desc = (JRFillField)fm.get("sub_led_desc");
        field_cr_amount = (JRFillField)fm.get("cr_amount");
        field_issue_date = (JRFillField)fm.get("issue_date");
        field_main_acc = (JRFillField)fm.get("main_acc");
        field_hn = (JRFillField)fm.get("hn");
        field_voucher_date = (JRFillField)fm.get("voucher_date");
        field_dr_amount = (JRFillField)fm.get("dr_amount");
        field_address = (JRFillField)fm.get("address");
        field_voucher_no = (JRFillField)fm.get("voucher_no");
        field_voucher_header_id = (JRFillField)fm.get("voucher_header_id");
        field_dn = (JRFillField)fm.get("dn");
        field_cheque_no = (JRFillField)fm.get("cheque_no");
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
        variable_Sub_voucher_COUNT = (JRFillVariable)vm.get("Sub_voucher_COUNT");
        variable_VoucherNo_COUNT = (JRFillVariable)vm.get("VoucherNo_COUNT");
        variable_voucherDate_COUNT = (JRFillVariable)vm.get("voucherDate_COUNT");
        variable_cur_Date = (JRFillVariable)vm.get("cur_Date");
        variable_balanceDrCr = (JRFillVariable)vm.get("balanceDrCr");
        variable_SUM_dr_amount_1 = (JRFillVariable)vm.get("SUM_dr_amount_1");
        variable_SUM_cr_amount_1 = (JRFillVariable)vm.get("SUM_cr_amount_1");
        variable_sum_1 = (JRFillVariable)vm.get("sum_1");
        variable_sum_2 = (JRFillVariable)vm.get("sum_2");
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
                value = (java.util.Date)(new Date());//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.String)(new String(""));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.util.Date)(new Date());//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()).subtract(((java.math.BigDecimal)field_cr_amount.getValue())));//$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()).subtract(((java.math.BigDecimal)field_cr_amount.getValue())));//$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()));//$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()));//$JR_EXPR_ID=24$
                break;
            }
            case 25 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr_amount.getValue()));//$JR_EXPR_ID=25$
                break;
            }
            case 26 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()));//$JR_EXPR_ID=26$
                break;
            }
            case 27 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()));//$JR_EXPR_ID=27$
                break;
            }
            case 28 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)field_voucher_header_id.getValue()));//$JR_EXPR_ID=28$
                break;
            }
            case 29 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_sum_2.getValue()));//$JR_EXPR_ID=29$
                break;
            }
            case 30 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_sum_1.getValue()));//$JR_EXPR_ID=30$
                break;
            }
            case 31 : 
            {
                value = (java.lang.Object)((((java.lang.String)field_voucher_no.getValue()))+""+((java.sql.Date)field_voucher_date.getValue()));//$JR_EXPR_ID=31$
                break;
            }
            case 32 : 
            {
                value = (java.lang.Object)(((java.sql.Date)field_voucher_date.getValue()));//$JR_EXPR_ID=32$
                break;
            }
            case 33 : 
            {
                value = (java.lang.String)(((java.lang.String)field_hospital_name.getValue()));//$JR_EXPR_ID=33$
                break;
            }
            case 34 : 
            {
                value = (java.util.Date)(new java.util.Date());//$JR_EXPR_ID=34$
                break;
            }
            case 35 : 
            {
                value = (java.lang.String)(((java.lang.String)field_cheque_no.getValue()));//$JR_EXPR_ID=35$
                break;
            }
            case 36 : 
            {
                value = (java.util.Date)(((java.sql.Date)field_voucher_date.getValue()));//$JR_EXPR_ID=36$
                break;
            }
            case 37 : 
            {
                value = (java.util.Date)(((java.sql.Date)field_issue_date.getValue()));//$JR_EXPR_ID=37$
                break;
            }
            case 38 : 
            {
                value = (java.lang.String)(((java.lang.String)field_voucher_no.getValue()));//$JR_EXPR_ID=38$
                break;
            }
            case 39 : 
            {
                value = (java.lang.String)(((java.lang.String)field_main_acc.getValue()));//$JR_EXPR_ID=39$
                break;
            }
            case 40 : 
            {
                value = (java.lang.String)(((java.lang.String)field_dn.getValue()));//$JR_EXPR_ID=40$
                break;
            }
            case 41 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()));//$JR_EXPR_ID=41$
                break;
            }
            case 42 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr_amount.getValue()));//$JR_EXPR_ID=42$
                break;
            }
            case 43 : 
            {
                value = (java.lang.String)("Page " + ((java.lang.Integer)variable_PAGE_NUMBER.getValue()) + " of ");//$JR_EXPR_ID=43$
                break;
            }
            case 44 : 
            {
                value = (java.lang.String)("" + ((java.lang.Integer)variable_PAGE_NUMBER.getValue()) + "");//$JR_EXPR_ID=44$
                break;
            }
            case 45 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_SUM_cr_amount_1.getValue()));//$JR_EXPR_ID=45$
                break;
            }
            case 46 : 
            {
                value = (java.lang.String)(((java.lang.String)field_hn.getValue()));//$JR_EXPR_ID=46$
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
                value = (java.util.Date)(new Date());//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.String)(new String(""));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.util.Date)(new Date());//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getOldValue()).subtract(((java.math.BigDecimal)field_cr_amount.getOldValue())));//$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getOldValue()).subtract(((java.math.BigDecimal)field_cr_amount.getOldValue())));//$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getOldValue()));//$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getOldValue()));//$JR_EXPR_ID=24$
                break;
            }
            case 25 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr_amount.getOldValue()));//$JR_EXPR_ID=25$
                break;
            }
            case 26 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getOldValue()));//$JR_EXPR_ID=26$
                break;
            }
            case 27 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getOldValue()));//$JR_EXPR_ID=27$
                break;
            }
            case 28 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)field_voucher_header_id.getOldValue()));//$JR_EXPR_ID=28$
                break;
            }
            case 29 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_sum_2.getOldValue()));//$JR_EXPR_ID=29$
                break;
            }
            case 30 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_sum_1.getOldValue()));//$JR_EXPR_ID=30$
                break;
            }
            case 31 : 
            {
                value = (java.lang.Object)((((java.lang.String)field_voucher_no.getOldValue()))+""+((java.sql.Date)field_voucher_date.getOldValue()));//$JR_EXPR_ID=31$
                break;
            }
            case 32 : 
            {
                value = (java.lang.Object)(((java.sql.Date)field_voucher_date.getOldValue()));//$JR_EXPR_ID=32$
                break;
            }
            case 33 : 
            {
                value = (java.lang.String)(((java.lang.String)field_hospital_name.getOldValue()));//$JR_EXPR_ID=33$
                break;
            }
            case 34 : 
            {
                value = (java.util.Date)(new java.util.Date());//$JR_EXPR_ID=34$
                break;
            }
            case 35 : 
            {
                value = (java.lang.String)(((java.lang.String)field_cheque_no.getOldValue()));//$JR_EXPR_ID=35$
                break;
            }
            case 36 : 
            {
                value = (java.util.Date)(((java.sql.Date)field_voucher_date.getOldValue()));//$JR_EXPR_ID=36$
                break;
            }
            case 37 : 
            {
                value = (java.util.Date)(((java.sql.Date)field_issue_date.getOldValue()));//$JR_EXPR_ID=37$
                break;
            }
            case 38 : 
            {
                value = (java.lang.String)(((java.lang.String)field_voucher_no.getOldValue()));//$JR_EXPR_ID=38$
                break;
            }
            case 39 : 
            {
                value = (java.lang.String)(((java.lang.String)field_main_acc.getOldValue()));//$JR_EXPR_ID=39$
                break;
            }
            case 40 : 
            {
                value = (java.lang.String)(((java.lang.String)field_dn.getOldValue()));//$JR_EXPR_ID=40$
                break;
            }
            case 41 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getOldValue()));//$JR_EXPR_ID=41$
                break;
            }
            case 42 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr_amount.getOldValue()));//$JR_EXPR_ID=42$
                break;
            }
            case 43 : 
            {
                value = (java.lang.String)("Page " + ((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()) + " of ");//$JR_EXPR_ID=43$
                break;
            }
            case 44 : 
            {
                value = (java.lang.String)("" + ((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()) + "");//$JR_EXPR_ID=44$
                break;
            }
            case 45 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_SUM_cr_amount_1.getOldValue()));//$JR_EXPR_ID=45$
                break;
            }
            case 46 : 
            {
                value = (java.lang.String)(((java.lang.String)field_hn.getOldValue()));//$JR_EXPR_ID=46$
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
                value = (java.util.Date)(new Date());//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.String)(new String(""));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.util.Date)(new Date());//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()).subtract(((java.math.BigDecimal)field_cr_amount.getValue())));//$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()).subtract(((java.math.BigDecimal)field_cr_amount.getValue())));//$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()));//$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()));//$JR_EXPR_ID=24$
                break;
            }
            case 25 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr_amount.getValue()));//$JR_EXPR_ID=25$
                break;
            }
            case 26 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()));//$JR_EXPR_ID=26$
                break;
            }
            case 27 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()));//$JR_EXPR_ID=27$
                break;
            }
            case 28 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)field_voucher_header_id.getValue()));//$JR_EXPR_ID=28$
                break;
            }
            case 29 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_sum_2.getEstimatedValue()));//$JR_EXPR_ID=29$
                break;
            }
            case 30 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_sum_1.getEstimatedValue()));//$JR_EXPR_ID=30$
                break;
            }
            case 31 : 
            {
                value = (java.lang.Object)((((java.lang.String)field_voucher_no.getValue()))+""+((java.sql.Date)field_voucher_date.getValue()));//$JR_EXPR_ID=31$
                break;
            }
            case 32 : 
            {
                value = (java.lang.Object)(((java.sql.Date)field_voucher_date.getValue()));//$JR_EXPR_ID=32$
                break;
            }
            case 33 : 
            {
                value = (java.lang.String)(((java.lang.String)field_hospital_name.getValue()));//$JR_EXPR_ID=33$
                break;
            }
            case 34 : 
            {
                value = (java.util.Date)(new java.util.Date());//$JR_EXPR_ID=34$
                break;
            }
            case 35 : 
            {
                value = (java.lang.String)(((java.lang.String)field_cheque_no.getValue()));//$JR_EXPR_ID=35$
                break;
            }
            case 36 : 
            {
                value = (java.util.Date)(((java.sql.Date)field_voucher_date.getValue()));//$JR_EXPR_ID=36$
                break;
            }
            case 37 : 
            {
                value = (java.util.Date)(((java.sql.Date)field_issue_date.getValue()));//$JR_EXPR_ID=37$
                break;
            }
            case 38 : 
            {
                value = (java.lang.String)(((java.lang.String)field_voucher_no.getValue()));//$JR_EXPR_ID=38$
                break;
            }
            case 39 : 
            {
                value = (java.lang.String)(((java.lang.String)field_main_acc.getValue()));//$JR_EXPR_ID=39$
                break;
            }
            case 40 : 
            {
                value = (java.lang.String)(((java.lang.String)field_dn.getValue()));//$JR_EXPR_ID=40$
                break;
            }
            case 41 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_dr_amount.getValue()));//$JR_EXPR_ID=41$
                break;
            }
            case 42 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)field_cr_amount.getValue()));//$JR_EXPR_ID=42$
                break;
            }
            case 43 : 
            {
                value = (java.lang.String)("Page " + ((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()) + " of ");//$JR_EXPR_ID=43$
                break;
            }
            case 44 : 
            {
                value = (java.lang.String)("" + ((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()) + "");//$JR_EXPR_ID=44$
                break;
            }
            case 45 : 
            {
                value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_SUM_cr_amount_1.getEstimatedValue()));//$JR_EXPR_ID=45$
                break;
            }
            case 46 : 
            {
                value = (java.lang.String)(((java.lang.String)field_hn.getValue()));//$JR_EXPR_ID=46$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
