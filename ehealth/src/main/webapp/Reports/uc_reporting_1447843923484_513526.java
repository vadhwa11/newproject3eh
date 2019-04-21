/*
 * Generated by JasperReports - 18/11/15 4:22 PM
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
public class uc_reporting_1447843923484_513526 extends JREvaluator
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
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_SUBREPORT_DIR = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_kmscl_category = null;
    private JRFillField field_village_id = null;
    private JRFillField field_contact_person_desig = null;
    private JRFillField field_ward_id = null;
    private JRFillField field_lsg_type = null;
    private JRFillField field_blood_bank = null;
    private JRFillField field_imergency_number = null;
    private JRFillField field_opening_time = null;
    private JRFillField field_bb_available = null;
    private JRFillField field_longitude = null;
    private JRFillField field_email_id = null;
    private JRFillField field_hospital_name = null;
    private JRFillField field_about_hospital = null;
    private JRFillField field_layout_map = null;
    private JRFillField field_contact_person_mobile = null;
    private JRFillField field_status = null;
    private JRFillField field_last_chg_time = null;
    private JRFillField field_district_id = null;
    private JRFillField field_spark_id = null;
    private JRFillField field_how_to_reach = null;
    private JRFillField field_short_name = null;
    private JRFillField field_contact_number = null;
    private JRFillField field_parliament = null;
    private JRFillField field_taluk_id = null;
    private JRFillField field_add3_locality = null;
    private JRFillField field_hospital_name_change_count = null;
    private JRFillField field_latitude = null;
    private JRFillField field_sanction_bed = null;
    private JRFillField field_lsg_name = null;
    private JRFillField field_assembly = null;
    private JRFillField field_electrical_section_id = null;
    private JRFillField field_jurisdiction_map = null;
    private JRFillField field_dy_superintendent = null;
    private JRFillField field_superintendent = null;
    private JRFillField field_last_chg_date = null;
    private JRFillField field_hod = null;
    private JRFillField field_hospital_type_change_count = null;
    private JRFillField field_bb_registration_number = null;
    private JRFillField field_formation = null;
    private JRFillField field_contact_person_name = null;
    private JRFillField field_last_chg_by = null;
    private JRFillField field_rmo = null;
    private JRFillField field_hospital_code = null;
    private JRFillField field_parent_institute_id = null;
    private JRFillField field_post_office = null;
    private JRFillField field_registration_year = null;
    private JRFillField field_pin_code = null;
    private JRFillField field_closing_time = null;
    private JRFillField field_bb_weekly_off = null;
    private JRFillField field_hospital_id = null;
    private JRFillField field_address = null;
    private JRFillField field_kmscl_institute_code = null;
    private JRFillField field_pro = null;
    private JRFillField field_hospital_type_id = null;
    private JRFillField field_add2_street = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_SUM_c1_1 = null;


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
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_SUBREPORT_DIR = (JRFillParameter)pm.get("SUBREPORT_DIR");
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
        field_kmscl_category = (JRFillField)fm.get("kmscl_category");
        field_village_id = (JRFillField)fm.get("village_id");
        field_contact_person_desig = (JRFillField)fm.get("contact_person_desig");
        field_ward_id = (JRFillField)fm.get("ward_id");
        field_lsg_type = (JRFillField)fm.get("lsg_type");
        field_blood_bank = (JRFillField)fm.get("blood_bank");
        field_imergency_number = (JRFillField)fm.get("imergency_number");
        field_opening_time = (JRFillField)fm.get("opening_time");
        field_bb_available = (JRFillField)fm.get("bb_available");
        field_longitude = (JRFillField)fm.get("longitude");
        field_email_id = (JRFillField)fm.get("email_id");
        field_hospital_name = (JRFillField)fm.get("hospital_name");
        field_about_hospital = (JRFillField)fm.get("about_hospital");
        field_layout_map = (JRFillField)fm.get("layout_map");
        field_contact_person_mobile = (JRFillField)fm.get("contact_person_mobile");
        field_status = (JRFillField)fm.get("status");
        field_last_chg_time = (JRFillField)fm.get("last_chg_time");
        field_district_id = (JRFillField)fm.get("district_id");
        field_spark_id = (JRFillField)fm.get("spark_id");
        field_how_to_reach = (JRFillField)fm.get("how_to_reach");
        field_short_name = (JRFillField)fm.get("short_name");
        field_contact_number = (JRFillField)fm.get("contact_number");
        field_parliament = (JRFillField)fm.get("parliament");
        field_taluk_id = (JRFillField)fm.get("taluk_id");
        field_add3_locality = (JRFillField)fm.get("add3_locality");
        field_hospital_name_change_count = (JRFillField)fm.get("hospital_name_change_count");
        field_latitude = (JRFillField)fm.get("latitude");
        field_sanction_bed = (JRFillField)fm.get("sanction_bed");
        field_lsg_name = (JRFillField)fm.get("lsg_name");
        field_assembly = (JRFillField)fm.get("assembly");
        field_electrical_section_id = (JRFillField)fm.get("electrical_section_id");
        field_jurisdiction_map = (JRFillField)fm.get("jurisdiction_map");
        field_dy_superintendent = (JRFillField)fm.get("dy_superintendent");
        field_superintendent = (JRFillField)fm.get("superintendent");
        field_last_chg_date = (JRFillField)fm.get("last_chg_date");
        field_hod = (JRFillField)fm.get("hod");
        field_hospital_type_change_count = (JRFillField)fm.get("hospital_type_change_count");
        field_bb_registration_number = (JRFillField)fm.get("bb_registration_number");
        field_formation = (JRFillField)fm.get("formation");
        field_contact_person_name = (JRFillField)fm.get("contact_person_name");
        field_last_chg_by = (JRFillField)fm.get("last_chg_by");
        field_rmo = (JRFillField)fm.get("rmo");
        field_hospital_code = (JRFillField)fm.get("hospital_code");
        field_parent_institute_id = (JRFillField)fm.get("parent_institute_id");
        field_post_office = (JRFillField)fm.get("post_office");
        field_registration_year = (JRFillField)fm.get("registration_year");
        field_pin_code = (JRFillField)fm.get("pin_code");
        field_closing_time = (JRFillField)fm.get("closing_time");
        field_bb_weekly_off = (JRFillField)fm.get("bb_weekly_off");
        field_hospital_id = (JRFillField)fm.get("hospital_id");
        field_address = (JRFillField)fm.get("address");
        field_kmscl_institute_code = (JRFillField)fm.get("kmscl_institute_code");
        field_pro = (JRFillField)fm.get("pro");
        field_hospital_type_id = (JRFillField)fm.get("hospital_type_id");
        field_add2_street = (JRFillField)fm.get("add2_street");
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
        variable_SUM_c1_1 = (JRFillVariable)vm.get("SUM_c1_1");
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
                value = (java.lang.String)(new String(""));//$JR_EXPR_ID=0$
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
                value = (java.lang.Object)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "//uc_reporting_sub_1.jasper");//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "//uc_reporting_sub_2.jasper");//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "//uc_reporting_sub_3.jasper");//$JR_EXPR_ID=17$
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
                value = (java.lang.String)(new String(""));//$JR_EXPR_ID=0$
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
                value = (java.lang.Object)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "//uc_reporting_sub_1.jasper");//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "//uc_reporting_sub_2.jasper");//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "//uc_reporting_sub_3.jasper");//$JR_EXPR_ID=17$
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
                value = (java.lang.String)(new String(""));//$JR_EXPR_ID=0$
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
                value = (java.lang.Object)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "//uc_reporting_sub_1.jasper");//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "//uc_reporting_sub_2.jasper");//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)(((java.lang.String)parameter_SUBREPORT_DIR.getValue()) + "//uc_reporting_sub_3.jasper");//$JR_EXPR_ID=17$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
