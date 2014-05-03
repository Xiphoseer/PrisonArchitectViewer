import java.io.*;

class PrisonParseWrapper{
  private boolean debug;
  private PrisonParser PP;
  public int NodeCount = 0;
  
  public static void main(String args[]){
    PrisonParseWrapper PPW = new PrisonParseWrapper(false);
    DataNode prisondata = PPW.parsePrisonFile("D:\\TestDev\\menu.prison");
    System.out.println(prisondata.getSubNode("Version").getValue());
  }
  
  public PrisonParseWrapper(boolean debug){
    this.debug = debug;
  } 
  
  public DataNode parsePrisonFile(BufferedReader savegame){
    NodeCount = 0;
    PP = new PrisonParser(savegame);
    DataNode root = new DataNode("root");
    DataNode currentNode = root;
    String exp = PP.nextExpression();
    String Name = "";
    int expect = 0; //O = var, 1=Val, 2 = Name
    int indent = 0;
    while (exp != null) 
    {
      if (expect == 0) 
      {
        if (exp.equals("BEGIN")) 
        {
          expect = 2;
        }else if(exp.equals("END")){
          if (indent > 0) 
          {
            indent--;
            currentNode = currentNode.getParent();
          }
          expect = 0;
        }else{
          expect = 1;
          Name = exp;
        }
      }else if(expect == 1){
        StringBuilder out = new StringBuilder("");
        if (indent > 0) 
        {
          for (int i = 0;i < indent ;i++) 
          {
            out.append(' ');
          }
        }
        out.append(Name);
        out.append(':');
        out.append(exp);
        debugOut(out.toString());
        expect = 0;
        currentNode.addSubNode(Name);
        NodeCount++;
        currentNode.getSubNode(Name).setValue(exp);
      }else{
        StringBuilder out = new StringBuilder("");
        if (indent > 0) 
        {
          for (int i = 0;i < indent ;i++) 
          {
            out.append(' ');
          }
        }
        out.append(exp);
        debugOut(out.toString());
        expect = 0;
        indent++;
        currentNode.addSubNode(exp);
        NodeCount++;
        currentNode = currentNode.getSubNode(exp);
      }
      exp = PP.nextExpression();
    }
    return root;
  }
  
  public DataNode parsePrisonFile(String filename){
    try{
      BufferedReader br = new BufferedReader(new FileReader(filename));
      return this.parsePrisonFile(br);
    }catch(FileNotFoundException e){
      return null;
    }
  }
  
  public void debugOut(String msg){
    if (debug) 
    {
      System.out.println(msg);
    }
  }
}