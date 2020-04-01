package autocode.code.model;

import java.util.List;

public class Device {
	private Long id;//主键
	private String deviceUuid;//设备唯一标识
	
	private String groupId;//	string	集团ID
	private String groupName;//	string	集团显示名称
	private String groupSort;//	integer	集团排序号
	private String groupVisible;//	integer	集团是否显示标识
	
	private String companyId;//	string	公司ID
	private String companyName;//	string	公司显示名称
	private String companySort;//	integer	公司排序号
	private String companyVisible;//	integer	公司是否显示标识
	
	private String factoryId;//	string	分厂ID
	private String factoryName;//	string	分厂显示名称
	private String factorySort;//	integer	分厂排序号
	private String factoryVisible;//	integer	分厂是否显示标识
	
	private String unitId;//	string	装置ID
	private String unitName;//	string	装置显示名称
	private String unitSort;//	integer	装置排序号
	private String unitVisible;//	integer	装置是否显示标识
	
	private String equipmentId;//	string	设备ID
	private String equipmentIndex;//	integer	设备索引
	private String equipmentName;//	string	设备显示名称
	private String equipmentSort;//	integer	设备排序号
	private String equipmentType;//	integer	设备类型编码
	private String equipmentTypeName;//	string	设备类型名称
	private String equipmentUuid;//	string	设备唯一标识
	private String equipmentVisible;//	integer	设备是否显示标识
	private String erpcode;//	string	设备资产编码
	private String graphType;//	integer	设备概貌图号
	private String driveName;//	string	驱动机类型名称
	private String driveType;//	integer	驱动机类型编码

	private String alarmAlias;//	string	设备状态描述
	private String alarmId;//	integer	报警ID
	private String alarmLevel;//	integer	报警级别
	private String alarmStatus;//	integer	设备状态编码
	private String dataType;//	integer	开停车状态有效位
	private String manufacturer;//	string	制造商
	private String mhost;//	string	
	private String mport;//	integer	
	private String nodeHost;//	string	主机地址
	private String nodeId;//	string	节点ID
	private String nodePort;//	integer	端口号
	private String nodeType;//	integer	节点类型
	private String rev;//	integer	转速
	private String samplingFreq;//	integer	采样频率
	private String samplingNumber;//	integer	采样点数
	private String updateTime;//	integer	数据更新时刻
	
	//-------------------------------业务字段
	
	private String busDeviceNo;//设备号
	private String busDeviceRemark;//设备描述	
	private String busDeviceStatus;//状态	
	private String busDeviceType;//类别	
	private String busDeviceKeycode;//关键字	
	private String busFactory;//维护工厂	
	private String busFactoryRemark;//维护工厂描述	
	private String busPm;//PM 计划者组名称	
	private String busFactoryArea;//工厂区域	
	private String busUser;//负责人	
	private String busAbc;//ABC 标识	
	private String busAbcContent;//ABC 标识正文	
	private String busAssets;//资产	
	private String busStock;//库存号	
	private String busManufacturer;//制造商	
	private String busModel;//型号	
	private String busMakeYear;//制造年份	
	private String busMakeMonth;//制造月份	
	private String busNumber;//技术标识号	
	private String busClassify;//分类字段	
	private String busFunPos;//功能位置	
	private String busFunPosRemark;//功能位置描述	
	private String busTitle;//抬头备注	
	private String busObjNo;//对象号
	
	private String busDeviceZl;//设备种类
	private String busDeviceTypeRemark;//设备类别描述
	private String busAssetsRemark;//资产编码描述

	private String bak1;
	private String bak2;
	private String bak3;
	private String bak4;
	private String bak5;//创建时间
	
	private String operationMode;//操作方式 0、未设置 1、手动操作 2、自动同步
	private String operationShow;//操作方式 显示值
	
	private String runhour;//运行小时数
	
	private List<String> deviceIds;
	
	private String favoriteNum;
	
	private String userId;

	public Long getId() {
		return id;
	}

	public String getDeviceUuid() {
		return deviceUuid;
	}

	public String getGroupId() {
		return groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getGroupSort() {
		return groupSort;
	}

	public String getGroupVisible() {
		return groupVisible;
	}

	public String getCompanyId() {
		return companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanySort() {
		return companySort;
	}

	public String getCompanyVisible() {
		return companyVisible;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public String getFactorySort() {
		return factorySort;
	}

	public String getFactoryVisible() {
		return factoryVisible;
	}

	public String getUnitId() {
		return unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public String getUnitSort() {
		return unitSort;
	}

	public String getUnitVisible() {
		return unitVisible;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public String getEquipmentIndex() {
		return equipmentIndex;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public String getEquipmentSort() {
		return equipmentSort;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public String getEquipmentTypeName() {
		return equipmentTypeName;
	}

	public String getEquipmentUuid() {
		return equipmentUuid;
	}

	public String getEquipmentVisible() {
		return equipmentVisible;
	}

	public String getErpcode() {
		return erpcode;
	}

	public String getGraphType() {
		return graphType;
	}

	public String getDriveName() {
		return driveName;
	}

	public String getDriveType() {
		return driveType;
	}

	public String getAlarmAlias() {
		return alarmAlias;
	}

	public String getAlarmId() {
		return alarmId;
	}

	public String getAlarmLevel() {
		return alarmLevel;
	}

	public String getAlarmStatus() {
		return alarmStatus;
	}

	public String getDataType() {
		return dataType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getMhost() {
		return mhost;
	}

	public String getMport() {
		return mport;
	}

	public String getNodeHost() {
		return nodeHost;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getNodePort() {
		return nodePort;
	}

	public String getNodeType() {
		return nodeType;
	}

	public String getRev() {
		return rev;
	}

	public String getSamplingFreq() {
		return samplingFreq;
	}

	public String getSamplingNumber() {
		return samplingNumber;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public String getBusDeviceNo() {
		return busDeviceNo;
	}

	public String getBusDeviceRemark() {
		return busDeviceRemark;
	}

	public String getBusDeviceStatus() {
		return busDeviceStatus;
	}

	public String getBusDeviceType() {
		return busDeviceType;
	}

	public String getBusDeviceKeycode() {
		return busDeviceKeycode;
	}

	public String getBusFactory() {
		return busFactory;
	}

	public String getBusFactoryRemark() {
		return busFactoryRemark;
	}

	public String getBusPm() {
		return busPm;
	}

	public String getBusFactoryArea() {
		return busFactoryArea;
	}

	public String getBusUser() {
		return busUser;
	}

	public String getBusAbc() {
		return busAbc;
	}

	public String getBusAbcContent() {
		return busAbcContent;
	}

	public String getBusAssets() {
		return busAssets;
	}

	public String getBusStock() {
		return busStock;
	}

	public String getBusManufacturer() {
		return busManufacturer;
	}

	public String getBusModel() {
		return busModel;
	}

	public String getBusMakeYear() {
		return busMakeYear;
	}

	public String getBusMakeMonth() {
		return busMakeMonth;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public String getBusClassify() {
		return busClassify;
	}

	public String getBusFunPos() {
		return busFunPos;
	}

	public String getBusFunPosRemark() {
		return busFunPosRemark;
	}

	public String getBusTitle() {
		return busTitle;
	}

	public String getBusObjNo() {
		return busObjNo;
	}

	public String getBusDeviceZl() {
		return busDeviceZl;
	}

	public String getBusDeviceTypeRemark() {
		return busDeviceTypeRemark;
	}

	public String getBusAssetsRemark() {
		return busAssetsRemark;
	}

	public String getBak1() {
		return bak1;
	}

	public String getBak2() {
		return bak2;
	}

	public String getBak3() {
		return bak3;
	}

	public String getBak4() {
		return bak4;
	}

	public String getBak5() {
		return bak5;
	}

	public String getOperationMode() {
		return operationMode;
	}

	public String getOperationShow() {
		return operationShow;
	}

	public String getRunhour() {
		return runhour;
	}

	public List<String> getDeviceIds() {
		return deviceIds;
	}

	public String getFavoriteNum() {
		return favoriteNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDeviceUuid(String deviceUuid) {
		this.deviceUuid = deviceUuid;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setGroupSort(String groupSort) {
		this.groupSort = groupSort;
	}

	public void setGroupVisible(String groupVisible) {
		this.groupVisible = groupVisible;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanySort(String companySort) {
		this.companySort = companySort;
	}

	public void setCompanyVisible(String companyVisible) {
		this.companyVisible = companyVisible;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public void setFactorySort(String factorySort) {
		this.factorySort = factorySort;
	}

	public void setFactoryVisible(String factoryVisible) {
		this.factoryVisible = factoryVisible;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public void setUnitSort(String unitSort) {
		this.unitSort = unitSort;
	}

	public void setUnitVisible(String unitVisible) {
		this.unitVisible = unitVisible;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public void setEquipmentIndex(String equipmentIndex) {
		this.equipmentIndex = equipmentIndex;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public void setEquipmentSort(String equipmentSort) {
		this.equipmentSort = equipmentSort;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public void setEquipmentTypeName(String equipmentTypeName) {
		this.equipmentTypeName = equipmentTypeName;
	}

	public void setEquipmentUuid(String equipmentUuid) {
		this.equipmentUuid = equipmentUuid;
	}

	public void setEquipmentVisible(String equipmentVisible) {
		this.equipmentVisible = equipmentVisible;
	}

	public void setErpcode(String erpcode) {
		this.erpcode = erpcode;
	}

	public void setGraphType(String graphType) {
		this.graphType = graphType;
	}

	public void setDriveName(String driveName) {
		this.driveName = driveName;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	public void setAlarmAlias(String alarmAlias) {
		this.alarmAlias = alarmAlias;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	public void setAlarmStatus(String alarmStatus) {
		this.alarmStatus = alarmStatus;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setMhost(String mhost) {
		this.mhost = mhost;
	}

	public void setMport(String mport) {
		this.mport = mport;
	}

	public void setNodeHost(String nodeHost) {
		this.nodeHost = nodeHost;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public void setNodePort(String nodePort) {
		this.nodePort = nodePort;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public void setSamplingFreq(String samplingFreq) {
		this.samplingFreq = samplingFreq;
	}

	public void setSamplingNumber(String samplingNumber) {
		this.samplingNumber = samplingNumber;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public void setBusDeviceNo(String busDeviceNo) {
		this.busDeviceNo = busDeviceNo;
	}

	public void setBusDeviceRemark(String busDeviceRemark) {
		this.busDeviceRemark = busDeviceRemark;
	}

	public void setBusDeviceStatus(String busDeviceStatus) {
		this.busDeviceStatus = busDeviceStatus;
	}

	public void setBusDeviceType(String busDeviceType) {
		this.busDeviceType = busDeviceType;
	}

	public void setBusDeviceKeycode(String busDeviceKeycode) {
		this.busDeviceKeycode = busDeviceKeycode;
	}

	public void setBusFactory(String busFactory) {
		this.busFactory = busFactory;
	}

	public void setBusFactoryRemark(String busFactoryRemark) {
		this.busFactoryRemark = busFactoryRemark;
	}

	public void setBusPm(String busPm) {
		this.busPm = busPm;
	}

	public void setBusFactoryArea(String busFactoryArea) {
		this.busFactoryArea = busFactoryArea;
	}

	public void setBusUser(String busUser) {
		this.busUser = busUser;
	}

	public void setBusAbc(String busAbc) {
		this.busAbc = busAbc;
	}

	public void setBusAbcContent(String busAbcContent) {
		this.busAbcContent = busAbcContent;
	}

	public void setBusAssets(String busAssets) {
		this.busAssets = busAssets;
	}

	public void setBusStock(String busStock) {
		this.busStock = busStock;
	}

	public void setBusManufacturer(String busManufacturer) {
		this.busManufacturer = busManufacturer;
	}

	public void setBusModel(String busModel) {
		this.busModel = busModel;
	}

	public void setBusMakeYear(String busMakeYear) {
		this.busMakeYear = busMakeYear;
	}

	public void setBusMakeMonth(String busMakeMonth) {
		this.busMakeMonth = busMakeMonth;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public void setBusClassify(String busClassify) {
		this.busClassify = busClassify;
	}

	public void setBusFunPos(String busFunPos) {
		this.busFunPos = busFunPos;
	}

	public void setBusFunPosRemark(String busFunPosRemark) {
		this.busFunPosRemark = busFunPosRemark;
	}

	public void setBusTitle(String busTitle) {
		this.busTitle = busTitle;
	}

	public void setBusObjNo(String busObjNo) {
		this.busObjNo = busObjNo;
	}

	public void setBusDeviceZl(String busDeviceZl) {
		this.busDeviceZl = busDeviceZl;
	}

	public void setBusDeviceTypeRemark(String busDeviceTypeRemark) {
		this.busDeviceTypeRemark = busDeviceTypeRemark;
	}

	public void setBusAssetsRemark(String busAssetsRemark) {
		this.busAssetsRemark = busAssetsRemark;
	}

	public void setBak1(String bak1) {
		this.bak1 = bak1;
	}

	public void setBak2(String bak2) {
		this.bak2 = bak2;
	}

	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}

	public void setBak4(String bak4) {
		this.bak4 = bak4;
	}

	public void setBak5(String bak5) {
		this.bak5 = bak5;
	}

	public void setOperationMode(String operationMode) {
		this.operationMode = operationMode;
	}

	public void setOperationShow(String operationShow) {
		this.operationShow = operationShow;
	}

	public void setRunhour(String runhour) {
		this.runhour = runhour;
	}

	public void setDeviceIds(List<String> deviceIds) {
		this.deviceIds = deviceIds;
	}

	public void setFavoriteNum(String favoriteNum) {
		this.favoriteNum = favoriteNum;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
	
}
