package com.vilderlee.design.commandchain;


public class RiskTransInfo {

  private long systemNo;
  private long systemTime;
  private String txCode;
  private String riskCommand;
  private long riskLevel;

  private int riskPriority;


  public long getSystemNo() {
    return systemNo;
  }

  public void setSystemNo(long systemNo) {
    this.systemNo = systemNo;
  }


  public long getSystemTime() {
    return systemTime;
  }

  public void setSystemTime(long systemTime) {
    this.systemTime = systemTime;
  }


  public String getTxCode() {
    return txCode;
  }

  public void setTxCode(String txCode) {
    this.txCode = txCode;
  }


  public String getRiskCommand() {
    return riskCommand;
  }

  public void setRiskCommand(String riskCommand) {
    this.riskCommand = riskCommand;
  }


  public long getRiskLevel() {
    return riskLevel;
  }

  public void setRiskLevel(long riskLevel) {
    this.riskLevel = riskLevel;
  }

  public int getRiskPriority() {
    return riskPriority;
  }

  public void setRiskPriority(int riskPriority) {
    this.riskPriority = riskPriority;
  }
}
