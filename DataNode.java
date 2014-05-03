import java.util.*;

class DataNode{
  private String Name;
  private String Value;
  private DataNode parent;
  public HashMap<String,DataNode> SubNodes = new HashMap<String,DataNode>();
  
  
  public DataNode(String name){
    this.Name = name;
    this.Value = null;
  }
  
  public void setValue(String val){
    Value = val;
  }
  
  public String getValue(){
    return Value;
  }
  
  public void addSubNode(String name){
    DataNode sn = new DataNode(name);
    sn.setParent(this);
    SubNodes.put(name,sn);
  }
  
  public DataNode getSubNode(String name){
    DataNode sn = SubNodes.get(name);
    if (sn != null) 
    {
      return sn;
    }else{
      return NullDataNode.NDN;
    }
  }
  
  public void removeSubNode(String name){
    SubNodes.remove(name);
  }
  
  public int countSubNodes(){
    return SubNodes.size();
  }
  
  public void setParent(DataNode parent){
    this.parent = parent;
  }
  
  public DataNode getParent(){
    return parent;
  }
  
  public String getName(){
    return Name;
  }
}