class NullDataNode extends DataNode{
  public static NullDataNode NDN = new NullDataNode("NULL");
  
  public NullDataNode(String name){
    super(name);
  }
  
  public void setValue(String val){
    
  }
  public String getValue(){
    return null;
  }
  public void addSubNode(String name){
    
  }
  public DataNode getSubNode(String name){
    return this;
  }
  public void setParent(DataNode parent){
    
  }
  public DataNode getParent(){
    return this;
  }
}