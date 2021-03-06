package com.ltvs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltvs.pojo.Ammeter;
import com.ltvs.pojo.CommunityInfo;
import com.ltvs.pojo.JunctionBox;
import com.ltvs.pojo.LineSegment;
import com.ltvs.pojo.LtvsTransformerInfo;
import com.ltvs.pojo.OperatingTransformer;
import com.ltvs.pojo.PowerBox;
import com.ltvs.pojo.PowerRoom;
import com.ltvs.pojo.TaiwanInfo;
import com.ltvs.service.ITransformerInfoService;

/**
 * 系统模块
 * 
 * @Description
 * @date 2019年4月11日 上午8:57:58
 */
@Controller
public class TransformerInfoController {

	@Resource
	private ITransformerInfoService transformerInfoService;

	/**
	 * 获得地图上的一级点
	 * 
	 * @Description
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getTransformerInfo", method = RequestMethod.GET)
	public List<LtvsTransformerInfo> getAlltsInfo() {
		return this.transformerInfoService.getAllTransformer();
	}

	/**
	 * 获得变压器
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getByq", method = RequestMethod.GET)
	public List<OperatingTransformer> getAllbyq() {
		return this.transformerInfoService.getAllByqInfo();
	}

	/*
	 * 根据台区id 获得台区下的变压器
	 */
	@ResponseBody
	@RequestMapping(value = "getByqInfo", method = RequestMethod.GET)
	public List<OperatingTransformer> getByqById(String tqid) {
		return this.transformerInfoService.getByqByTqId(tqid);
	}

	/**
	 * 获得所有分接箱信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getjboxinfo", method = RequestMethod.GET)
	public List<JunctionBox> getAllJunctionBox() {
		return this.transformerInfoService.getAllJunctionBox();
	}

	/**
	 * 验证该折线编号是否存在
	 * 
	 * @param bh
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "validateLine", method = RequestMethod.GET)
	public String validataLineExist(String bh) {
		if (transformerInfoService.validateLine(bh) > 0) {
			return "exist";
		}
		return "ok";
	}

	/**
	 * 验证该折线编号是否存在
	 * 
	 * @param bh
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveLine", method = RequestMethod.GET)
	public String saveLinePath(String bh, String zoom, String path) {
		int _zoom = Integer.parseInt(zoom);
		if (transformerInfoService.saveLine(bh, _zoom, path) > 0) {
			return "ok";
		} else {
			return "error";
		}
	}

	/**
	 * 根据层级获得线路信息
	 */
	@ResponseBody
	@RequestMapping(value = "getLineByLev", method = RequestMethod.GET)
	public List<LineSegment> getIineInfoByLev(String lev) {
		Integer l = Integer.parseInt(lev);
		return transformerInfoService.getLineByLev(l);
	}

	/**
	 * 获取所有台区信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "gettqinfo", method = RequestMethod.GET)
	public List<TaiwanInfo> getAllTqInfo() {
		return transformerInfoService.getAllTqInfo();
	}

	/**
	 * 获取所有小区信息
	 */
	@ResponseBody
	@RequestMapping(value = "getxqinfo", method = RequestMethod.GET)
	public List<CommunityInfo> getXqInfo() {
		return transformerInfoService.getAllXqInfo();
	}






	/*
	 * 获得台区下的配电房
	 */
	@ResponseBody
	@RequestMapping(value = "getPdfById", method = RequestMethod.GET)
	public List<PowerRoom> getPdfByTqId(String tqid) {
		return transformerInfoService.getPdfByTqId(tqid);
	}
	
	/*
	 * 获得配电房下的配电箱
	 */
	@ResponseBody
	@RequestMapping(value = "getPdxById",method = RequestMethod.GET)
	public List<PowerBox> getPdxByPdfId(String pdfId){
		return transformerInfoService.getPdxByPdfId(pdfId);
	}
	/*
	 * 获得 配电箱下的电表
	 */
	@ResponseBody
	@RequestMapping(value = "getDbById",method = RequestMethod.GET)
	public List<Ammeter> getDbByDbxId(String dbxId){
		return transformerInfoService.getDbByDbxId(dbxId);
	}
	/*
	 * 修改异常数据
	 */
	@ResponseBody
	@RequestMapping(value = "setData",method = RequestMethod.GET)
	public Integer setCommunitybyCal(){
		return transformerInfoService.setCommunitybyCal();
	}
}
