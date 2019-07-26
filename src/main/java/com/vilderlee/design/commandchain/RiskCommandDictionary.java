package com.vilderlee.design.commandchain;


public class RiskCommandDictionary {

  private String riskCommand;
  private String riskLevel;


  public String getRiskCommand() {
    return riskCommand;
  }

  public void setRiskCommand(String riskCommand) {
    this.riskCommand = riskCommand;
  }


  public String getRiskLevel() {
    return riskLevel;
  }

  public void setRiskLevel(String riskLevel) {
    this.riskLevel = riskLevel;
  }

  @Override public String toString() {
    return "RiskCommandDictionary{" + "riskCommand='" + riskCommand + '\'' + ", riskLevel='" + riskLevel + '\'' + '}';
  }
}
