package jkt.hrms.masters.business;

import jkt.hrms.masters.business.base.BasePrjCalendar;



public class PrjCalendar extends BasePrjCalendar {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PrjCalendar () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PrjCalendar (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PrjCalendar (
		java.lang.Integer id,
		java.lang.Integer prjId,
		java.util.Date prjPlan,
		java.util.Date fsStart,
		java.util.Date fsEnd,
		java.util.Date prjKick,
		java.util.Date rsDate,
		java.util.Date raDate,
		java.util.Date fECSubm,
		java.util.Date fECApp,
		java.util.Date fSiteInit,
		java.util.Date fPatin,
		java.util.Date lPatIn,
		java.util.Date lPatOut,
		java.util.Date lCRFInHouse,
		java.util.Date lQryRes,
		java.util.Date lSClsOut,
		java.util.Date dataLock,
		java.util.Date anlys,
		java.util.Date dBFrz,
		java.util.Date dblock,
		java.util.Date dataTrn,
		java.util.Date stsSub,
		java.util.Date frstDrft,
		java.util.Date fnlDrft,
		java.util.Date drftStd,
		java.util.Date fnlclinicStdy,
		java.util.Date trnfCRF,
		java.util.Date arRemData,
		java.util.Date pIMeetStrt,
		java.lang.Integer pIMeetNo,
		java.util.Date prtTrainStrt,
		java.lang.Integer prtTrainNo,
		java.util.Date prjTeamTrainStrt,
		java.lang.Integer prjTeamTrainNo,
		java.util.Date prjComp,
		java.lang.Integer createdBy,
		java.util.Date createdAt,
		java.lang.Integer modifiedBy,
		java.util.Date modifiedAt) {

		super (
			id,
			prjId,
			prjPlan,
			fsStart,
			fsEnd,
			prjKick,
			rsDate,
			raDate,
			fECSubm,
			fECApp,
			fSiteInit,
			fPatin,
			lPatIn,
			lPatOut,
			lCRFInHouse,
			lQryRes,
			lSClsOut,
			dataLock,
			anlys,
			dBFrz,
			dblock,
			dataTrn,
			stsSub,
			frstDrft,
			fnlDrft,
			drftStd,
			fnlclinicStdy,
			trnfCRF,
			arRemData,
			pIMeetStrt,
			pIMeetNo,
			prtTrainStrt,
			prtTrainNo,
			prjTeamTrainStrt,
			prjTeamTrainNo,
			prjComp,
			createdBy,
			createdAt,
			modifiedBy,
			modifiedAt);
	}

/*[CONSTRUCTOR MARKER END]*/


}